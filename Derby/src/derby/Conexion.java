
package derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alejandro
 */
public class Conexion {
    
    private static final String nombreDB    = "Unidad4";
    private static final String user        = "alejandro";
    private static final String password    = "alejandro";
    private static final String ip          = "localhost";
    private static final String url         = "jdbc:derby://localhost:1527/"+nombreDB;
    
    public static final Connection obtenerConexion(){
        Connection conexionADerby = null;
        System.out.println("Obteniendo conexion a la base de datos...");
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conexionADerby = DriverManager.getConnection(url, user, password);
        }catch(Exception e){            
            System.out.println("Error: " + e);
        }    
        return conexionADerby;
    }
    
    public static final boolean cerrarConexion(Connection conexion){
        if(conexion == null){
          return false;
        }
        try {
          conexion.close();
          return true;
        }catch(SQLException e){
           System.out.println("Error: " + e);
        }
        return false;
    }
    
    public static final ResultSet getRegistros(String sql, Connection cn){
        ResultSet rs = null;
        try{
            Statement stmt = cn.createStatement();
            rs = stmt.executeQuery(sql);
        }catch(SQLException e){
            System.out.println("Error: " + e);          
        }
        return rs;
    }
    
}
