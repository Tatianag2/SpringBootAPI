package com.example.demoTres.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoTres.model.PersonaTres;

public interface IPersonaRepo extends JpaRepository<PersonaTres, Integer>{

}
