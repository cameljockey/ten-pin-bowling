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
package com.bowling.round.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bowling.roll.Roll;
import com.bowling.util.RollCreatorUtil;

public class TwoRollRoundTest {	

	TwoRollRound trr;
	Roll firstRoll;
	Roll secondRoll;
	Roll thirdRoll;
	
	@Before
	public void setUp() throws Exception {
		trr = new TwoRollRound();
	}
	
	@Test
	public void testGetBonusAllMiss() {
		firstRoll = RollCreatorUtil.createRollFromChar('-');
		secondRoll = RollCreatorUtil.createRollFromChar('-');
		assertThat(trr.getBonus(firstRoll, secondRoll), is(0));
	}
	
	@Test
	public void testGetBonusWithSpare() {
		firstRoll = RollCreatorUtil.createRollFromChar('2');
		secondRoll = RollCreatorUtil.createRollFromChar('/');
		assertThat(trr.getBonus(firstRoll, secondRoll), is(1));
	}
	
	@Test
	public void testGetBonusWithHit() {
		firstRoll = RollCreatorUtil.createRollFromChar('9');
		secondRoll = RollCreatorUtil.createRollFromChar('-');
		assertThat(trr.getBonus(firstRoll, secondRoll), is(0));
	}
	
	@Test
	public void testGetBonusWithStrike() {
		firstRoll = RollCreatorUtil.createRollFromChar('X');
		secondRoll = RollCreatorUtil.createRollFromChar('2');
		assertThat(trr.getBonus(firstRoll, secondRoll), is(2));
	}
	
	@Test
	public void testGetBonusGarbageValue() {
		firstRoll = RollCreatorUtil.createRollFromChar('g');
		secondRoll = RollCreatorUtil.createRollFromChar('r');
		assertThat(trr.getBonus(firstRoll, secondRoll), is(0));
	}

	@Test
	public void testGetConsumedAllMiss() {
		firstRoll = RollCreatorUtil.createRollFromChar('-');
		secondRoll = RollCreatorUtil.createRollFromChar('-');
		assertThat(trr.getConsumed(firstRoll, secondRoll), is(1));
	}

	@Test
	public void testGetConsumedWithHit() {
		firstRoll = RollCreatorUtil.createRollFromChar('2');
		secondRoll = RollCreatorUtil.createRollFromChar('4');
		assertThat(trr.getConsumed(firstRoll, secondRoll), is(1));
	}

	@Test
	public void testGetConsumedWithSpare() {
		firstRoll = RollCreatorUtil.createRollFromChar('2');
		secondRoll = RollCreatorUtil.createRollFromChar('/');
		assertThat(trr.getConsumed(firstRoll, secondRoll), is(1));
	}

	@Test
	public void testGetConsumedWithStrike() {
		firstRoll = RollCreatorUtil.createRollFromChar('X');
		secondRoll = RollCreatorUtil.createRollFromChar('5');
		assertThat(trr.getConsumed(firstRoll, secondRoll), is(0));
	}
	
	@Test
	public void testGetConsumedGarbageValue() {
		firstRoll = RollCreatorUtil.createRollFromChar('g');
		secondRoll = RollCreatorUtil.createRollFromChar('r');
		assertThat(trr.getConsumed(firstRoll, secondRoll), is(1));
	}

	@Test
	public void testGetScoreAllMiss() {
		firstRoll = RollCreatorUtil.createRollFromChar('-');
		secondRoll = RollCreatorUtil.createRollFromChar('-');
		assertThat(trr.getScore(firstRoll, secondRoll, thirdRoll), is(0));
	}

	@Test
	public void testGetScoreWithHit() {
		firstRoll = RollCreatorUtil.createRollFromChar('2');
		secondRoll = RollCreatorUtil.createRollFromChar('3');
		thirdRoll = RollCreatorUtil.createRollFromChar('4');
		assertThat(trr.getScore(firstRoll, secondRoll, thirdRoll), is(5));
	}

	@Test
	public void testGetScoreWithSpare() {
		firstRoll = RollCreatorUtil.createRollFromChar('3');
		secondRoll = RollCreatorUtil.createRollFromChar('/');
		thirdRoll = RollCreatorUtil.createRollFromChar('-');
		assertThat(trr.getScore(firstRoll, secondRoll, thirdRoll), is(10));
	}

	@Test
	public void testGetScoreWithStrike() {
		firstRoll = RollCreatorUtil.createRollFromChar('X');
		secondRoll = RollCreatorUtil.createRollFromChar('3');
		thirdRoll = RollCreatorUtil.createRollFromChar('4');
		assertThat(trr.getScore(firstRoll, secondRoll, thirdRoll), is(17));
	}
	
	@Test
	public void testGetScoreGarbageValue() {
		firstRoll = RollCreatorUtil.createRollFromChar('g');
		secondRoll = RollCreatorUtil.createRollFromChar('r');
		thirdRoll = RollCreatorUtil.createRollFromChar('z');
		assertThat(trr.getScore(firstRoll, secondRoll, thirdRoll), is(43));
	}

}
