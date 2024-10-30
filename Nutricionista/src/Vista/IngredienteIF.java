package Vista;

import ModeloSQL.Ingrediente;
import Persistencia.Funciones;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class IngredienteIF extends javax.swing.JInternalFrame {

    private final Ingrediente ingrediente;
    private String nombreClave;
    private DefaultTableModel modeloT;
    
    public IngredienteIF() {
        initComponents();
        this.ingrediente = new Ingrediente();
        
        setColumn();
        setRow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        guardarJB = new javax.swing.JButton();
        modificarJB = new javax.swing.JButton();
        eliminarJB = new javax.swing.JButton();
        panelDatos = new javax.swing.JPanel();
        nombreJL = new javax.swing.JLabel();
        nombreJT = new javax.swing.JTextField();
        caloriasJL = new javax.swing.JLabel();
        caloriasJT = new javax.swing.JTextField();
        calorias1JL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        panelTitulo = new javax.swing.JPanel();
        ingredientesJL = new javax.swing.JLabel();
        limpiarJB = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        guardarJB.setText("Guardar");
        guardarJB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        guardarJB.setBorderPainted(false);
        guardarJB.setPreferredSize(new java.awt.Dimension(95, 30));
        guardarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarJBActionPerformed(evt);
            }
        });
        panelPrincipal.add(guardarJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, -1, -1));

        modificarJB.setText("Modificar");
        modificarJB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        modificarJB.setBorderPainted(false);
        modificarJB.setPreferredSize(new java.awt.Dimension(95, 30));
        modificarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarJBActionPerformed(evt);
            }
        });
        panelPrincipal.add(modificarJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        eliminarJB.setText("Eliminar");
        eliminarJB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        eliminarJB.setBorderPainted(false);
        eliminarJB.setPreferredSize(new java.awt.Dimension(95, 30));
        eliminarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarJBActionPerformed(evt);
            }
        });
        panelPrincipal.add(eliminarJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, -1, -1));

        panelDatos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        nombreJL.setText("Nombre:");

        nombreJT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreJTKeyReleased(evt);
            }
        });

        caloriasJL.setText("Calorias");

        calorias1JL.setText("cada 100g");

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(nombreJL)
                        .addGap(4, 4, 4)
                        .addComponent(nombreJT))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(caloriasJL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(caloriasJT, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(calorias1JL)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreJL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreJT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caloriasJL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caloriasJT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calorias1JL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        panelPrincipal.add(panelDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 150));

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
        jScrollPane1.setViewportView(tabla);

        panelPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 340, 210));

        panelTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ingredientesJL.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        ingredientesJL.setText("Ingredientes");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(ingredientesJL)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(ingredientesJL)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        panelPrincipal.add(panelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 70));

        limpiarJB.setText("Limpiar");
        limpiarJB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        limpiarJB.setBorderPainted(false);
        limpiarJB.setPreferredSize(new java.awt.Dimension(95, 30));
        limpiarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarJBActionPerformed(evt);
            }
        });
        panelPrincipal.add(limpiarJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, -1));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 360, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarJBActionPerformed
        ArrayList<Ingrediente> ingredientes = new ArrayList(ingrediente.getAll(nombreJT.getText()));
        boolean flag = Funciones.checkField(panelDatos);
        try 
        {
            if (flag) 
            {
                if (ingredientes.isEmpty()) 
                {
                    ingrediente.SQLIngrediente(nombreJT.getText(), Float.parseFloat(caloriasJT.getText()));
                }
                else if (ingredientes.size() == 1)
                {
                    JOptionPane.showMessageDialog(rootPane, "No puede cargar el mismo Ingrediente 2 veces.\nModifique el existente.");
                }
            }
            else 
            {
                JOptionPane.showMessageDialog(rootPane, "Complete los campos para continuar.");
            }
        }
        catch (NumberFormatException ex) 
        {
            JOptionPane.showMessageDialog(rootPane, "Tipo de dato incorrecto.");
        }
        
        limpiarJBActionPerformed(evt);
    }//GEN-LAST:event_guardarJBActionPerformed

    private void modificarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarJBActionPerformed
        boolean flag = Funciones.checkField(panelDatos);
        try 
        {
            if (flag) 
            {
                ingrediente.setSQLCaloriasCda100g(Float.parseFloat(caloriasJT.getText()), nombreJT.getText());
                ingrediente.setSQLNombre(nombreJT.getText(), nombreClave);
            }
            else 
            {
                JOptionPane.showMessageDialog(rootPane, "Seleccione en la tabla el Ingrediente que desea modificar.");
            }
        }
        catch (NumberFormatException ex) 
        {
            JOptionPane.showMessageDialog(rootPane, "Tipo de dato incorrecto.");
        }

        limpiarJBActionPerformed(evt);
    }//GEN-LAST:event_modificarJBActionPerformed

    private void eliminarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarJBActionPerformed
        boolean flag = Funciones.checkField(panelDatos);
        
        if (flag) 
        { 
            int confirm = JOptionPane.showConfirmDialog(rootPane, "Seguro desea eliminar el ingrediente?");

            if (confirm == 0) 
            {
                Funciones.eliminarRegistro("ingrediente", "NombreI", nombreJT.getText());
            }
            else 
            {
                JOptionPane.showMessageDialog(rootPane, "Operacion Cancelada.");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Complete los campos silicitados.");
        }
        
        limpiarJBActionPerformed(evt);
    }//GEN-LAST:event_eliminarJBActionPerformed

    private void nombreJTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreJTKeyReleased
        resetTable();
        setRow();
    }//GEN-LAST:event_nombreJTKeyReleased

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int filaSelect = tabla.getSelectedRow();
        try
        {
            String nombreI = (String)tabla.getValueAt(filaSelect, 0);
            float calorias = (float)tabla.getValueAt(filaSelect, 1);
            
            nombreJT.setText(nombreI);
            caloriasJT.setText(String.valueOf(calorias));
        }
        catch (Exception ex) {}
        nombreClave = nombreJT.getText();
    }//GEN-LAST:event_tablaMouseClicked

    private void limpiarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarJBActionPerformed
        Funciones.cleanField(panelDatos);
        resetTable();
        setRow();
        
        nombreJT.setRequestFocusEnabled(true);
    }//GEN-LAST:event_limpiarJBActionPerformed

    private void setColumn() {
        modeloT = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        
        modeloT.addColumn("Nombre Ingrediente");
        modeloT.addColumn("Calorias (100g)");
        
        tabla.setModel(modeloT);
    }
    
    private void setRow() {
        ArrayList<Ingrediente> ingredientes = new ArrayList(ingrediente.getAll(nombreJT.getText()));
        
        for (Ingrediente ing : ingredientes) 
        {
            modeloT.addRow(new Object[]{
                ing.getNombre(),
                ing.getCaloriasCda100g(),
            });
        }
        
        tabla.setModel(modeloT);
    }
    
    private void resetTable() {
        int x = modeloT.getRowCount()-1;
        
        for (int c = x; c >= 0; c--) {
            modeloT.removeRow(c);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel calorias1JL;
    private javax.swing.JLabel caloriasJL;
    private javax.swing.JTextField caloriasJT;
    private javax.swing.JButton eliminarJB;
    private javax.swing.JButton guardarJB;
    private javax.swing.JLabel ingredientesJL;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiarJB;
    private javax.swing.JButton modificarJB;
    private javax.swing.JLabel nombreJL;
    private javax.swing.JTextField nombreJT;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
