/**
 * 
 */
package com.example.di.config;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author JColmenares
 *
 */
@Service
public class AreaCalculatorService1 {
	
	@Autowired
	private List<Figure1> figures;
	/*
	 * Inyección de dependencias multiples Objetos (@Autowired)
	 * 		Este @Autowired hace el llamado a una lista de todos los objetos
	 * 		relacionados con la interface Figure, por lo que trae todos los 
	 * 		datos y valores que contienen dichas clase, en la carga de bean.
	 * 
	 * */
	
	public double calcAreas() {
		
		double area = 0;
		
		for (Figure1 figure : figures) {
			area += figure.calculateArea();
		}
		
		return area;
	}
	
}
