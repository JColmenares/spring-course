 package com.example.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.di.atributo.inyecciones.atributos.Coche;
import com.example.di.atributo.inyecciones.constructores.Coche2;
import com.example.di.atributo.inyecciones.setters.Coche3;

@SpringBootApplication
public class DependencyInyectionApplication {

	public static void main(String[] args) {
		
		//El contexto  
		ConfigurableApplicationContext context = SpringApplication.run(DependencyInyectionApplication.class, args);
		
		//1- Inyección de dependencias por Atributos:
		Coche injectionOfDependenciesByAttributes = context.getBean(Coche.class);
		System.out.println("Valores de Objetos Mediantes Inyección de Dependencias por Atributos:");
		System.out.println("\t" + injectionOfDependenciesByAttributes);
		
		System.out.println("\n");
		
		
		//2- Inyección de dependencias por medio del Constructor:
		Coche2 injectionOfDependenciesByCosntructors = context.getBean(Coche2.class);
		System.out.println("Valores de Objetos Mediantes Inyección de Dependencias por el Constructor:");
		System.out.println("\t" + injectionOfDependenciesByCosntructors);
		
		System.out.println("\n");
		
		//3- Inyección de dependencias por medio de los metodos Setters:
		Coche3 injectionOfDependenciesBySetters = context.getBean(Coche3.class);
		System.out.println("Valores de Objetos Mediantes Inyección de Dependencias por los Setters:");
		System.out.println("\t" + injectionOfDependenciesBySetters);
		
		System.out.println("\n");
				
	}

}
