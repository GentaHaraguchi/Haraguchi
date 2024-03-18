package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.GakuseiHyou;
import com.example.demo.sarvice.GakuseiService;

import io.micrometer.common.lang.NonNull;
 
@Controller
public class MainController {
	@Autowired
	private GakuseiService GakuseiService;
@GetMapping("/")
public String index(Model model) {
	model.addAttribute("message", "こんにちは");
	return "top";
	}

@GetMapping("/test/")
public String index2(Model model) {
  model.addAttribute("message", "こんにちは");
  return "top2";
  }

@GetMapping("/touroku/")
public ModelAndView add(GakuseiHyou gakuseihyou, ModelAndView model)  {
	model.addObject("gakuseihyou", gakuseihyou);
	model.setViewName("touroku");
	return model;
	}

@PostMapping("/gakuseihyou/")
public String gakuseihyou(@Validated @ModelAttribute @NonNull GakuseiHyou gakuseihyou, RedirectAttributes result, ModelAndView model,
		RedirectAttributes redirectAttributes) {
	try {
		this.GakuseiService.save(gakuseihyou);
		redirectAttributes.addFlashAttribute("exception", "");
		
	} catch (Exception e) {
		
		redirectAttributes.addFlashAttribute("exception", e.getMessage());
	}
	return "redirect:/";
	}
}