package com.company.frames;

import com.company.Database;
import com.company.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditUser extends Container {
    private int id_user;

    private Database database=new Database();
    private ArrayList<Users> users;
    private MainFrame frame;
    Users user;


    private JButton edit;
    private JButton back;

    private JTextField name;
    private JTextField lastname;
    private JTextField login;
    private JTextField password;

    private JLabel l_name;
    private JLabel l_lastname;
    private JLabel l_login;
    private JLabel l_password;

//    public void getId_user(int i){
//        id_user=i;
//        System.out.println(id_user);
//    }

    public EditUser(MainFrame frame,int i){
        this.frame=frame;

        users=database.getAllUsers();
        id_user=i;
        for (int w=0; w<users.size();w++){
            if (users.get(w).getId()==id_user){
                user=users.get(w);
            }
        }




        l_name=new JLabel("Name");
        l_name.setSize(200,60);
        l_name.setLocation(150,160);
        l_name.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(l_name);

        name=new JTextField(user.getName());
        name.setSize(200,60);
        name.setLocation(350,160);
        name.setFont(new Font("SansSerif", Font.ITALIC, 20));
        add(name);

        l_lastname=new JLabel("Lastname");
        l_lastname.setSize(200,60);
        l_lastname.setLocation(150,220);
        l_lastname.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(l_lastname);

        lastname=new JTextField(user.getLastname());
        lastname.setSize(200,60);
        lastname.setLocation(350,220);
        lastname.setFont(new Font("SansSerif", Font.ITALIC, 20));
        add(lastname);

        l_login=new JLabel("Login");
        l_login.setSize(200,60);
        l_login.setLocation(150,300);
        l_login.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(l_login);

        login=new JTextField(user.getLogin());
        login.setSize(200,60);
        login.setLocation(350,300);
        login.setFont(new Font("SansSerif", Font.ITALIC, 20));
        add(login);

        l_password=new JLabel("Password");
        l_password.setSize(200,60);
        l_password.setLocation(150,360);
        l_password.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(l_password);

        password=new JTextField(user.getPassword());
        password.setSize(200,60);
        password.setLocation(350,360);
        password.setFont(new Font("SansSerif", Font.ITALIC, 20));
        add(password);

        edit=new JButton("Edit");
        edit.setSize(100,60);
        edit.setLocation(550,500);
        edit.setBackground(Color.white);
        edit.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(edit);

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
                frame.openWindow(frame.listUsers,frame.editUser);
            }});

        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Users user2=new Users(id_user,name.getText(),lastname.getText(),login.getText(),password.getText(),user.getType());
                database.updateUser(user2);
            }});

    }

}
