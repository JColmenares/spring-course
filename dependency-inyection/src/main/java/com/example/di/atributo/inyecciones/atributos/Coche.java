/**
 * 
 */
package com.example.di.atributo.inyecciones.atributos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author josea
 *
 */
@Component
public class Coche {

	/*INYECCION DE DEPENDENCIAS POR ATRIBUTOS: 
	 * 
	 * 	Esta inyección se aplica suministrandoles los ESTEREOTIPOS o atributos encima de las variables.
	 *  - El @Value("") proporciona una valor fijo a la variables al inicializar el proyecto.
	 *  - El @Autowired Busca el Objeto en los Beam de Spring y extrayendo los valores que vienen configurados por defecto.
	 *	- El @Component ubicado encima de la clase permite decirle al Spring que dicha clase estara embebida en los beam.
	 *
	*/
	
	@Value("VW")
	private String marca;
	@Value("1981")
	private Integer modelo;
	
	@Autowired
	private Motor motor;
	
	public Coche() {
		super();
	}
	
	public Coche(String marca, Integer modelo, Motor motor) {
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
	
	public Motor getMotor() {
		return motor;
	}
	
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	
	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", motor=" + motor + "]";
	}
}
