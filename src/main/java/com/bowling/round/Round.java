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

/**
 * <p>
 * Interface created to Represent a full {@link com.bowling.round.Round}
 * containing two {@link com.bowling.roll.Roll}s. However if its a Strike then
 * only 1 {@link com.bowling.roll.Roll}. The interface is culmination of three
 * other Interfaces designed on SOLID principles. This Interface provides all
 * three as single representation to help in providing more extensibility.
 * </p>
 *
 * @author Tejinder Singh.
 */
public interface Round extends RoundBonus, RoundConsumed, RoundScore {

}
