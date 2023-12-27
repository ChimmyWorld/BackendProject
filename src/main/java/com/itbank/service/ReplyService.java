package com.itbank.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.components.Paging;
import com.itbank.model.ReplyDAO;
import com.itbank.model.vo.AccountVO;
import com.itbank.model.vo.BoardVO;
import com.itbank.model.vo.ReplyVO;
import com.itbank.model.vo.Reply_ListVO;

@Service
public class ReplyService {
	@Autowired
	private ReplyDAO dao;
	
	public List<Reply_ListVO> getReplys(int board_idx){
		return dao.selectReplyAll(board_idx);
	}
	
	public int addReply(ReplyVO input) {
		return dao.insertReply(input);
	}
	
	public String deleteReply(int idx) {
 		ReplyVO vo = dao.selectBoardIdx(idx);
 		
		dao.deleteReply(idx);
		
		String path = "";
		
		if (vo.getType() == 401) {
			path = "qna/" + vo.getBoard_idx();
		}
		
		else path = "articles/" + vo.getBoard_idx();
		
		return path;
	}
	
	public int countReply(int idx) {
		return dao.countOne(idx);
	}

	public Map<String, Object> getMyReplys(Integer idx, Integer type, String order, 
			String keyword, String search, AccountVO user) {
		idx = idx == null ? 1 : idx;

		// 페이징 코드
		Paging p = new Paging(idx, dao.totalMyReply(user), type, order, keyword, search);
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("user", user);
		param.put("p", p);
		
		List<BoardVO> list = dao.selectMyReplyList(param);
		
		Map<String, Object> result = new HashMap<>();

		result.put("p", p);
		result.put("list", list);
		
		return result;
	}

	public String replyUpdate(ReplyVO input) {
		int row = dao.updateReply(input);
		
		if(row == 1) {
			return input.getContents();
		}
		
		return null;
	}

}
