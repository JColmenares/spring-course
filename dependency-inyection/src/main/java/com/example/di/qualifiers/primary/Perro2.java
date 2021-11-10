/**
 * 
 */
package com.example.di.qualifiers.primary;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author JColmenares
 *
 */
@Component
public class Perro2 extends Animal2{

	/**
	 * @param name
	 * @param age
	 */
	public Perro2(@Value("Rocky") String name, @Value("1") Integer age) {
		super(name, age);
	}

}
