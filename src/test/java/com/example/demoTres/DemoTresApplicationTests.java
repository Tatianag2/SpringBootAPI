package com.example.demoTres;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demoTres.model.Usuario;
import com.example.demoTres.repo.IUsuarioRepo;

@SpringBootTest
class DemoTresApplicationTests {
	
	//Inyeccion a la capa del repositorio para poder hacer una insercion
	@Autowired
	private IUsuarioRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	public void crearUsuarioTest() {
		Usuario us = new Usuario();
		us.setId(5);
		us.setNombre("mito");
		us.setClave(encoder.encode("123"));
		//encore permite encriptar la contraseña
		Usuario retorno = repo.save(us);
		
		assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));
	}

}
