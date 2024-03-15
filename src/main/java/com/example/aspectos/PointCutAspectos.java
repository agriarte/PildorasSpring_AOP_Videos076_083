package com.example.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointCutAspectos {

    // Cuando se tienen numerosos métodos de aspecto, es útil utilizar Pointcuts. Un PointCut es esencialmente
    // un conjunto de expresiones que identifican un conjunto de métodos. Definimos un método vacío que
    // actuará como el nombre del conjunto de aspectos compartido por varios métodos. De esta manera, con una
    // única definición de la anotación @Before se puede asignar de manera más sencilla a múltiples métodos.
    
     @Pointcut("execution(public void probandoPointCut())")
     private void paraClientes(){}
     
    /**
     * Serie de métodos que se llamarán aspectos1, 2 y 3
     */
    @Before("paraClientes()")
    public void antesAspectos1() {
        System.out.println("Pointcut: Simulación de usuario logueado");
        System.out.println("Pointcut: Simulación de perfil de usuario correcto");
    }

    
    @Before("paraClientes()")
    public void antesAspectos2() {
        System.out.println("Pointcut: Simulación de llamada a método de aspectos si se llama a insertaClientes (con_parámetro_de_clase)");
    }

    @Before("paraClientes()")
    public void antesAspectos3() {
        System.out.println("Pointcut: Simulación de llamada a método de aspectos si se llama con o sin parámetros. Se usan '..' como comodín");
    }
    
    
    
}
