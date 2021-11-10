/**
 * 
 */
package com.example.di.qualifiers.primary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author JColmenares
 *
 */


/* Para este ejemplo, se utilizara el Estereotipo @Primary, el cual permite definir a nivel de beam de Spring que dicha clase
 * esta establecida como candidata por defecto en los qualifiers, por lo que al realizar los @Autoriwed o herencias de esta clase
 * Spring Instanciara esta clase como qualifiers con por encima de otras que entren en las herencias de quealifiers.
 * 
 * Ejemplo: la clase Pajaro2 se instaciara por defecto al ser llamado la clase Nido, en vez de instanciarse la clase Perro.
 * 
 * Se usa cuando se tiene una Clase con multiples clases hijas, las clases hijas pueden ser inyectadas en algun lado, porque lo que
 * con este estereotipo se le define que tome esta por defecto.
 */

@Component
@Primary
public class Pajaro2 extends Animal2 implements Volador2{

	private static final Logger log = LoggerFactory.getLogger(Pajaro2.class);

	/**
	 * @param name
	 * @param age
	 */
	public Pajaro2(@Value("Pajaro Loco2") String name, @Value("1") Integer age) {
		super(name, age);
	}
	
	@Override
	public void volar() {
		log.info("Soy un pajaro y estoy Volando2!!");
		
	}

	
	
}
