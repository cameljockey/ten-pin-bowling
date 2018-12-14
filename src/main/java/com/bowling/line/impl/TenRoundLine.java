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
package com.bowling.line.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bowling.line.Line;
import com.bowling.model.BowlingContext;
import com.bowling.roll.Roll;
import com.bowling.round.Round;
import com.bowling.util.RollCreatorUtil;

/**
 * Represent a Single Player Ten Round Line for bowling.
 *
 * @author Tejinder Singh.
 */
public class TenRoundLine implements Line {

	private static final Logger logger = LoggerFactory.getLogger(TenRoundLine.class);

	public Integer CalculateLineScore(BowlingContext context, String rollString) {
		logger.info("Entering the TenRoundLine to calculate Line Score");
		logger.debug("Calculating the line score for " + rollString);
		// Split the string into a List of 1-character entries.
		// Prepare the List to host all rolls. Add place for 2 more virtual
		// entries so that we don't have to check for null's for 2nd and 3rd rolls in
		// last round.
		List<Character> rollsCharList = rollString.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

		int totalRollCount = rollsCharList.size();
		logger.debug("Total Roll Count is " + totalRollCount);
		// Add 2 more virtual entries (2nd and 3rd roll in last round.)
		rollsCharList.add(null);
		rollsCharList.add(null);
		// Calculate Total Score By Recreating Round In Loops
		int totalScore = CalculateTotalScoreByRecreatingRoundInLoops(context, rollsCharList, totalRollCount);
		logger.debug("Total Score calculated is " + totalScore);
		logger.info("Exiting the TenRoundLine to calculate Line Score");
		return totalScore;
	}

	private int CalculateTotalScoreByRecreatingRoundInLoops(BowlingContext context, List<Character> rollsCharList,
			int totalRollCount) {
		// Initialize counter variable.
		int totalScore = 0;

		// Get the Object of kind of Round chosen for this game.
		Round theRound = context.getRound();

		// Start analyzing at first roll.
		int rollPos = 0;

		// initialize bonus as zero to start
		int rollBonus = 0;
		logger.info("Starting Analysis of rolls using a loop in order to recreate the rounds");
		// Analyze the rolls using a loop in order to recreate the rounds.
		do {
			// Next round...

			// Get (possibly) three Rolls of this round.
			Roll firstRoll = RollCreatorUtil.createRollFromChar(rollsCharList.get(rollPos));
			Roll secondRoll = RollCreatorUtil.createRollFromChar(rollsCharList.get(rollPos + 1));
			Roll thirdRoll = RollCreatorUtil.createRollFromChar(rollsCharList.get(rollPos + 2));

			// Add round's score to total score.
			totalScore += theRound.getScore(firstRoll, secondRoll, thirdRoll);

			// Jump the consumed rolls so that we don't process them with round.
			rollPos += theRound.getConsumed(firstRoll, secondRoll);

			rollBonus = theRound.getBonus(firstRoll, secondRoll);
			logger.trace("firstRoll=" + firstRoll + ", secondRoll=" + secondRoll + ", thirdRoll=" + thirdRoll
					+ ", totalScore=" + totalScore + ", rollPos=" + rollPos + ", rollBonus=" + rollBonus);

		} while (totalRollCount - rollBonus > ++rollPos);
		return totalScore;
	}

}
