/**
 * 
 */
package com.example.di.qualifiers.primary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author JColmenares
 *
 */
@Component
public class Avion2 implements Volador2{

	private static final Logger log = LoggerFactory.getLogger(Avion2.class);
	
	@Override
	public void volar() {
		log.info("Soy un Avión y estoy Volando!!");
		
	}

}
