package Vista;

import ModeloSQL.Dieta;
import ModeloSQL.Paciente;
import Persistencia.Funciones;
import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
//import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RegistroIF extends javax.swing.JInternalFrame {

    private final Paciente paciente;
    private final Dieta dieta;
    
    public RegistroIF() {
        initComponents();
        this.paciente = new Paciente();
        this.dieta = new Dieta();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        panelDatosPaciente = new javax.swing.JPanel();
        labelNombrePac = new javax.swing.JLabel();
        nombrePacJTF = new javax.swing.JTextField();
        labelApellido = new javax.swing.JLabel();
        apellidoJTF = new javax.swing.JTextField();
        labelDNI = new javax.swing.JLabel();
        dniJTF = new javax.swing.JTextField();
        labelEdad = new javax.swing.JLabel();
        edadJTF = new javax.swing.JTextField();
        labelPesoAct = new javax.swing.JLabel();
        pesoActualJTF = new javax.swing.JTextField();
        labelPesoBusc = new javax.swing.JLabel();
        pesoBuscadoJTF = new javax.swing.JTextField();
        labelAltura = new javax.swing.JLabel();
        alturaJTF = new javax.swing.JTextField();
        labelPesoFinal = new javax.swing.JLabel();
        pesoFinalJTF = new javax.swing.JTextField();
        panelDatosDieta = new javax.swing.JPanel();
        labelCaloriasTotal = new javax.swing.JLabel();
        labelNombreDieta1 = new javax.swing.JLabel();
        fechaIniJD = new com.toedter.calendar.JDateChooser();
        labelFechaInicio = new javax.swing.JLabel();
        fechaFinJD = new com.toedter.calendar.JDateChooser();
        labelFechaFin = new javax.swing.JLabel();
        labelDetalle = new javax.swing.JLabel();
        detalleJTF = new javax.swing.JTextField();
        panelBotones = new javax.swing.JPanel();
        agregarJB = new javax.swing.JButton();
        modificarJB = new javax.swing.JButton();
        eliminarJB = new javax.swing.JButton();
        limpiarJB = new javax.swing.JButton();
        labelDieta = new javax.swing.JLabel();
        labelPaciente = new javax.swing.JLabel();

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
        jScrollPane2.setViewportView(tabla);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 1000, 140));

        panelDatosPaciente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelDatosPaciente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNombrePac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelNombrePac.setText("Nombre:");
        panelDatosPaciente.add(labelNombrePac, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 70, 30));

        nombrePacJTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nombrePacJTF.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelDatosPaciente.add(nombrePacJTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 152, 30));

        labelApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelApellido.setText("Apellido:");
        panelDatosPaciente.add(labelApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, 30));

        apellidoJTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        apellidoJTF.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelDatosPaciente.add(apellidoJTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 152, 30));

        labelDNI.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDNI.setText("DNI:");
        panelDatosPaciente.add(labelDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 40, 30));

        dniJTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dniJTF.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelDatosPaciente.add(dniJTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 152, 30));

        labelEdad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelEdad.setText("Edad:");
        panelDatosPaciente.add(labelEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 50, 30));

        edadJTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        edadJTF.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelDatosPaciente.add(edadJTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 152, 30));

        labelPesoAct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPesoAct.setText("Peso Actual:");
        panelDatosPaciente.add(labelPesoAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 90, 30));

        pesoActualJTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pesoActualJTF.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelDatosPaciente.add(pesoActualJTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 152, 30));

        labelPesoBusc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPesoBusc.setText("Peso Buscado:");
        panelDatosPaciente.add(labelPesoBusc, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 100, 30));

        pesoBuscadoJTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pesoBuscadoJTF.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelDatosPaciente.add(pesoBuscadoJTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 152, 30));

        labelAltura.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelAltura.setText("Altura:");
        panelDatosPaciente.add(labelAltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 50, 30));

        alturaJTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        alturaJTF.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelDatosPaciente.add(alturaJTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 152, 30));

        labelPesoFinal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPesoFinal.setText("Peso Final:");
        panelDatosPaciente.add(labelPesoFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 80, 30));
        labelPesoFinal.setVisible(false);

        pesoFinalJTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pesoFinalJTF.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelDatosPaciente.add(pesoFinalJTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 152, 30));
        pesoFinalJTF.setVisible(false);

        jPanel2.add(panelDatosPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 530, 170));

        panelDatosDieta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelDatosDieta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelCaloriasTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCaloriasTotal.setText("Calorias Totales:");
        panelDatosDieta.add(labelCaloriasTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 110, 30));

        labelNombreDieta1.setBackground(new java.awt.Color(0, 102, 102));
        labelNombreDieta1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelNombreDieta1.setText("0");
        panelDatosDieta.add(labelNombreDieta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 140, 30));

        fechaIniJD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelDatosDieta.add(fechaIniJD, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 152, -1));

        labelFechaInicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelFechaInicio.setText("Fecha de Inicio:");
        panelDatosDieta.add(labelFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 110, 30));

        fechaFinJD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelDatosDieta.add(fechaFinJD, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 152, -1));

        labelFechaFin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelFechaFin.setText("Fecha de Finalizacion:");
        panelDatosDieta.add(labelFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 150, 30));

        labelDetalle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDetalle.setText("Detalle:");
        panelDatosDieta.add(labelDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 60, 30));

        detalleJTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        detalleJTF.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelDatosDieta.add(detalleJTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 152, 30));

        jPanel2.add(panelDatosDieta, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 320, 170));

        panelBotones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelBotones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agregarJB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        agregarJB.setText("Agregar");
        agregarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarJBActionPerformed(evt);
            }
        });
        panelBotones.add(agregarJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 10, 110, -1));

        modificarJB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        modificarJB.setText("Modificar");
        modificarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarJBActionPerformed(evt);
            }
        });
        panelBotones.add(modificarJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, -1));

        eliminarJB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        eliminarJB.setText("Eliminar");
        panelBotones.add(eliminarJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 110, -1));

        limpiarJB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        limpiarJB.setText("Limpiar");
        panelBotones.add(limpiarJB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 110, -1));

        jPanel2.add(panelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 50, 130, 170));

        labelDieta.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        labelDieta.setText("Dieta");
        jPanel2.add(labelDieta, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, -1));

        labelPaciente.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        labelPaciente.setText("Paciente");
        jPanel2.add(labelPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarJBActionPerformed
        boolean flagPaciente = Funciones.checkField(panelDatosPaciente);
        String fechaIni = traducirDate(fechaIniJD);
        String fechaFin = traducirDate(fechaFinJD);
        if (flagPaciente & !fechaIni.equals("") & !fechaFin.equals("") & !detalleJTF.getText().equals("")) 
        {
            String nombre = nombrePacJTF.getText();
            String apellido = apellidoJTF.getText();
            int DNI = Integer.parseInt(dniJTF.getText());
            int edad = Integer.parseInt(edadJTF.getText());
            float altura = Float.parseFloat(alturaJTF.getText());
            float pesoA = Float.parseFloat(pesoActualJTF.getText());
            float pesoB = Float.parseFloat(pesoBuscadoJTF.getText());
            
            paciente.SQLPaciente(DNI, nombre, apellido, edad, altura, pesoA, pesoB);
            
            DNI = Integer.parseInt(dniJTF.getText());
            LocalDate fIni = LocalDate.parse(fechaIni);
            LocalDate fFin = LocalDate.parse(fechaFin);
            
            dieta.SQLDieta(DNI, detalleJTF.getText(), fIni, fFin);
        }
        else JOptionPane.showMessageDialog(rootPane, "Asegurece de completar los datos de Paciente y Dieta.");
//            ArrayList<Paciente> pacientes = new ArrayList(paciente.getAll(dniJTF.getText()));
//            if (!pacientes.isEmpty()) 
//            {
//                ArrayList<Dieta> dietas = new ArrayList(dieta.getAll(dniJTF.getText()));
//                
//            }
    }//GEN-LAST:event_agregarJBActionPerformed

    private void modificarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarJBActionPerformed
        // TODO add your handling code here:
        System.out.println(fechaIniJD.getCalendar());
        
        String dia = String.valueOf(fechaIniJD.getDate().getDate());
        String mes = String.valueOf(fechaIniJD.getDate().getMonth()+1);
        String anio = String.valueOf(fechaIniJD.getDate().getYear()+1900);
        String fecha = anio + "-" + mes + "-" + dia;
        System.out.println(fecha);
    }//GEN-LAST:event_modificarJBActionPerformed

    private String traducirDate(JDateChooser fecha) {
        String localDate = "";
        
        if (fecha.getCalendar() != null) 
        {
            String dia = String.valueOf(fechaIniJD.getDate().getDate());
            String mes = String.valueOf(fechaIniJD.getDate().getMonth()+1);
            String anio = String.valueOf(fechaIniJD.getDate().getYear()+1900);
            
            localDate = anio + "-" + mes + "-" + dia;
        }
        return localDate;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarJB;
    private javax.swing.JTextField alturaJTF;
    private javax.swing.JTextField apellidoJTF;
    private javax.swing.JTextField detalleJTF;
    private javax.swing.JTextField dniJTF;
    private javax.swing.JTextField edadJTF;
    private javax.swing.JButton eliminarJB;
    private com.toedter.calendar.JDateChooser fechaFinJD;
    private com.toedter.calendar.JDateChooser fechaIniJD;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelAltura;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelCaloriasTotal;
    private javax.swing.JLabel labelDNI;
    private javax.swing.JLabel labelDetalle;
    private javax.swing.JLabel labelDieta;
    private javax.swing.JLabel labelEdad;
    private javax.swing.JLabel labelFechaFin;
    private javax.swing.JLabel labelFechaInicio;
    private javax.swing.JLabel labelNombreDieta1;
    private javax.swing.JLabel labelNombrePac;
    private javax.swing.JLabel labelPaciente;
    private javax.swing.JLabel labelPesoAct;
    private javax.swing.JLabel labelPesoBusc;
    private javax.swing.JLabel labelPesoFinal;
    private javax.swing.JButton limpiarJB;
    private javax.swing.JButton modificarJB;
    private javax.swing.JTextField nombrePacJTF;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelDatosDieta;
    private javax.swing.JPanel panelDatosPaciente;
    private javax.swing.JTextField pesoActualJTF;
    private javax.swing.JTextField pesoBuscadoJTF;
    private javax.swing.JTextField pesoFinalJTF;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
/*Ver funcion de eliminacion de MenuIF*/
