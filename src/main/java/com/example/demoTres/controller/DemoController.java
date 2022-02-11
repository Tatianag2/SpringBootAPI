package com.example.demoTres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demoTres.model.PersonaTres;
import com.example.demoTres.repo.IPersonaRepo;

@Controller
public class DemoController {
	@Autowired
	private IPersonaRepo repo;
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		//logica
		PersonaTres p = new PersonaTres();
		p.setIdPersona(8);
		p.setNombre("Gilberto");
		repo.save(p);
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@GetMapping("/listar")
	public String greeting(Model model) {
		//logica
		model.addAttribute("personas", repo.findAll());
		return "greeting";
	}
}
