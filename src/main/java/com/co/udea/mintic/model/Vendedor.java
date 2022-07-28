package com.co.udea.mintic.model;

public class Vendedor {
 
   private int documento_vendedor; 
   private String nombres ;
   private String apellidos ;
   private String ciudad ;

    public int getDocumento_vendedor() {
        return documento_vendedor;
    }

    public void setDocumento_vendedor(int documento_vendedor) {
        this.documento_vendedor = documento_vendedor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
   
   

}
