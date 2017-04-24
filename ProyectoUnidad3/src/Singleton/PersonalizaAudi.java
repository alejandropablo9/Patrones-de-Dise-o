package Singleton;

import Adaptador.AudiCellRenderer;
import Adaptador.AudiEntry;
import Adaptador.ComponentCellRenderer;
import Adaptador.ComponentEntry;
import Decorador.Audi;

import Decorador.AudiGenerico;
import Decorador.Color.AzulMetalizado;
import Decorador.Color.NegroMetalizado;
import Decorador.Color.RojoMisano;
import Decorador.Interior.TapizadoHerzklopfen;
import Decorador.Interior.TapizadoMilano;
import Decorador.Interior.TapizadoPielAlcantara;
import Decorador.Motor.TFSIEgo;
import Decorador.Motor.TFSISline;
import Decorador.Motor.TFSIUrban;
import Estrategia.Pagar12Meses;
import Estrategia.Pagar24Meses;
import Estrategia.PagarContado;
//import Observador.Observable;
import Observador.Observador;
import Observador.Sujeto;
import Observador.actualizar;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class PersonalizaAudi extends javax.swing.JFrame implements Sujeto {
    
    private static PersonalizaAudi instancia = null;
    private ArrayList observadores;
    private static Factura vtnFactura = null;
    
    private final Audi a1 = new AudiGenerico("A1", 299900.0);
    private final Audi a3 = new AudiGenerico("A3", 389900.0);
    
    private Audi base = new AudiGenerico("Base", 0);
    
    private final Audi decTFSIEgo = new TFSIEgo(base);
    private final Audi decTFSLine = new TFSISline(base);
    private final Audi decTFSIUrban = new TFSIUrban(base);
    
    private final Audi decAzulM = new AzulMetalizado(base);
    private final Audi decNegroM = new NegroMetalizado(base);
    private final Audi decRojoM = new RojoMisano(base);
    
    private final Audi decTaH = new TapizadoHerzklopfen(base);
    private final Audi decTaM = new TapizadoMilano(base);
    private final Audi decTaP = new TapizadoPielAlcantara(base);
    
    private double total_pagar, costo_unitario, total_intereses;
    private DecimalFormat formateador = new DecimalFormat("###,###.##");
    
    private final AudiEntry audis[] = { 
        new AudiEntry(a1, "src/imagen/audis/A1_64.png"), 
        new AudiEntry(a3, "src/imagen/audis/A3.png"),  
    };   

    private final ComponentEntry motoresE [] = {
        new ComponentEntry (decTFSIUrban, "TFSI Urban", "src/imagen/audis/motor1.png"),
        new ComponentEntry (decTFSIEgo, "TFSI Ego", "src/imagen/audis/motor3.png"),
        new ComponentEntry (decTFSLine, "TFSI S line", "src/imagen/audis/motor2.png")
    };
    private final ComponentEntry interiores [] = {
        new ComponentEntry (decTaH, "Tapizado Herzklopfen", "src/imagen/audis/interior1.png"),
        new ComponentEntry (decTaM, "Tapizado Milano", "src/imagen/audis/interior2.png"),
        new ComponentEntry (decTaP, "Tapizado Piel Alcantara", "src/imagen/audis/interior3.png")
    };
    private final ComponentEntry exteriores [] = {
        new ComponentEntry (decAzulM, "Azul Metalizado", "src/imagen/audis/color_am.png"),
        new ComponentEntry (decNegroM, "Negro Metalizado", "src/imagen/audis/color_nm.png"),
        new ComponentEntry (decRojoM, "Rojo Misano", "src/imagen/audis/color_rm.png")
    };
    
    
    public PersonalizaAudi() {
        initComponents();
        observadores = new ArrayList();
        listAudi.setCellRenderer(new AudiCellRenderer());
       
        listAudi.setVisibleRowCount(3);
        motores.setCellRenderer(new ComponentCellRenderer());
        motores.setVisibleRowCount(3);
        listExteriores.setCellRenderer(new ComponentCellRenderer());
        listExteriores.setVisibleRowCount(3);        
       listInteriores.setCellRenderer(new ComponentCellRenderer());
       listInteriores.setVisibleRowCount(3);      
    }
    
    public static PersonalizaAudi getInstancia() {
        if(instancia == null){
            instancia = new PersonalizaAudi();            
            instancia.setVisible(true);
            //Observable observable = new Observable(PersonalizaAudi.instancia);
             Observador o1 = new actualizar(PersonalizaAudi.instancia);
        }       
        return instancia;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAudi = new javax.swing.JList<>(audis);
        letSelecAudi = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        motores = new javax.swing.JList<>(motoresE);
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listExteriores = new javax.swing.JList<>(exteriores);
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listInteriores = new javax.swing.JList<>(interiores);
        jLabel3 = new javax.swing.JLabel();
        btnRestablecer = new javax.swing.JButton();
        btnFabricar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        mPago = new javax.swing.JComboBox<>();
        letTotal = new javax.swing.JLabel();
        btnFacturar = new javax.swing.JButton();
        wallpaper = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(null);

        listAudi.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listAudi);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(50, 60, 140, 230);

        letSelecAudi.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        letSelecAudi.setForeground(new java.awt.Color(255, 255, 255));
        letSelecAudi.setText("Selecciona tu Audi");
        jPanel1.add(letSelecAudi);
        letSelecAudi.setBounds(31, 25, 170, 20);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);

        motores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        motores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(motores);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Motor");

        listExteriores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listExteriores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(listExteriores);

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("Exterior");

        listInteriores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listInteriores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(listInteriores);

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Interior");

        btnRestablecer.setBackground(new java.awt.Color(153, 0, 0));
        btnRestablecer.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnRestablecer.setForeground(new java.awt.Color(255, 255, 255));
        btnRestablecer.setText("Restablecer");
        btnRestablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestablecerActionPerformed(evt);
            }
        });

        btnFabricar.setBackground(new java.awt.Color(0, 102, 153));
        btnFabricar.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnFabricar.setForeground(new java.awt.Color(255, 255, 255));
        btnFabricar.setText("Fabricar");
        btnFabricar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFabricarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRestablecer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFabricar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addContainerGap())
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRestablecer)
                    .addComponent(btnFabricar)))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(220, 20, 610, 290);

        jPanel3.setOpaque(false);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel4.setText("Metodo de pago:");

        mPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contado", "12 Meses", "24 Meses", "36 Meses" }));
        mPago.setEnabled(false);
        mPago.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mPagoItemStateChanged(evt);
            }
        });
        mPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mPagoActionPerformed(evt);
            }
        });

        letTotal.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        letTotal.setText("Total: $");

        btnFacturar.setBackground(new java.awt.Color(0, 102, 153));
        btnFacturar.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnFacturar.setForeground(new java.awt.Color(255, 255, 255));
        btnFacturar.setText("Factura");
        btnFacturar.setEnabled(false);
        btnFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mPago, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(letTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFacturar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(letTotal)
                .addGap(18, 18, 18)
                .addComponent(btnFacturar)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(618, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 330, 840, 210);

        wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/wallpaper.jpg"))); // NOI18N
        jPanel1.add(wallpaper);
        wallpaper.setBounds(-510, 0, 1380, 720);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFabricarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFabricarActionPerformed
        if(listAudi.getSelectedIndex() != -1){
            base = (Audi) listAudi.getSelectedValue().getAudi();
            costo_unitario = base.precio();
            
            if(motores.getSelectedIndex() != -1){
                Audi motor = (Audi) motores.getSelectedValue().getComponent();
                if(motor instanceof TFSIEgo){
                    base = new TFSIEgo(base);
                }else if(motor instanceof TFSISline){
                    base = new TFSISline(base);
                }else if(motor instanceof TFSIUrban){
                    base = new TFSIUrban(base);
                }                
            }
            
            if(listInteriores.getSelectedIndex() != -1){
                Audi inter = (Audi) listInteriores.getSelectedValue().getComponent();
                if(inter instanceof TapizadoHerzklopfen){
                    base = new TapizadoHerzklopfen(base);
                }else if(inter instanceof TapizadoMilano){
                    base = new TapizadoMilano(base);
                }else if(inter instanceof TapizadoPielAlcantara){
                    base = new TapizadoPielAlcantara(base);
                }                
            }
            
            if(listExteriores.getSelectedIndex() != -1){
                Audi ext = (Audi) listExteriores.getSelectedValue().getComponent();
                if(ext instanceof AzulMetalizado){
                    base = new AzulMetalizado(base);
                }else if(ext instanceof NegroMetalizado){
                    base = new NegroMetalizado(base);
                }else if(ext instanceof RojoMisano){
                    base = new RojoMisano(base);
                }                
            }
            total_pagar = base.precio();            
            total_intereses = new PagarContado(total_pagar).calcularPagos();
            this.letTotal.setText("Total $" +
                    formateador.format(total_intereses));
            System.out.println(base.getDescripcion());
            System.out.println("$ " + base.precio());
            mPago.setEnabled(true);          
            btnFacturar.setEnabled(true);
            notificaObservadores();
        }else{
            JOptionPane.showMessageDialog(null, "Elige un audi");
        }        
    }//GEN-LAST:event_btnFabricarActionPerformed

    private void btnRestablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestablecerActionPerformed
        listAudi.clearSelection();
        listExteriores.clearSelection();
        listInteriores.clearSelection();
        motores.clearSelection();
        mPago.setEnabled(false);
        btnFacturar.setEnabled(false);
        letTotal.setText("Total $0.00");
    }//GEN-LAST:event_btnRestablecerActionPerformed

    private void mPagoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mPagoItemStateChanged
        switch((String)mPago.getSelectedItem()){            
            case "Contado":
                total_intereses = total_pagar + new PagarContado(total_pagar).calcularPagos();
                this.letTotal.setText("Total $"+
                    formateador.format(total_intereses));
            break;
            case "12 Meses":
                total_intereses = total_pagar + new Pagar12Meses(total_pagar).calcularPagos();
                this.letTotal.setText("Total $"+
                    formateador.format(total_intereses));
            break;
            case "24 Meses":
                total_intereses = total_pagar + new Pagar24Meses(total_pagar).calcularPagos();
                this.letTotal.setText("Total $"+
                    formateador.format(total_intereses));
            break;
            case "36 Meses":
                total_intereses = total_pagar + new Pagar24Meses(total_pagar).calcularPagos();
                this.letTotal.setText("Total $"+
                    formateador.format(total_intereses));
            break;            
        }
    }//GEN-LAST:event_mPagoItemStateChanged

    private void btnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturarActionPerformed
        vtnFactura = Factura.getInstancia(base, total_intereses);
    }//GEN-LAST:event_btnFacturarActionPerformed

    private void mPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mPagoActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFabricar;
    private javax.swing.JButton btnFacturar;
    private javax.swing.JButton btnRestablecer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel letSelecAudi;
    private javax.swing.JLabel letTotal;
    private javax.swing.JList<AudiEntry> listAudi;
    private javax.swing.JList<ComponentEntry> listExteriores;
    private javax.swing.JList<ComponentEntry> listInteriores;
    private javax.swing.JComboBox<String> mPago;
    private javax.swing.JList<ComponentEntry> motores;
    private javax.swing.JLabel wallpaper;
    // End of variables declaration//GEN-END:variables
        
    @Override
    public void registraObservador(Observador o) {        
        observadores.add(o);
    }

    @Override
    public void remueveObservador(Observador o) {
        int i = observadores.indexOf(o);
        if (i >= 0) {
            observadores.remove(o);
        }
    }

    @Override
    public void notificaObservadores() {
        for (int i = 0; i < observadores.size(); i++) {
            Observador observador = (Observador) observadores.get(i);
            //(float costo_total,float costo_unitario,int cantidad, String nombre);
            observador.actualiza(total_pagar, costo_unitario, base.getDescripcion());
        }
    }
}
