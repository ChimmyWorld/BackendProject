package com.itbank.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.vo.BoardVO;
import com.itbank.model.vo.ReplyVO;
import com.itbank.service.BoardService;
import com.itbank.service.RecommendService;
import com.itbank.service.ReplyService;

@Controller
public class QnaController {
	@Autowired private BoardService bs;
	@Autowired private ReplyService rs;
	@Autowired private RecommendService recs;

	// QnA 게시판
	@GetMapping("/qna")
	public ModelAndView qna(@RequestParam(name = "page", defaultValue = "1") Integer page,
			@RequestParam(name = "order", defaultValue = "idx") String order,
			@RequestParam(name = "keyword", defaultValue = "title") String keyword,
			@RequestParam(name = "search", defaultValue = "") String search) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> result = bs.getList(page, 400, order, keyword, search);

		mav.addObject("qnaList", result.get("list"));
		mav.addObject("p", result.get("p"));
		mav.setViewName("/board/qna");
		return mav;
	}

	@GetMapping("/qna/new")
	public String writeQnA() {
		return "/board/newQna";
	}

	@PostMapping("/qna/new")
	public String writeQnA(BoardVO input) throws IOException {
		int idx = bs.writeBoard(input);

		return "redirect:/qna/" + idx;
	}
	
	@GetMapping("/qna/{idx}")
	public ModelAndView view(@PathVariable int idx, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("view", bs.updateViewCount(idx));
		mav.addObject("row", bs.getBoard(idx));
		mav.addObject("replys", rs.getReplys(idx));
		mav.addObject("reply", rs.countReply(idx));
		mav.addObject("isChecked", recs.userCheck(idx, session));
		mav.setViewName("/board/articles_qna");

		return mav;
	}

	@PostMapping("/qna/{idx}")
	public ModelAndView view(ReplyVO input) {
		ModelAndView mav = new ModelAndView("msg");

		mav.addObject("row", rs.addReply(input));
		mav.addObject("message", "작성완료");

		return mav;
	}

	@GetMapping("/qna/{idx}/edit")
	public ModelAndView update(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("row", bs.getBoard(idx));
		mav.setViewName("/board/update");

		return mav;
	}

	@PostMapping("/qna/{idx}/edit")
	public String update(BoardVO input) throws IOException {
		bs.updateBoard(input);

		return "redirect:/qna/" + input.getIdx();
	}

	@GetMapping("/qna/{idx}/delete")
	public String delete(@PathVariable int idx) {
		bs.deleteBoard(idx);

		return "redirect:/";
	}
	
	
}
