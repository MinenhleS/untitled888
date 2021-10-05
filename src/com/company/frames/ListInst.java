package com.company.frames;

import com.company.Database;
import com.company.Institution;
import com.company.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListInst extends Container {
    private Database database=new Database();
    private MainFrame frame;
    ArrayList<Institution> institutions;

    private JScrollPane scrollPane;
    private JList list;

    private JButton edit;
    private JButton remove;
    private JButton back;


    public ListInst(MainFrame frame){
        this.frame=frame;

        institutions=database.getAllInst();
        String[] inst_str= new String[institutions.size()];

        for (int i=0;i<institutions.size();i++){
            inst_str[i] = (institutions.get(i).getID())+"|. "+institutions.get(i).getName()+" "+institutions.get(i).getLocation()+"- login: "+institutions.get(i).getType();
        }

        list=new JList(inst_str);
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
                frame.UpdatePageEditInst(getIdString(list.getSelectedValue().toString()));
                frame.openWindow(frame.editInst,frame.listInst);

            }});

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.openWindow(frame.mainpageAdmin,frame.listInst);
            }
        });

        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                database.deleteInst(getIdString(list.getSelectedValue().toString()));
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
