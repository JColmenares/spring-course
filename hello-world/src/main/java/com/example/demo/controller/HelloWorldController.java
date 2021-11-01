/**
 * 
 */
package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author josea
 *
 */
@RestController 	//Anotacion permite definir que es un API REST
@RequestMapping("/hello-world")//Mapeo de ruta Inicial
public class HelloWorldController {

	@GetMapping
	public ResponseEntity<String> helloworld(){
		return new ResponseEntity<>("Hello World", HttpStatus.OK);
	}
	
}
