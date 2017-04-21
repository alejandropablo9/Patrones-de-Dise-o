/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


import Singleton.PersonalizaAudi;
import Singleton.SingletonFabricaAudi;
import Singleton.SingletonEligeAudi;
import javax.swing.JOptionPane;

/**
 *
 * @author Ericko
 */
public final class Main extends javax.swing.JFrame {
    public static PersonalizaAudi vtnPersonaliza = null; 
    public static boolean abierta_ec;
    public static boolean abierta_cc;
    /**
     * Creates new form Desarrollador
     */
    public Main() {
        initComponents();
        setTitle("Agencia Audi MX");
        abierta_ec = false;
        abierta_cc = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        areaInforme = new javax.swing.JTextArea();
        imagenD = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        menuPersonaliza = new javax.swing.JMenuItem();
        menuElige = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Acerca de");
        setForeground(java.awt.Color.red);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        areaInforme.setEditable(false);
        areaInforme.setColumns(20);
        areaInforme.setRows(5);
        jScrollPane1.setViewportView(areaInforme);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 340, 220, 210));

        imagenD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/q5.jpg"))); // NOI18N
        imagenD.setToolTipText("");
        getContentPane().add(imagenD, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -10, 1000, 560));

        menu.setText("Tu Audi");

        menuPersonaliza.setText("Personaliza");
        menuPersonaliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPersonalizaActionPerformed(evt);
            }
        });
        menu.add(menuPersonaliza);

        menuElige.setText("Elige");
        menuElige.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEligeActionPerformed(evt);
            }
        });
        menu.add(menuElige);

        jMenuBar2.add(menu);

        setJMenuBar(jMenuBar2);

        getAccessibleContext().setAccessibleName("Acercade");
        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuEligeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEligeActionPerformed
        if (abierta_cc == false) {
            try {
                SingletonEligeAudi instancia1 = SingletonEligeAudi.getInstancia();
               // imagenD.add(instancia1);
                //instancia1.toFront();
                //instancia1.setLocation(15, 1);
                abierta_ec = true;
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Operacion Fabricar Audi");
        }
    }//GEN-LAST:event_menuEligeActionPerformed

    private void menuPersonalizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPersonalizaActionPerformed
        if(vtnPersonaliza == null){
            vtnPersonaliza = PersonalizaAudi.getInstancia();
        }else{
            vtnPersonaliza.setVisible(true);
        }
        /*
        if (abierta_ec == false) {
            try {
                SingletonFabricaAudi instancia = SingletonFabricaAudi.getInstancia();
                //imagenD.add(instancia);
               // instancia.toFront();
                //instancia.setLocation(15, 1);
                abierta_cc = true;
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Operacion Elegir un Audi pre");
        }
        */
    }//GEN-LAST:event_menuPersonalizaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea areaInforme;
    private javax.swing.JLabel imagenD;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuItem menuElige;
    private javax.swing.JMenuItem menuPersonaliza;
    // End of variables declaration//GEN-END:variables

}
