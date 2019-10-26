/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebadb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Walter
 */
public class PruebaFrame extends javax.swing.JFrame {
    public ArrayList<Alumno> listado = new ArrayList<>();
    /**
     * Creates new form PruebaFrame
     */
    public PruebaFrame() {
        
        
        try {
            /*
                Username: aAmmbFODPF
                Database name: aAmmbFODPF
                Password: BOwcRFIcnJ
                Server: remotemysql.com
                Port: 3306
             */
            ConexionDB myconexion = new ConexionDB("jdbc:mysql://remotemysql.com:3306/aAmmbFODPF", "aAmmbFODPF", "BOwcRFIcnJ");

            Connection c = myconexion.connect();

            Statement s = c.createStatement();

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet resultados
            ResultSet resultados = s.executeQuery(
                    "SELECT p.* ,\n"
                    + "       a.nroregistro,\n"
                    + "       a.ingreso,\n"
                    + "       a.carrera\n"
                    + "                    FROM alumno a, persona p\n"
                    + "                    where p.id = a.persona_id;");

            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            while (resultados.next()) {

                Alumno a = new Alumno(
                        resultados.getInt("id"),
                        resultados.getInt("nroregistro"),
                        resultados.getInt("ingreso"),
                        resultados.getString("carrera"),
                        resultados.getInt("id"),
                        resultados.getString("nombre"),
                        resultados.getString("apellido"),
                        resultados.getString("dni"),
                        resultados.getString("mail"),
                        resultados.getString("telefono")
                );
                listado.add(a);

                /*
                System.out.print(
                        "ID: " + resultados.getInt("id"));
                System.out.println(
                        " - " + resultados.getString("nombre")
                        + " " + resultados.getString("apellido"));
                 */
            }
        /*
            PreparedStatement stmt = c.prepareStatement(
                    "select * from alumnomateria, materia\n"
                    + "where alumnomateria.alumno_id = ?\n"
                    + "and alumnomateria.materia_id = materia.id;"
            );
            stmt.setInt(1, listado.get(0).getId());//1 specifies the first parameter in the query
        */          
            
        } catch (SQLException ex) {
            //Logger.getLogger(PruebaDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error!!!  " + ex);
        } finally{
            initComponents();
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        dato1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listadoAlumnos = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        dato1.setText("jLabel1");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(dato1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(dato1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listadoAlumnos.setModel(new javax.swing.AbstractListModel<String>() {
            //Alumno alumno1 = new Alumno(1, 1234, 2019, "carrera1", 1, "juan", "perez", "123123", "ssssss", "2223232323");
            //Alumno[] alumnitos = {listado.get(0)};
            //listado
            public int getSize() { return listado.size(); }
            public String getElementAt(int i) { return listado.get(i).getNombre()+" "+listado.get(i).getApellido(); }
        });
        jScrollPane2.setViewportView(listadoAlumnos);

        jButton1.setText("Ver Datos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ver Materias");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        String columnas[] = {"Nombre","Apellido","DNI"};
        DefaultTableModel mimodelo = new javax.swing.table.DefaultTableModel(
            columnas,0);
        jTable1.setModel(mimodelo);
        //listado.forEach((n) -> Object[] filita = {n.getNombre(), n.getApellido(), n.getDNI()};
            for(int i= 0; i< listado.size(); i++){
                Object[] filita = {listado.get(i).getNombre(), listado.get(i).getApellido(), listado.get(i).getDni()};
                mimodelo.addRow(filita);
            }
            jScrollPane1.setViewportView(jTable1);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addContainerGap())
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int seleccion = listadoAlumnos.getSelectedIndex();
        
        if(seleccion >= 0){
            System.out.println(listado.get(seleccion).toString());
            dato1.setText(listado.get(seleccion).getMail());
            jDialog1.setVisible(true);
                    
        }else{
            System.out.println("No hay selección");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PruebaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PruebaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PruebaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PruebaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PruebaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dato1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JList<String> listadoAlumnos;
    // End of variables declaration//GEN-END:variables
}