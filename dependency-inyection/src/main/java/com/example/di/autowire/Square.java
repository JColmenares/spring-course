/**
 * 
 */
package com.example.di.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author JColmenares
 *
 */
@Component
public class Square implements Figure {

	@Value("2.5")
	private double side;
	
	@Override
	public double calculateArea() {
		return side * side;
	}

}
