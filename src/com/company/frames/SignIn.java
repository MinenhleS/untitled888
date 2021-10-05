package com.company.frames;

import com.company.Database;
import com.company.Users;
import com.company.frames.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SignIn  extends Container {
    private Database database=new Database();
    ArrayList<Users> users;
    private MainFrame frame;
    private JTextField login;
    private JTextField password;
    private JLabel login_t;
    private JLabel pass_t;
    private JButton go;



    public SignIn(MainFrame frame){
        this.frame=frame;


        login_t=new JLabel("Login");
        login_t.setSize(100,60);
        login_t.setLocation(350,140);
        login_t.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(login_t);

        login=new JTextField("login");
        login.setSize(200,60);
        login.setLocation(350,200);
        login.setFont(new Font("SansSerif", Font.ITALIC, 20));
        add(login);


        pass_t=new JLabel("Password");
        pass_t.setSize(200,60);
        pass_t.setLocation(350,260);
        pass_t.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(pass_t);

        password=new JTextField("password");
        password.setSize(200,60);
        password.setLocation(350,320);
        password.setFont(new Font("SansSerif", Font.ITALIC, 20));
        add(password);

        go=new JButton("GO");
        go.setSize(100,60);
        go.setLocation(450,400);
        go.setBackground(Color.white);
        go.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(go);


        setSize(1000,700);
        setLayout(null);





        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String loginText=login.getText();
                String passwordText=password.getText();
                boolean sign_key=false;

                users=database.getAllUsers();
                for (int i=0; i<users.size();i++){
                    if (users.get(i).getLogin().equals(loginText)){
                        if (users.get(i).getPassword().equals(passwordText)){
                            sign_key=true;
                            break;
                        }
                    }
                }


                if (sign_key==true){
                    frame.openWindow(frame.mainpageAdmin, frame.signIn);
                }

            }});


        }



}
