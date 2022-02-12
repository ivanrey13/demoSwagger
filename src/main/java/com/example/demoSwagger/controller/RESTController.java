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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@Validated
@Api(value= "Controlador de usuarios")
@ApiResponses(value = {
		@ApiResponse(code=504, message = "Sistema cargando, espere un momento")
})
public class RESTController {

	
	
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
		return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@Autowired
	private DemoService demoService;
	
	@RequestMapping(method= RequestMethod.GET, value="/hello")
	@ResponseBody
	@ApiOperation(value= "Retorno mensaje de prueba")
	public String mensaje() {
		return demoService.muestraString();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	@ResponseBody
	@ApiOperation(value= "Retorno usuario")
	public List<Usuario> getUser() {
		return demoService.getUsuarios();
	}

	
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	@ResponseBody
	@ApiOperation(value= "Retorno borrado de usuario")
	public Usuario boorrarId(@PathVariable int id) {
		return demoService.borrarCampo(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/users")
	@ResponseBody
	@ApiOperation(value= "Agregar usuario")
	public Usuario agregarUsuario(@RequestBody Usuario usuario) {
		return demoService.addUsuario(usuario);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/users")
	@ResponseBody
	@ApiOperation(value= "Modificar usuario")
	public Usuario actualizarUsuario(@RequestBody Usuario usuario) {
		return demoService.updateUsuario(usuario);
	}
}
