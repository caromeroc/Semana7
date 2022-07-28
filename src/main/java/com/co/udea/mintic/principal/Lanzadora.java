package com.co.udea.mintic.principal;

import com.co.udea.mintic.controller.Consultas;

public class Lanzadora {

    public static void main(String[] args) {
        Consultas objCon = new Consultas();     
        //objCon.selectAllVendedor();
        //objCon.insertVendedor();
        objCon.deleteVendedor();
        
    }  
}
