/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.FileManager;
import backend.FileTypes;
import backend.MemoryFile;
import backend.Inventario;
import backend.Ticket;
import backend.Venta;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author Rubén Escalante
 */
public class MainScreen extends javax.swing.JFrame {
    
    // NullSoft Variables
    public static MainScreen INSTANCE;
    public static HashMap<String, Inventario> alimentos = new HashMap<String, Inventario>();
    public static Venta recibo; 
    public static boolean isCardPayed;
    public static ArrayList<Inventario> dayMenus = null;
    DefaultListModel model;
    
    

    /**
     * Creates new form NewJFrame
     */
    public MainScreen() {
        INSTANCE = this;
        initComponents();
        startUp();
        startUI();
    }
    
    private void startUp() {
        try {
            if (!MemoryFile.isMemoryFile()) {
                // Se muestra la configuración inicial
                new MenuSelector().setVisible(true);
                
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    // Inicia las listas en pantalla
    public void startUI() {         
        startList(cartaList, FileTypes.CARTA);
        startList(bebidasList, FileTypes.BEBIDAS);
        startList(antojosList, FileTypes.ANTOJOS);
        startList(extrasList, FileTypes.EXTRAS);
        startMenu();
        startWaiters();
        
        recibo = new Venta();
    }
    
    public void resetUI() {
        cartaList.removeAll();
        bebidasList.removeAll();
        antojosList.removeAll();
        extrasList.removeAll();
        menusList.removeAll();
        waiterChoose.removeAll();
        
        alimentos.clear();
        startUI();
    }
    
    // Inicializa las listas de la GUI con los valores de los txt
    public void startList(java.awt.List listField, FileTypes file) {
        ArrayList<Inventario> platillos = FileManager.readItemsInFile(file);
        Collections.sort(platillos);
        String name;
        for (Inventario platillo : platillos) {
            name = platillo.getName();
            // Añade cada producto a la lista en pantalla correspondiente
            listField.add(name);
            
            // Guarda cada producto en el hash table
            if (!alimentos.containsKey(name)) {
                alimentos.put(name, platillo);
            }
        }
    }
    
    private void startMenu() {
        
        loadMenuFromMemory();
        
        if (dayMenus == null || dayMenus.size() < 1) {
            return;
        }
        
        Collections.sort(dayMenus);
        String name;
        
        for (Inventario platillo : dayMenus) {
            name = platillo.getName();
            // Añade cada producto a la lista en pantalla correspondiente
            menusList.add(name);
            
            // Guarda cada producto en el hash table
            if (!alimentos.containsKey(name)) {
                alimentos.put(name, platillo);
            }
        }   
    }
    
    private void loadMenuFromMemory() {
        ArrayList<Object> memory = MemoryFile.getData();
        
        for (Object object : memory) {
            
            if (object instanceof Inventario) {
                dayMenus.add((Inventario)object);
            }
            
        }
    }
    
    public void clearRecibo() {
        reciboList.removeAll();
        recibo.cleanVenta();
    }
    
    public void addRecibo(String key) {
        Inventario selected = alimentos.get(key);
        String name = selected.getName();
        Double price = selected.getPrice();
        
        recibo.addItem(selected);
        
        reciboList.add(name + ".... $" + String.valueOf(price));
    }
    
    private void startWaiters() {
        ArrayList<String> meseros = FileManager.readStringsInFile(FileTypes.MESEROS);
        for (String mesero : meseros) {
            waiterChoose.add(mesero);
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
        ventasPanel = new javax.swing.JPanel();
        btnFinalizar = new java.awt.Button();
        btnCancelar = new java.awt.Button();
        cartaList = new java.awt.List();
        jLabel1 = new javax.swing.JLabel();
        antojosList = new java.awt.List();
        jLabel2 = new javax.swing.JLabel();
        bebidasList = new java.awt.List();
        jLabel3 = new javax.swing.JLabel();
        waiterChoose = new java.awt.Choice();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        menusList = new java.awt.List();
        jLabel6 = new javax.swing.JLabel();
        extrasList = new java.awt.List();
        reciboList = new java.awt.List();
        creditCardRadioBtn = new javax.swing.JRadioButton();
        inventarioPanel = new javax.swing.JPanel();
        list1 = new java.awt.List();
        MenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        MenuConfiguracion = new javax.swing.JMenuItem();
        irMenuSelector = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NullSoft Sale System");
        setMinimumSize(new java.awt.Dimension(1200, 850));
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
                .addGap(0, 1408, Short.MAX_VALUE)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        HeadLayout.setVerticalGroup(
            HeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        getContentPane().add(Head, java.awt.BorderLayout.PAGE_START);

        Body.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Body.setLayout(new java.awt.GridLayout(1, 0));

        ventasPanel.setBackground(new java.awt.Color(51, 51, 51));
        ventasPanel.setForeground(new java.awt.Color(102, 102, 102));

        btnFinalizar.setBackground(new java.awt.Color(0, 204, 0));
        btnFinalizar.setFont(new java.awt.Font("Quarca Norm Regular", 0, 24)); // NOI18N
        btnFinalizar.setLabel("Finalizar Venta");
        btnFinalizar.setMinimumSize(new java.awt.Dimension(20, 25));
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnCancelar.setActionCommand("Cancelar Venta");
        btnCancelar.setBackground(new java.awt.Color(204, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Quarca Norm Regular", 0, 24)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setLabel("Cancelar Venta");
        btnCancelar.setMinimumSize(new java.awt.Dimension(20, 25));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cartaList.setBackground(new java.awt.Color(204, 204, 204));
        cartaList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cartaList.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        cartaList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartaListActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Quarca Norm Light", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("A la Carta");

        antojosList.setBackground(new java.awt.Color(204, 204, 204));
        antojosList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        antojosList.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        antojosList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                antojosListActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Quarca Norm Light", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Antojos");

        bebidasList.setBackground(new java.awt.Color(204, 204, 204));
        bebidasList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bebidasList.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        bebidasList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bebidasListActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Quarca Norm Light", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Bebidas");

        waiterChoose.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Quarca Norm Light", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Extras");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Quarca Norm Light", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Mesero");

        menusList.setBackground(new java.awt.Color(204, 204, 204));
        menusList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menusList.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        menusList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menusListActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Quarca Norm Light", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Menús");

        extrasList.setBackground(new java.awt.Color(204, 204, 204));
        extrasList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        extrasList.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        extrasList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extrasListActionPerformed(evt);
            }
        });

        reciboList.setBackground(new java.awt.Color(204, 204, 204));
        reciboList.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        reciboList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reciboListActionPerformed(evt);
            }
        });

        creditCardRadioBtn.setFont(new java.awt.Font("Quarca Norm Thin", 0, 18)); // NOI18N
        creditCardRadioBtn.setForeground(new java.awt.Color(204, 204, 204));
        creditCardRadioBtn.setText("Tarjeta de Credito");
        creditCardRadioBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        creditCardRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditCardRadioBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ventasPanelLayout = new javax.swing.GroupLayout(ventasPanel);
        ventasPanel.setLayout(ventasPanelLayout);
        ventasPanelLayout.setHorizontalGroup(
            ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bebidasList, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(antojosList, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cartaList, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                    .addComponent(menusList, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                    .addComponent(extrasList, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ventasPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(waiterChoose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                    .addComponent(reciboList, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(creditCardRadioBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ventasPanelLayout.setVerticalGroup(
            ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(waiterChoose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bebidasList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(antojosList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cartaList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventasPanelLayout.createSequentialGroup()
                        .addGroup(ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(reciboList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ventasPanelLayout.createSequentialGroup()
                                .addComponent(extrasList, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ventasPanelLayout.createSequentialGroup()
                                .addComponent(creditCardRadioBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(btnFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(menusList, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        btnFinalizar.getAccessibleContext().setAccessibleName("btnFinalizar");

        jTabbedPane1.addTab("Ventas", ventasPanel);

        list1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout inventarioPanelLayout = new javax.swing.GroupLayout(inventarioPanel);
        inventarioPanel.setLayout(inventarioPanelLayout);
        inventarioPanelLayout.setHorizontalGroup(
            inventarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventarioPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(list1, javax.swing.GroupLayout.DEFAULT_SIZE, 1534, Short.MAX_VALUE)
                .addContainerGap())
        );
        inventarioPanelLayout.setVerticalGroup(
            inventarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventarioPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inventario", inventarioPanel);

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

        irMenuSelector.setText("Elegir menús del día");
        irMenuSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irMenuSelectorActionPerformed(evt);
            }
        });
        jMenu1.add(irMenuSelector);

        MenuBar.add(jMenu1);

        setJMenuBar(MenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void irConfig(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irConfig
        // TODO add your handling code here:
        new Config().setVisible(true);
    }//GEN-LAST:event_irConfig

    private void bebidasListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebidasListActionPerformed
        // TODO add your handling code here:
        String selected = bebidasList.getSelectedItem();
        addRecibo(selected);
    }//GEN-LAST:event_bebidasListActionPerformed

    private void antojosListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_antojosListActionPerformed
        // TODO add your handling code here:
        String selected = antojosList.getSelectedItem();
        addRecibo(selected);
    }//GEN-LAST:event_antojosListActionPerformed

    private void cartaListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartaListActionPerformed
        // TODO add your handling code here:
        String selected = cartaList.getSelectedItem();
        addRecibo(selected);
    }//GEN-LAST:event_cartaListActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        clearRecibo();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed

        UIManager.put("OptionPane.minimumSize",new Dimension(400,400)); 
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 18)));
        
        String credit;
        if (isCardPayed) {
            credit = "Si";
        } else {
            credit = "No";
        }
        
        int n = JOptionPane.showConfirmDialog(null, recibo.getElements() + 
                "\nPaga con tarjeta: " + credit + 
                "\nTotal a pagar: " + recibo.getTotal() +
                "\nMesero: " + waiterChoose.getSelectedItem(),
                "Cuenta a Pagar", JOptionPane.OK_CANCEL_OPTION);
       
        if (n == JOptionPane.OK_OPTION) {
            // Crear ticket
            new Ticket(recibo, isCardPayed, waiterChoose.getSelectedItem()).confirmarVenta();
            creditCardRadioBtn.setSelected(false);
            clearRecibo();
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void menusListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menusListActionPerformed
        // TODO add your handling code here:
        String selected = menusList.getSelectedItem();
        addRecibo(selected);
    }//GEN-LAST:event_menusListActionPerformed

    private void extrasListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extrasListActionPerformed
        // TODO add your handling code here:
        String selected = extrasList.getSelectedItem();
        addRecibo(selected);
    }//GEN-LAST:event_extrasListActionPerformed

    private void reciboListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reciboListActionPerformed
        // TODO add your handling code here:
        String selected = reciboList.getSelectedItem();
        System.out.println(selected);
        reciboList.remove(selected);
        recibo.removeItemByItem(selected);
        System.out.println(recibo.toString());
       
    }//GEN-LAST:event_reciboListActionPerformed

    private void creditCardRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditCardRadioBtnActionPerformed
        // TODO add your handling code here:
        isCardPayed = creditCardRadioBtn.isSelected();
    }//GEN-LAST:event_creditCardRadioBtnActionPerformed

    private void irMenuSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irMenuSelectorActionPerformed
        // TODO add your handling code here:
        new MenuSelector().setVisible(true);
    }//GEN-LAST:event_irMenuSelectorActionPerformed

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
//                ReportManager.createReport("excelTest");
                // /.TEST ZONE
                
                //startup();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JPanel Head;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem MenuConfiguracion;
    private java.awt.List antojosList;
    private java.awt.List bebidasList;
    private java.awt.Button btnCancelar;
    private java.awt.Button btnFinalizar;
    private java.awt.List cartaList;
    private javax.swing.JRadioButton creditCardRadioBtn;
    private java.awt.List extrasList;
    private javax.swing.JPanel inventarioPanel;
    private javax.swing.JMenuItem irMenuSelector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private java.awt.List list1;
    private javax.swing.JLabel logo;
    private java.awt.List menusList;
    private java.awt.List reciboList;
    private javax.swing.JPanel ventasPanel;
    private java.awt.Choice waiterChoose;
    // End of variables declaration//GEN-END:variables
}
