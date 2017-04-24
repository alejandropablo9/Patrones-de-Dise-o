package derby;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class PersonaDAO {
    
    public static final ArrayList<Persona> personas(){
        ArrayList<Persona> lista = new ArrayList();
        Connection cn = Conexion.obtenerConexion();
        ResultSet consulta = Conexion.getRegistros("SELECT * FROM AGENDA.PERSONA", cn);
        try{
            while(consulta.next()){
                Persona p = new Persona();
                p.setId(consulta.getInt(1));
                p.setNombre(consulta.getString(2));                
                p.setApellidos(consulta.getString(3));
                p.setTelefono(consulta.getString(4));
                p.setEmail(consulta.getString(5));
                p.setCumple(consulta.getString(6));
                lista.add(p);                
            }   
            consulta.close();
            Conexion.cerrarConexion(cn);
        }catch(Exception e){
            System.out.println("Ha ocurrido un error"+e);
        }
        return lista;
    }
    
    public static final void eliminarPersona(int id){
        Connection cn = Conexion.obtenerConexion();
        try{
            Statement stmt = cn.createStatement();
            stmt.executeUpdate("DELETE FROM AGENDA.PERSONA WHERE id=" + id);
            System.out.println("Se ha eliminado\n¡Exitosamente!");
            stmt.close();
            Conexion.cerrarConexion(cn);
        }catch(Exception e){
            System.out.println("No se ha sido posible eliminar recibo...\n"+e);
        }
    }
    
    public static final boolean registrarPersona(Persona p){
        Connection cn = Conexion.obtenerConexion();
        try{
            Statement stmt = cn.createStatement(); 
            stmt.executeUpdate("INSERT INTO AGENDA.PERSONA VALUES ("
                    + p.getId() + ", '" 
                    + p.getNombre() + "', '"
                    + p.getApellidos() + "', "
                    + p.getTelefono() + ", '"
                    + p.getEmail() + "', '"
                    + p.getCumple() +"')");
            System.out.println("Se ha registrado\n¡Exitosamente!");
            stmt.close();            
            Conexion.cerrarConexion(cn);
            return true;
        }catch(Exception e){
            System.out.println("No se ha podido registrar...\n"+e);
        }
        return false;
    }
    
}
