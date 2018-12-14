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
package com.bowling.game;

import java.util.List;

import com.bowling.model.BowlingContext;
import com.bowling.model.Score;

/**
 * Interface created to Represent a full game for the bowling.
 *
 * @author Tejinder Singh.
 */
public interface Game {
	/**
	 * <p>
	 * To return the List of {@link com.bowling.model.Score} for a single/multi
	 * player game
	 * </p>
	 * 
	 * @param context
	 *            of all essential instantiated Objects necessary for calculation to
	 *            proceed
	 * @param rollStringList
	 *            has all {@link com.bowling.roll.Roll} as a List of String
	 * @return List of {@link com.bowling.model.Score} (each score has score,
	 *         message and boolean if calculation was success)
	 * @author Tejinder Singh.
	 * @since 1.0
	 */
	List<Score> evaluate(BowlingContext context, List<String> rollStringList);
}
