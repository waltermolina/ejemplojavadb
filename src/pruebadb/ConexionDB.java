
package pruebadb;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Walter
 */
public class ConexionDB {
    private String url;
    private String user;
    private String pass;
    
    private Connection conexion;

    public ConexionDB(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
        this.conexion = null;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Connection getConexion() {
        return conexion;
    }

    public Connection connect() {
        try {
            // Se registra el Driver de MySQL
            //DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            
            this.conexion = DriverManager.getConnection(
                    this.url,
                    this.user, 
                    this.pass);
            
        }
        catch (Exception e){
            switch(e.getClass().getName()){
                case "java.sql.SQLSyntaxErrorException":
                    System.out.println("Pasaron cosas..."+e);
                    break;
                case "java.sql.SQLException":
                    System.out.println("No tiene permiso "+e);
                    break;
                default:
                    System.out.println("Error desconocido "+e);
                    break;
            }   
        } finally{
            return this.conexion;
        }
    }
    
    
}

/*

// Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            
            // Se realiza la consulta. Los resultados se guardan en el 
            // ResultSet resultados
            ResultSet resultados = s.executeQuery(
                    "SELECT a.*, g.* FROM alumno a JOIN genero g on a.Genero = g.idGenero");
            
            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            while (resultados.next()){
                System.out.println(
                        resultados.getInt("IdAlumno") 
                                + " " + resultados.getString("FechaNacimiento") 
                                + " " + resultados.getString("Descripcion"));
            }


*/