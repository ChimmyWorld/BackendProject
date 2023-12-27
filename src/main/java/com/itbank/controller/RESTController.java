package com.itbank.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.model.vo.AccountVO;
import com.itbank.model.vo.ReplyVO;
import com.itbank.service.AccountService;
import com.itbank.service.ReplyService;

@RestController
public class RESTController {
	
	@Autowired private AccountService as;
	@Autowired private ReplyService rs;
	
	@GetMapping("/myPage/pwCheck")
	public String pwHash(String password) throws NoSuchAlgorithmException {
		return as.changeHash(password);
	}
	
	@GetMapping("/signUp/existId")
	public AccountVO existId(AccountVO input) {
		System.out.println(input.getUserid());
		
		AccountVO acc = as.existId(input);
		
		return acc;
	}
	
	@GetMapping("/signUp/existNick")
	public AccountVO existNick(AccountVO input) {
		System.out.println(input.getNick());
		
		AccountVO acc = as.existNick(input);
		
		return acc;
	}
	
	@GetMapping("/signUp/existEmail")
	public AccountVO existEmail(AccountVO input) {
		System.out.println(input.getEmail());
		
		AccountVO acc = as.existEmail(input);
		
		return acc;
	}
	
	@PostMapping("articles/replyedit")
	public String replyUpdate(@RequestBody ReplyVO input) {
		System.out.println(input.getContents());
		
		String contents = rs.replyUpdate(input);
		
		return contents;
	}
	
	@ExceptionHandler(NoSuchAlgorithmException.class)
	public String algoEx() {
		return "redirect:/";
	}
	
	@PatchMapping("/myPage/info/{idx}")
	public int setDefaultImage(AccountVO input, HttpSession session) {
		System.out.println(input);
		System.out.println(input.getIdx());
		
		int row = as.setProfileImgDefault(input.getIdx(), session);

		return row;
	}
	
}