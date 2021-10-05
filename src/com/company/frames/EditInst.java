package com.company.frames;

import com.company.Database;
import com.company.Institution;
import com.company.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditInst extends Container {
    private int id_inst;

    private Database database=new Database();
    private ArrayList<Institution> institutions;
    private MainFrame frame;
    Institution institution;


    private JButton edit;
    private JButton back;

    private JTextField name;
    private JTextField location;
    private JTextField type;

    private JLabel l_name;
    private JLabel l_location;
    private JLabel l_type;


    public EditInst(MainFrame frame,int i){
        this.frame=frame;

        institutions=database.getAllInst();
        id_inst=i;
        for (int w=0; w<institutions.size();w++){
            if (institutions.get(w).getID()==id_inst){
                institution=institutions.get(w);
            }
        }




        l_name=new JLabel("Name");
        l_name.setSize(200,60);
        l_name.setLocation(150,160);
        l_name.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(l_name);

        name=new JTextField(institution.getName());
        name.setSize(200,60);
        name.setLocation(350,160);
        name.setFont(new Font("SansSerif", Font.ITALIC, 20));
        add(name);

        l_location=new JLabel("Location");
        l_location.setSize(200,60);
        l_location.setLocation(150,220);
        l_location.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(l_location);

        location=new JTextField(institution.getLocation());
        location.setSize(200,60);
        location.setLocation(350,220);
        location.setFont(new Font("SansSerif", Font.ITALIC, 20));
        add(location);

        l_type=new JLabel("Type");
        l_type.setSize(200,60);
        l_type.setLocation(150,300);
        l_type.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(l_type);

        type=new JTextField(institution.getType());
        type.setSize(200,60);
        type.setLocation(350,300);
        type.setFont(new Font("SansSerif", Font.ITALIC, 20));
        add(type);



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
                frame.openWindow(frame.listInst,frame.editInst);
            }});

        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Institution institution7=new Institution(id_inst,name.getText(),location.getText(),type.getText());
                database.updateInst(institution7);
            }});

    }
}
