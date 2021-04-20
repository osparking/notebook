package com.jbpark.notebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jbpark.notebook.domain.Memo;
import com.jbpark.notebook.service.MemoService;

@Controller
public class IndexController {
	@RequestMapping("/")
	public String index(Model model) {
		List<Memo> memo_list = memoService.getMemoLines(10);
		
		model.addAttribute("memo_list", memo_list);
		model.addAttribute("ownerName", "박종범");
		model.addAttribute("welcomMsg", "지금 당신의 기분은?");
		Memo newMemo = new Memo();
		model.addAttribute("newMemo", newMemo);
		return "index";
	}

	@Autowired
	MemoService memoService;

	@RequestMapping("/deleteMemo")
	public String deleteMemo(@RequestParam("seqNo") int seqNo,
			RedirectAttributes redAttrs) {
		int delCount = memoService.deleteMemo(seqNo);
		redAttrs.addFlashAttribute("delCount", delCount);
		redAttrs.addFlashAttribute("delSeqNo", seqNo);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String saveMemo(@ModelAttribute("newMemo") Memo newMemo, 
			Model model) {
		try {
			memoService.addMemo(newMemo);
		} catch (DataAccessException e) {
			return "index";
		}
		return "redirect:/";
	}
}
