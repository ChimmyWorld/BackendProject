package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.itbank.model.vo.ReplyVO;
import com.itbank.service.ReplyService;

@Controller
public class ReplyController {
	@Autowired
	private ReplyService rs;
	
	@GetMapping("/reply/{idx}/delete")
	public String deleteReply(ReplyVO input) {
		String path = rs.deleteReply(input.getIdx());
		
		return "redirect:/" + path;
	}

}
