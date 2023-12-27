package com.itbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.model.vo.RecommendVO;
import com.itbank.service.RecommendService;

@RestController
public class RecommendController {
	
	@Autowired private RecommendService rs;
	
	// 게시판 (free, info, study) 
	@GetMapping("articles/recommend/goodCount")
	public int countGood(RecommendVO input) {
		System.out.println(input.getBoard_idx());
		System.out.println(input.getGood());
		
		int count = rs.getGood(input);
		
		return count;
	}
	
	@GetMapping("articles/recommend/badCount")
	public int countBad(RecommendVO input) {
		System.out.println(input.getBoard_idx());
		System.out.println(input.getGood());
		
		int count = rs.getGood(input);
		
		return count;
	}
	
	@GetMapping("articles/recommend/user")
	public int userCheck(RecommendVO input, HttpSession session) {
		int isChecked = rs.userCheck(input, session);
		
		return isChecked;
	}

	@PostMapping("articles/recommend/recommendGood")
	public ResponseEntity<Integer> recommendGood(@RequestBody RecommendVO input, HttpSession session) {
		int result = rs.processGood(input, session);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("articles/recommend/recommendBad")
	public ResponseEntity<Integer> recommendBad(@RequestBody RecommendVO input, HttpSession session) {
		int result = rs.processBad(input, session);
		return ResponseEntity.ok(result);
	}
	
	// QnA
	@GetMapping("qna/recommend/goodCount")
	public int countGoodQna(RecommendVO input) {
		System.out.println(input.getBoard_idx());
		System.out.println(input.getGood());
		
		int count = rs.getGood(input);
		
		return count;
	}
	
	@GetMapping("qna/recommend/badCount")
	public int countBadQna(RecommendVO input) {
		System.out.println(input.getBoard_idx());
		System.out.println(input.getGood());
		
		int count = rs.getGood(input);
		
		return count;
	}
	
	@GetMapping("qna/recommend/user")
	public int userCheckQna(RecommendVO input, HttpSession session) {
		int isChecked = rs.userCheck(input, session);
		
		return isChecked;
	}

	@PostMapping("qna/recommend/recommendGood")
	public ResponseEntity<Integer> recommendGoodQna(@RequestBody RecommendVO input, HttpSession session) {
		int result = rs.processGood(input, session);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("qna/recommend/recommendBad")
	public ResponseEntity<Integer> recommendBadQna(@RequestBody RecommendVO input, HttpSession session) {
		int result = rs.processBad(input, session);
		return ResponseEntity.ok(result);
	}
}
