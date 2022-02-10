package com.example.demoSwagger.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoSwagger.model.Usuario;
import com.example.demoSwagger.service.DemoService;


@RestController
@Validated
public class RESTController {

	
	//Recoger errores
	/*@ExceptionHandler(IllegalStateException.class)
	public String exceptionHandler() {
		return "error";
	}*/
	
	/*@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
		return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	}*/
	
	@Autowired
	private DemoService demoService;
	
	@RequestMapping(method= RequestMethod.GET, value="/hello")
	@ResponseBody
	public String mensaje() {
		return demoService.muestraString();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	@ResponseBody
	public List<Usuario> getUser() {
		return demoService.getUsuarios();
	}

	
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	@ResponseBody
	public Usuario boorrarId(@PathVariable int id) {
		return demoService.borrarCampo(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/users")
	@ResponseBody
	public Usuario agregarUsuario(@RequestBody Usuario usuario) {
		return demoService.addUsuario(usuario);
	}
	
	
	/*@RequestMapping(method = RequestMethod.PUT, value = "/users")
	@ResponseBody
	public Usuario actualizarUsuario(@RequestBody Usuario usuario) {
		return demoService.updateUsuario(usuario);
	}*/
}
