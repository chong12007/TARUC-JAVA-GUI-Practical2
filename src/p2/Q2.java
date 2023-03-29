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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Q2 extends JFrame {

    private JButton redbtn = new JButton("Red");
    private JButton greenbtn = new JButton("Green");
    private JButton bluebtn = new JButton("Blue");
    private JPanel colorPanel = new JPanel(new FlowLayout());
    private JPanel fontPanel = new JPanel(new FlowLayout());
    private Font fontColor = new Font("SanSerif ", Font.BOLD, 18);
    private JLabel jlabelColor = new JLabel("COLOR");

    public Q2() {
        setLayout(new GridLayout(0, 1));
        //Set JLabel "Color"
        jlabelColor.setFont(fontColor);
        fontPanel.add(jlabelColor);
        add(fontPanel);

        //Method for inner class
        ButtonListner btnListner = new ButtonListner();

        //Add action listner with inner class method
        redbtn.addActionListener(btnListner);
        greenbtn.addActionListener(btnListner);
        bluebtn.addActionListener(btnListner);

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
    //Using only one inner class process 3 button
    public class ButtonListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //get e.getSource
            if (e.getSource() == redbtn)
                jlabelColor.setForeground(Color.red);
            else if (e.getSource() == greenbtn)
                jlabelColor.setForeground(Color.green);
            else if (e.getSource() == bluebtn)
                jlabelColor.setForeground(Color.blue);
            else
                JOptionPane.showMessageDialog(null, "Invalid selection");
        }

    }

}
