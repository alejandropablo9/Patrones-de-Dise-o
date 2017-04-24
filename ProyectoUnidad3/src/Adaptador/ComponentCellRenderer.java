/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adaptador;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Alejandro
 */
public class ComponentCellRenderer extends JLabel implements ListCellRenderer{
    private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
    public ComponentCellRenderer(){
        setOpaque(true);
        setIconTextGap(12);
    }
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {        
        ComponentEntry audi = (ComponentEntry) value;
        setText(audi.toString());
        setIcon(audi.getImage());
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
