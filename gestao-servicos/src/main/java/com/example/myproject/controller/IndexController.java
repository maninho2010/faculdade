package com.example.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.myproject.model.Categoria;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("categoria", new Categoria());
		return "index";
	}
	
	@PostMapping("/")
	public String search(Categoria categoria, RedirectAttributes attributes) {
		
		attributes.addFlashAttribute("categoria", categoria);
		//model.addAttribute("categoria", categoria);
		return "redirect:/categorias";
		
	}
	
}
