/**
 * 
 */
package com.example.di.atributo.inyecciones.setters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author josea
 *
 */
@Component
public class Coche3 {

	/*INYECCION DE DEPENDENCIAS MEDIANTE LOS METODOS SETTERS: 
	 * 
	 * 	Como su nombre lo dice se aplica en los metodos Setters de las vartaibles de la clase, Colocando los atributos encima de dichos metodos.
	 *  Para que funcione se debe omitir el constructor con parametros de entrada.
	 *  - El @Value("") proporciona una valor fijo a la variables al inicializar el proyecto.
	 *  - El @Autowired Busca el Objeto en los Beam de Spring y extrayendo los valores que vienen configurados por defecto.
	 *	- El @Component ubicado encima de la clase permite decirle al Spring que dicha clase estara embebida en los beam.
	 *
	*/
	
	private String marca;
	private Integer modelo;
	private Motor3 motor;
	
	public Coche3() {
		super();
	}
		
	public String getMarca() {
		return marca;
	}
	
	@Value("VW")
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public Integer getModelo() {
		return modelo;
	}
	
	@Value("1981")
	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}
	
	public Motor3 getMotor3() {
		return motor;
	}
	
	@Autowired
	public void setMotor(Motor3 motor) {
		this.motor = motor;
	}
	
	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", motor=" + motor + "]";
	}
}
