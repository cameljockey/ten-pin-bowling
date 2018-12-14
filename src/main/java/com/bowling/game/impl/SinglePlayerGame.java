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
package com.bowling.game.impl;

import java.util.ArrayList;
import java.util.List;

import com.bowling.game.Game;
import com.bowling.model.BowlingContext;
import com.bowling.model.Score;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represent a Single Player full game for bowling.
 *
 * @author Tejinder Singh.
 */
public class SinglePlayerGame implements Game {
	
	private static final Logger logger = LoggerFactory.getLogger(SinglePlayerGame.class);

	public List<Score> evaluate(BowlingContext context, List<String> rollStringList) {
		logger.info("Entering the SinglePlayerGame evaluation");
		logger.debug("The Roll String List passed in is " + rollStringList);
		// Start evaluation of game based upon the kind of objects we pass in context
		// and List of Rolls as String we pass
		List<Score> gameScoreList = new ArrayList<Score>();
		if (rollStringList == null || rollStringList.isEmpty()) {
			//return predefined message score for invalid string
			getGameScoreForInvalidInput(gameScoreList);
			logger.error("The RollString Passed in is Empty Or Null");
			logger.info("Exiting the SinglePlayerGame evaluation");
			return gameScoreList;
		} else {
			//return score calculated for valid Roll string
			getGameScoreForValidInput(context, rollStringList, gameScoreList);
			logger.debug("The output Game Score List is = " + gameScoreList);
			logger.info("Exiting the SinglePlayerGame evaluation");
			return gameScoreList;
		}
		
	}

	private void getGameScoreForInvalidInput(List<Score> gameScoreList) {
		//return a pre-calculated message we want to pass on in Score
		Score score = new Score();
		score.setMessage("No Input for Score was provided. Hence not able to calculate score for game");
		score.setSuccess(false);
		gameScoreList.add(score);
	}

	private void getGameScoreForValidInput(BowlingContext context, List<String> rollStringList,
			List<Score> gameScoreList) {
		//initialize parameters for score and those we want to pass n to line for calculation.
		Score score = new Score();
		String rollString = rollStringList.get(0);
		List<Integer> scoreList = new ArrayList<Integer>();
		//Calculate the line Score based upon kind of Line passed in Context
		logger.debug("The Roll String getting passed is " + rollString);
		Integer lineScore = context.getLine().CalculateLineScore(context, rollString);
		scoreList.add(lineScore);
		score.setScoreList(scoreList);
		//calculate customized Success message based upon Score range
		score.setMessage(getSuccessMessage(lineScore));
		score.setSuccess(true);
		logger.debug("The output score is " + score);
		//Add to game score list to be returned
		gameScoreList.add(score);
	}

	private String getSuccessMessage(Integer score) {
		//calculate customized Success message based upon Score range
		if (score > 0 && score < 50) {
			return "You suck big time Billie Boy!!";
		} else if (score > 50 && score < 100) {
			return "You need some more practice before you score biggies!!";
		} else if (score > 100 && score < 200) {
			return "You are good but you can do better then that!!";
		} else if (score > 200 && score < 250) {
			return "Buoy Buoy You are a league material!!";
		} else {
			return "Hoorah!!! You are a champion Striker!!!";
		}
	}

}
