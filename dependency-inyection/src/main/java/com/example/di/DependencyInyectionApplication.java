 package com.example.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.example.di.atributo.inyecciones.atributos.Coche;
import com.example.di.atributo.inyecciones.constructores.Coche2;
import com.example.di.atributo.inyecciones.setters.Coche3;
import com.example.di.qualifiers.Animal;
import com.example.di.qualifiers.Nido;
import com.example.di.qualifiers.Pajaro;
import com.example.di.qualifiers.Perro;
import com.example.di.qualifiers.primary.Nido2;

@SpringBootApplication
public class DependencyInyectionApplication {

	
	private static final Logger log = LoggerFactory.getLogger(DependencyInyectionApplication.class);

	
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
		
		//4- Lo Qualifiers son necesarios unicamente cuando los tipos de Datos que se quiere inyectar tiene multiples Implementaciones. 
				
		//4.1- Uso de Qualifiers
		Perro quelifiersPerro = context.getBean(Perro.class);
		log.info("Objeto Perror {}", quelifiersPerro.getName());
		
		//4.2- Uso de Qualifiers
		Pajaro quelifiersPajaro = context.getBean(Pajaro.class);
		log.info("Objeto Pajaro {}", quelifiersPajaro.getName());
		quelifiersPajaro.volar();
		
		//4.3- Uso de Qualifiers - Error por no sabes cual Objeto del Beam Utilizar
//		Animal quelifiersAnimal = context.getBean(Animal.class);
//		log.info("Objeto Animal Nombre: {} y Edad: {}", quelifiersAnimal.getName(), quelifiersAnimal.getAge());
		/*
		 * Para estes caso se genera el siguiente Error:
		 * 
		 * 		No qualifying bean of type 'com.example.di.qualifiers.Animal' available: expected single matching 
		 * 		bean but found 2: pajaro,perro
		 * 
		 * Esto sucede ya que las Inyecciones de Dependecias se hacen a traves de tipos de datos, y como en el caso del Objeto 
		 * Animal existen dos clases que extienden de ella, las cuales son Perro y Pajaro, en los Beam se generan dos candidatos 
		 * disponibles para aplicar la Inyección, pero Spring no sabe cual de ellos tomar.
		 * 
		 * Pasa Solucionar el error se puede tomas dos opciones:
		 * 
		 * 1- Es espeficica la clase que se quiere tomar en minuscula en el getBeam, haciendo referencia al Qualifiers que se quiere
		 * Utilizar
		 * 
		 * */
//		Animal quelifiersAnimalPajaro = context.getBean("pajaro",Animal.class);
//		log.info("Animal Qualifiers 'Pajaro' Nombre: {} y Edad: {}", quelifiersAnimalPajaro.getName(), quelifiersAnimalPajaro.getAge());
				
		/* 4.3.2- Tambien se puede especificar un nombre al @Component, de la clase que se quiere tomar, en este caso se le
		 * Aplica a la clase Pajaro, quedando su Estereotipo @Component("pajarito"), por lo que ahora se le llama por ese
		 * nombre
		 * 
		 * NOTA: Al espeficicarle nombre al @Component("pajarito"), se debe llamar con ese nombre especifico, si se le coloca el nombre 
		 * de referencia de la clase "pajaro", fallara.
		 * 
		 */
		Animal quelifiersAnimalPajarito = context.getBean("pajarito",Animal.class);
		log.info("Qualifiers - Animal 'Pajarito' Nombre: {} y Edad: {}", quelifiersAnimalPajarito.getName(), quelifiersAnimalPajarito.getAge());
		
		/* 4.3.3- Opcion con configuraciones directas en la clase Nido.
		 * 
		 * Para este caso se presentara un error si no se le especifica el @Qualifiers("name") en la variable de Animal
		 * contenida en el la clase nido, ya que el @Autowired no sabra cual de las clase con contenido debe Inyectar en la dependencia.
		 * 
		 * IMPORTANTE: Es obligatorio el @Autowired para aplicar la Inyección de Dependencias.
		 * 
		 * */
		Nido quelifiersNido = context.getBean(Nido.class);
		quelifiersNido.print();
		
		// 5- Uso de Estereotipo @Primary
		/*
		 * Es utilizado para establece una clase por defecto en los qualifiers, cuando se consigue mas de dos considencias en los beam.
		 * Esto sustituye el la especificacion del nombre de las clases colocadas en los estereotipos @Component("pajarito") y del estereotipo
		 * 	@Qualifier("pajarito")
		 * */
		Nido2 quelifiersNido2 = context.getBean(Nido2.class);
		quelifiersNido2.print();
	}

}
