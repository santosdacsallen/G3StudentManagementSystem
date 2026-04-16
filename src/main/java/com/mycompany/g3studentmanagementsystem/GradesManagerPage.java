package com.mycompany.g3studentmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class GradesManagerPage extends JFrame implements ActionListener {

    private JLabel lblIcon, lblTitle;
    private JButton btnAttendance, btnStudents, btnGrades, btnSignOut;
    private JButton btnSearch, btnEdit;
    private JTextField txtSearchId;
    private JTable tblMath, tblScience, tblEnglish;
    private JTabbedPane tabbedPane;

    GradesManagerPage() {

        // Frame Settings
        setTitle("FACULTY PORTAL - Grades Manager");
        setSize(1024, 764);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(235, 242, 250));

        // Logo
        lblIcon = new JLabel("🎓");
        lblIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 48));
        lblIcon.setBounds(10, 10, 60, 60);
        add(lblIcon);

        // Title
        lblTitle = new JLabel("FACULTY PORTAL");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setBounds(80, 20, 200, 40);
        add(lblTitle);

        // Top Buttons
        btnAttendance = new JButton("ATTENDANCE");
        btnAttendance.setBounds(300, 20, 120, 40);
        btnAttendance.setBackground(new Color(52, 168, 235));
        btnAttendance.setForeground(Color.WHITE);
        add(btnAttendance);

        btnStudents = new JButton("STUDENTS");
        btnStudents.setBounds(430, 20, 120, 40);
        btnStudents.setBackground(new Color(52, 168, 235));
        btnStudents.setForeground(Color.WHITE);
        add(btnStudents);

        btnGrades = new JButton("GRADES");
        btnGrades.setEnabled(false);
        btnGrades.setBounds(560, 20, 120, 40);
        btnGrades.setBackground(new Color(52, 168, 235));
        btnGrades.setForeground(Color.WHITE);
        add(btnGrades);

        btnSignOut = new JButton("Sign Out");
        btnSignOut.setBounds(850, 20, 120, 40);
        btnSignOut.setBackground(new Color(224, 69, 52));
        btnSignOut.setForeground(Color.WHITE);
        add(btnSignOut);

        // Search Field
        txtSearchId = new JTextField();
        txtSearchId.setBounds(20, 100, 140, 35);
        add(txtSearchId);

        btnSearch = new JButton("SEARCH STUDENT");
        btnSearch.setBounds(20, 140, 140, 40);
        btnSearch.setBackground(new Color(52, 168, 235));
        btnSearch.setForeground(Color.WHITE);
        add(btnSearch);

        btnEdit = new JButton("EDIT GRADES");
        btnEdit.setBounds(20, 200, 140, 40);
        btnEdit.setBackground(new Color(52, 168, 235));
        btnEdit.setForeground(Color.WHITE);
        add(btnEdit);

		
		
        // Table
        String[] columns = {
            "STUDENT ID",
            "NAME",
            "SECTION",
            "UNITS",
            "FINAL GRADE",
            "GRADE STATUS"
        };

        Object[][] data = new Object[0][6];

        tblMath = new JTable(new DefaultTableModel(data, columns));
        JScrollPane mathScroll = new JScrollPane(tblMath);

        tblScience = new JTable(new DefaultTableModel(data, columns));
        JScrollPane scienceScroll = new JScrollPane(tblScience);

        tblEnglish = new JTable(new DefaultTableModel(data, columns));
        JScrollPane englishScroll = new JScrollPane(tblEnglish);

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("MATH", mathScroll);
        tabbedPane.addTab("SCIENCE", scienceScroll);
        tabbedPane.addTab("ENGLISH", englishScroll);

        tabbedPane.setBounds(200, 100, 780, 550);
        add(tabbedPane);

        btnAttendance.addActionListener(this);
        btnEdit.addActionListener(this);
        btnSearch.addActionListener(this);
        btnSignOut.addActionListener(this);
        btnStudents.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAttendance) {
            AttendanceMathPage amp = new AttendanceMathPage();
            FrameSizeNavigation.navigate(this, amp);

        } else if (e.getSource() == btnEdit) {
            GradesEditorPage gep = new GradesEditorPage();
            gep.setVisible(true);

        } else if (e.getSource() == btnSignOut) {
            LandingPageGUI lp = new LandingPageGUI();
            FrameSizeNavigation.navigate(this, lp);

        } else if (e.getSource() == btnStudents) {
            StudentManagerPage smp = new StudentManagerPage();
            FrameSizeNavigation.navigate(this, smp);
//      } else if (e.getSource() == btnSearch) {
//          EditStudentPage esp = new EditStudentPage();
//          esp.setVisible(true);        still working on search buttons
		}
    }
}
