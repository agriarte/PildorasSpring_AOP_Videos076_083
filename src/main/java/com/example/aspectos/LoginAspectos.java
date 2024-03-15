package com.example.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspectos {

    // La anotación sirve para ejecutar el método que la lleva al ejecutar uno o más métodos de la clase indicada.
    // En este caso se activa cuando es llamado el método insertarCliente de cualquier clase con anotación componente.
    // Si queremos que sea el método de una clase concreta pondremos la ruta antes: com.example.dao.ClienteDAO.insertaClientes())")
    @Before("execution(public void insertaClientes())")
    // 2 - Otra`posibilidad:
    // El patrón "execution(* com.example.dao.ClienteDAO.*(..))" utiliza wildcards para describir cualquier método (*) 
    // con cualquier tipo de retorno (*) y cualquier conjunto de parámetros ((..))). En resumen, esta anotación se 
    // utiliza para aplicar lógica antes de la ejecución de cualquier método en la clase ClienteDAO.
    // @Before("execution(* com.example.dao.ClienteDAO.*(..))")
    // 3 - También se puede utilizar el asterisco (*) para ejecutar el aspecto en todos los métodos que comiencen con el nombre indicado.
    // Por ejemplo, insertaCliente* activará el aspecto para métodos como insertaClienteVIP, insertaClienteNacional, etc.

    public void antesAspectos() {
        System.out.println("Simulación de usuario logueado");
        System.out.println("Simulación de perfil de usuario correcto");
    }
    // 4 - Aspecto que se ejecuta si inserClientes lleva un parámetro de tipo Cliente
    // Si hubieran más parámetros separados por "," el aspecto solo se ejecutará si coinciden el número y tipo de parámetros
    @Before("execution(public void insertaClientes(com.example.oap.Cliente))")
    public void antesAspectos2(){
        System.out.println("Simulación de llamada a método de aspectos si se llama a insertaClientes (con_parámetro_de_clase)");
    }
    
    @Before("execution(public void insertaClientes(..))")
    public void antesAspectos3(){
        System.out.println("Simulación de llamada a método de aspectos si se llama con o sin parámetros. Se usan '..' como comodín");
    }
    
}
