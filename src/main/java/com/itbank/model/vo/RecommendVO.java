package com.itbank.model.vo;

/*
BOARD_IDX      NUMBER        
RECOMMENDER    VARCHAR2(100) 
GOOD           NUMBER        
 */

public class RecommendVO {
	private int board_idx, good, isCheck;
	private String recommender;
	
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	public String getRecommender() {
		return recommender;
	}
	public void setRecommender(String recommender) {
		this.recommender = recommender;
	}
	public int getIsCheck() {
		return isCheck;
	}
	public void setIsCheck(int isCheck) {
		this.isCheck = isCheck;
	}

}
