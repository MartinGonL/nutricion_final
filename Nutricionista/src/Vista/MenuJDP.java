package Vista;

public class MenuJDP extends javax.swing.JFrame {
    
    private IngredienteIF ingredienteIF;
    private MenuIF menuIF;
    
    public MenuJDP() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JDesktopPane();
        menuJMB = new javax.swing.JMenuBar();
        pacientesJM = new javax.swing.JMenu();
        pacientesJMI = new javax.swing.JMenuItem();
        dietasJM = new javax.swing.JMenu();
        dietasJMI = new javax.swing.JMenuItem();
        comidasJM = new javax.swing.JMenu();
        comidasJMI = new javax.swing.JMenuItem();
        ingredientesJM = new javax.swing.JMenu();
        ingredientesJMI = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setMinimumSize(new java.awt.Dimension(500, 500));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(300, 500));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pacientesJM.setText("Pacientes");

        pacientesJMI.setText("Lista Pacientes");
        pacientesJMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pacientesJMIActionPerformed(evt);
            }
        });
        pacientesJM.add(pacientesJMI);

        menuJMB.add(pacientesJM);

        dietasJM.setText("Dietas");
        dietasJM.setBorderPainted(false);

        dietasJMI.setText("Lista Dietas");
        dietasJM.add(dietasJMI);

        menuJMB.add(dietasJM);

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
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void pacientesJMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pacientesJMIActionPerformed
        
    }//GEN-LAST:event_pacientesJMIActionPerformed

    private void ingredientesJMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingredientesJMIActionPerformed
        panelPrincipal.removeAll();
        panelPrincipal.repaint();

        ingredienteIF = new IngredienteIF();
        ingredienteIF.setVisible(true);

        panelPrincipal.add(ingredienteIF);
        panelPrincipal.moveToFront(ingredienteIF);
    }//GEN-LAST:event_ingredientesJMIActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuJDP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new MenuJDP().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu comidasJM;
    private javax.swing.JMenuItem comidasJMI;
    private javax.swing.JMenu dietasJM;
    private javax.swing.JMenuItem dietasJMI;
    private javax.swing.JMenu ingredientesJM;
    private javax.swing.JMenuItem ingredientesJMI;
    private javax.swing.JMenuBar menuJMB;
    private javax.swing.JMenu pacientesJM;
    private javax.swing.JMenuItem pacientesJMI;
    private javax.swing.JDesktopPane panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
