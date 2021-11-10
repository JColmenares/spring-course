/**
 * 
 */
package com.example.di.qualifiers.primary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author JColmenares
 *
 */
@Component
public class Nido2{

	private static final Logger log = LoggerFactory.getLogger(Nido2.class);

	@Autowired
	private Animal2 animal;
	
	public void print() {
		log.info("El Nido tiene al animal {}", animal.getName());
		
	}
	
}
