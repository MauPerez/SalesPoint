/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.ExcelFile;
import backend.FileManager;
import backend.MemoryFile;
import backend.ReportManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Rubén Escalante
 */
public class MainScreen extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public MainScreen() {
        initComponents();
        startUI();
    }
    
    public void startUI() {         
        startCarta();
    }
    
    public void startCarta() {
        ArrayList<String> platillos = FileManager.readCarta();
        Collections.sort(platillos);
        for (String platillo : platillos) {
            cartaList.add(platillo);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Head = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        Body = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        textArea1 = new java.awt.TextArea();
        btnFinalizar = new java.awt.Button();
        btnCancelar = new java.awt.Button();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        cartaList = new java.awt.List();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        MenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        MenuConfiguracion = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NullSoft Sale System");
        setMinimumSize(new java.awt.Dimension(1200, 850));
        setPreferredSize(new java.awt.Dimension(1280, 850));
        setSize(new java.awt.Dimension(1280, 1000));

        Head.setBackground(new java.awt.Color(51, 51, 51));
        Head.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Head.setPreferredSize(new java.awt.Dimension(1269, 50));

        logo.setFont(new java.awt.Font("Quarca Norm Light", 0, 24)); // NOI18N
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/DayNS32.png"))); // NOI18N
        logo.setText("NullSoft");
        logo.setForeground(new java.awt.Color(187, 187, 187));

        javax.swing.GroupLayout HeadLayout = new javax.swing.GroupLayout(Head);
        Head.setLayout(HeadLayout);
        HeadLayout.setHorizontalGroup(
            HeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeadLayout.createSequentialGroup()
                .addGap(0, 1164, Short.MAX_VALUE)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        HeadLayout.setVerticalGroup(
            HeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        getContentPane().add(Head, java.awt.BorderLayout.PAGE_START);

        Body.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Body.setLayout(new java.awt.GridLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));

        textArea1.setBackground(new java.awt.Color(204, 204, 204));
        textArea1.setEditable(false);
        textArea1.setMinimumSize(new java.awt.Dimension(50, 80));

        btnFinalizar.setBackground(new java.awt.Color(0, 204, 0));
        btnFinalizar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnFinalizar.setLabel("Finalizar Venta");
        btnFinalizar.setMinimumSize(new java.awt.Dimension(20, 25));

        btnCancelar.setActionCommand("Cancelar Venta");
        btnCancelar.setBackground(new java.awt.Color(204, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setLabel("Cancelar Venta");
        btnCancelar.setMinimumSize(new java.awt.Dimension(20, 25));

        button1.setBackground(new java.awt.Color(0, 153, 204));
        button1.setFont(new java.awt.Font("Quarca Norm Light", 0, 24)); // NOI18N
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setLabel("Menú 3");

        button2.setBackground(new java.awt.Color(0, 153, 204));
        button2.setFont(new java.awt.Font("Quarca Norm Light", 0, 24)); // NOI18N
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setLabel("Menú 2");

        button3.setBackground(new java.awt.Color(0, 153, 204));
        button3.setFont(new java.awt.Font("Quarca Norm Light", 0, 24)); // NOI18N
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setLabel("Menú 1");

        cartaList.setBackground(new java.awt.Color(204, 204, 204));
        cartaList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cartaList.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        cartaList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartaListActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Quarca Norm Light", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("A la Carta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(647, 647, 647)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cartaList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(button1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(textArea1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cartaList, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        btnFinalizar.getAccessibleContext().setAccessibleName("btnFinalizar");

        jTabbedPane1.addTab("Ventas", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1310, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 703, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Inventario", jPanel2);

        Body.add(jTabbedPane1);
        jTabbedPane1.getAccessibleContext().setAccessibleName("Ventas");

        getContentPane().add(Body, java.awt.BorderLayout.CENTER);

        MenuBar.setBorder(null);
        MenuBar.setFont(new java.awt.Font("Quarca Norm Bold", 1, 12)); // NOI18N

        jMenu1.setMnemonic('a');
        jMenu1.setText("Archivo");

        jMenuItem1.setMnemonic('r');
        jMenuItem1.setText("Abrir Reportes");
        jMenu1.add(jMenuItem1);

        MenuConfiguracion.setMnemonic('c');
        MenuConfiguracion.setText("Configuración");
        MenuConfiguracion.setToolTipText("");
        MenuConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irConfig(evt);
            }
        });
        jMenu1.add(MenuConfiguracion);
        jMenu1.add(jSeparator1);

        jMenuItem2.setMnemonic('s');
        jMenuItem2.setText("Salir");
        jMenu1.add(jMenuItem2);

        MenuBar.add(jMenu1);

        setJMenuBar(MenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void irConfig(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irConfig
        // TODO add your handling code here:
        new Config().setVisible(true);
    }//GEN-LAST:event_irConfig

    private void cartaListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartaListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cartaListActionPerformed

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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainScreen mainScreen = new MainScreen();
                mainScreen.setVisible(true);
                mainScreen.setPreferredSize(new Dimension(1250, 200));
                
                // TEST ZONE
                ReportManager.createReport("excelTest");
                new Config().setVisible(true);
                // /.TEST ZONE
                
                //startup();
            }
        });
    }
    
    private static void startup() {
        try {
            if (!MemoryFile.isMemoryFile()) {
                // Se muestra la configuración inicial
                new Config().setVisible(true);
                
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JPanel Head;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem MenuConfiguracion;
    private java.awt.Button btnCancelar;
    private java.awt.Button btnFinalizar;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.List cartaList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel logo;
    private java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables
}
