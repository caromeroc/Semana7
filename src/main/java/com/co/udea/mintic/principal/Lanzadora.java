package com.co.udea.mintic.principal;

import com.co.udea.mintic.controller.Consultas;
import com.co.udea.mintic.controller.ConsultasHibernate;
import com.co.udea.mintic.db.Vehiculos;
import com.co.udea.mintic.db.Vendedores;

public class Lanzadora {

    public static void main(String[] args) {
        //Consultas objCon = new Consultas();     
        //objCon.selectAllVendedor();
        //objCon.insertVendedor();
        //objCon.deleteVendedor();
        ConsultasHibernate objCH = new ConsultasHibernate();
        Vendedores objV2 =  new Vendedores(1964, "aaa", "aaa", "aaa");
        Vehiculos objVehi = new Vehiculos("ACD 427", "", "", 0);
        
        //objCH.insertVendedor();
        
        objCH.deleteVendedor(objV2);
        objCH.deleteVehiculo(objVehi);
        
        objCH.selectAllHibernateVendedor();
    }  
}
