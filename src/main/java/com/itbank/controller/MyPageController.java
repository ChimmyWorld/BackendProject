package com.itbank.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.vo.AccountVO;
import com.itbank.service.AccountService;
import com.itbank.service.BoardService;
import com.itbank.service.ReplyService;

@Controller
@RequestMapping("/myPage")
public class MyPageController {
	
	@Autowired private AccountService as;
	@Autowired private BoardService bs;
	@Autowired private ReplyService rs;

	@GetMapping("/info")
	public void info() {}
	
	@PostMapping("/info")
	public String info(AccountVO input, HttpSession session) throws IOException{
		as.updateProfileImg(input, session);
		
		return "myPage/info";
	}
	
	@GetMapping("/articles")
	public ModelAndView articles(HttpSession session,
			@RequestParam(name = "page", defaultValue = "1") Integer page,
			@RequestParam(name = "type", defaultValue = "") Integer type,
			@RequestParam(name = "order", defaultValue = "idx") String order,
			@RequestParam(name = "keyword", defaultValue ="title") String keyword,
			@RequestParam(name = "search", defaultValue ="") String search) {
		ModelAndView mav = new ModelAndView();
		AccountVO user = (AccountVO) session.getAttribute("user");
		
		Map<String, Object> result = bs.getMyBoardList(page, type, order, keyword, search, user);
		
		mav.addObject("myBoardList", result.get("list"));
		mav.addObject("p", result.get("p"));
		
		return mav;
	}
	
	@GetMapping("/replies")
	public ModelAndView replies(HttpSession session,
			@RequestParam(name = "page", defaultValue = "1") Integer page,
			@RequestParam(name = "type", defaultValue = "") Integer type,
			@RequestParam(name = "order", defaultValue = "idx") String order,
			@RequestParam(name = "keyword", defaultValue ="contents") String keyword,
			@RequestParam(name = "search", defaultValue ="") String search) {
		ModelAndView mav = new ModelAndView();
		AccountVO user = (AccountVO) session.getAttribute("user");
		
		Map<String, Object> result = rs.getMyReplys(page, type, order, keyword, search, user);
		
		mav.addObject("myReplyList", result.get("list"));
		mav.addObject("p", result.get("p"));
		
		return mav;
	}
	
	@GetMapping("/settings")
	public void settings() {}
	
	@GetMapping("/pwChange")
	public void pwChange() {}
	
	@PostMapping("/pwChange")
	public String pwChange(Model model, AccountVO input, String newpw) throws NoSuchAlgorithmException {
		System.out.println(input.getUserpw());
		System.out.println(newpw);
		
		model.addAttribute("map", as.updateUser(input, newpw));
		
		return "myPage/pwChangeSuccess";
	}
	
	@GetMapping("/withdraw")
	public void withdraw() {}
	
	@PostMapping("/withdraw")
	public String withdraw(AccountVO input) {
		System.out.println(input.getIdx());
		
		as.deleteUser(input);
		
		return "myPage/withdrawComplete";
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public String ex() {
		System.out.println("SQL에 작성 실패");
		
		return "redirect:/";
	}
	
	@ExceptionHandler(NoSuchAlgorithmException.class)
	public String algoEx() {
		return "redirect:/";
	}
}
