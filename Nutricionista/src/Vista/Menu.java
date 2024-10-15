package Vista;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        menuJMB = new javax.swing.JMenuBar();
        pacienteJM = new javax.swing.JMenu();
        pacienteJMI = new javax.swing.JMenuItem();
        dietaJM = new javax.swing.JMenu();
        dietaJMI = new javax.swing.JMenuItem();
        menuJM = new javax.swing.JMenu();
        menuJMI = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );

        pacienteJM.setText("Pacientes");

        pacienteJMI.setText("Formulario Paciente");
        pacienteJM.add(pacienteJMI);

        menuJMB.add(pacienteJM);

        dietaJM.setText("Dieta");

        dietaJMI.setText("Formualario Dieta");
        dietaJM.add(dietaJMI);

        menuJMB.add(dietaJM);

        menuJM.setText("Comida");

        menuJMI.setText("Formulario Comida");
        menuJMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuJMIActionPerformed(evt);
            }
        });
        menuJM.add(menuJMI);

        menuJMB.add(menuJM);

        setJMenuBar(menuJMB);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuJMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuJMIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuJMIActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu dietaJM;
    private javax.swing.JMenuItem dietaJMI;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu menuJM;
    private javax.swing.JMenuBar menuJMB;
    private javax.swing.JMenuItem menuJMI;
    private javax.swing.JMenu pacienteJM;
    private javax.swing.JMenuItem pacienteJMI;
    // End of variables declaration//GEN-END:variables
}
