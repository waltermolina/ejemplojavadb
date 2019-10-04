/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebadb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        try {
            ConexionDB myconexion = new ConexionDB("jdbc:mysql://localhost:3306/escuelachano", "root", "1234");
            Connection c = myconexion.connect();
            
            Statement s = c.createStatement();
            
            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet resultados
            ResultSet resultados = s.executeQuery(
                    "SELECT a.*, g.* FROM alumno a JOIN genero g on a.Genero = g.idGenero");
            
            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            while (resultados.next()) {
                System.out.print(
                        "ID: " +resultados.getInt("IdAlumno"));
                System.out.println(
                        " - "+resultados.getString("Nombre")
                                + " " + resultados.getString("Apellido"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(PruebaDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error!!!  "+ ex);
        }

    }

}
