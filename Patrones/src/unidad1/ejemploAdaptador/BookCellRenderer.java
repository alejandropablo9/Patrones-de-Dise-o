package unidad1.ejemploAdaptador;

import java.awt.Color;
import java.awt.Component;
import static javafx.scene.paint.Color.color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Alejandro
 */
public class BookCellRenderer extends JLabel implements ListCellRenderer {
    private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
    public BookCellRenderer() {
        setOpaque(true);
        setIconTextGap(12);        
    }

    @Override
    public Component getListCellRendererComponent(
            JList list, 
            Object value, 
            int index, 
            boolean isSelected, 
            boolean cellHasFocus) {
        BookEntry entry = (BookEntry)value;
        setText(entry.getTitle());
        setIcon(entry.getImage());
        if(isSelected) {
            setBackground(HIGHLIGHT_COLOR);
            setForeground(Color.white);
        } else {
            setBackground(Color.white);
            setForeground(Color.black);
        } 
        return this;
    }
    
}
