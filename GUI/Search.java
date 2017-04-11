package GUI;


import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.*;
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

public class Search extends JFrame implements ActionListener {   //อย่าลืม extends JFrame

    private JFrame jfSearch;
    private JLabel lblSearch;
    private JTextField txtSearch;
    private JButton btnSearch;
    private JTable table;
    private JScrollPane scrollPane;
    public Search() {
//          jfSearch = new JFrame("Search Restaurants");
        
        setTitle("Search Restaurants");
//        getContentPane().setLayout(null);
        
        scrollPane = new JScrollPane();
//        scrollPane.setBounds(65, 72, 440, 89);
        table = new JTable();        
        scrollPane.setViewportView(table);
        
        lblSearch = new JLabel("Find: ");
//        lblSearch.setBounds(101, 27, 84, 14);
        getContentPane().add(lblSearch);
        txtSearch = new JTextField();
//        txtSearch.setBounds(195, 24, 160, 20);
//        txtSearch.setColumns(10);
        getContentPane().add(txtSearch);
        btnSearch = new JButton("Search");
        getContentPane().add(btnSearch);
//        btnSearch.setBounds(365, 23, 79, 23);
        
               
        JPanel jp1 = new JPanel(new GridLayout(1, 1));
        jp1.add(lblSearch);
        jp1.add(txtSearch);
        jp1.add(btnSearch);
        JPanel jp2 = new JPanel();
        jp2.add(scrollPane);
        add(jp1,BorderLayout.WEST);
        add(jp2,BorderLayout.SOUTH);

        showTable();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            showTable();
        }
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
            cont = ConnectionBuilder.getConnection();
            Statement stm = cont.createStatement();
            String sql = "SELECT * FROM Restaurant WHERE resName LIKE '%" + txtSearch.getText() + "%'";
            ResultSet rs = stm.executeQuery(sql);
            int row = 0;
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
        } finally {
            try {
                cont.close();
            } catch (SQLException ex) {
                System.out.println("!!!" + ex.getMessage());
            }
        }

    }

    public static void main(String[] args) {
        Search jfSearch = new Search();
        jfSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfSearch.setSize(500, 800);
        jfSearch.setLocationRelativeTo(null);
        jfSearch.setVisible(true);
        jfSearch.pack();
    }

}
