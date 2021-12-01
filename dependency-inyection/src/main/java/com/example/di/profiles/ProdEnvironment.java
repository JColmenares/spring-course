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
@Profile("prod")
public class ProdEnvironment implements EnvironmentService {

	@Override
	public String getEnvironment() {
		return "Prod";
	}

}
