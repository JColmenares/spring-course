/**
 * 
 */
package com.example.di.qualifiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author JColmenares
 *
 */
@Component
public class Nido{

	private static final Logger log = LoggerFactory.getLogger(Nido.class);

	@Autowired
	@Qualifier("pajarito")/* Se presentara un error si no se especifica, ya que Spring no sabra cual de las clases Animal (Perro o Pajaro 
							ubicadas en los Beam) debe Inyectar en las dependencias. */
	private Animal animal;
	
	public void print() {
		log.info("El Nido tiene al animal {}", animal.getName());
		
	}
	
}
