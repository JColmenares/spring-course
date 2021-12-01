/**
 * 
 */
package com.example.di.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author JColmenares
 *
 */

/*
 * USO DE SCOPE
 * 
 * Estereotipo permite establecer el comportamiento de una clase en bean. 
 * 
 *  @Scope("singleton") -> Valor por defecto en las clases Beam. Crea una sola instancia del beam por
 *  						 por contenedor de Spring.
 *  
 *  @Scope("prototype") -> Crea una nueva instancia cada vez que se solicita.
 *  
 *  @Scope("request") -> Crea una nueva instancia por cada peticiön HTTP, solo se puede utilizar en una aplicación web.
 *  
 *  @Scope("session") -> Crea una nueva instancia por cada sesión HTTP.
 * 
 * */

@Service
//@Scope("singleton") //Default
@Scope("prototype") 
public class ExampleScopeService {

}
