/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Walter
 */
public class PruebaDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Alumno> listado = new ArrayList<>();

        try {
            // ConexionDB myconexion = new ConexionDB("jdbc:mysql://localhost:3306/escuelachano", "root", "1234");

            /*
                Username: aAmmbFODPF
                Database name: aAmmbFODPF
                Password: BOwcRFIcnJ
                Server: remotemysql.com
                Port: 3306
             */
            ConexionDB myconexion = new ConexionDB("jdbc:mysql://remotemysql.com:3306/aAmmbFODPF", "aAmmbFODPF", "BOwcRFIcnJ");

            Connection c = myconexion.connect();

            Statement s = c.createStatement();

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet resultados
            ResultSet resultados = s.executeQuery(
                    "SELECT p.* ,\n"
                    + "       a.nroregistro,\n"
                    + "       a.ingreso,\n"
                    + "       a.carrera\n"
                    + "                    FROM alumno a, persona p\n"
                    + "                    where p.id = a.persona_id;");

            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            while (resultados.next()) {

                Alumno a = new Alumno(
                        resultados.getInt("id"),
                        resultados.getInt("nroregistro"),
                        resultados.getInt("ingreso"),
                        resultados.getString("carrera"),
                        resultados.getInt("id"),
                        resultados.getString("nombre"),
                        resultados.getString("apellido"),
                        resultados.getString("dni"),
                        resultados.getString("mail"),
                        resultados.getString("telefono")
                );
                listado.add(a);

                /*
                System.out.print(
                        "ID: " + resultados.getInt("id"));
                System.out.println(
                        " - " + resultados.getString("nombre")
                        + " " + resultados.getString("apellido"));
                 */
            }
        /*
            PreparedStatement stmt = c.prepareStatement(
                    "select * from alumnomateria, materia\n"
                    + "where alumnomateria.alumno_id = ?\n"
                    + "and alumnomateria.materia_id = materia.id;"
            );
            stmt.setInt(1, listado.get(0).getId());//1 specifies the first parameter in the query
        */          
            
        } catch (SQLException ex) {
            //Logger.getLogger(PruebaDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error!!!  " + ex);
        }

        System.out.println("ID: " + listado.get(0).toString());
        System.out.println("ID: " + listado.get(1).toString());

    }

}
