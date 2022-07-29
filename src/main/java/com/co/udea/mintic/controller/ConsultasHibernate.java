package com.co.udea.mintic.controller;

import com.co.udea.mintic.db.*;
import com.co.udea.mintic.util.DBUtilSession;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ConsultasHibernate {

    Transaction transaction = null;
    Vendedores objV1 = new Vendedores(6666, "Carlos", "Romero", "Soacha");

    public List<Vendedores> selectAllHibernateVendedor() {
        List<Vendedores> vend = null;

        try {
            Session session = DBUtilSession.getSessionFactory().openSession();
            vend = session.createQuery("from Vendedores", Vendedores.class).list();
/*
            for (Vendedores v : vend) {
                System.out.println("Nombres: " + v.getNombres());
            }
*/
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("Error :: " + e.getCause());
        }

        return vend;

    }

    public String insertVendedor(Vendedores objV) {

        String salida = "";
        
        try {
            Session session = DBUtilSession.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(objV);
            transaction.commit();
            salida = "Insert terminado Correctamente";
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("Error :: " + e.getCause());
            salida = "Insert Failure";
        }
        return salida;
    }

    public void deleteVendedor(Vendedores obj) {
        try {
            Session session = DBUtilSession.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(obj);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("Error :: " + e.getCause());
        }
    }
    // To-do -- Delete cascada

    public void deleteVehiculo(Vehiculos objVehi) {
        try {
            Session session = DBUtilSession.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(objVehi);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("Error :: " + e.getCause());
        }
    }

}
