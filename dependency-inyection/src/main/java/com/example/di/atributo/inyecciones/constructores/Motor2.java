/**
 * 
 */
package com.example.di.atributo.inyecciones.constructores;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author josea
 *
 */
@Component
public class Motor2 {
	
	/*INYECCION DE DEPENDENCIAS POR CONTRUCTORES: 
	 * 
	 * 	Como su nombre lo dice se aplica en el contructor de la clase, especificamente en el constructor que tiene paramentros de entrada.
	 *  Para que funcione se debe omitir Eel constructor vacio.
	 *  - El @Value("") proporciona una valor fijo a la variables al inicializar el proyecto.
	 *	- El @Component ubicado encima de la clase permite decirle al Spring que dicha clase estara embebida en los beam.
	 *
	*/
	
	private String marca;
	private Integer modelo;
	
	public Motor2(@Value("XL1") String marca, @Value("1982")Integer modelo) {
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
