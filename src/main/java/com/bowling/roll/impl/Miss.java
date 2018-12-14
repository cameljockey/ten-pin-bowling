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
package com.bowling.roll.impl;

import com.bowling.roll.Roll;

/**
 * Represents a Miss for {@link com.bowling.roll.Roll} having a score
 * from 1 to 9
 *
 * @author Tejinder Singh.
 */
public class Miss extends Roll {
	public Miss(int score) {
		this.isMiss = true;
		this.score = score;
	}
}
