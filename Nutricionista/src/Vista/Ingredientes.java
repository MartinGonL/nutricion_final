package Vista;

public class Ingredientes extends javax.swing.JInternalFrame {

    public Ingredientes() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelDatos = new javax.swing.JPanel();
        nombreJL = new javax.swing.JLabel();
        nombreJT = new javax.swing.JTextField();
        caloriasJL = new javax.swing.JLabel();
        caloriasJT = new javax.swing.JTextField();
        calorias1JL = new javax.swing.JLabel();
        guardarJB = new javax.swing.JButton();
        modificarJB = new javax.swing.JButton();
        eliminarJB = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelDatos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        nombreJL.setText("Nombre:");

        caloriasJL.setText("Calorias");

        calorias1JL.setText("cada 100g");

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(nombreJL)
                        .addGap(4, 4, 4)
                        .addComponent(nombreJT))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(caloriasJL)
                        .addGap(4, 4, 4)
                        .addComponent(caloriasJT, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calorias1JL)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreJL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreJT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caloriasJL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caloriasJT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calorias1JL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panelPrincipal.add(panelDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 110));

        guardarJB.setText("Guardar");
        guardarJB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        guardarJB.setPreferredSize(new java.awt.Dimension(95, 30));
        panelPrincipal.add(guardarJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        modificarJB.setText("Modificar");
        modificarJB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        modificarJB.setPreferredSize(new java.awt.Dimension(95, 30));
        panelPrincipal.add(modificarJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        eliminarJB.setText("Eliminar");
        eliminarJB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        eliminarJB.setPreferredSize(new java.awt.Dimension(95, 30));
        panelPrincipal.add(eliminarJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, -1, -1));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 355, 140));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel calorias1JL;
    private javax.swing.JLabel caloriasJL;
    private javax.swing.JTextField caloriasJT;
    private javax.swing.JButton eliminarJB;
    private javax.swing.JButton guardarJB;
    private javax.swing.JButton modificarJB;
    private javax.swing.JLabel nombreJL;
    private javax.swing.JTextField nombreJT;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
