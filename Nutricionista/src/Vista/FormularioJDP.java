package Vista;

import ModeloSQL.Dieta;
import ModeloSQL.Ingrediente;
import ModeloSQL.Menu;
import ModeloSQL.Paciente;
import Persistencia.Funciones;

import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormularioJDP extends javax.swing.JFrame {

    private RegistroIF registroIF;
    private IngredienteIF ingredienteIF;
    private MenuIF menuIF;

    private static DefaultTableModel modeloT;
    
    private final Paciente paciente;
    private final Dieta dieta;
    private static Ingrediente ingrediente;
    
    private static final TreeMap<String, String> tab = new TreeMap();
    private int count = 0;
    
    public FormularioJDP() {
        initComponents();
        this.paciente = new Paciente();
        this.dieta = new Dieta();
        ingrediente = new Ingrediente();
        
        setResizable(false);
        setLocationRelativeTo(null);

        setColumn("dietaDiaria");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        panelAutomatico = new javax.swing.JPanel();
        ingresarDatoJL = new javax.swing.JLabel();
        labelGenerarDieta = new javax.swing.JLabel();
        datoJTF = new javax.swing.JTextField();
        okJB = new javax.swing.JButton();
        enviarJB = new javax.swing.JButton();
        menuJMB = new javax.swing.JMenuBar();
        registroJM = new javax.swing.JMenu();
        registroJMI = new javax.swing.JMenuItem();
        comidasJM = new javax.swing.JMenu();
        comidasJMI = new javax.swing.JMenuItem();
        ingredientesJM = new javax.swing.JMenu();
        ingredientesJMI = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setMinimumSize(new java.awt.Dimension(500, 500));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(1050, 600));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tabla.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);
        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);

        panelAutomatico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelAutomatico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ingresarDatoJL.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        ingresarDatoJL.setText("Que ingrediente quiere que contenga su Desayuno/Merienda?");
        panelAutomatico.add(ingresarDatoJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 50));
        ingresarDatoJL.setVisible(false);

        labelGenerarDieta.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelGenerarDieta.setText("Generar dieta automatica ");
        panelAutomatico.add(labelGenerarDieta, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, -1, 50));

        datoJTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                datoJTFFocusGained(evt);
            }
        });
        datoJTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                datoJTFKeyReleased(evt);
            }
        });
        panelAutomatico.add(datoJTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 110, -1));
        datoJTF.setVisible(false);

        okJB.setText("OK");
        okJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okJBActionPerformed(evt);
            }
        });
        panelAutomatico.add(okJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, 90, -1));

        enviarJB.setText("Enviar");
        enviarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarJBActionPerformed(evt);
            }
        });
        panelAutomatico.add(enviarJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, -1, -1));
        enviarJB.setVisible(false);

        registroJM.setText("Registro");

        registroJMI.setText("Administrar Pacientes");
        registroJMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroJMIActionPerformed(evt);
            }
        });
        registroJM.add(registroJMI);

        menuJMB.add(registroJM);

        comidasJM.setText("Comidas");

        comidasJMI.setText("Lista Comidas");
        comidasJMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comidasJMIActionPerformed(evt);
            }
        });
        comidasJM.add(comidasJMI);

        menuJMB.add(comidasJM);

        ingredientesJM.setText("Ingredientes");

        ingredientesJMI.setText("Lista Ingredientes");
        ingredientesJMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingredientesJMIActionPerformed(evt);
            }
        });
        ingredientesJM.add(ingredientesJMI);

        menuJMB.add(ingredientesJM);

        setJMenuBar(menuJMB);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(panelAutomatico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAutomatico, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comidasJMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comidasJMIActionPerformed
        panelPrincipal.removeAll();
        panelPrincipal.repaint();

        menuIF = new MenuIF();
        menuIF.setVisible(true);

        panelPrincipal.add(menuIF);
        panelPrincipal.moveToFront(menuIF);
    }//GEN-LAST:event_comidasJMIActionPerformed

    private void registroJMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroJMIActionPerformed
        panelPrincipal.removeAll();
        panelPrincipal.repaint();

        registroIF = new RegistroIF();
        registroIF.setVisible(true);

        panelPrincipal.add(registroIF);
        panelPrincipal.moveToFront(registroIF);
    }//GEN-LAST:event_registroJMIActionPerformed

    private void ingredientesJMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingredientesJMIActionPerformed
        panelPrincipal.removeAll();
        panelPrincipal.repaint();

        ingredienteIF = new IngredienteIF();
        ingredienteIF.setVisible(true);

        panelPrincipal.add(ingredienteIF);
        panelPrincipal.moveToFront(ingredienteIF);
    }//GEN-LAST:event_ingredientesJMIActionPerformed

    private void okJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okJBActionPerformed
        if (count != 3 & count != 0) Funciones.eliminarRegistro("colacion", "ID_Dieta", dieta.getSQLID_Dieta(registroIF.sendDNI()).toString());
        okJB.setText((okJB.getText().equals("OK")) ? "Cancelar" : "OK");
        
        ingresarDatoJL.setVisible(okJB.getText().equals("Cancelar"));
        datoJTF.setVisible(okJB.getText().equals("Cancelar"));
        enviarJB.setVisible(okJB.getText().equals("Cancelar"));
        
        resetTable();
        setColumn((okJB.getText().equals("OK")) ? "dietaDiaria" : "ingrediente");
        count = 0;
    }//GEN-LAST:event_okJBActionPerformed

    private void enviarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarJBActionPerformed
        String pregunta = "Que ingrediente quiere que contenga su ";
        try 
        { 
            String DNI = registroIF.sendDNI(); 
            
            if (paciente.getSQLEstadoPaciente(DNI) & dieta.getSQLDietaDiaria(DNI).size() != 15) 
            {
                if (count < 3)
                {
                    if (!DNI.equals("")) 
                    {
                        count = dieta.generarDietaDiara(datoJTF.getText(), DNI, count);

                        if (count > 0) 
                        {    
                            pregunta += (count == 1) ? "Almuerzo/Cena?" : "Snack?";
                            ingresarDatoJL.setText(pregunta);
                            datoJTF.setText("");
                        }
                    }
                    else JOptionPane.showMessageDialog(rootPane, "Seleccione un pasiente en la pestaña registro.");
                }
                if (count == 3) 
                {
                    okJBActionPerformed(evt);
                    armarDietaDiaria(dieta.getSQLDietaDiaria(DNI), DNI);
                }
            }
            else 
            {
                JOptionPane.showMessageDialog(rootPane, "El paciente ya posee una Dieta Diaria o aun no a sido dado de alta.");
                okJBActionPerformed(evt);
            }
        }
        catch (NullPointerException ex) {}
        
    }//GEN-LAST:event_enviarJBActionPerformed

    private void datoJTFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_datoJTFFocusGained
        resetTable();
        setRow(new String[0][0], "ingrediente");
    }//GEN-LAST:event_datoJTFFocusGained

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        if (datoJTF.isVisible()) 
        {
            int filaSelect = tabla.getSelectedRow();
            try
            {
                String nombreI = (String)tabla.getValueAt(filaSelect, 0);
                datoJTF.setText(nombreI);
            }
            catch (Exception ex) {}
        }
        else 
        {
            int filaSelect = tabla.getSelectedRow();
            tab.put("momento", String.valueOf(filaSelect));
            
            int columnSelect = tabla.getSelectedColumn();
            tab.put("dia", String.valueOf(columnSelect));
            
            String nombreC = (String)tabla.getValueAt(filaSelect, columnSelect);
            tab.put("nombreC", nombreC);
            
            menuIF.setearDatos(tab);
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void datoJTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datoJTFKeyReleased
        resetTable();
        setRow(new String[0][0], "ingrediente");
    }//GEN-LAST:event_datoJTFKeyReleased

    private void setColumn(String tipo) {
        modeloT = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };

        switch (tipo) {
            case "dietaDiaria" -> 
            {
                modeloT.addColumn("Lunes");     //0
                modeloT.addColumn("Martes");    //1
                modeloT.addColumn("Miercoles"); //2
                modeloT.addColumn("Jueves");    //3
                modeloT.addColumn("Viernes");   //4
                modeloT.addColumn("Sabado");    //5
                modeloT.addColumn("Domingo");   //6
            }
            case "ingrediente" -> 
            {
                modeloT.addColumn("Nombre Ingrediente");     //0
            }
        }

        tabla.setModel(modeloT);
    }

    private static void setRow(String[][] comidas, String tipo) {
        switch (tipo) {
            case "dietaDiaria" -> 
            {
                for (int c = 0; c < 5; c++) 
                {
                    modeloT.addRow(new Object[]{
                        comidas[0][c],
                        comidas[1][c],
                        comidas[2][c],
                        comidas[3][c],
                        comidas[4][c],
                        comidas[5][c],
                        comidas[6][c],
                    });
                }
            }
            case "ingrediente" -> 
            {
                ArrayList<Ingrediente> ingredientes = new ArrayList(ingrediente.getAll(datoJTF.getText()));
                for (Ingrediente ing : ingredientes)
                {
                    modeloT.addRow(new Object[]{
                        ing.getNombre()
                    });
                }
            }
        }
        tabla.setModel(modeloT);
    }

    public static void resetTable() {
        int x = modeloT.getRowCount()-1;
        
        for (int c = x; c >= 0; c--) {
            modeloT.removeRow(c);
        }
    }
    
    public static void armarDietaDiaria(ArrayList<Menu> menus, String dni) {
        String[][] comidas = new String[7][5];
        int fila = 0;
        int colum = 0;
        for (Menu menu : menus) {
            String dia = menu.getDia();
            switch (dia) {
                case "Lunes" -> { colum = 0; }
                case "Martes" -> { colum = 1; }
                case "Miercoles" -> { colum = 2; }
                case "Jueves" -> { colum = 3; }
                case "Viernes" -> { colum = 4; }
                case "Sabado" -> { colum = 5; }
                case "Domingo" -> { colum = 6; }
            }
            String momento = menu.getMomentoDelDia();
            switch (momento) {
                case "Desayuno" -> { fila = 0; }
                case "Almuerzo" -> { fila = 1; }
                case "Snack" -> { fila = 2; }
                case "Merienda" -> { fila = 3; }
                case "Cena" -> { fila = 4; }
            }
            comidas[colum][fila] = menu.getNombre();
        }
        tab.clear();
        tab.put("paciente", dni);
        
        resetTable();
        setRow(comidas, "dietaDiaria");
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioJDP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new FormularioJDP().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu comidasJM;
    private javax.swing.JMenuItem comidasJMI;
    private static javax.swing.JTextField datoJTF;
    private javax.swing.JButton enviarJB;
    private javax.swing.JMenu ingredientesJM;
    private javax.swing.JMenuItem ingredientesJMI;
    private javax.swing.JLabel ingresarDatoJL;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelGenerarDieta;
    private javax.swing.JMenuBar menuJMB;
    private javax.swing.JButton okJB;
    private javax.swing.JPanel panelAutomatico;
    private javax.swing.JDesktopPane panelPrincipal;
    private javax.swing.JMenu registroJM;
    private javax.swing.JMenuItem registroJMI;
    private static javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
