/*
 * Copyright (C) 2014 Tejinder Singh.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bowling.main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bowling.game.Game;
import com.bowling.game.impl.SinglePlayerGame;
import com.bowling.line.Line;
import com.bowling.line.impl.TenRoundLine;
import com.bowling.model.BowlingContext;
import com.bowling.model.Score;
import com.bowling.round.Round;
import com.bowling.round.impl.TwoRollRound;

/**
 * Java Swing Class created to help User run the Game as Swing application and
 * get resultant Score.
 *
 * @author Tejinder Singh.
 */
public class BowlingSwing extends JPanel {

	private static final Logger logger = LoggerFactory.getLogger(BowlingSwing.class);
	// Declare all variables to be used
	private JButton calcButton;
	private JButton clearButton;
	private JButton quitButton;
	private JLabel inputLabel;
	private JLabel outputLabel;
	private JTextField inputTextField;
	private JTextArea outputScoreTextArea; // money

	public BowlingSwing() {
		super(new BorderLayout());
		logger.info("Starting the creating of labels, buttons, testfields, and textareas and arranging them on layout");
		inputLabel = new JLabel(
				"<html><body>Input Rolls as 12 Character <br>String like \"XXXXXXXXXXXX\"<br> or \"9-9-9-9-9-9-9-9-9-9-\" etc: </body></html>",
				JLabel.LEFT);
		inputTextField = new JTextField(12);
		// Create the Calculate button that also has a listener event to perform an
		// action
		// when clicked
		calcButton = new JButton("Calculate");
		calcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calculateButtonActionPerformed(evt);
			}
		});
		// Create the Clear button that also has a listener event to perform an action
		// when clicked
		clearButton = new JButton("Clear/Reset");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				clearButtonActionPerformed(evt);
			}
		});
		// Create the Quit button that also has a listener event to perform an action
		// when clicked
		quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				quitButtonActionPerformed(evt);
			}
		});

		// Add the final fields that will display the Output Score Fields and message
		// after it is
		// calculated
		outputLabel = new JLabel("The Output Score is : ");
		outputScoreTextArea = new JTextArea(5, 20);
		// put the labels into a specific panel layout
		JPanel labelPane = new JPanel(new GridLayout(0, 1));
		labelPane.add(inputLabel);
		labelPane.add(outputLabel);

		// put the input textFields into a specific panel layout
		JPanel fieldPane = new JPanel(new GridLayout(0, 1));
		fieldPane.add(inputTextField);
		// put the buttons into a specific panel layout
		JPanel buttonPane = new JPanel(new GridLayout(0, 1));
		buttonPane.add(calcButton);
		buttonPane.add(clearButton);
		buttonPane.add(quitButton);
		// Create a boarder around the items and specify where to show each of the
		// panels previously created.
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		add(labelPane, BorderLayout.WEST);
		add(fieldPane, BorderLayout.CENTER);
		add(buttonPane, BorderLayout.LINE_END);
		add(outputScoreTextArea, BorderLayout.SOUTH);
		logger.info("Exiting the creation of labels, buttons, testfields, and textareas and arranging them on layout\");");
	}

	// Setup what the quit button is going to do when clicked
	private void quitButtonActionPerformed(ActionEvent evt) {
		logger.info("Quit button Clicked.");
		System.exit(0);
	}

	// Setup what the clear button will do when clicked
	private void clearButtonActionPerformed(ActionEvent evt) {
		logger.info("Clear button Clicked.");
		inputTextField.setText("");
		outputScoreTextArea.setText("");
	}

	// Setup what the calculate button will do when clicked
	private void calculateButtonActionPerformed(ActionEvent evt) {
		logger.info("Calculate button clicked");
		// clear the text area before calculation.
		outputScoreTextArea.setText("");
		// get the source of button
		Object source = evt.getSource();
		if (source == calcButton) {
			logger.info("Initializing and starting the application...");
			List<String> rollStringList = new ArrayList<String>();
			// Add the rolls to a List that will be evaluated. We choose a List so that
			// later if application need to be made for multiplayer then multiple Strings
			// can be passed
			rollStringList.add(inputTextField.getText());
			logger.debug("The roll getting passed is " + rollStringList);
			// Initialize Kind of Objects we need to run this Game. We can choose different
			// Kind if we later wants to add Multiplayer game, with many Lines and many
			// Rounds
			Game game = new SinglePlayerGame();
			Line line = new TenRoundLine();
			Round round = new TwoRollRound();
			BowlingContext context = new BowlingContext(line, round, game);
			// Run the Game to evaluate Score
			List<Score> scoreList = game.evaluate(context, rollStringList);
			// Display Score on output textArea
			scoreList.stream().forEach(score -> {
				outputScoreTextArea.append("SCORE      = " + score.getScoreList().get(0) + "\n");
				outputScoreTextArea.append("MESSAGE = " + score.getMessage() + "\n");
				outputScoreTextArea.append("SUCCESS= " + score.isSuccess() + "\n");
			});
		}
	}

	// Create the GUI and prepare to show on users screen
	private static void createAndShowGUI() {
		logger.info("Creating and showing the GUI");
		JFrame frame = new JFrame("BowlingSwing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new BowlingSwing());
		frame.pack();
		frame.setVisible(true);
	}

	// Show the GUI to user
	public static void main(String[] args) {
		logger.info("Starting the main entry point of Bowling Swing Application");
		createAndShowGUI();
	}
}
