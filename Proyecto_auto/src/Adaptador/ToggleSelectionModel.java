/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adaptador;

import javax.swing.DefaultListSelectionModel;

/**
 *
 * @author Alejandro
 */
public class ToggleSelectionModel extends DefaultListSelectionModel {
    boolean gestureStarted = false;   
    
    @Override
    public void setSelectionInterval(int index0, int index1) {
        if (isSelectedIndex(index0) && !gestureStarted) {
            super.removeSelectionInterval(index0, index1);
        }
        else {
            super.removeSelectionInterval(index0, index1);
        }
        gestureStarted = true;
    }

    @Override
    public void setValueIsAdjusting(boolean isAdjusting) {
        if (isAdjusting == false) {
          gestureStarted = false;
        }
    }
}
