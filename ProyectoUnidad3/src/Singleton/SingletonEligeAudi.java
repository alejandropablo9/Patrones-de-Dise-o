/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import Iterador.IteraLista;
import Iterador.IteraPrecio;
//import Iterador.IteraTipo;
import Estrategia.Pagar12Meses;
import Estrategia.Pagar24Meses;
import Estrategia.PagarContado;
import Iterador.Lista_Audis;
//import Observador.Observable;
import Observador.Observador;
import Observador.Sujeto;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Main.Main;
import Observador.actualizar;
import java.text.DecimalFormat;

/**
 *
 * @author Ericko
 */
public class SingletonEligeAudi extends JFrame implements Sujeto {
    private javax.swing.JList<AudiEntry> listAudi;
    private javax.swing.JList<ComponentEntry> listExteriores;
    private javax.swing.JList<ComponentEntry> listInteriores;
    private javax.swing.JComboBox<String> mPago;
    private javax.swing.JList<ComponentEntry> motores;
    private ArrayList observadores;
     private static Factura vtnFactura = null;
    boolean todos;
    Lista_Audis ls;
    IteraLista it;
    IteraPrecio itp;
    //IteraTipo itt;
     int fila;
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

    private double costo_unidad;
    private static int numIns = 0;
    private static SingletonEligeAudi instancia;
    // Observador
   

    protected SingletonEligeAudi() {
        numIns++;
        todos = true;
        total_pagar = 0;
       //observadores = new ArrayList();
        initComponents();
        iniciar();
    }

    public void iniciar() {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        ls = new Lista_Audis();
        it = new IteraLista(ls);

         observadores = new ArrayList();
         /*
        listAudi.setCellRenderer(new AudiCellRenderer());
        listAudi.setVisibleRowCount(3);
        motores.setCellRenderer(new ComponentCellRenderer());
        motores.setVisibleRowCount(3);
        listExteriores.setCellRenderer(new ComponentCellRenderer());
        listExteriores.setVisibleRowCount(3);        
        listInteriores.setCellRenderer(new ComponentCellRenderer());
        listInteriores.setVisibleRowCount(3);      
*/
        ls.add((AudiGenerico)a1);
        ls.add((AudiGenerico)a3);
        

        System.out.println(ls.size());
        //ls.mostrar(it);
        tabla(ls.modelo_tabla(it));
    }

    public void tabla(DefaultTableModel modelo) {
        tablaResultado.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filtros = new javax.swing.ButtonGroup();
        pago = new javax.swing.ButtonGroup();
        panelMuestraAutos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaResultado = new javax.swing.JTable();
        btnAcepta = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        radSinFiltro = new javax.swing.JRadioButton();
        radFiltros = new javax.swing.JRadioButton();
        panelFiltros = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMayor = new javax.swing.JTextField();
        txtMenor = new javax.swing.JTextField();
        etiNumIns = new javax.swing.JLabel();
        etiEleccion = new javax.swing.JLabel();
        etiElegido = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtTotalPagar = new javax.swing.JTextField();

        setTitle("Audis");
        setIconImage(getIconImage());
        setIconImages(null);

        panelMuestraAutos.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados Busqueda"));

        tablaResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaResultadoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaResultado);

        javax.swing.GroupLayout panelMuestraAutosLayout = new javax.swing.GroupLayout(panelMuestraAutos);
        panelMuestraAutos.setLayout(panelMuestraAutosLayout);
        panelMuestraAutosLayout.setHorizontalGroup(
            panelMuestraAutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );
        panelMuestraAutosLayout.setVerticalGroup(
            panelMuestraAutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMuestraAutosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
        );

        btnAcepta.setText("Facturar");
        btnAcepta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptaActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        filtros.add(radSinFiltro);
        radSinFiltro.setSelected(true);
        radSinFiltro.setText("Todos");
        radSinFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radSinFiltroActionPerformed(evt);
            }
        });

        filtros.add(radFiltros);
        radFiltros.setText("Filtros");
        radFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radFiltrosActionPerformed(evt);
            }
        });

        panelFiltros.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        jLabel1.setText("Precio Mayor a:");

        jLabel2.setText("Precio Menor a:");

        txtMayor.setEnabled(false);
        txtMayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMayorActionPerformed(evt);
            }
        });
        txtMayor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMayorKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMayorKeyReleased(evt);
            }
        });

        txtMenor.setEnabled(false);
        txtMenor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMenorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMenorKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelFiltrosLayout = new javax.swing.GroupLayout(panelFiltros);
        panelFiltros.setLayout(panelFiltrosLayout);
        panelFiltrosLayout.setHorizontalGroup(
            panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtMenor, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtMayor)))
                .addContainerGap())
        );
        panelFiltrosLayout.setVerticalGroup(
            panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltrosLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMayor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMenor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        etiNumIns.setText("jLabel3");

        etiEleccion.setText("Audi Elegido :");

        etiElegido.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        etiElegido.setText("   ");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel3.setText("Metodo de Pago");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contado", "12 Meses", "24 Meses", "36 Meses" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mpago(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Total a Pagar");

        txtTotalPagar.setEnabled(false);
        txtTotalPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radSinFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radFiltros))
                            .addComponent(panelFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelMuestraAutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnAcepta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(etiNumIns)
                                .addGap(42, 42, 42))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(etiEleccion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(etiElegido, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(155, 155, 155))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radSinFiltro)
                            .addComponent(radFiltros))
                        .addGap(18, 18, 18)
                        .addComponent(panelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelMuestraAutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(etiNumIns))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(etiElegido)
                            .addComponent(etiEleccion)
                            .addComponent(btnAcepta))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptaActionPerformed
        //aqui no se que voy a poner

        
     
        base= ls.get(fila);
       vtnFactura = Factura.getInstancia(base, total_intereses);
        Main.areaInforme.setText(null);
        Main.abierta_ec = false;
        this.instancia.dispose();
        this.instancia = null;
    }//GEN-LAST:event_btnAceptaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // DESTRUYE SINGLETON
        Main.areaInforme.setText(null);
        Main.abierta_ec = false;
        this.instancia.dispose();
        this.instancia = null;

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void radFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radFiltrosActionPerformed
        
        txtMayor.setEnabled(true);
        txtMenor.setEnabled(true);
        todos = false;
    }//GEN-LAST:event_radFiltrosActionPerformed

    private void radSinFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radSinFiltroActionPerformed
      //  cbxEligeTipo.setEnabled(false);
        txtMayor.setEnabled(false);
        txtMenor.setEnabled(false);
        iniciar();
    }//GEN-LAST:event_radSinFiltroActionPerformed

    private void tablaResultadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaResultadoMousePressed
        fila=-1;
        if (evt.getClickCount() == 2) {
            
            fila = tablaResultado.getSelectedRow();
            costo_unidad = Float.parseFloat(tablaResultado.getValueAt(fila, 1).toString());
            etiElegido.setText(tablaResultado.getValueAt(fila, 0).toString());
            
                total_pagar = costo_unidad *1;
                txtTotalPagar.setText("$ " + total_pagar);
            
            txtTotalPagar.setText("$ " + total_pagar);
            cambiosMedicion();
        }
    }//GEN-LAST:event_tablaResultadoMousePressed

    private void txtMayorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMayorKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresa numeros", "Tipo de dato erroneo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtMayorKeyTyped

    private void txtMenorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMenorKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresa numeros", "Tipo de dato erroneo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtMenorKeyTyped

    private void txtMayorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMayorKeyReleased
        if (!txtMayor.getText().isEmpty()) {
            float precio = Float.parseFloat(txtMayor.getText());
            itp = new IteraPrecio(ls, precio, 'M');
            tabla(ls.modelo_tabla(itp));
        }
    }//GEN-LAST:event_txtMayorKeyReleased

    private void txtMenorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMenorKeyReleased
        if (!txtMenor.getText().isEmpty()) {
            float precio = Float.parseFloat(txtMenor.getText());
            itp = new IteraPrecio(ls, precio, 'm');
            tabla(ls.modelo_tabla(itp));
        }
    }//GEN-LAST:event_txtMenorKeyReleased

    private void txtMayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMayorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMayorActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void mpago(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mpago
        // TODO add your handling code here:
        total_intereses=0;
         switch((String)jComboBox1.getSelectedItem()){   
             
            case "Contado":
                total_intereses =  costo_unidad + new PagarContado(total_pagar).calcularPagos();
                this.txtTotalPagar.setText("Total $"+
                    formateador.format(total_intereses));
            break;
            case "12 Meses":
                total_intereses =  costo_unidad + new Pagar12Meses(total_pagar).calcularPagos();
                this.txtTotalPagar.setText("Total $"+
                    formateador.format(total_intereses));
            break;
            case "24 Meses":
                total_intereses =  costo_unidad + new Pagar24Meses(total_pagar).calcularPagos();
                this.txtTotalPagar.setText("Total $"+
                    formateador.format(total_intereses));
            break;
            case "36 Meses":
                total_intereses =  costo_unidad + new Pagar24Meses(total_pagar).calcularPagos();
                this.txtTotalPagar.setText("Total $"+
                    formateador.format(total_intereses));
            break;            
        }
    }//GEN-LAST:event_mpago

    private void txtTotalPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPagarActionPerformed

    public static SingletonEligeAudi getInstancia() {
        if (instancia == null) {
            instancia = new SingletonEligeAudi();
            instancia.setVisible(true);
            etiNumIns.setText("Alesco Inc ®");
          
            Observador o1 = new actualizar(SingletonEligeAudi.instancia);
        }
        numIns = 0;
        return instancia;

    }

    public int getNumIns() {
        return numIns;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcepta;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel etiEleccion;
    private javax.swing.JLabel etiElegido;
    public static javax.swing.JLabel etiNumIns;
    private javax.swing.ButtonGroup filtros;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup pago;
    private javax.swing.JPanel panelFiltros;
    private javax.swing.JPanel panelMuestraAutos;
    private javax.swing.JRadioButton radFiltros;
    private javax.swing.JRadioButton radSinFiltro;
    private javax.swing.JTable tablaResultado;
    private javax.swing.JTextField txtMayor;
    private javax.swing.JTextField txtMenor;
    private javax.swing.JTextField txtTotalPagar;
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
            Observador observador = (Observador)observadores.get(i);
            //(float costo_total,float costo_unitario,int cantidad, String nombre);
            observador.actualiza(total_pagar, costo_unidad, etiElegido.getText());
        }

    }
    public void cambiosMedicion() {
        notificaObservadores(); /// cambio de estado modificacion en el estado
    }

    public int obtenCantidad() {
        int cantidad = 1;
      
        return cantidad;
    }

}
