/**
 * 
 */
package com.example.di.atributo.inyecciones.constructores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author josea
 *
 */
@Component
public class Coche2 {

	/*INYECCION DE DEPENDENCIAS POR CONTRUCTORES: 
	 * 
	 * 	Como su nombre lo dice se aplica en el contructor de la clase, especificamente en el constructor que tiene paramentros de entrada.
	 *  Para que funcione se debe omitir el constructor vacio.
	 *  - El @Value("") proporciona una valor fijo a la variables al inicializar el proyecto.
	 *  - El @Autowired Busca el Objeto en los Beam de Spring y extrayendo los valores que vienen configurados por defecto.
	 *	- El @Component ubicado encima de la clase permite decirle al Spring que dicha clase estara embebida en los beam.
	 *
	*/
	
	private String marca;
	private Integer modelo;
	
	private Motor2 motor;
	
	@Autowired//Este atributo hace referencia al Objeto Motor2
	public Coche2(@Value("VW") String marca, @Value("1981") Integer modelo, Motor2 motor) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.motor = motor;
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
	
	public Motor2 getMotor() {
		return motor;
	}
	
	public void setMotor(Motor2 motor) {
		this.motor = motor;
	}
	
	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", motor=" + motor + "]";
	}
}
