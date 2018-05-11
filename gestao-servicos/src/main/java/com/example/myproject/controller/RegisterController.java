package com.example.myproject.controller;

import java.lang.reflect.InvocationTargetException;

import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.myproject.model.Role;
import com.example.myproject.model.Trabalhador;
import com.example.myproject.model.Usuario;
import com.example.myproject.model.Cliente;
import com.example.myproject.repository.ClienteRepository;
import com.example.myproject.repository.TrabalhadorRepository;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private ClienteRepository cr;
	
	@Autowired
	private TrabalhadorRepository tr;
	
	@GetMapping
	public String register(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("roleSelected", new Role());
		return "register";
	}
	
	@Transactional
	@PostMapping
	public ModelAndView register(Usuario usuario, Role roleSelected) throws IllegalAccessException, InvocationTargetException {
		
		Cliente c = new Cliente();
		Trabalhador t = new Trabalhador();
		
		if(roleSelected.nomeRole.equals("cliente")) {
			BeanUtils.copyProperties(c, usuario);
			cr.save(c);
		} else if(roleSelected.nomeRole.equals("trabalhar")) {
			BeanUtils.copyProperties(t, usuario);
			tr.save(t);
		}
		
		return confirmRegistration(usuario);
		
	}
	
	public ModelAndView confirmRegistration(Usuario usuario) {
		
		ModelAndView modelAndView = new ModelAndView("confirm-registration");
		modelAndView.addObject(usuario);
		
		return modelAndView;
	}
}
