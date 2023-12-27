package com.itbank.model;

import java.util.List;
import java.util.Map;

import com.itbank.model.vo.AccountVO;
import com.itbank.model.vo.BoardVO;
import com.itbank.model.vo.ReplyVO;
import com.itbank.model.vo.Reply_ListVO;

public interface ReplyDAO {
	List<Reply_ListVO> selectReplyAll(int board_idx);

	int insertReply(ReplyVO input);
	
	int deleteReply(int idx);

	int countOne(int idx);

	List<ReplyVO> selectMyReplyAll(AccountVO user);

	int updateReply(ReplyVO input);

	List<BoardVO> selectMyReplyList(Map<String, Object> param);

	ReplyVO selectBoardIdx(int idx);

	String selectType(int idx);

	int totalMyReply(AccountVO user);
	
}
