/**
 * 
 */
package com.example.di.qualifiers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author JColmenares
 *
 */
@Component
public class Perro extends Animal{

	/**
	 * @param name
	 * @param age
	 */
	public Perro(@Value("Rocky") String name, @Value("1") Integer age) {
		super(name, age);
	}

}
