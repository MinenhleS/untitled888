package com.company.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainpageAdmin extends Container {
    private MainFrame frame;
    private JButton add_user;
    private JButton edit_user;
    private JButton add_inst;
    private JButton edit_inst;


    public MainpageAdmin(MainFrame frame){
        this.frame=frame;

        add_user=new JButton("Add user");
        add_user.setSize(200,60);
        add_user.setLocation(200,200);
        add_user.setBackground(Color.white);
        add_user.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(add_user);

        edit_user=new JButton("Edit User");
        edit_user.setSize(200,60);
        edit_user.setLocation(410,200);
        edit_user.setBackground(Color.white);
        edit_user.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(edit_user);


        add_inst=new JButton("Add Inst");
        add_inst.setSize(200,60);
        add_inst.setLocation(200,300);
        add_inst.setBackground(Color.white);
        add_inst.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(add_inst);


        edit_inst=new JButton("Edit Inst");
        edit_inst.setSize(200,60);
        edit_inst.setLocation(410,300);
        edit_inst.setBackground(Color.white);
        edit_inst.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(edit_inst);



        setSize(1000,700);
        setLayout(null);


        add_user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.openWindow(frame.addUser,frame.mainpageAdmin);
            }});

        edit_user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.openWindow(frame.listUsers,frame.mainpageAdmin);
            }});

        add_inst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.openWindow(frame.addInst,frame.mainpageAdmin);
            }});

        edit_inst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.openWindow(frame.listInst,frame.mainpageAdmin);
            }
        });
    }
}
