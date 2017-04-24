package derby;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alejandro
 */
public class ModeloTablaPersona extends AbstractTableModel{
    private final String[] nombreColumnas = {"#", "Nombre", "Apellidos", "Telefono", "Email", "Cumpleaños"};
    private ArrayList<Persona> personas;

    public ModeloTablaPersona(ArrayList<Persona> personas) {
        this.personas = personas;
    }        

    public ArrayList<Persona> getPersonas() {
        return personas;
    }
        
    @Override
    public int getRowCount() {
        return personas.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona p = personas.get(rowIndex);
        switch(columnIndex){
            case 0: return p.getId();
            case 1: return p.getNombre();
            case 2: return p.getApellidos();
            case 3: return p.getTelefono();
            case 4: return p.getEmail();
            case 5: return p.getCumple();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }
       
    public Persona getPersona(int indice){
        return personas.get(indice);
    }
        
    public boolean estVacio(){
        return (personas == null);
    }
    
}
