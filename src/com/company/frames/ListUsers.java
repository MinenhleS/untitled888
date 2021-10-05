package com.company.frames;

import com.company.Database;
import com.company.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListUsers extends Container {
    private Database database=new Database();
    private MainFrame frame;
    ArrayList<Users> users;

    private JScrollPane scrollPane;
    private JList list;

    private JButton edit;
    private JButton remove;
    private JButton back;


    public ListUsers(MainFrame frame){
        this.frame=frame;

        users=database.getAllUsers();
        String[] users_str= new String[users.size()];

        for (int i=0;i<users.size();i++){
            users_str[i] = (users.get(i).getId())+"|. "+users.get(i).getName()+" "+users.get(i).getLastname()+"- login: "+users.get(i).getLogin();
        }

        list=new JList(users_str);
        scrollPane = new JScrollPane(list);
        scrollPane.setSize(600,600);
        scrollPane.setLocation(20,20);
        add(scrollPane);



        edit=new JButton("Edit");
        edit.setSize(300,60);
        edit.setLocation(650,200);
        edit.setBackground(Color.white);
        edit.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(edit);

        back=new JButton("Back");
        back.setSize(150,60);
        back.setLocation(650,500);
        back.setBackground(Color.white);
        back.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(back);

        remove=new JButton("Delete");
        remove.setSize(300,60);
        remove.setLocation(650,300);
        remove.setBackground(Color.white);
        remove.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(remove);


        setSize(1000,700);
        setLayout(null);

        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.UpdatePageEdit(getIdString(list.getSelectedValue().toString()));
                frame.openWindow(frame.editUser,frame.listUsers);

            }});

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.openWindow(frame.mainpageAdmin,frame.listUsers);
            }
        });

        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                database.deleteUser(getIdString(list.getSelectedValue().toString()));
            }});
    }

    public int getIdString(String s){

        String[] subStr;
        String delimeter = "|. ";
        subStr = s.split(delimeter);
        int h=Integer.parseInt(subStr[0]);
        return h;
    }
}
