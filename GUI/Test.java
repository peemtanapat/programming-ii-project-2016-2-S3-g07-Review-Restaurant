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

public class Test extends JFrame {

    private JFrame jfSearch;
    private JLabel lblSearch;
    private JTextField txtSearch;
    private JButton btnSearch;
    private JTable table;
    private JScrollPane scrollPane;

    public Test() {
        lblSearch = new JLabel("Find: ");
        txtSearch = new JTextField();
        btnSearch = new JButton("Search");
        JButton btnSearch2 = new JButton("Search");
        table = new JTable();
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        JPanel jp1 = new JPanel(new GridLayout(1, 1));
        jp1.add(lblSearch);
        jp1.add(txtSearch);
        jp1.add(btnSearch);
        JPanel jp2 = new JPanel();
        jp2.add(scrollPane);
        JPanel jp3 = new JPanel();
        jp3.add(btnSearch2);
        add(jp1,BorderLayout.WEST);
        add(jp2,BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        Test jfSearch = new Test();
        jfSearch.setLocationRelativeTo(null);
        jfSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfSearch.setSize(500, 500);
        jfSearch.setVisible(true);
        jfSearch.pack();
    }
}
