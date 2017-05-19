/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Review;
import model.User;
import GUI.LoginGUI;

public class ReviewResGUI extends javax.swing.JFrame {

    HomeGUI h = null;
    String pathimg = "";
    int res_id;

    public ReviewResGUI() {
    }

    public ReviewResGUI(int res_id) {
        this.res_id = res_id;
        System.out.println("Res_id: " + this.res_id);
//        System.out.println("Username: "+username);
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnCreate = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtFldTopic = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        comboLook = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboService = new javax.swing.JComboBox<>();
        comboTaste = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comboClean = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        comboWorth = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        img = new javax.swing.JLabel();
        btnBrowse = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtFldContent = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Myproject\\Picture\\Untitled-1.jpg")); // NOI18N

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCreate.setBackground(new java.awt.Color(0, 153, 0));
        btnCreate.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(255, 51, 51));
        btnCreate.setText("ส่ง");
        btnCreate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnCreate.setPreferredSize(new java.awt.Dimension(60, 35));
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 520, 71, 47));

        jLabel12.setFont(new java.awt.Font("Pattaya", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("หัวข้อรีวิว");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 120, 39));

        jLabel13.setFont(new java.awt.Font("Pattaya", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("เขียนรัวิวที่นี่");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 120, 39));

        txtFldTopic.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtFldTopic.setForeground(new java.awt.Color(51, 51, 51));
        txtFldTopic.setText("topic");
        txtFldTopic.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.black, java.awt.Color.lightGray));
        txtFldTopic.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFldTopicFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFldTopicFocusLost(evt);
            }
        });
        txtFldTopic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldTopicActionPerformed(evt);
            }
        });
        jPanel1.add(txtFldTopic, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 352, 40));

        jPanel2.setBackground(new java.awt.Color(102, 255, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comboLook.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        comboLook.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "คะแนน", "0", "1", "2", "3", "4", "5" }));
        comboLook.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.black, java.awt.Color.lightGray));
        jPanel2.add(comboLook, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 200, -1, -1));

        jLabel7.setBackground(new java.awt.Color(0, 102, 204));
        jLabel7.setFont(new java.awt.Font("Pattaya", 0, 18)); // NOI18N
        jLabel7.setText("รสชาติ(0-5)");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 59, 120, 39));

        jLabel9.setFont(new java.awt.Font("Pattaya", 0, 18)); // NOI18N
        jLabel9.setText("ความสะอาด(0-5)");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 105, 120, 39));

        comboService.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        comboService.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "คะแนน", "0", "1", "2", "3", "4", "5" }));
        comboService.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.black, java.awt.Color.lightGray));
        jPanel2.add(comboService, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 156, -1, -1));

        comboTaste.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        comboTaste.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "คะแนน", "0", "1", "2", "3", "4", "5" }));
        comboTaste.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.black, java.awt.Color.lightGray));
        comboTaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTasteActionPerformed(evt);
            }
        });
        jPanel2.add(comboTaste, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 64, -1, -1));

        jLabel8.setFont(new java.awt.Font("Pattaya", 0, 18)); // NOI18N
        jLabel8.setText("การบริการ(0-5)");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 151, 120, 39));

        jLabel11.setFont(new java.awt.Font("Pattaya", 0, 18)); // NOI18N
        jLabel11.setText("บรรยากาศ(0-5)");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 195, 120, 39));

        comboClean.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        comboClean.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "คะแนน", "0", "1", "2", "3", "4", "5" }));
        comboClean.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.black, java.awt.Color.lightGray));
        jPanel2.add(comboClean, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 110, -1, -1));

        jLabel10.setFont(new java.awt.Font("Pattaya", 0, 18)); // NOI18N
        jLabel10.setText("ความคุ้มค่า(0-5)");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 241, 120, 39));

        comboWorth.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        comboWorth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "คะแนน", "0", "1", "2", "3", "4", "5" }));
        comboWorth.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.black, java.awt.Color.lightGray));
        jPanel2.add(comboWorth, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 246, -1, -1));

        jLabel14.setFont(new java.awt.Font("Pattaya", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 153));
        jLabel14.setText("ให้คะแนนร้านค้า");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 177, 39));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 270, 290));

        img.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        img.setForeground(new java.awt.Color(255, 255, 255));
        img.setText("       image");
        jPanel1.add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 180, 110));

        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });
        jPanel1.add(btnBrowse, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Input image here: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, -1, -1));

        txtFldContent.setColumns(20);
        txtFldContent.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        txtFldContent.setRows(5);
        jScrollPane2.setViewportView(txtFldContent);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 360, 260));

        jLabel15.setBackground(new java.awt.Color(51, 51, 255));
        jLabel15.setFont(new java.awt.Font("Pattaya", 1, 48)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 51));
        jLabel15.setText("รีวิว");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        btnBack.setFont(new java.awt.Font("Pattaya", 1, 20)); // NOI18N
        btnBack.setText("กลับ");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed

        JOptionPane.showMessageDialog(null, "Complete");

        System.out.println("Selected CreateButton");

        String username = LoginGUI.getUsername(); //
        System.out.println("Username: " + username);
        int resId = this.res_id;
        String topic = txtFldTopic.getText();
        String content = txtFldContent.getText();
        int taste = Integer.parseInt(comboTaste.getSelectedItem().toString());
        int clean = Integer.parseInt(comboClean.getSelectedItem().toString());
        int service = Integer.parseInt(comboService.getSelectedItem().toString());
        int look = Integer.parseInt(comboLook.getSelectedItem().toString());
        int worth = Integer.parseInt(comboWorth.getSelectedItem().toString());
        String url = pathimg;
        System.out.println("pathimg: " + url);
        try {
//            ArrayList<Review> img = Review.imgin(pathimg);
            Review.reviewRes(username, resId, topic, content, taste, clean, service, look, worth, url);
        } catch (SQLException ex) {
            //            Logger.getLogger(ReviewGUI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("! SQL ReviewGUI");
        } catch (ClassNotFoundException ex) {
            //            Logger.getLogger(ReviewGUI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("!! ClassNotFound ReviewGUI");
        } catch (NumberFormatException ex) { //Exceptionnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
            System.out.println("Restaurant ID is invalid");
        }
        int conf = JOptionPane.showConfirmDialog(null, "Go to homepage?", "Confirm Dialog", 2);
        if (conf == 0) {
            System.out.println("You Press OK...Go to Homepage");
            try {
                h = new HomeGUI();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            h.setVisible(true);
            this.setVisible(false);
        } else {
            System.out.println("You Press Cancel...Stay this page");
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void txtFldTopicFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFldTopicFocusGained
        if (txtFldTopic.getText().equalsIgnoreCase("topic")) {
            txtFldTopic.setText("");
        } else {
        }
    }//GEN-LAST:event_txtFldTopicFocusGained

    private void txtFldTopicFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFldTopicFocusLost
        if (txtFldTopic.getText().equalsIgnoreCase("")) {
            txtFldTopic.setText("topic");
        }
    }//GEN-LAST:event_txtFldTopicFocusLost

    private void txtFldTopicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldTopicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldTopicActionPerformed

    private void comboTasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTasteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTasteActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        JFileChooser fileopen = new JFileChooser(); 
        fileopen.setAcceptAllFileFilterUsed(false);
        fileopen.addChoosableFileFilter(new FileNameExtensionFilter(".jpg", "jpg"));
        fileopen.addChoosableFileFilter(new FileNameExtensionFilter(".gif", "gif"));
        fileopen.addChoosableFileFilter(new FileNameExtensionFilter(".png", "png"));
        int result = fileopen.showDialog(null, "Choose Picture");
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectfile = fileopen.getSelectedFile();
            String path = selectfile.getAbsolutePath();
            img.setIcon(new ImageIcon((new ImageIcon(path).getImage().getScaledInstance(120, 80, Image.SCALE_DEFAULT))));
            pathimg = path;
            System.out.println(pathimg);
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        try {
            h = new HomeGUI();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        h.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReviewResGUI reGUI = new ReviewResGUI();
                reGUI.setLocationRelativeTo(null);
                reGUI.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnCreate;
    private javax.swing.JComboBox<String> comboClean;
    private javax.swing.JComboBox<String> comboLook;
    private javax.swing.JComboBox<String> comboService;
    private javax.swing.JComboBox<String> comboTaste;
    private javax.swing.JComboBox<String> comboWorth;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtFldContent;
    private javax.swing.JTextField txtFldTopic;
    // End of variables declaration//GEN-END:variables
}
