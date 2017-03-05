package unidad1.ejemploAdaptador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Alejandro
 */
public class ListExample extends JPanel{
    
    private static BookEntry books[] = { 
        new BookEntry("Programación Java", "src/unidad1/ejemploAdaptador/recursos/java_troy_opt.jpg"),
        new BookEntry("Aura", "src/unidad1/ejemploAdaptador/recursos/aura_opt.jpg"),
        new BookEntry("Dont Breath", "src/unidad1/ejemploAdaptador/recursos/Dont_Breath_opt.jpg"),
        new BookEntry("Allied", "src/unidad1/ejemploAdaptador/recursos/allied.jpg"),
        new BookEntry("Programación Java", "src/unidad1/ejemploAdaptador/recursos/java_troy_opt.jpg"),
        new BookEntry("Aura", "src/unidad1/ejemploAdaptador/recursos/aura_opt.jpg"),
        new BookEntry("Dont Breath", "src/unidad1/ejemploAdaptador/recursos/Dont_Breath_opt.jpg"),
        new BookEntry("Allied", "src/unidad1/ejemploAdaptador/recursos/allied.jpg")        
    };    
    private static JList booklist = new JList(books);
    
    public ListExample() {
        setLayout(new BorderLayout());
        JButton button = new JButton("Print");
        button.addActionListener(new PrintListener());
        
        booklist = new JList(books);
        booklist.setCellRenderer(new BookCellRenderer());
        booklist.setVisibleRowCount(4);
        JScrollPane pane = new JScrollPane(booklist);
        
        add(pane, BorderLayout.NORTH);
        add(button, BorderLayout.SOUTH);
    }
    
    public static void main(String s[]){
        JFrame frame = new JFrame("Ejemplo Adaptador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ListExample());
        frame.pack();
        frame.setVisible(true);
    }

    private static class PrintListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int selected[] = booklist.getSelectedIndices();
            System.out.println("Elementos Seleccionados: ");
            
            for (int i = 0; i < selected.length; i++) {
                BookEntry element = 
                        (BookEntry)booklist.getModel().getElementAt(selected[i]);
                System.out.println(" " + element.getTitle());
            }
        }
    }
    
}
