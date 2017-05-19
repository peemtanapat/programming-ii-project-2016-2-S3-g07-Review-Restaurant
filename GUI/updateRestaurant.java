package GUI;

import model.Restaurant;
import model.Review;
import model.ConnectionBuilder;
import java.awt.Dialog;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class UpdateRestaurant extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    Object[] data = new Object[0];
    Restaurant rest = new Restaurant();
    private JDialog dialog;
    TableRowSorter<DefaultTableModel> sorter;
    int resIdFromTable;

    public UpdateRestaurant() {
        initComponents();
        model = (DefaultTableModel) tableRest.getModel();
        sorter = new TableRowSorter<>(model);
        tableRest.setRowSorter(sorter);
        tableRest.setRowHeight(20);
        showDataRecord();

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRest = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtFldSearch = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        txtFldRestName = new javax.swing.JTextField();
        txtFldRestAdd = new javax.swing.JTextField();
        txtFldRestType = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        txtFldRestRoad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFldRestProvince = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFldRestTime = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtFldRestTel = new javax.swing.JTextField();
        btnHome = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));

        tableRest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "ResName", "Type", "Address", "Road", "Province", "Number", "Open-Close"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRestMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableRest);
        if (tableRest.getColumnModel().getColumnCount() > 0) {
            tableRest.getColumnModel().getColumn(0).setMinWidth(30);
            tableRest.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableRest.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jLabel1.setText("Search");

        txtFldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldSearchActionPerformed(evt);
            }
        });
        txtFldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFldSearchKeyReleased(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(153, 153, 255));

        txtFldRestName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtFldRestName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldRestNameActionPerformed(evt);
            }
        });

        txtFldRestAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtFldRestType.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel3.setText("ResName:");

        jLabel4.setText("Type");

        jLabel5.setText("Address");

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        txtFldRestRoad.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtFldRestRoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldRestRoadActionPerformed(evt);
            }
        });

        jLabel6.setText("Road");

        jLabel7.setText("Province");

        txtFldRestProvince.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel8.setText("Time:");

        txtFldRestTime.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel9.setText("Tel.");

        txtFldRestTel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtFldRestAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                    .addComponent(txtFldRestProvince, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtFldRestRoad, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtFldRestTime))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtFldRestName, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFldRestType, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtFldRestTel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFldRestName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFldRestType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFldRestRoad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFldRestAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtFldRestTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFldRestProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFldRestTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(70, 70, 70)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87))
        );

        btnHome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnHome.setText("HOME");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHome)
                .addGap(60, 60, 60))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnHome))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableRestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRestMouseClicked
        int currentRow = tableRest.getSelectedRow();
//        String restId = tbRest.getValueAt(currentRow, 0).toString();

        resIdFromTable = Integer.parseInt(tableRest.getValueAt(currentRow, 0).toString());
        System.out.println(resIdFromTable);
        txtFldRestName.setText(tableRest.getValueAt(currentRow, 1).toString());
        txtFldRestType.setText(tableRest.getValueAt(currentRow, 2).toString());
        txtFldRestAdd.setText(tableRest.getValueAt(currentRow, 3).toString());
        txtFldRestRoad.setText(tableRest.getValueAt(currentRow, 4).toString());
        txtFldRestProvince.setText(tableRest.getValueAt(currentRow, 5).toString());
        txtFldRestTel.setText(tableRest.getValueAt(currentRow, 6).toString());
        txtFldRestTime.setText(tableRest.getValueAt(currentRow, 7).toString());

        txtFldRestName.setEnabled(true);
        txtFldRestType.setEnabled(true);
        txtFldRestAdd.setEnabled(true);

    }//GEN-LAST:event_tableRestMouseClicked

    private void txtFldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldSearchActionPerformed
        sorter.setRowFilter(RowFilter.regexFilter(txtFldSearch.getText()));
    }//GEN-LAST:event_txtFldSearchActionPerformed

    private void txtFldRestNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldRestNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldRestNameActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            insertData();
        } catch (ClassNotFoundException ex) {
            System.out.println("Insert Error ClassNotFound");
        } catch (SQLException ex) {
            System.out.println("Insert Error SQLException");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtFldRestRoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldRestRoadActionPerformed

    }//GEN-LAST:event_txtFldRestRoadActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        updateData();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteData();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtFldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFldSearchKeyReleased
        sorter.setRowFilter(RowFilter.regexFilter(txtFldSearch.getText()));
    }//GEN-LAST:event_txtFldSearchKeyReleased

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        try {
            HomeGUI hg = new HomeGUI();
            hg.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnHomeActionPerformed

    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UpdateRestaurant UpdatePage = new UpdateRestaurant();
                UpdatePage.setVisible(true);
            }
        });
    }

    public void setRestObjFromTextField() {
        rest.setResId(resIdFromTable);
        rest.setUserName("tanapat128"); //****ใส่ username ผู้ที่ login เข้ามา

        rest.setResName(txtFldRestName.getText());
        rest.setResType(txtFldRestType.getText());
        rest.setNameAdd(txtFldRestAdd.getText());
        rest.setRoad(txtFldRestRoad.getText());
        rest.setProvince(txtFldRestProvince.getText());
        rest.setResTel(txtFldRestTel.getText());
        rest.setResTime(txtFldRestTime.getText());
    }

    public void showDataRecord() {
        clearTableRows();
        String sql = "SELECT res_id,resname,restype,resAdd,road,province,resTel,resTime FROM Restaurant";
        try {
            Connection conn = ConnectionBuilder.getConnection();
            ResultSet rs = conn.createStatement().executeQuery(sql);
//            System.out.println("id: "+rs.getInt(1));
            int row = 0;
            while (rs.next()) {
                model.addRow(data);
                model.setValueAt(rs.getInt(1), row, 0);
                model.setValueAt(rs.getString(2), row, 1);
                model.setValueAt(rs.getString(3), row, 2);
                model.setValueAt(rs.getString(4), row, 3);
                model.setValueAt(rs.getString(5), row, 4);
                model.setValueAt(rs.getString(6), row, 5);
                model.setValueAt(rs.getString(7), row, 6);
                model.setValueAt(rs.getString(8), row, 7);

                row++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        tbProduct.setFillsViewportHeight(true);
    }

    public void insertData() throws ClassNotFoundException, SQLException {
        setRestObjFromTextField();
        if (rest.insertRestaurantInDB() != -1) {
            JOptionPane.showMessageDialog(this, "บันทึกข้อมลเรียบร้อยแล้ว", "แจ้งข้อมูล", JOptionPane.INFORMATION_MESSAGE);
            showDataRecord();
            clearText();
        }
    }

    public void updateData() {
        setRestObjFromTextField();
        if (rest.updateRestaurantInDB() != -1) {
            JOptionPane.showMessageDialog(this, "แก้ไขข้อมลเรียบร้อยแล้ว", "แจ้งข้อมูล", JOptionPane.INFORMATION_MESSAGE);
            showDataRecord();
            clearText();
        }
    }

    public void deleteData() {
        setRestObjFromTextField();
        int n = JOptionPane.showConfirmDialog(this,
                "Do you want to delete this list?",
                "Warning",
                JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            if (rest.deleteRestaurantInDB() != -1) {
                JOptionPane.showMessageDialog(this, "ลบข้อมลเรียบร้อยแล้ว", "แจ้งข้อมูล", JOptionPane.INFORMATION_MESSAGE);
                showDataRecord();
                clearText();
            }
        }
    }

    public boolean validateFields() {
        return false;
    }

    public void clearTableRows() {
        int row = model.getRowCount() - 1;
        while (row > -1) {
            model.removeRow(row--);
        }
    }

    public void clearText() {
        txtFldRestName.setText("");
        txtFldRestType.setText("");
        txtFldRestAdd.setText("");
        txtFldRestRoad.setText("");
        txtFldRestProvince.setText("");
        txtFldRestTel.setText("");
        txtFldRestTime.setText("");
//        jbtnEdit.setEnabled(false);
//        jbtnRemove.setEnabled(false);
    }

    private void setText() {

//        txtFldRestId.setText(rest.getResId() + "");
        txtFldRestName.setText(rest.getResName() + "");
        txtFldRestType.setText(rest.getResType() + "");
        txtFldRestAdd.setText(rest.getNameAdd() + "");
        txtFldRestRoad.setText(rest.getRoad() + "");
        txtFldRestProvince.setText(rest.getProvince() + "");
        txtFldRestTel.setText(rest.getResTel() + "");
        txtFldRestTime.setText(rest.getResTime() + "");

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableRest;
    private javax.swing.JTextField txtFldRestAdd;
    private javax.swing.JTextField txtFldRestName;
    private javax.swing.JTextField txtFldRestProvince;
    private javax.swing.JTextField txtFldRestRoad;
    private javax.swing.JTextField txtFldRestTel;
    private javax.swing.JTextField txtFldRestTime;
    private javax.swing.JTextField txtFldRestType;
    private javax.swing.JTextField txtFldSearch;
    // End of variables declaration//GEN-END:variables
}
