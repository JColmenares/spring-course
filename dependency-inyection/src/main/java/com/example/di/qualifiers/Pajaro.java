/**
 * 
 */
package com.example.di.qualifiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author JColmenares
 *
 */


/* 2- Se puede especificar un nombre al @Component, de la clase que se quiere tomar, en este caso se le
 * Aplica a la clase Pajaro, quedando su Estereotipo @Component("pajarito"), por lo que ahora se le llama por ese
 * nombre, en el getBeam context.getBean("pajarito",Animal.class); desde su contexto.
 * 
 * NOTA: Al espeficicarle nombre al @Component("pajarito"), se debe llamar con ese nombre especifico, si se le coloca el nombre 
 * de referencia de la clase "pajaro", fallara.
 * 
 */

@Component("pajarito")
public class Pajaro extends Animal implements Volador{

	private static final Logger log = LoggerFactory.getLogger(Pajaro.class);

	/**
	 * @param name
	 * @param age
	 */
	public Pajaro(@Value("Pajaro Loco") String name, @Value("1") Integer age) {
		super(name, age);
	}
	
	@Override
	public void volar() {
		log.info("Soy un pajaro y estoy Volando!!");
		
	}

	
	
}
