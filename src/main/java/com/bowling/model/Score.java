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

import java.util.ArrayList;
import java.util.List;

/**
 * Score Object to encapsulate all important information related for Score.
 *
 * @author Tejinder Singh.
 */
public class Score {

	private List<Integer> scoreList = new ArrayList<Integer>();
	private String message;
	private boolean isSuccess;

	/**
	 * Get the list of {@link com.bowling.model.Score}
	 * @return Get the list of {@link com.bowling.model.Score}
	 */
	public List<Integer> getScoreList() {
		return this.scoreList;
	}

	/**
	 * Set the list of {@link com.bowling.model.Score}
	 * @param scoreList : Set the list of {@link com.bowling.model.Score}
	 */
	public void setScoreList(List<Integer> scoreList) {
		this.scoreList = scoreList;
	}

	/**
	 * Get the message {@link String} to display to User
	 * @return Get the message {@link String} to display to User
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Set the message {@link String} to display to User
	 * @param message : Set the message {@link String} to display to User
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Get the boolean flag if Score was calculated successfully
	 * @return Get the boolean flag if Score was calculated successfully
	 */
	public boolean isSuccess() {
		return isSuccess;
	}

	/**
	 * Set the boolean flag if Score was calculated successfully
	 * @param isSuccess : Set the boolean flag if Score was calculated successfully
	 */
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Score [scoreList=" + scoreList + ", message=" + message + ", isSuccess=" + isSuccess + "]";
	}

}
