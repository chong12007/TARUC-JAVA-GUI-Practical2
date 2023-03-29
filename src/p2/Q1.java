package p2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Q1 extends JFrame {

    private JButton redbtn = new JButton("Red");
    private JButton greenbtn = new JButton("Green");
    private JButton bluebtn = new JButton("Blue");
    private JPanel colorPanel = new JPanel(new FlowLayout());
    private JPanel fontPanel = new JPanel(new FlowLayout());
    private Font fontColor = new Font("SanSerif ", Font.BOLD, 18);
    private JLabel jlabelColor = new JLabel("COLOR");

    public Q1() {
        setLayout(new GridLayout(0, 1));
        //Set JLabel "Color"
        jlabelColor.setFont(fontColor);
        fontPanel.add(jlabelColor);
        add(fontPanel);

        //Method for inner class
        redBtnListner redListner = new redBtnListner();
        greenBtnListner greenListner = new greenBtnListner();
        blueBtnListner blueListner = new blueBtnListner();

        //Add action listner with inner class method
        redbtn.addActionListener(redListner);
        greenbtn.addActionListener(greenListner);
        bluebtn.addActionListener(blueListner);

        //Add 3 button
        colorPanel.add(redbtn);
        colorPanel.add(greenbtn);
        colorPanel.add(bluebtn);

        add(colorPanel);

        setSize(400, 120);
        setTitle("Q5");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //=======================================================
    //Inner class event handler 
    //Press alt + enter auto implement actionPerformed method
    public class redBtnListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            jlabelColor.setForeground(Color.red);
        }

    }

    public class greenBtnListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            jlabelColor.setForeground(Color.green);
        }

    }

    public class blueBtnListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            jlabelColor.setForeground(Color.blue);
        }

    }

}
