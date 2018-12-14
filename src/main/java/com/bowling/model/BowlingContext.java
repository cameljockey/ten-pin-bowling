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
package com.bowling.model;

import com.bowling.game.Game;
import com.bowling.line.Line;
import com.bowling.round.Round;

/**
 * Bowling Context that encapsulates all valid classes Objects needed for Game
 * to function.
 *
 * @author Tejinder Singh.
 */
public class BowlingContext {
	private Game game;
	private Line line;
	private Round round;
	private Score score;

	/**
	 * Constructor Initializes all necessary Object required for Game with correct
	 * versions of implementations
	 * 
	 * @param line
	 * @param round
	 * @param game
	 */
	public BowlingContext(Line line, Round round, Game game) {
		this.line = line;
		this.round = round;
		this.game = game;
	}

	/**
	 * Get the pre-initialized version of {@link com.bowling.game.Game}
	 * @return Get the pre-initialized version of {@link com.bowling.game.Game}  
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Set the pre-initialized version of {@link com.bowling.game.Game}
	 * @param game :Set the pre-initialized version of {@link com.bowling.game.Game}
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * Get the pre-initialized version of {@link com.bowling.line.Line}
	 * @return Get the pre-initialized version of {@link com.bowling.line.Line}
	 */
	public Line getLine() {
		return line;
	}

	/**
	 * Set the pre-initialized version of {@link com.bowling.line.Line}
	 * @param line : Set the pre-initialized version of {@link com.bowling.line.Line}
	 */
	public void setLine(Line line) {
		this.line = line;
	}

	/**
	 * Get the pre-initialized version of {@link com.bowling.round.Round}
	 * @return Get the pre-initialized version of {@link com.bowling.round.Round}
	 */
	public Round getRound() {
		return round;
	}

	/**
	 * Set the pre-initialized version of {@link com.bowling.round.Round}
	 * @param round :Set the pre-initialized version of {@link com.bowling.round.Round}
	 */
	public void setRound(Round round) {
		this.round = round;
	}

	/**
	 * Get the pre-initialized version of {@link com.bowling.model.Score}
	 * @return Get the pre-initialized version of {@link com.bowling.model.Score}
	 */
	public Score getScore() {
		return score;
	}

	/**
	 * Set the pre-initialized version of {@link com.bowling.model.Score}
	 * @param score : Set the pre-initialized version of {@link com.bowling.model.Score}
	 */
	public void setScore(Score score) {
		this.score = score;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BowlingContext [game=" + game + ", line=" + line + ", round=" + round + ", score=" + score + "]";
	}
}
