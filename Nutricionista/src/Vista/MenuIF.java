package Vista;

import ModeloSQL.Ingrediente;
import ModeloSQL.Menu;
import Persistencia.Funciones;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.MenuComponent;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class MenuIF extends javax.swing.JInternalFrame {

    private final Menu menu;
    private final Ingrediente ingrediente;
    private DefaultTableModel modeloT;
    
    private String FLAG;
    private int contadorGlob = 5;
    
    public MenuIF() {
        initComponents();
        this.menu = new Menu();
        this.ingrediente = new Ingrediente();
        
        manejarPaneles();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        panelPrincipal = new javax.swing.JPanel();
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
        tipoJL = new javax.swing.JLabel();
        tipoComidaJCB = new javax.swing.JComboBox<>();
        comidasJL = new javax.swing.JLabel();
        diaJL = new javax.swing.JLabel();
        diaJCB = new javax.swing.JComboBox<>();
        CantDiasJL = new javax.swing.JLabel();
        cantDiasJS = new javax.swing.JSpinner();
        porcionesJL = new javax.swing.JLabel();
        porcionesJS = new javax.swing.JSpinner();
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

        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBotonesComida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelBotonesComida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        limpiarJB.setText("Limpiar");
        limpiarJB.setPreferredSize(new java.awt.Dimension(95, 30));
        limpiarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarJBActionPerformed(evt);
            }
        });
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
        eliminarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarJBActionPerformed(evt);
            }
        });
        panelBotonesComida.add(eliminarJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        panelPrincipal.add(panelBotonesComida, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 410, 50));

        panelDatosComida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelDatosComida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dniJL.setText("DNI:");
        panelDatosComida.add(dniJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 20));

        dniJT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelDatosComida.add(dniJT, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 80, -1));

        nombreComidaJL.setText("Nombre Comida:");
        panelDatosComida.add(nombreComidaJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, 20));

        nombreComidaJT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
        panelDatosComida.add(nombreComidaJT, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 130, -1));

        tipoJL.setText("Tipo:");
        panelDatosComida.add(tipoJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 40, 30));

        tipoComidaJCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desayuno", "Almuerzo", "Snack", "Merienda", "Cena" }));
        tipoComidaJCB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tipoComidaJCB.setName("tipoComida"); // NOI18N
        panelDatosComida.add(tipoComidaJCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 110, -1));

        comidasJL.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        comidasJL.setText("Comidas");
        panelDatosComida.add(comidasJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        diaJL.setText("Dia:");
        panelDatosComida.add(diaJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 40, 30));

        diaJCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" }));
        diaJCB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        diaJCB.setName("dia"); // NOI18N
        panelDatosComida.add(diaJCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        CantDiasJL.setText("Dias de la Semana:");
        panelDatosComida.add(CantDiasJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 30));

        cantDiasJS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SpinnerModel modeloS = new SpinnerNumberModel(3, 3, 7, 1);
        cantDiasJS.setModel(modeloS);
        panelDatosComida.add(cantDiasJS, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 50, -1));

        porcionesJL.setText("Porciones:");
        porcionesJL.setToolTipText("");
        panelDatosComida.add(porcionesJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, 30));

        porcionesJS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SpinnerModel modeloS2 = new SpinnerNumberModel(1, 1, 3, 1);
        porcionesJS.setModel(modeloS2);
        panelDatosComida.add(porcionesJS, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 50, -1));

        panelPrincipal.add(panelDatosComida, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, 170));

        panelDatosIng.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelDatosIng.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreIngJL.setText("Nombre:");
        panelDatosIng.add(nombreIngJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 20));

        nombreIngJT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
        panelDatosIng.add(nombreIngJT, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 90, -1));

        cantidadJL.setText("Cantidad:");
        panelDatosIng.add(cantidadJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 20));

        cantidadJT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelDatosIng.add(cantidadJT, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 46, -1));

        gramosJL.setText("g");
        panelDatosIng.add(gramosJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, 20));

        ingredientesJL.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        ingredientesJL.setText("Ingredientes");
        panelDatosIng.add(ingredientesJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        panelPrincipal.add(panelDatosIng, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 210, 170));

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

        panelPrincipal.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 310, 230));

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
        quitarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarJBActionPerformed(evt);
            }
        });
        panelBotonesIng.add(quitarJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        panelPrincipal.add(panelBotonesIng, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 210, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreIngJTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreIngJTKeyReleased
        ArrayList<Ingrediente> ingredientes = new ArrayList(ingrediente.getAll(nombreIngJT.getText()));
        
        agregarJB.setEnabled(!ingredientes.isEmpty());
        quitarJB.setEnabled(!ingredientes.isEmpty());
        
        setColumn("ingrediente");
        resetTable();
        setRow("ingrediente");
    }//GEN-LAST:event_nombreIngJTKeyReleased
    
    private void nombreComidaJTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreComidaJTKeyReleased
        ArrayList<Menu> menus = new ArrayList(menu.getAll(nombreComidaJT.getText()));
        
        guardarJB.setText((menus.isEmpty()) ? "Crear" : "Guardar");
        modificarJB.setText((menus.isEmpty()) ? "Finalizar" : "Modificar");
        
        setColumn("comida");
        resetTable();
        setRow("comida");
    }//GEN-LAST:event_nombreComidaJTKeyReleased

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        try
        {
            int filaSelect = tabla.getSelectedRow();
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

    /*Falta 2° parte*/
    private void guardarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarJBActionPerformed
        if (guardarJB.getText().equals("Crear") | eliminarJB.getText().equals("Cancelar")) 
        {
            eliminarJB.setText((eliminarJB.getText().equals("Eliminar")) ? "Cancelar" : "Eliminar");
            
            if (eliminarJB.getText().equals("Cancelar")) 
            {
                menu.SQLMenu(nombreComidaJT.getText());
                FLAG = "ingrediente";
                setColumn("ingrediente");
                setRow("ingrediente");
            }
            manejarPaneles();
//            for (Component componente : panelDatosComida.getComponents()) 
//            {
//                componente.setEnabled(eliminarJB.getText().equals("Eliminar"));
//            }
        }
        else 
        {
            boolean flag = Funciones.checkField(panelDatosComida);
            if (flag) 
            {
                int count = (int)cantDiasJS.getValue();
                if (contadorGlob > 0) 
                {
                    contadorGlob = menu.estructurarDieta(contadorGlob, dniJT.getText(), nombreComidaJT.getText(), diaJCB.getSelectedItem().toString(), tipoComidaJCB.getSelectedItem().toString(), (int)porcionesJS.getValue());
//                    precaucionTipoDeComida();
                }
                else 
                {
                    count--;
                    cantDiasJS.setValue(count);
                    contadorGlob = 5;
                }

                dniJT.setEnabled(count == 0);
                diaJCB.setEnabled(count == 0);
                cantDiasJS.setEnabled(count == 0);
            }
        }
    }//GEN-LAST:event_guardarJBActionPerformed

    private void agregarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarJBActionPerformed
        boolean flag = Funciones.checkField(panelDatosIng);
        
        if (flag) 
        {
            menu.setSQLIngredientes(nombreComidaJT.getText(), nombreIngJT.getText(), Float.parseFloat(cantidadJT.getText()));
            setColumn("receta");
            resetTable();
            setRow("receta");
            
            Funciones.cleanField(panelDatosIng);
        }
        else 
        {
            JOptionPane.showMessageDialog(rootPane, "Complete los campos solicitados.");
        }
    }//GEN-LAST:event_agregarJBActionPerformed

    /*Falta 2° parte*/
    private void modificarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarJBActionPerformed
        if (modificarJB.getText().equals("Finalizar"))
        {
            menu.setSQLCaloriasValorTotal(nombreComidaJT.getText());
            guardarJB.setText("Guardar");
            modificarJB.setText("Modificar");

            setColumn("comida");
            resetTable();
            setRow("comida");
            
            guardarJBActionPerformed(evt);
        }
        else 
        {
            if (contadorGlob > 0) 
            {
                System.out.println(tipoComidaJCB.getName());
                contadorGlob--;
                precaucionTipoDeComida(tipoComidaJCB);
            }
        }
    }//GEN-LAST:event_modificarJBActionPerformed

    private void nombreComidaJTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreComidaJTFocusGained
        FLAG = "comida";
        
        setColumn("comida");
        resetTable();
        setRow("comida");
    }//GEN-LAST:event_nombreComidaJTFocusGained

    private void nombreIngJTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreIngJTFocusGained
        FLAG = "ingrediente";
        
        setColumn("ingrediente");
        resetTable();
        setRow("ingrediente");
    }//GEN-LAST:event_nombreIngJTFocusGained

    private void eliminarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarJBActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(rootPane, (eliminarJB.getText().equals("Cancelar")) ? "Seguro que desea cancelar la operacion?" : "Seguro que desea eliminar el menu?");
        if (respuesta == 0) 
        {
            Funciones.eliminarRegistro("menu", "NombreM", nombreComidaJT.getText());
        }
        if (eliminarJB.getText().equals("Cancelar")) guardarJBActionPerformed(evt);
        Funciones.cleanField(panelDatosComida);
        Funciones.cleanField(panelDatosIng);
        resetTable();
//        Funciones.cleanField(panelPrincipal);
    }//GEN-LAST:event_eliminarJBActionPerformed

    //PROBAR.
    private void quitarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarJBActionPerformed
        Funciones.eliminarRegistro("receta", "NombreI", nombreIngJT.getText());
        
        setColumn("receta");
        resetTable();
        setRow("receta");
        
        Funciones.cleanField(panelDatosIng);
    }//GEN-LAST:event_quitarJBActionPerformed

    //PROBAR.
    private void limpiarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarJBActionPerformed
        Funciones.cleanField(panelDatosIng);
        Funciones.cleanField(panelDatosComida);
        
        resetTable();
    }//GEN-LAST:event_limpiarJBActionPerformed

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
                modeloT.addColumn("Cantidades (Gramos)");
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
                            datos.getKey(),
                            datos.getValue(),
                        });
                    }
                }
            }

            tabla.setModel(modeloT);
        }
        catch (NullPointerException ex) {}
    }
    
    private void resetTable() {
        int x = modeloT.getRowCount()-1;
        
        for (int c = x; c > 0; c--) {
            modeloT.removeRow(c);
        }
    }
    
    private void precaucionTipoDeComida(JComboBox box) {
        String[] TC = {"Desayuno", "Almuerzo", "Snack", "Merienda", "Cena"};
        String[] DIA = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
        
        DefaultComboBoxModel modelo = new DefaultComboBoxModel((box.getName().equals("dia")) ? DIA : TC);

        if (contadorGlob == 0) box.setModel(modelo);
        else box.removeItem(box.getSelectedItem());
    }
    
    private void manejarPaneles() {
        for (Component componente : panelDatosComida.getComponents()) 
        {
            componente.setEnabled(eliminarJB.getText().equals("Eliminar"));
        }
        for (Component componente : panelDatosIng.getComponents()) 
        {
            componente.setEnabled(!eliminarJB.getText().equals("Eliminar"));
        }
        for (Component componente : panelBotonesIng.getComponents()) 
        {
            componente.setEnabled(!eliminarJB.getText().equals("Eliminar"));
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CantDiasJL;
    private javax.swing.JButton agregarJB;
    private javax.swing.JSpinner cantDiasJS;
    private javax.swing.JLabel cantidadJL;
    private javax.swing.JTextField cantidadJT;
    private javax.swing.JLabel comidasJL;
    private javax.swing.JComboBox<String> diaJCB;
    private javax.swing.JLabel diaJL;
    private javax.swing.JLabel dniJL;
    private javax.swing.JTextField dniJT;
    private javax.swing.JButton eliminarJB;
    private javax.swing.JLabel gramosJL;
    private javax.swing.JButton guardarJB;
    private javax.swing.JLabel ingredientesJL;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JLabel porcionesJL;
    private javax.swing.JSpinner porcionesJS;
    private javax.swing.JButton quitarJB;
    private javax.swing.JTable tabla;
    private javax.swing.JComboBox<String> tipoComidaJCB;
    private javax.swing.JLabel tipoJL;
    // End of variables declaration//GEN-END:variables
}