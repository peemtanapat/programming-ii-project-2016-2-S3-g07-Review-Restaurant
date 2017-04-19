package GUI;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.*;
import static java.awt.FlowLayout.LEFT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import project_review.Restaurant;
import project_review.ConnectionBuilder;

public class Home extends JFrame implements ActionListener {   //อย่าลืม extends JFrame

    private JFrame jfSearch;
//แถว 1
    private JLabel lblSearch;
    private JTextField txtSearch;
    private JButton btnSearch;
//แถว 2     
    private JButton btnNew;
    private JComboBox comboCate;
//แถว 3    
    private JTable table;
    private JScrollPane scrollPane;

    public Home() {
//          jfSearch = new JFrame("Search Restaurants");

        setTitle("Search Restaurants");
//        getContentPane().setLayout(null);

        scrollPane = new JScrollPane();
//        scrollPane.setBounds(65, 72, 440, 89);
        table = new JTable();
        scrollPane.setViewportView(table);

        lblSearch = new JLabel("Find: ");
        lblSearch.setHorizontalAlignment(SwingConstants.RIGHT);
//        lblSearch.setBounds(101, 27, 84, 14);
        getContentPane().add(lblSearch);
        txtSearch = new JTextField();
        txtSearch.setSize(100, 100);
//        txtSearch.setBounds(195, 24, 160, 20);
//        txtSearch.setColumns(10);
        getContentPane().add(txtSearch);
        btnSearch = new JButton("Search");
        getContentPane().add(btnSearch);
//        btnSearch.setBounds(365, 23, 79, 23);

//-------แถว 2
        btnNew = new JButton("New");
//        String[] cateString = {"Categories", "ตามสั่ง", "ภัตตาคาร", "บุฟเฟต์", "กาแฟ เบเกอรี่"};
//        comboCate = new JComboBox(cateString);
//        comboCate.setSelectedIndex(0); //ตั้งค่าให้โชว์ตัวไหน
//        comboCate.setBounds(113, 76, 107, 20);
        comboCate = comboCate();

//jp1   
        JPanel jp1 = new JPanel(new GridLayout(1, 1));
//        jp1.setLayout(new FlowLayout());
        jp1.add(lblSearch);
        jp1.add(txtSearch);
        jp1.add(btnSearch);
        JPanel jp2 = new JPanel(new GridLayout(1, 1));
        jp2.add(btnNew);
        jp2.add(comboCate);
        JPanel jp3 = new JPanel();
        jp3.add(scrollPane);
        JPanel jpAll = new JPanel(new BorderLayout(5, 5));
        jpAll.add(jp1, BorderLayout.EAST);
        jpAll.add(jp2, BorderLayout.WEST);
        jpAll.add(jp3, BorderLayout.SOUTH);
//        add(jp1,BorderLayout.WEST);
//        add(jp2);
//        add(jp3,BorderLayout.SOUTH);
        add(jpAll);
        showTable();
        btnSearch.addActionListener(this);
        btnNew.addActionListener(this);
        comboCate.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            showTable();
            System.out.println("Success");
        }
        if (e.getSource() == btnNew) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Create().setVisible(true);
                }
            });
            //categories
        }
        if (e.getSource() == comboCate) {

            JComboBox comboBox = (JComboBox) e.getSource();

            String data = comboCate.getSelectedItem().toString();
            switch (data) {
                case "categories":
                    System.out.println("selected: " + data);
                    break;
                case "ทั้งหมด":
            }
//            if(data.equalsIgnoreCase("categories")){
//            
//            }else if
            System.out.println("selected: " + data);
        }

    }

    public JComboBox comboCate() {
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        comboBoxModel.addElement("Categories");
        comboBoxModel.addElement("ทั้งหมด");
        comboBoxModel.addElement("ตามสั่ง");
        comboBoxModel.addElement("ภัตตาคาร");
        comboBoxModel.addElement("บุฟเฟต์");
        comboBoxModel.addElement("กาแฟ&เบเกอรี่");

//        String[] cateString = {"Categories", "ตามสั่ง", "ภัตตาคาร", "บุฟเฟต์", "กาแฟ เบเกอรี่"};
        comboCate = new JComboBox(comboBoxModel);
        comboCate.setSelectedIndex(0); //ตั้งค่าให้โชว์ตัวไหน
        comboCate.setBounds(113, 76, 107, 20);
        return comboCate;

    }

    private void showTable() {

        table.setModel(new DefaultTableModel());
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addColumn("res_id");
        model.addColumn("username");
        model.addColumn("resName");
        model.addColumn("resType");
        model.addColumn("road");
        model.addColumn("province");
        model.addColumn("resAdd");
        model.addColumn("resTel");
        model.addColumn("resTime");
        Connection cont = null;
        try {
//            ResultSet rs = null;
            String nameS = txtSearch.getText();
            ResultSet rs = Restaurant.findStoreResult(nameS);
//            cont = ConnectionBuilder.getConnection();
//            Statement stm = cont.createStatement();
//            String sql = "SELECT * FROM Restaurant WHERE resName LIKE '%" + txtSearch.getText() + "%'";
//            ResultSet rs = stm.executeQuery(sql);
//            System.out.println("MODEL");
         
            int row = 0;
            if (rs == null) {
                System.out.println("!ResultSet is null");
            }
            while (rs != null && rs.next()) {
                model.addRow(new Object[0]);
                model.setValueAt(rs.getString("res_id"), row, 0);
                model.setValueAt(rs.getString("username"), row, 1);
                model.setValueAt(rs.getString("resName"), row, 2);
                model.setValueAt(rs.getString("resType"), row, 3);
                model.setValueAt(rs.getString("road"), row, 4);
                model.setValueAt(rs.getString("province"), row, 5);
                model.setValueAt(rs.getString("resAdd"), row, 6);
                model.setValueAt(rs.getString("resTel"), row, 7);
                model.setValueAt(rs.getString("resTime"), row, 8);
                row++;
            }

        } catch (SQLException ex) {
            System.out.println("!" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("!!" + ex.getMessage());
        } 

    }

    public static void main(String[] args) {
        Home jfSearch = new Home();
        jfSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jfSearch.setSize(500, 800);
        jfSearch.setLocationRelativeTo(null);
        jfSearch.setVisible(true);
        jfSearch.pack();
    }


}
