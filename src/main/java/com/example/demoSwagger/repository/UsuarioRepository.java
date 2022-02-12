package com.example.demoSwagger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoSwagger.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	
	
	Usuario findById(int id);

	List<Usuario> findAll();
	
	Usuario deleteById(int id);
	
	Usuario save(Usuario usuario);
	
}
