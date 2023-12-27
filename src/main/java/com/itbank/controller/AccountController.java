package com.itbank.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itbank.model.vo.AccountVO;
import com.itbank.service.AccountService;

@Controller
public class AccountController {

@Autowired private AccountService as;
	
	@GetMapping("/login")
	public String login() {
		return "login/login";
	}
	
	@PostMapping("/login")
	public String login(AccountVO input, String saveId, 
			HttpSession session, HttpServletResponse response) {
		System.out.println(input.getUserid());
		System.out.println(input.getUserpw());
		System.out.println(saveId);
		
		as.login(input, saveId, session, response);
		
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		
		return "redirect:/";
	}
	
	@GetMapping("/signUp")
	public String signUp() {
		return "login/signUp";
	}
	
	@PostMapping("/signUp")
	public String signUp(Model model, AccountVO input) {
		System.out.println(input.getUserid());
		System.out.println(input.getUserpw());
		System.out.println(input.getNick());
		System.out.println(input.getEmail());
		
		model.addAttribute("map", as.signUp(input));
		
		return "login/success";
	}
	
	@GetMapping("/findId")
	public String idFind() {
		return "login/idFind";
	}
	
	@PostMapping("/findId")
	public String idFind(Model model, String email) {
		System.out.println(email);
		
		model.addAttribute("map", as.findID(email));
		
		return "login/result";
	}
	
	@GetMapping("/findPw")
	public String pwFind() {
		return "login/pwFind";
	}
	
	@PostMapping("/findPw")
	public String pwFind(Model model, AccountVO input) throws NoSuchAlgorithmException {
		System.out.println(input.getUserid());
		System.out.println(input.getEmail());
		
		model.addAttribute("map", as.findPW(input));
		
		return "login/result";
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
