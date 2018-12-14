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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class RollCreatorUtilTest {

	@Test
	public void testCreateRollFromCharMiss() {
		char evalChar = '-';
		assertThat(RollCreatorUtil.createRollFromChar(evalChar).isMiss(), is(true));
		assertThat(RollCreatorUtil.createRollFromChar(evalChar).ishit(), is(false));
		assertThat(RollCreatorUtil.createRollFromChar(evalChar).isSpare(), is(false));
		assertThat(RollCreatorUtil.createRollFromChar(evalChar).isStrike(), is(false));
	}
	
	@Test
	public void testCreateRollFromCharHit() {
		char evalChar = '3';
		assertThat(RollCreatorUtil.createRollFromChar(evalChar).isMiss(), is(false));
		assertThat(RollCreatorUtil.createRollFromChar(evalChar).ishit(), is(true));
		assertThat(RollCreatorUtil.createRollFromChar(evalChar).isSpare(), is(false));
		assertThat(RollCreatorUtil.createRollFromChar(evalChar).isStrike(), is(false));
	}
	
	@Test
	public void testCreateRollFromCharSpare() {
		char evalChar = '/';
		assertThat(RollCreatorUtil.createRollFromChar(evalChar).isMiss(), is(false));
		assertThat(RollCreatorUtil.createRollFromChar(evalChar).ishit(), is(false));
		assertThat(RollCreatorUtil.createRollFromChar(evalChar).isSpare(), is(true));
		assertThat(RollCreatorUtil.createRollFromChar(evalChar).isStrike(), is(false));
	}
	
	@Test
	public void testCreateRollFromCharStrike() {
		char evalChar = 'X';
		assertThat(RollCreatorUtil.createRollFromChar(evalChar).isMiss(), is(false));
		assertThat(RollCreatorUtil.createRollFromChar(evalChar).ishit(), is(false));
		assertThat(RollCreatorUtil.createRollFromChar(evalChar).isSpare(), is(false));
		assertThat(RollCreatorUtil.createRollFromChar(evalChar).isStrike(), is(true));
	}

}
