package com.itbank.model.vo;

import java.sql.Date;

/*
IDX        NOT NULL NUMBER        
BOARD_IDX           NUMBER        
TYPE                NUMBER        
CONTENTS   NOT NULL CLOB          
WRITER              VARCHAR2(100) 
WRITE_DATE          DATE          
 */

public class ReplyVO {
	private int idx, board_idx, type;
	private String contents, writer;
	private Date write_date;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}

}
