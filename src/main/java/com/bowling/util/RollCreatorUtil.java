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
package com.bowling.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bowling.roll.Roll;
import com.bowling.roll.impl.Hit;
import com.bowling.roll.impl.Miss;
import com.bowling.roll.impl.Spare;
import com.bowling.roll.impl.Strike;

/**
 * A utility to calculate {@link com.bowling.roll.Roll} for a Character.
 *
 * @author Tejinder Singh.
 */
public class RollCreatorUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(RollCreatorUtil.class);
	
	private final static char MISS = '-';
	private final static char SPARE = '/';
	private final static char STRIKE = 'X';
	
	/**
	 * Calculates {@link com.bowling.roll.Roll} for a Character.
	 * @param rollChar
	 * @return the {@link com.bowling.roll.Roll} for the Character
	 */
	public static Roll createRollFromChar(Character rollChar) {
		logger.info("Creating out the Roll from Char passed in");
		logger.trace("The char passed in is " + rollChar);
		Roll roll = null;
		if(rollChar == null || MISS == rollChar) {
			// This is a MISS throw.
			roll = new Miss(0);
		} else if(SPARE == rollChar) {
			// This is a SPARE throw.
			roll = new Spare(10);
		} else if(STRIKE == rollChar) {
			// This is a STRIKE throw.
			roll = new Strike(10);
		} else {
			// This is a throw which knocked down some pins.
			roll = new Hit(Character.getNumericValue(rollChar));
		}
		logger.trace("The Roll getting passed back is " + roll);
		return roll;
	}
}
