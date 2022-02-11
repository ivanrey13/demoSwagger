package com.example.demoSwagger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.demoSwagger.exceptionhandler.RestResponseEntityExceptionHandler;
import com.example.demoSwagger.model.Usuario;
import com.example.demoSwagger.repository.UsuarioRepository;

import lombok.NonNull;




@Service
public class DemoService {

	//@Value("${course.message}")
	//private String hello;

	//@Autowired
	//RestResponseEntityExceptionHandler rreeh;
	
	
	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	
	
	
	public String muestraString() {
		return "hello";
	}

	public List<Usuario> getUsuarios() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}
	
	public Usuario getUsuario(int id) {
		return usuarioRepository.findById(id);
	}
	
	public Usuario borrarCampo(int id) {
		return usuarioRepository.deleteById(id);
	}
	

	public Usuario addUsuario(Usuario usuario) throws IllegalStateException {
		return usuarioRepository.save(usuario);
	}
	
	/*public Usuario updateUsuario(Usuario usuario) {
		return usuarioRepository.updateUsuario(usuario);
	}*/
	
	/*public void addUserAcount(Usuario usuario) {
		Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
		
		if(!violations.isEmpty) {
			StringBuilder sb = new StringBuilder();
			sb.append(constraintViolation.getMessage());
		}
	}*/
	
	
	
}
