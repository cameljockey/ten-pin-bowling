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
package com.bowling.roll;

/**
 * Represents a Roll and its score. Which can be
 * {@link com.bowling.roll.impl.Hit}, {@link com.bowling.roll.impl.Miss},
 * {@link com.bowling.roll.impl.Spare}, {@link com.bowling.roll.impl.Strike}
 *
 * @author Tejinder Singh.
 */
public abstract class Roll {

	/**
	 * Whether the {@link com.bowling.roll.Roll} was a Miss as primitive
	 * {@code boolean}
	 */
	protected boolean isMiss;

	/**
	 * Whether the {@link com.bowling.roll.Roll} was a Spare as primitive
	 * {@code boolean}
	 */
	protected boolean isSpare;

	/**
	 * Whether the {@link com.bowling.roll.Roll} was a Strike as primitive
	 * {@code boolean}
	 */
	protected boolean isStrike;

	/**
	 * Whether the {@link com.bowling.roll.Roll} was a Hit as primitive
	 * {@code boolean}
	 */
	protected boolean isHit;

	/**
	 * The primitive {@code boolean} Score for a {@link com.bowling.roll.Roll}
	 */
	protected int score;

	/**
	 * Whether the {@link com.bowling.roll.Roll} was a Miss as primitive
	 * {@code boolean}
	 * 
	 * @return Whether the {@link com.bowling.roll.Roll} was a Miss as primitive
	 *         {@code boolean}
	 */
	public boolean isMiss() {
		return isMiss;
	}

	/**
	 * Whether the {@link com.bowling.roll.Roll} was a Spare as primitive
	 * {@code boolean}
	 * 
	 * @return Whether the {@link com.bowling.roll.Roll} was a Spare as primitive
	 *         {@code boolean}
	 */
	public boolean isSpare() {
		return isSpare;
	}

	/**
	 * Whether the {@link com.bowling.roll.Roll} was a Strike as primitive
	 * {@code boolean}
	 * 
	 * @return Whether the {@link com.bowling.roll.Roll} was a Strike as primitive
	 *         {@code boolean}
	 */
	public boolean isStrike() {
		return isStrike;
	}

	/**
	 * Whether the {@link com.bowling.roll.Roll} was a Hit as primitive
	 * {@code boolean}
	 * 
	 * @return Whether the {@link com.bowling.roll.Roll} was a Hit as primitive
	 *         {@code boolean}
	 */
	public boolean ishit() {
		return isHit;
	}

	/**
	 * Gets the primitive {@code boolean} {@link com.bowling.model.Score} for a
	 * {@link com.bowling.roll.Roll}
	 * 
	 * @return Gets the primitive {@code boolean} {@link com.bowling.model.Score}
	 *         for a {@link com.bowling.roll.Roll}
	 */
	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Roll [isMiss=" + isMiss + ", isSpare=" + isSpare + ", isStrike=" + isStrike + ", isHit=" + isHit
				+ ", score=" + score + "]";
	}
}
