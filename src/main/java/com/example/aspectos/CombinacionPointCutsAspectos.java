package com.example.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CombinacionPointCutsAspectos {

    // Se pueden crear aspectos que actúen sobre un paquete y combinaciones de todos o parte de los métodos.
    // En el ejemplo, el primer asterisco indica que actúe sobre cualquier método, el segundo asterisco es el 
    // nombre del método.
    // Al poner '*' se indica que se llame como se llame. Los '(..)' le dicen que no se tendrá en cuenta el número ni tipo de parámetros.      
     @Pointcut("execution(* com.example.dao.*.*(..))")
     private void paraClientes(){}
     
    // Ejemplo de pointcut solo para getters
     @Pointcut("execution(* com.example.dao.*.get*(..))")
     private void soloGettersClientes(){}
     
    // Ejemplo de pointcut solo para Setters
     @Pointcut("execution(* com.example.dao.*.set*(..))")
     private void soloSettersClientes(){}
     
    // Combinación Aspecto para todo el paquete excepto getters y setters
    @Pointcut("paraClientes() && !soloGettersClientes() && !soloSettersClientes()")
    private void combinacionClientes(){}
     
  
    @Before("paraClientes()")
    public void antesAspectos() {
        System.out.println("Simulacion: Simulación de combinacion de pointcut");
    }


    @Before("soloGettersClientes()")
    public void antesAspectosGetters() {
        System.out.println("Simulacion: Simulación de combinacion de pointcut. SOLO GETTERS");
    }
    
    @Before("soloGettersClientes()")
    public void combinacionExceptogettersetter() {
        System.out.println("Simulacion: Simulación todo excepto getter/setter");
    }
    
}
