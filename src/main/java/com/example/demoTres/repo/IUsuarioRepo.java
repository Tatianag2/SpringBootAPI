package com.example.demoTres.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demoTres.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{
	
	Usuario findByNombre(String nombre);
	
}
