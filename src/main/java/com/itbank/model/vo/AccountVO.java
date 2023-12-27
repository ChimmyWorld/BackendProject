package com.itbank.model.vo;

/*
IDX         NOT NULL NUMBER        
USERID      NOT NULL VARCHAR2(100) 
USERPW      NOT NULL VARCHAR2(128) 
NICK        NOT NULL VARCHAR2(100) 
EMAIL       NOT NULL VARCHAR2(300) 
JOIN_DATE            DATE          
ISROOT               CHAR(1)       
PROFILE_IMG          VARCHAR2(500) 
*/

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class AccountVO {
	private int idx;
	private String userid, userpw;
	private String nick, email;
	private String profile_img;
	private Date join_date;
	private MultipartFile upload;
	private boolean isRoot;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	public boolean isRoot() {
		return isRoot;
	}
	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}
	

}