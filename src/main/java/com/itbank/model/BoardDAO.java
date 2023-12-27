package com.itbank.model;

import java.util.List;
import java.util.Map;

import com.itbank.components.Paging;
import com.itbank.model.vo.AccountVO;
import com.itbank.model.vo.BoardVO;
import com.itbank.model.vo.Board_Count_ListVO;
import com.itbank.model.vo.Board_ListVO;

public interface BoardDAO {

	// 게시판
	List<Board_Count_ListVO> selectPreview(int idx);
	List<Board_Count_ListVO> selectList(Paging p);
	Board_ListVO selectOne(int idx);
	int insert(BoardVO input);
	int delete(int idx);
	int update(BoardVO input);
	int countUp(int idx);
	int selectIdx();
	Integer totalBoard(Integer type);
	
	// 마이페이지
	List<BoardVO> selectMyBoardList(Map<String, Object> param);
	Integer totalMyBoard(AccountVO user);

}
