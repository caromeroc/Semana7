package com.co.udea.mintic.controller;

import com.co.udea.mintic.model.Vendedor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class Consultas {

    String url = "jdbc:mysql://localhost:3307/concesionario?serverTimezone=UTC";
    String user = "root";
    String password = "admin";
    String selectAll = "SELECT * FROM vendedores";
    String sqlInsertVendedor = "INSERT INTO vendedores (documento_vendedor, nombres, apellidos, ciudad) VALUES (?,?,?,?)";
    String sqlDeleteVendedor = "DELETE FROM vendedores WHERE documento_vendedor = ?";
    
    public void selectAllVendedor() {

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectAll);
            Vendedor objVen = new Vendedor();

            while (rs.next()) {
                objVen.setApellidos(rs.getString("apellidos"));
                objVen.setNombres(rs.getString("nombres"));
                System.out.println("Nombres :: " + objVen.getNombres() + "   Apellidos ::  " + objVen.getApellidos());
            }

        } catch (SQLException e) {

            System.err.println("Error :: " + e.getCause());

        }

    }

    public void insertVendedor() {

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conn.prepareStatement(sqlInsertVendedor);

            Random rnd = new Random();
            int docRan = rnd.nextInt(9999);

            ps.setInt(1, docRan);
            ps.setString(2, "Raul");
            ps.setString(3, "Perilla");
            ps.setString(4, "Mundo");

            ps.executeUpdate();
            System.out.println("Todo OK");

        } catch (SQLException e) {
            System.out.println("Todo KO");
            System.err.println("Error :: " + e.getCause());
        }

    }

    public void deleteVendedor() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conn.prepareStatement(sqlDeleteVendedor);
            
            ps.setInt(1, 5572);
            ps.executeUpdate();
            System.out.println("Todo OK");
        } catch (SQLException e) {
            System.out.println("Todo KO");
            System.err.println("Error :: " + e.getCause());
        }
    }

}
