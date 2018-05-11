package com.example.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.myproject.model.Categoria;
import com.example.myproject.model.Trabalhador;
import com.example.myproject.repository.CategoriaRepository;
import com.example.myproject.repository.TrabalhadorRepository;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	TrabalhadorRepository trabalhadorRepository;
	
	@GetMapping
	public String list(@ModelAttribute("categoria")Categoria categoria, Model model) {
		
		model.addAttribute("categoria", categoria);
		
		List<Categoria> categorias = null;
		
		if(categoria.getNome() == null || categoria.getNome().isEmpty()) {
			categorias = categoriaRepository.findAll();
		} else {
			categorias = categoriaRepository.findAllByNomeContaining(categoria.getNome());
		}
		
		model.addAttribute("categorias", categorias);
		
		return "categorias";
	}
	
	@PostMapping
	public String search(@ModelAttribute("categoria")Categoria categoria, RedirectAttributes attributes) {
		
		attributes.addFlashAttribute("categoria", categoria);
		return "redirect:/categorias";
	}
	
	@GetMapping("/{id}")
	public ModelAndView details(@PathVariable Long id) {
		Categoria categoria = new Categoria();
		categoria.setId(id);
		
		ModelAndView modelAndView = new ModelAndView("trabalhadores-categoria");
		modelAndView.addObject("trabalhadores", trabalhadorRepository.findByCategoria(categoria));
		
		for(Trabalhador t: trabalhadorRepository.findByCategoria(categoria)) {
			System.out.println(t);
		}
		
		return modelAndView;
	}
	
}
