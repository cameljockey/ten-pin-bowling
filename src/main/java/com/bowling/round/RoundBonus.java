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
package com.bowling.round;

import com.bowling.roll.Roll;

/**
 * <p>
 * Provides the bonus calculation feature to {@link com.bowling.round.Round}.
 * The interface is designed on SOLID principles for extensibility.
 * </p>
 *
 * @author Tejinder Singh.
 */
public interface RoundBonus {
	/**
	 * <p>
	 * Interface created to return the bonus calculated for a
	 * {@link com.bowling.round.Round}. We need next roll too in here so that we
	 * should know if {@link com.bowling.round.Round} resulted in Spare, in which
	 * case Bonus will differ.
	 * </p>
	 * 
	 * @param firstRoll
	 *            has the Roll representation of first {@link com.bowling.roll.Roll}
	 * @param secondRoll
	 *            has the Roll representation of second
	 *            {@link com.bowling.roll.Roll}
	 * @return Integer as Bonus calculated for {@link com.bowling.round.Round}
	 * @since 1.0
	 */
	Integer getBonus(Roll firstRoll, Roll secondRoll);
}
