package com.itbank.model;

import com.itbank.model.vo.AccountVO;

public interface AccountDAO {
	
	// 계정 관련 기능
	String test();

	AccountVO selectOne(AccountVO input);

	int insert(AccountVO input);

	AccountVO findID(String email);

	AccountVO findPW(AccountVO input);

	int delete(AccountVO input);

	int updatePW(AccountVO input);

	AccountVO searchId(AccountVO input);

	AccountVO searchNick(AccountVO input);

	AccountVO searchEmail(AccountVO input);
	
	// 프로필 등록 관련 기능
	String selectIdx();
	int updateProfileImg(AccountVO input);

	int setProfileImgDefault(int idx); 
}
