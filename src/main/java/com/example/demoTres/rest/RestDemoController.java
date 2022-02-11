package com.example.demoTres.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoTres.model.PersonaTres;
import com.example.demoTres.repo.IPersonaRepo;
//Nota: me sale error con @RequestBody, error 415 en Postman, PUT me esta también agregando elementos nuevos
//consumes y produces, investigar
@RestController
@RequestMapping("/personas")
public class RestDemoController {
	@Autowired
	private IPersonaRepo repo;
	
	@GetMapping
	public List<PersonaTres> Listar(){
		return repo.findAll();
	}
	
	@PostMapping
	public void insertar(PersonaTres per){
		repo.save(per);
	}
	//Este put se debe modificar
	@PutMapping(value = "/{id}")
	public void modificar(PersonaTres per) {
		//.findById(id);
		//.save(per);
		repo.save(per);
		
		//save se comporta de acuerdo a la llave primaria que se este pasando
	}
	//No me elimina con el 0 por queeeeee
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
	
}