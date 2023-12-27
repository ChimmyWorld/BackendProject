package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.BoardService;

@Controller
public class HomeController {
	
	@Autowired
	private BoardService bs;
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("freePreview", bs.getPreview(100));
		mav.addObject("infoPreview", bs.getPreview(200));
		mav.addObject("studyPreview", bs.getPreview(300));
		mav.addObject("qnaPreview", bs.getPreview(400));
		mav.setViewName("home");
		return mav;
	}

}
