/**
 * 
 */
package com.example.di.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author JColmenares
 *
 */
@Component
public class Cicle1 implements Figure1 {

	@Value("${circle.radius:1}") /* Hace el llamado del valor circle.radius del properties
								  * si no se consigue el valor en el properties, se declara un 
								  * valor especifico con el :1 despues del nombre de la variable
								  * del properties
								  */
	private double radius;
	
	@Override
	public double calculateArea() {
		return Math.PI * Math.pow(radius, 2);
	}

}
