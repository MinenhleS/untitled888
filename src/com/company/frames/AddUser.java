package com.company.frames;

import com.company.Database;
import com.company.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUser extends Container {
    private Database database=new Database();
    private Users users;
    private MainFrame frame;

    private JButton add;
    private JButton back;

    private JTextField name;
    private JTextField lastname;
    private JTextField login;
    private JTextField password;

    private JLabel l_name;
    private JLabel l_lastname;
    private JLabel l_login;
    private JLabel l_password;


    public AddUser(MainFrame frame){
        this.frame=frame;

        l_name=new JLabel("Name");
        l_name.setSize(200,60);
        l_name.setLocation(150,160);
        l_name.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(l_name);

        name=new JTextField("");
        name.setSize(200,60);
        name.setLocation(350,160);
        name.setFont(new Font("SansSerif", Font.ITALIC, 20));
        add(name);

        l_lastname=new JLabel("Lastname");
        l_lastname.setSize(200,60);
        l_lastname.setLocation(150,220);
        l_lastname.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(l_lastname);

        lastname=new JTextField("");
        lastname.setSize(200,60);
        lastname.setLocation(350,220);
        lastname.setFont(new Font("SansSerif", Font.ITALIC, 20));
        add(lastname);

        l_login=new JLabel("Login");
        l_login.setSize(200,60);
        l_login.setLocation(150,300);
        l_login.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(l_login);

        login=new JTextField("");
        login.setSize(200,60);
        login.setLocation(350,300);
        login.setFont(new Font("SansSerif", Font.ITALIC, 20));
        add(login);

        l_password=new JLabel("Password");
        l_password.setSize(200,60);
        l_password.setLocation(150,360);
        l_password.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(l_password);

        password=new JTextField("");
        password.setSize(200,60);
        password.setLocation(350,360);
        password.setFont(new Font("SansSerif", Font.ITALIC, 20));
        add(password);

        add=new JButton("Add");
        add.setSize(100,60);
        add.setLocation(550,500);
        add.setBackground(Color.white);
        add.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(add);

        back=new JButton("Back");
        back.setSize(150,60);
        back.setLocation(100,500);
        back.setBackground(Color.white);
        back.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(back);

        setSize(1000,700);
        setLayout(null);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.openWindow(frame.mainpageAdmin,frame.addUser);
            }});

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                users=new Users(666,name.getText(),lastname.getText(),login.getText(),password.getText(),"client");
                database.addUser(users);
                name.setText("");
                lastname.setText("");
                login.setText("");
                password.setText("");
            }});
    }
}
