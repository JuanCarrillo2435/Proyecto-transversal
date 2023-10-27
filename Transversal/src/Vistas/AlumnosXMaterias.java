/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;
import Data.AlumnoData;
import Data.InscripcionData;
import Data.MateriaData;
import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class AlumnosXMaterias extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo;
    private List<Materia> listaMateria;
    private MateriaData matActual;
    private List<Alumno> listaAlumnoInsc;
    private InscripcionData aluData;
    public AlumnosXMaterias() {
        
        aluData = new InscripcionData();
        matActual = new MateriaData();
         modelo = new DefaultTableModel(){
            

            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }

        };
        listaMateria = matActual.listarMateria();
        initComponents();
        armarTabla();
        cargarMaterias();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCseleccionarMat = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMateria = new javax.swing.JTable();
        jBsalir = new javax.swing.JButton();

        jLabel1.setText("Listado de alumnos por materia");

        jLabel2.setText("Seleccione una materia");

        jCseleccionarMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCseleccionarMatActionPerformed(evt);
            }
        });

        jTMateria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTMateria);

        jBsalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(212, 212, 212))
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBsalir)
                        .addGap(0, 419, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jCseleccionarMat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCseleccionarMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127)
                .addComponent(jBsalir)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCseleccionarMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCseleccionarMatActionPerformed
        // TODO add your handling code here:
       borrarFila();
        Materia elegida =  (Materia) jCseleccionarMat.getSelectedItem();
        if(elegida!=null){
            listaAlumnoInsc = aluData.obtenerAlumnosXMateria(elegida.getIdMateria());
        
        if (listaAlumnoInsc.size()>0) {
            for (Alumno alum : listaAlumnoInsc) {
                modelo.addRow(new Object[]{
                    alum.getApellido(),
                    alum.getNombre(),
                    alum.getFechaDeNacimiento(),
                    alum.isEstado(),
                    alum.getDni()
                });
            }
            
        }
        }
        
    }//GEN-LAST:event_jCseleccionarMatActionPerformed
private void armarTabla(){
    modelo.addColumn("Apellido");
    modelo.addColumn("Nombre");
    modelo.addColumn("Fecha de nacimiento");
    modelo.addColumn("Estado");
    modelo.addColumn("Dni");
   jTMateria.setModel(modelo);
    
}

private void cargarMaterias(){
    for (Materia materia : listaMateria) {
        jCseleccionarMat.addItem(materia);
    }
}
  private void borrarFila() {
        int ind = modelo.getRowCount() - 1;
        for (int i = ind; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBsalir;
    private javax.swing.JComboBox<Materia> jCseleccionarMat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMateria;
    // End of variables declaration//GEN-END:variables
}
