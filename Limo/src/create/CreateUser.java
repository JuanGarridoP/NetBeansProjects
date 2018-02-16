/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package create;

import implementDAO.users;
import implementDAO.roles;
import java.awt.Color;
import java.awt.Window;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan_Garrido
 */
public class CreateUser extends javax.swing.JInternalFrame {

    /**
     * Creates new form User
     */
    private static Map<Integer, String> rol = new HashMap<Integer, String>();
    public CreateUser() {
        initComponents();
        buscarRoles();
        idRol.setVisible(false);
        //idRol.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rolesBox = new javax.swing.JComboBox<>();
        usuarioText = new javax.swing.JTextField();
        correoText = new javax.swing.JTextField();
        avisoLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        idRol = new javax.swing.JTextField();
        passText = new javax.swing.JPasswordField();
        pass2Text = new javax.swing.JPasswordField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Crear Usuario");

        jLabel1.setText("Rol");

        jLabel2.setText("Usuario");

        jLabel3.setText("Correo");

        jLabel4.setText("Password");

        jLabel5.setText("Repite Password");

        rolesBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rolesBoxItemStateChanged(evt);
            }
        });

        avisoLabel.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        avisoLabel.setForeground(new java.awt.Color(204, 0, 0));

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        idRol.setEditable(false);
        idRol.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(idRol, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(correoText)
                            .addComponent(avisoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(rolesBox, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(usuarioText, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passText, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(pass2Text))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(idRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rolesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(correoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pass2Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(avisoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean exec=false;
        if(correoText.getText().equals("")){
            avisoLabel.setForeground(Color.RED);
            avisoLabel.setText("Correo requerido");
        }else if(usuarioText.getText().equals("")){
            avisoLabel.setForeground(Color.RED);
            avisoLabel.setText("Usuario requerido");
        }else if(passText.getText().equals("")){
            avisoLabel.setForeground(Color.RED);
            avisoLabel.setText("Contraseña requerida");
        }
        else if(pass2Text.getText().equals("")){
            avisoLabel.setForeground(Color.RED);
            avisoLabel.setText("Las contraseñas no son iguales");
        }else if (verificaPass() != true){
            avisoLabel.setForeground(Color.RED);
            avisoLabel.setText("Revise los password");
        }else{
            exec=users.userInsert(usuarioText.getText(), correoText.getText(), passText.getText(), Integer.parseInt(idRol.getText()));
           // exec=true;
            if(exec!=true){
                JOptionPane.showMessageDialog (null, "Parece que ha sucedido un problema", "Atención!!", JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog (null, "Se ha agregado correctamente!", "", JOptionPane.INFORMATION_MESSAGE);
                try {
                    this.setClosed(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rolesBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rolesBoxItemStateChanged
        idRol.setText((String) rolesBox.getSelectedItem());
        Iterator it = rol.keySet().iterator();
        while(it.hasNext()){
          Object key =  it.next();
          if(rol.get(key).equals(rolesBox.getSelectedItem())){
              idRol.setText(key.toString());
          }
        }
    }//GEN-LAST:event_rolesBoxItemStateChanged
    private void buscarRoles(){
        rol = roles.getRoles();
        Iterator it = rol.keySet().iterator();
        while(it.hasNext()){
          Object key =  it.next();
          rolesBox.addItem(rol.get(key));
          System.out.println("Clave: " + key + " -> Valor: " + rol.get(key));
        }
    }
    
    private boolean verificaPass(){
        boolean choice = false; 
        if(!pass2Text.getText().equals("")){
            if(!passText.getText().equals(pass2Text.getText())){  
                choice = false;
            }
            else{
                choice = true;
            }
        }
        return choice;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avisoLabel;
    private javax.swing.JTextField correoText;
    private javax.swing.JTextField idRol;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField pass2Text;
    private javax.swing.JPasswordField passText;
    private javax.swing.JComboBox<String> rolesBox;
    private javax.swing.JTextField usuarioText;
    // End of variables declaration//GEN-END:variables
}