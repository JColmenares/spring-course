/**
 * 
 */
package com.example.di.atributo.inyecciones.setters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author josea
 *
 */
@Component //
public class Motor3 {
	
	/*INYECCION DE DEPENDENCIAS MEDIANTE LOS METODOS SETTERS: 
	 * 
	 * 	Como su nombre lo dice se aplica en los metodos Setters de las vartaibles de la clase, Colocando los atributos encima de dichos metodos.
	 *  Para que funcione se debe omitir el constructor con parametros de entrada.
	 *  - El @Value("") proporciona una valor fijo a la variables al inicializar el proyecto.
	 *	- El @Component ubicado encima de la clase permite decirle al Spring que dicha clase estara embebida en los beam.
	 *  
	 *
	*/
	
	private String marca;
	private Integer modelo;
	
	public Motor3() {
	}

	public String getMarca() {
		return marca;
	}

	@Value("XL1")
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getModelo() {
		return modelo;
	}

	@Value("1982")
	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Motor [marca=" + marca + ", modelo=" + modelo + "]";
	}
}
