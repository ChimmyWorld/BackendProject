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
public class BoardController {

	@Autowired private BoardService bs;
	@Autowired private ReplyService rs;
	@Autowired private RecommendService recs;
	
	// 자유 게시판
	@GetMapping("/free")
	public ModelAndView free(@RequestParam(name = "page", defaultValue = "1") Integer page,
			@RequestParam(name = "order", defaultValue = "idx") String order,
			@RequestParam(name = "keyword", defaultValue ="title") String keyword,
			@RequestParam(name = "search", defaultValue ="") String search){
		ModelAndView mav = new ModelAndView();
		Map<String, Object> result = bs.getList(page, 100, order, keyword, search);

		mav.addObject("freeList", result.get("list"));
		mav.addObject("p", result.get("p"));
		mav.setViewName("/board/free");
		return mav;
	}

	@GetMapping("/free/new")
	public String writeFree() {
		return "/board/newFree";
	}

	@PostMapping("/free/new")
	public String writeFree(BoardVO input) throws IOException {
		int idx = bs.writeBoard(input);

		return "redirect:/articles/" + idx;
	}

	// 정보/팁 게시판
	@GetMapping("/info")
	public ModelAndView info(@RequestParam(name = "page", defaultValue = "1") Integer page,
			@RequestParam(name = "order", defaultValue = "idx") String order,
			@RequestParam(name = "keyword", defaultValue ="title") String keyword,
			@RequestParam(name = "search", defaultValue ="") String search){
		ModelAndView mav = new ModelAndView();
		Map<String, Object> result = bs.getList(page, 200, order, keyword, search);

		mav.addObject("infoList", result.get("list"));
		mav.addObject("p", result.get("p"));
		mav.setViewName("/board/info");
		return mav;
	}

	@GetMapping("/info/new")
	public String writeInfo() {
		return "/board/newInfo";
	}
	
	
	
	@PostMapping("/info/new")
	public String writeInfo(BoardVO input) throws IOException {
		int idx = bs.writeBoard(input);

		return "redirect:/articles/" + idx;
	}

	// 스터디 게시판
	@GetMapping("/study")
	public ModelAndView study(@RequestParam(name = "page", defaultValue = "1") Integer page,
			@RequestParam(name = "order", defaultValue = "idx") String order,
			@RequestParam(name = "keyword", defaultValue ="title") String keyword,
			@RequestParam(name = "search", defaultValue ="") String search){
		ModelAndView mav = new ModelAndView();
		Map<String, Object> result = bs.getList(page, 300, order, keyword, search);

		mav.addObject("studyList", result.get("list"));
		mav.addObject("p", result.get("p"));
		mav.setViewName("/board/study");
		return mav;
	}

	@GetMapping("/study/new")
	public String writeStudy() {
		return "/board/newStudy";
	}

	@PostMapping("/study/new")
	public String writeStudy(BoardVO input) throws IOException {
		int idx = bs.writeBoard(input);

		return "redirect:/articles/" + idx;
	}

	@GetMapping("/articles/{idx}")
	public ModelAndView view(@PathVariable int idx, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("view", bs.updateViewCount(idx));
		mav.addObject("row", bs.getBoard(idx));
		mav.addObject("replys", rs.getReplys(idx));
		mav.addObject("reply", rs.countReply(idx));
		mav.addObject("isChecked", recs.userCheck(idx, session));
		mav.setViewName("/board/articles");

		return mav;
	}

	@PostMapping("/articles/{idx}")
	public ModelAndView view(ReplyVO input) {
		ModelAndView mav = new ModelAndView("msg");

		mav.addObject("row", rs.addReply(input));
		mav.addObject("message", "작성완료");

		return mav;
	}

	@GetMapping("/articles/{idx}/edit")
	public ModelAndView update(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("row", bs.getBoard(idx));
		mav.setViewName("/board/update");

		return mav;
	}

	@PostMapping("/articles/{idx}/edit")
	public String update(BoardVO input) throws IOException {
		bs.updateBoard(input);

		return "redirect:/articles/" + input.getIdx();
	}

	@GetMapping("/articles/{idx}/delete")
	public String delete(@PathVariable int idx) {
		bs.deleteBoard(idx);

		return "redirect:/";
	}


}
