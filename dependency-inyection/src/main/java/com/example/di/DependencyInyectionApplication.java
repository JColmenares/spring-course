  package com.example.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.example.di.atributo.inyecciones.atributos.Coche;
import com.example.di.atributo.inyecciones.constructores.Coche2;
import com.example.di.atributo.inyecciones.setters.Coche3;
import com.example.di.autowire.AreaCalculatorService;
import com.example.di.profiles.EnvironmentService;
import com.example.di.qualifiers.Animal;
import com.example.di.qualifiers.Nido;
import com.example.di.qualifiers.Pajaro;
import com.example.di.qualifiers.Perro;
import com.example.di.qualifiers.primary.Nido2;
import com.example.di.scopes.ExampleScopeService;

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
		
		// 6- Uso de Perfiles @Profile("dev")
		/*
		 * Este estereotipo se utiliza para definr diferentes perfiles en el codigo, con el cual permite establecer 
		 * diferentes ejecuciones según el perfil especificado. Hay 3 opciones de activar los perfiles:
		 * 	
		 * 	6.1. Definiendo el tag el archivo application.properties:
		 * 		spring.profiles.active=dev
		 *  
		 *  6.2. Definir en la MV un argumento llamado:
		 *  	-Dspring.profiles.active=dev 
		 * 
		 * 
		 * 	NOTA: Si se mezclan estas dos formas, tiene como prioridad la 6.2. MV Argument
		 *	IMPORTANTE: Si al al ejecutar no se define un perfil ni en el application.propeties, y en el MV Argument
		 *				Spring dara error ya que no sabe cual Perfil tomar, por lo que se puede establecer un Perfil por 
		 *				Default agregandole el siguiente paremetro:
		 *	
		 *					@Profile({"dev", "default"})
		 *
		 * */
		EnvironmentService environmentService = context.getBean(EnvironmentService.class);
		log.info("Active Environment {} ", environmentService.getEnvironment());
	
		// 7- Uso de Scope @Scope("singleton")
		/*
		 *  Estereotipo permite establecer el comportamiento de una clase en bean. 
		 * 
		 * 	7.1.  @Scope("singleton") -> Valor por defecto en las clases Beam. Crea una sola instancia del beam por
		 *   							 por contenedor de Spring.
		 *   
		 *  7.2.  @Scope("prototype") -> Crea una nueva instancia cada vez que se solicita.
		 *  
		 *  7.3.  @Scope("request") -> Crea una nueva instancia por cada peticiön HTTP, solo se puede utilizar en una aplicación web.
		 *  
		 *  7.4.  @Scope("session") -> Crea una nueva instancia por cada sesión HTTP.
		 * 
		 * */
		//Prueba
		ExampleScopeService exampleScope = context.getBean(ExampleScopeService.class);
		ExampleScopeService exampleScope2 = context.getBean(ExampleScopeService.class);
		
		log.info("Are beans equal {} ", exampleScope.equals(exampleScope2));
		log.info("Are beans == {} ", exampleScope == exampleScope2);
		
		// 7- Uso de beans de forma Explicita @Bean
		/*
		 *    - Bean Implicitos: Es aplicado con los Estereotipos que son declarados, directamente
		 *    					 en las clases principales, siempre y cuando se tenga acceso a la 
		 *    					 misma, o se pueda realizar una herencia.
		 *    
		 *    - Bean Explicitos: Se utiliza mediante el estereotipo @Bean encima de un metedo, dandole
		 *    					 valor la clase Bean. Cumple cuando se le quiere aplicar un estereotipo bean a una clase
		 *    					 pero no se tiene acceso a ella ni se puede Heredar ya que es final
		 *    					 como por ejemplo la clase String.
		 *       
		 * 
		 * */
		String nameApplication = context.getBean(String.class);
		log.info("Name Application {} ", nameApplication);
		
		// 8- Inyección de dependencias multiples Objetos (@Autowired)
		/*
		 *   Esta inyección permite realizar una busqueda todos los objetos con datos
		 *   asociados a una Interface, permitiendo recolectarlos y almacenarlos en una variable con el 
		 *   estereotipo @Autowired
		 * */
		AreaCalculatorService calculator = context.getBean(AreaCalculatorService.class);
		log.info("Area total {} ", calculator.calcAreas());
		
	}
	
	//7.Uso de beans de forma Explicita @Bean
	 @Bean //Convierte el metodo Bean, indirectamente por su clase de salida.
	 public String getApplicationName() {
		 return "¡Devs4j Rules!";
	 }

}
