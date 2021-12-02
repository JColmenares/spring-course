/**
 * 
 */
package com.example.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author JColmenares
 *
 */
@Configuration
@PropertySource("classpath:areas.properties")/* Permite hacer llamado a un properties en la carpeta
											  * classpath -> src/main/resources
 											  */
public class FigurePropertyConfiguration {

	@Bean //Almacena los valores del Properties
	public PropertySourcesPlaceholderConfigurer getPropertiesConfig() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
