package com.example.dao;
import com.example.oap.Cliente;
import org.springframework.stereotype.Component;

@Component ("ClienteDAO")
public class ClienteDAO {
    
    private String valoracionClienteNormal;
    private String codigoClienteNormal;

    public String getValoracionClienteNormal() {
         System.out.println("obteniendo valoración del cliente");
        return valoracionClienteNormal;
    }

    public void setValoracionClienteNormal(String valoracionClienteNormal) {
         System.out.println("setter valoración del cliente");
        this.valoracionClienteNormal = valoracionClienteNormal;
    }

    public String getCodigoClienteNormal() {
        System.out.println("obteniendo código del cliente");
        return codigoClienteNormal;
    }

    public void setCodigoClienteNormal(String codigoClienteNormal) {
        System.out.println("setter código del cliente");
        this.codigoClienteNormal = codigoClienteNormal;
    }
    
    
    public void insertaClientes(){
        System.out.println("Simulación de insertar cliente con éxito.");
    }
    
    public void insertaClientes (ClienteDAO cliente){
        System.out.println("Simulacion de insertar cliente desde método con parámetro");
    }
    
    public void probandoPointCut () {
        System.out.println("Probando Pointcut en clase ClienteDAO");
    }

    
    public void capturaParametrosJoinPoint(String nombreCliente, String telefonoCliente) {
        System.out.println("método en dao captura");    }
    
    public void capturaClaseJoinPoint (Cliente cliente){
        System.out.println("com.example.dao.ClienteDAO.capturaClaseJoinPoint()");
    }
}
