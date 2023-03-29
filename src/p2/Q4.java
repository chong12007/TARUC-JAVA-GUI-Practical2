package p2;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.JOptionPane.YES_NO_OPTION;

public class Q4 extends JFrame {

    private JButton btnCreate = new JButton("Create");
    private JButton btnRetrieve = new JButton("Retrieve");
    private JButton btnUpdate = new JButton("Update");
    private JButton btnDelete = new JButton("Delete");
    private JButton btnShowAll = new JButton("Show all");
    String studentName;
    private JTextField JTstudent = new JTextField();

    private ArrayList<String> studentList = new ArrayList<String>();

    public Q4() {

        setLayout(new FlowLayout());

        BtnListner btnListner = new BtnListner();
        //add button action lisner
        btnCreate.addActionListener(btnListner);
        btnRetrieve.addActionListener(btnListner);
        btnUpdate.addActionListener(btnListner);
        btnDelete.addActionListener(btnListner);
        btnShowAll.addActionListener(btnListner);

        //Add button
        add(btnCreate);
        add(btnRetrieve);
        add(btnUpdate);
        add(btnDelete);
        add(btnShowAll);

        setSize(400, 110);
        setTitle("");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //Check studentlist array
    public boolean checkExist(String studentName) {
        String studentListName;

        for (int i = 0; i < studentList.size(); i++) {

            studentListName = studentList.get(i);

            if (studentName.equalsIgnoreCase(studentListName))

                return true;

        }
        //no match return false
        return false;
    }

    public int getStudentInArray(String studentName) {
        String studentListName;

        for (int i = 0; i < studentList.size(); i++) {

            studentListName = studentList.get(i);

            if (studentName.equalsIgnoreCase(studentListName))

                return i;

        }
        //no match return false
        return 0;
    }

    //Add student if studentlist dont have same student 
    public void addStudent(String studentName) {
        boolean sameStudent = checkExist(studentName);
        if (!sameStudent) {
            studentList.add(studentName);
            JOptionPane.showMessageDialog(null, "Student " + studentName + " successfully added in Student List !!");
        } else
            JOptionPane.showMessageDialog(null, "Student already Exist");

    }

    //Find if student entered available in studentlist
    public boolean retrieveStudent(String studentName) {
        boolean sameStudent = checkExist(studentName);
        if (sameStudent) {
            JOptionPane.showMessageDialog(null, "Student " + studentName + " found !!");
            return true;

        } else
            JOptionPane.showMessageDialog(null, "Student not found !!");

        return false;
    }

    //Find student if available prompt for user to update the name
    public void updateStudent(String studentName) {
        boolean sameStudent = checkExist(studentName);
        int oldStudentNum = 0;
        String newStudentName = null;
        if (sameStudent) {

            //Enter new student name
            newStudentName = JOptionPane.showInputDialog(null, "Please Enter the new name for " + studentName + " :");

            //Check do the new name exitst in student list
            boolean newNameSameStudent = checkExist(newStudentName);

            //if new student name already exist in studentlist
            if (newNameSameStudent)
                JOptionPane.showMessageDialog(null, "Student " + newStudentName + " already exist!");
            else {
                //Get the oldStudent array number in studentlist to update
                oldStudentNum = getStudentInArray(studentName);
                studentList.set(oldStudentNum, newStudentName);
                JOptionPane.showMessageDialog(null, "Student Name " + studentName + " updated to " + newStudentName + "!!");
            }

            // if entered student not found display not found
        } else
            JOptionPane.showMessageDialog(null, "Student not found !!");
    }

    public void deleteStudent(String studentName) {
        boolean sameStudent = checkExist(studentName);
        int studentInArray;
        int deleteChoice;
        boolean confirmDelete;

        if (sameStudent) {
            deleteChoice = JOptionPane.showConfirmDialog(null, "Do you sure you wanted to delete student " + studentName + "?", "Delete Warning", JOptionPane.YES_NO_OPTION);
            //Convert int to boolean
            confirmDelete = (deleteChoice == JOptionPane.YES_NO_OPTION);
            if (confirmDelete) {
                //Get student num in array
                studentInArray = getStudentInArray(studentName);
                studentList.remove(studentInArray);
                JOptionPane.showMessageDialog(null, "Student " + studentName + "successfully deleted");

            }

        } else
            JOptionPane.showMessageDialog(null, "Student not found !!");

    }

//    public void showAllStudent(ArrayList<String> studentList) {
//        String studentListName;
//        for (int i = 0; i < studentList.size(); i++) {
//
//            studentListName = studentList.get(i);
//            JTstudent.add(new JLabel("hello"));
//
//        }
//
//    }
    public class BtnListner implements ActionListener {

        boolean result;

        @Override
        public void actionPerformed(ActionEvent e) {
            studentName = JOptionPane.showInputDialog(null, "Please Enter Student Name : ");

            if (e.getSource() == btnCreate)
                //addStudent method
                addStudent(studentName);
            else if (e.getSource() == btnRetrieve)

                retrieveStudent(studentName);
            else if (e.getSource() == btnUpdate)
                updateStudent(studentName);
            else if (e.getSource() == btnDelete)
                deleteStudent(studentName);
            else
                System.out.println("error");

        }

    }

}//end file
