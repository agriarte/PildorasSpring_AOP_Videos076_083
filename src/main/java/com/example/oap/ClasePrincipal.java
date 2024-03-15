package com.example.oap;

import com.example.dao.ClienteDAO;
import com.example.dao.ClienteVIPDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 */
@SpringBootApplication
@ComponentScan("com.example")
public class ClasePrincipal {

    public static void main(String[] args) {
        System.out.println("******* pildoras.oap.ClasePrincipal.main()");

        SpringApplication.run(ClasePrincipal.class, args);

        // Leer configuracion de Spring
        AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
        // Obtener el bean del contenedor de Spring
        ClienteDAO miClienteDAO = contexto.getBean("ClienteDAO", ClienteDAO.class);
        // crear un segundo bean para probar aspectos
        ClienteVIPDAO miClienteVIPDAO = contexto.getBean("clienteVIPDAO", ClienteVIPDAO.class);
        // Llamar al método insertaClientes que dispara los aspectos
        miClienteDAO.insertaClientes();
        miClienteVIPDAO.insertaClientes();
        // Llamar al método insertaClientes con parámetro
        ClienteDAO cl1 = new ClienteDAO();
        miClienteDAO.insertaClientes(cl1);
        
        
        // Llamar a otro método que activa pointcuts
        miClienteDAO.probandoPointCut();
        
        // llamando a los getter/setter de Cliente    
        miClienteDAO.setCodigoClienteNormal("1234567");
        String codigoCliente1 = miClienteDAO.getCodigoClienteNormal();
        miClienteDAO.setValoracionClienteNormal("positiva");
        String valoracionCliente1 = miClienteDAO.getValoracionClienteNormal();
        
        // Llamar al método insertaClientes con usando antes getters/setters para practicar 
        // como obtener datos de parámetros en los aspectos
        Cliente cl2 = new Cliente();
        cl2.setNombre("Luís Martín");
        cl2.setTelefono("555-5555");
        // Obtener el bean del contenedor de Spring
        ClienteDAO miClienteDAO2 = contexto.getBean("ClienteDAO", ClienteDAO.class);
        miClienteDAO2.capturaParametrosJoinPoint(cl2.getNombre(),cl2.getTelefono());
        
        // como obtener parámetro clase desde aspectos
        Cliente cl3 = new Cliente();
        cl3.setNombre("Luís Martín");
        cl3.setTelefono("555-5555");
        // Obtener el bean del contenedor de Spring
        ClienteDAO miClienteDAO3 = contexto.getBean("ClienteDAO", ClienteDAO.class);
        miClienteDAO3.capturaClaseJoinPoint(cl3);
        
        
        // Cerrar el contexto
        contexto.close();
    }
}
