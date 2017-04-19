package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import project_review.Review;

public class ReviewGUI extends JFrame implements ActionListener {

    public ReviewGUI() {
        setTitle("Review");
        
        JPanel p0 = new JPanel(new GridLayout(3, 1));
        lblReviewId = new JLabel("Review ID");
        txtReviewId = new JTextField();
        lblUsername = new JLabel("Username");;
        txtUsername = new JTextField();
        lblResId = new JLabel("Restaurant ID");;
        txtResId = new JTextField();
//        lblReviewId.setHorizontalAlignment(SwingConstants.LEFT);
//        lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
        p0.add(lblReviewId);
        p0.add(txtReviewId);
        p0.add(lblUsername);
        p0.add(txtUsername);
        p0.add(lblResId);
        p0.add(txtResId);
        lblResName = new JLabel("ชื่อร้านอาหาร");

        //P2-----Topic       
        lblTopic = new JLabel("หัวข้อรีวิว");
        txtFldTopic = new JTextField(20);
        JPanel p2 = new JPanel();
        lblTopic.setHorizontalAlignment(SwingConstants.LEFT);
        txtFldTopic.setHorizontalAlignment(SwingConstants.LEFT);

        p2.add(lblTopic);
        p2.add(txtFldTopic);

        //P3-----Score
//        JPanel p3 = new JPanel();
        lblScoreTaste = new JLabel("รสชาติ(0-5)");
        lblScoreClean = new JLabel("ความสะอาด(0-5)");
        lblScoreService = new JLabel("การบริการ(0-5)");
        lblScoreLook = new JLabel("บรรยากาศ(0-5)");
        lblScoreWorth = new JLabel("ความคุ้มค่า(0-5)");
        String[] num = {"0", "1", "2", "3", "4", "5"};
        comboScore1 = new JComboBox(num);
        comboScore2 = new JComboBox(num);
        comboScore3 = new JComboBox(num);
        comboScore4 = new JComboBox(num);
        comboScore5 = new JComboBox(num);
        JPanel p3 = new JPanel(new GridLayout(5, 2));
        p3.add(lblScoreTaste);
        p3.add(comboScore1);
        p3.add(lblScoreClean);
        p3.add(comboScore2);
        p3.add(lblScoreService);
        p3.add(comboScore3);
        p3.add(lblScoreLook);
        p3.add(comboScore4);
        p3.add(lblScoreWorth);
        p3.add(comboScore5);
        //P4-----CONTENT
        lblContent = new JLabel("เขียนรีวิวที่นี่");
        txtFldContent = new JTextField(20);
        btnOK = new JButton("OK");
        JPanel p4 = new JPanel();
        lblContent.setHorizontalAlignment(SwingConstants.LEFT);
        txtFldContent.setHorizontalAlignment(SwingConstants.LEFT);
//        JPanel p41 = new JPanel();
        p4.add(lblContent);
        p4.add(txtFldContent);
//        btnOK.setHorizontalAlignment(SwingConstants.CENTER);
//        p4.add(p41);
//        p4.add(btnOK);
        JPanel p5 = new JPanel();
        p5.add(btnOK);

        add(p0, BorderLayout.NORTH);
        add(p2, BorderLayout.NORTH);
        add(p3, BorderLayout.CENTER);
        add(p4);
        add(p5, BorderLayout.SOUTH);
        setLayout(new FlowLayout());
//        add(btnOK, BorderLayout.SOUTH);
        btnOK.addActionListener(this);

    }

    public static void main(String[] args) {
        ReviewGUI frReview = new ReviewGUI();
        frReview.setSize(400, 340);
        frReview.setLocationRelativeTo(null);
        frReview.setVisible(true);
        frReview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnOK) {
            System.out.println("Selected OK");
//            reviewRes(int reId, String user, int resId, String top, String content, 
//            int taste, int clean, int service, int look, int worth)
            int reId = Integer.parseInt(txtReviewId.getText()); //Integer.parseInt("1234");
            String username = txtUsername.getText();
            int resId = Integer.parseInt(txtResId.getText());
            String topic = txtFldTopic.getText();
            String content = txtFldContent.getText();
            int taste = Integer.parseInt(comboScore1.getSelectedItem().toString());
            int clean = Integer.parseInt(comboScore2.getSelectedItem().toString());
            int service = Integer.parseInt(comboScore3.getSelectedItem().toString());
            int look = Integer.parseInt(comboScore4.getSelectedItem().toString());
            int worth = Integer.parseInt(comboScore5.getSelectedItem().toString());
            System.out.println(reId);
            try {
                ArrayList<Review> rev = Review.reviewRes(reId,username,resId,topic,content,taste,clean,service,look,worth);
            } catch (SQLException ex) {
                System.out.println("!");
            } catch (ClassNotFoundException ex) {
                System.out.println("!!");
            }

        }
    }
    private JLabel lblReviewId;
    private JTextField txtReviewId;
    private JLabel lblUsername;
    private JTextField txtUsername;
    private JLabel lblResId;
    private JTextField txtResId;
    private JLabel lblResName;
    private JButton btnOK;
    private JLabel lblTopic;
    private JTextField txtFldTopic;
    private JLabel lblScoreTaste;
    private JLabel lblScoreClean;
    private JLabel lblScoreService;
    private JLabel lblScoreLook;
    private JLabel lblScoreWorth;
    private JComboBox comboScore1;
    private JComboBox comboScore2;
    private JComboBox comboScore3;
    private JComboBox comboScore4;
    private JComboBox comboScore5;
    private JLabel lblContent;
    private JTextField txtFldContent;
}
