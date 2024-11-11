package Vista;

import ModeloSQL.Menu;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class FormularioJDP extends javax.swing.JFrame {

    private RegistroIF registroIF;
    private IngredienteIF ingredienteIF;
    private MenuIF menuIF;

    private static DefaultTableModel modeloT;
//    private static final ArrayList<Menu> menus = new ArrayList();

    public FormularioJDP() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);

        setColumn();
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
        jScrollPane1.setViewportView(tabla);
        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);

        panelAutomatico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelAutomatico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ingresarDatoJL.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        ingresarDatoJL.setText("Ingrese:");
        panelAutomatico.add(ingresarDatoJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 50));
        ingresarDatoJL.setVisible(false);

        labelGenerarDieta.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelGenerarDieta.setText("Generar dieta automatica ");
        panelAutomatico.add(labelGenerarDieta, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, -1, 50));
        panelAutomatico.add(datoJTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 110, -1));
        datoJTF.setVisible(false);

        okJB.setText("OK");
        okJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okJBActionPerformed(evt);
            }
        });
        panelAutomatico.add(okJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 70, -1));

        enviarJB.setText("Enviar");
        panelAutomatico.add(enviarJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));
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
                .addComponent(panelAutomatico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        // TODO add your handling code here:
    }//GEN-LAST:event_okJBActionPerformed

    private void setColumn() {
        modeloT = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };

        modeloT.addColumn("Lunes");     //0
        modeloT.addColumn("Martes");    //1
        modeloT.addColumn("Miercoles"); //2
        modeloT.addColumn("Jueves");    //3
        modeloT.addColumn("Viernes");   //4
        modeloT.addColumn("Sabado");    //5
        modeloT.addColumn("Domingo");   //6

        tabla.setModel(modeloT);
    }

    private static void setRow(String[][] comidas) {
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
        tabla.setModel(modeloT);
    }

    private static void resetTable() {
        int x = modeloT.getRowCount()-1;
        
        for (int c = x; c >= 0; c--) {
            modeloT.removeRow(c);
        }
    }
    
    public static void armarDietaDiaria(ArrayList<Menu> menus) {
        String[][] comidas = new String[7][5];
        int fila = 0;
        int colum = 0;
        for (Menu menu : menus) {
            String dia = menu.getDia();
            switch (dia) {
                case "Lunes" -> { fila = 0; }
                case "Martes" -> { fila = 1; }
                case "Miercoles" -> { fila = 2; }
                case "Jueves" -> { fila = 3; }
                case "Viernes" -> { fila = 4; }
                case "Sabado" -> { fila = 5; }
                case "Domingo" -> { fila = 6; }
            }
            String momento = menu.getMomentoDelDia();
            switch (momento) {
                case "Desayuno" -> { colum = 0; }
                case "Almuerzo" -> { colum = 1; }
                case "Snack" -> { colum = 2; }
                case "Merienda" -> { colum = 3; }
                case "Cena" -> { colum = 4; }
            }
            comidas[fila][colum] = menu.getNombre();
        }
        resetTable();
        setRow(comidas);
    }

    public static void main(String args[]) {
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
    private javax.swing.JTextField datoJTF;
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
