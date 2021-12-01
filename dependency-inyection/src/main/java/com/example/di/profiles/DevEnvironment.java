/**
 * 
 */
package com.example.di.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author JColmenares
 *
 */
@Service
//@Profile("dev")				//Declaración de Perfil Basico
//@Profile({"dev", "default"})	//Declaración y Espeficicación de Perfil por Defecto (Solo se toma en cuenta si no se declara un Perfil en el 
								//				application.properties o en el MV Argument)
@Profile(value = {"dev", "default"})	//Declaración y Espeficicación de Perfil por Defecto 
public class DevEnvironment implements EnvironmentService {

	@Override
	public String getEnvironment() {
		return "Dev";
	}

}
