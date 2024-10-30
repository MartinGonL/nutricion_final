package Vista;

import ModeloSQL.Ingrediente;
import ModeloSQL.Menu;
import java.awt.Component;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.table.DefaultTableModel;

public class MenuIF extends javax.swing.JInternalFrame {

    private final Menu menu;
    private final Ingrediente ingrediente;
    private DefaultTableModel modeloT;
    
    private String FLAG;
    
    public MenuIF() {
        initComponents();
        this.menu = new Menu();
        this.ingrediente = new Ingrediente();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panelBotonesComida = new javax.swing.JPanel();
        limpiarJB = new javax.swing.JButton();
        modificarJB = new javax.swing.JButton();
        guardarJB = new javax.swing.JButton();
        eliminarJB = new javax.swing.JButton();
        panelDatosComida = new javax.swing.JPanel();
        dniJL = new javax.swing.JLabel();
        dniJT = new javax.swing.JTextField();
        nombreComidaJL = new javax.swing.JLabel();
        nombreComidaJT = new javax.swing.JTextField();
        diasJL = new javax.swing.JLabel();
        cantidadDiasJS = new javax.swing.JSpinner();
        tipoJL = new javax.swing.JLabel();
        tipoComidaJCB = new javax.swing.JComboBox<>();
        comidasJL = new javax.swing.JLabel();
        panelDatosIng = new javax.swing.JPanel();
        nombreIngJL = new javax.swing.JLabel();
        nombreIngJT = new javax.swing.JTextField();
        cantidadJL = new javax.swing.JLabel();
        cantidadJT = new javax.swing.JTextField();
        gramosJL = new javax.swing.JLabel();
        ingredientesJL = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        panelBotonesIng = new javax.swing.JPanel();
        agregarJB = new javax.swing.JButton();
        quitarJB = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBotonesComida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelBotonesComida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        limpiarJB.setText("Limpiar");
        limpiarJB.setPreferredSize(new java.awt.Dimension(95, 30));
        panelBotonesComida.add(limpiarJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        modificarJB.setText("Modificar");
        modificarJB.setPreferredSize(new java.awt.Dimension(95, 30));
        modificarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarJBActionPerformed(evt);
            }
        });
        panelBotonesComida.add(modificarJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        guardarJB.setText("Guardar");
        guardarJB.setPreferredSize(new java.awt.Dimension(95, 30));
        guardarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarJBActionPerformed(evt);
            }
        });
        panelBotonesComida.add(guardarJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        eliminarJB.setText("Eliminar");
        eliminarJB.setPreferredSize(new java.awt.Dimension(95, 30));
        panelBotonesComida.add(eliminarJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jPanel2.add(panelBotonesComida, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 410, 50));

        panelDatosComida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelDatosComida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dniJL.setText("DNI Paciente:");
        panelDatosComida.add(dniJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 30));
        panelDatosComida.add(dniJT, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 90, -1));

        nombreComidaJL.setText("Nombre Comida:");
        panelDatosComida.add(nombreComidaJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 30));

        nombreComidaJT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombreComidaJTFocusGained(evt);
            }
        });
        nombreComidaJT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreComidaJTKeyReleased(evt);
            }
        });
        panelDatosComida.add(nombreComidaJT, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 110, -1));

        diasJL.setText("Dias de la Semana:");
        panelDatosComida.add(diasJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, 30));
        panelDatosComida.add(cantidadDiasJS, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 60, -1));

        tipoJL.setText("Tipo:");
        panelDatosComida.add(tipoJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, 30));

        tipoComidaJCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desayuno", "Almuerzo", "Snack", "Merienda", "Cena" }));
        panelDatosComida.add(tipoComidaJCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 110, -1));

        comidasJL.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        comidasJL.setText("Comidas");
        panelDatosComida.add(comidasJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel2.add(panelDatosComida, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, 110));

        panelDatosIng.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelDatosIng.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreIngJL.setText("Nombre:");
        panelDatosIng.add(nombreIngJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 30));

        nombreIngJT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombreIngJTFocusGained(evt);
            }
        });
        nombreIngJT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreIngJTKeyReleased(evt);
            }
        });
        panelDatosIng.add(nombreIngJT, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 90, -1));

        cantidadJL.setText("Cantidad:");
        panelDatosIng.add(cantidadJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 30));
        panelDatosIng.add(cantidadJT, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 46, -1));

        gramosJL.setText("g");
        panelDatosIng.add(gramosJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, 30));

        ingredientesJL.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        ingredientesJL.setText("Ingredientes");
        panelDatosIng.add(ingredientesJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel2.add(panelDatosIng, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 210, 110));

        tabla.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 310, 170));

        panelBotonesIng.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelBotonesIng.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agregarJB.setText("Agregar");
        agregarJB.setPreferredSize(new java.awt.Dimension(90, 30));
        agregarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarJBActionPerformed(evt);
            }
        });
        panelBotonesIng.add(agregarJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        quitarJB.setText("Quitar");
        quitarJB.setPreferredSize(new java.awt.Dimension(90, 30));
        panelBotonesIng.add(quitarJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jPanel2.add(panelBotonesIng, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 210, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreIngJTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreIngJTKeyReleased
        FLAG = "ingrediente";
        
        setColumn("ingrediente");
        resetTable();
        setRow("ingrediente");
    }//GEN-LAST:event_nombreIngJTKeyReleased
    
    private void nombreComidaJTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreComidaJTKeyReleased
        ArrayList<Menu> menus = new ArrayList(menu.getAll(nombreComidaJT.getText()));
        FLAG = "comida";
        
        if (menus.isEmpty()) 
        {
            guardarJB.setText("Crear");
            modificarJB.setText("Finalizar");
        }
        else 
        {
            setColumn("comida");
            resetTable();
            setRow("comida");
        }
    }//GEN-LAST:event_nombreComidaJTKeyReleased

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int filaSelect = tabla.getSelectedRow();
        try
        {
            String nombre = (String)tabla.getValueAt(filaSelect, 0);

            if (FLAG.equals("ingrediente")) 
            {
                nombreIngJT.setText(nombre);
            }
            else 
            {
                nombreComidaJT.setText(nombre);
                
                setColumn("receta");
                resetTable();
                setRow("receta");
            }
        }
        catch (HeadlessException ex) {}
    }//GEN-LAST:event_tablaMouseClicked

    private void guardarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarJBActionPerformed
        if (guardarJB.getText().equals("Crear")) 
        {
            menu.SQLMenu(nombreComidaJT.getText());
            
            for (Component componente : panelDatosComida.getComponents()) 
            {
                componente.setEnabled(false);
            }
            
            setRow("comida");
        }
    }//GEN-LAST:event_guardarJBActionPerformed

    private void agregarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarJBActionPerformed
        guardarJB.setText("Guardar");
        
        menu.setSQLIngredientes(nombreComidaJT.getText(), nombreIngJT.getText(), Float.parseFloat(cantidadJT.getText()));
        setColumn("receta");
        resetTable();
        setRow("receta");
    }//GEN-LAST:event_agregarJBActionPerformed

    private void modificarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarJBActionPerformed
        if (modificarJB.getText().equals("Finalizar"))
        {
            menu.setSQLCaloriasValorTotal(nombreComidaJT.getText());

            setColumn("comida");
            resetTable();
            setRow("comida");
            
            for (Component componente : panelDatosComida.getComponents()) 
            {
                componente.setEnabled(true);
            }            
            guardarJB.setText("Guardar");
            modificarJB.setText("Modificar");
        }
    }//GEN-LAST:event_modificarJBActionPerformed

    private void nombreComidaJTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreComidaJTFocusGained
        setColumn("comida");
        resetTable();
        setRow("comida");
    }//GEN-LAST:event_nombreComidaJTFocusGained

    private void nombreIngJTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreIngJTFocusGained
        setColumn("ingrediente");
        resetTable();
        setRow("ingrediente");
    }//GEN-LAST:event_nombreIngJTFocusGained

    private void setColumn(String tipo) {
        modeloT = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        
        switch (tipo) {
            case "ingrediente" -> {
                modeloT.addColumn("Nombre Ingrediente");
                modeloT.addColumn("Calorias Cada 100g");
            }
            case "comida" -> {
                modeloT.addColumn("Nombre Comida");
                modeloT.addColumn("Calorias Totales");
            }
            case "receta" -> {
                modeloT.addColumn("Ingredientes");
                modeloT.addColumn("Cantidad (Gramos)");
            }
        }
        
        tabla.setModel(modeloT);
    }
    
    private void setRow(String tipo) {
        try {
            switch (tipo) {
                case "ingrediente" -> {
                    ArrayList<Ingrediente> ingredientes = new ArrayList(ingrediente.getAll(nombreIngJT.getText()));
                    
                    for (Ingrediente ing : ingredientes) 
                    {
                        modeloT.addRow(new Object[]{
                            ing.getNombre(),
                            ing.getCaloriasCda100g(),
                        });
                        
                    }
                }
                case "comida" -> {
                    ArrayList<Menu> menus = new ArrayList(menu.getAll(nombreComidaJT.getText()));
                    
                    for (Menu men : menus) 
                    {
                        modeloT.addRow(new Object[]{
                            men.getNombre(),
                            men.getCaloriasValorTotal(),
                        });
                        
                    }
                }
                case "receta" -> {
                    TreeMap<String, Float> ingredientes = new TreeMap(menu.getSQLIngredientes(nombreComidaJT.getText()));

                    for (Map.Entry<String, Float> datos : ingredientes.entrySet()) 
                    {
                        modeloT.addRow(new Object[]{
                            datos.getValue(),
                            datos.getKey(),
                        });
                    }
                }
            }

            tabla.setModel(modeloT);
        }
        catch (NullPointerException ex) {}
    }
    
//    private void setInfo() {
//        TreeMap<String, Float> ingredientes = new TreeMap(menu.getSQLIngredientes(nombreComidaJT.getText()));
//
//        for (Map.Entry<String, Float> datos : ingredientes.entrySet()) 
//        {
//            modeloT.addRow(new Object[]{
//                datos.getValue(),
//                datos.getKey(),
//            });
//        }
//        tabla.setModel(modeloT);
//    }
    
    private void resetTable() {
        int x = modeloT.getRowCount()-1;
        
        for (int c = x; c >= 0; c--) {
            modeloT.removeRow(c);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarJB;
    private javax.swing.JSpinner cantidadDiasJS;
    private javax.swing.JLabel cantidadJL;
    private javax.swing.JTextField cantidadJT;
    private javax.swing.JLabel comidasJL;
    private javax.swing.JLabel diasJL;
    private javax.swing.JLabel dniJL;
    private javax.swing.JTextField dniJT;
    private javax.swing.JButton eliminarJB;
    private javax.swing.JLabel gramosJL;
    private javax.swing.JButton guardarJB;
    private javax.swing.JLabel ingredientesJL;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limpiarJB;
    private javax.swing.JButton modificarJB;
    private javax.swing.JLabel nombreComidaJL;
    private javax.swing.JTextField nombreComidaJT;
    private javax.swing.JLabel nombreIngJL;
    private javax.swing.JTextField nombreIngJT;
    private javax.swing.JPanel panelBotonesComida;
    private javax.swing.JPanel panelBotonesIng;
    private javax.swing.JPanel panelDatosComida;
    private javax.swing.JPanel panelDatosIng;
    private javax.swing.JButton quitarJB;
    private javax.swing.JTable tabla;
    private javax.swing.JComboBox<String> tipoComidaJCB;
    private javax.swing.JLabel tipoJL;
    // End of variables declaration//GEN-END:variables
}
