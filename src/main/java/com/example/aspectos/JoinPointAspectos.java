package com.example.aspectos;

import com.example.oap.Cliente;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 *
 * clase para implementar aspectos con puntos de observación de los parámetros
 * dentro de los métoodos de los aspectos
 */

@Aspect
@Component
public class JoinPointAspectos {

    /**
     * Aspecto que captura parámetros con un punto de observación o JoinPoint
     * Los parámetros llegan como un array que podemos leer con foreach
     */
    @Before("execution(public void capturaParametrosJoinPoint(..))")
    public void capturaParámetros(JoinPoint miJoin) {
        System.out.println("com.example.aspectos.JoinPointAspectos.capturaParámetros()");
        Object[] miObjeto = miJoin.getArgs();
        for (Object temp : miObjeto) {
            System.out.println("com.example.aspectos.JoinPointAspectos.capturaParámetros(): " + temp);
        }

    }

    /**
     * Aspecto que captura una clase con un punto de observación o JoinPoint La
     * clase llega como un Object. Se comprueba que el objeto corresponde con
     * una instancia
     */
    @Before("execution(public void capturaClaseJoinPoint(..))")
    public void capturaClase(JoinPoint miJoin) {
        System.out.println("com.example.aspectos.JoinPointAspectos.capturaClase()");
        Object[] miObjeto = miJoin.getArgs();
        for (Object temp : miObjeto) {
            if (temp instanceof Cliente) {
                Cliente cli= (Cliente) temp;
                System.out.println("Dato por cli.getNombre(): " + cli.getNombre());
                System.out.println("Dato por cli.getTelefono(): " + cli.getTelefono());
            }
        }

    }

}
