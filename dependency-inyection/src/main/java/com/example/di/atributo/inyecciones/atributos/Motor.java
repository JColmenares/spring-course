/**
 * 
 */
package com.example.di.atributo.inyecciones.atributos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author josea
 *
 */
@Component
public class Motor {
	
	/*INYECCION DE DEPENDENCIAS POR ATRIBUTOS: 
	 * 
	 * 	Esta inyección se aplica suministrandoles los ESTEREOTIPOS o atributos encima de las variables.
	 *  - El @Value("") proporciona una valor fijo a la variables al inicializar el proyecto.
	 *  - El @Autowired Busca el Objeto en los Beam de Spring y extrayendo los valores que vienen configurados por defecto.
	 *	- El @Component ubicado encima de la clase permite decirle al Spring que dicha clase estara embebida en los beam.
	 *
	*/
	
	@Value("XL1")
	private String marca;
	@Value("1982")
	private Integer modelo;
	
	public Motor() {
	}
	
	public Motor(String marca, Integer modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getModelo() {
		return modelo;
	}

	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Motor [marca=" + marca + ", modelo=" + modelo + "]";
	}
}
