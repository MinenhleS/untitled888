package com.company.frames;

import com.company.Database;
import com.company.Institution;
import com.company.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddInst extends Container {
    private Database database=new Database();
    private Institution institution;
    private MainFrame frame;

    private JButton add;
    private JButton back;

    private JTextField name;
    private JTextField location;
    private JTextField type;

    private JLabel l_name;
    private JLabel l_location;
    private JLabel l_type;


    public AddInst(MainFrame frame){
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

        l_location=new JLabel("Location");
        l_location.setSize(200,60);
        l_location.setLocation(150,220);
        l_location.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(l_location);

        location=new JTextField("");
        location.setSize(200,60);
        location.setLocation(350,220);
        location.setFont(new Font("SansSerif", Font.ITALIC, 20));
        add(location);

        l_type=new JLabel("Type");
        l_type.setSize(200,60);
        l_type.setLocation(150,300);
        l_type.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(l_type);

        type=new JTextField("");
        type.setSize(200,60);
        type.setLocation(350,300);
        type.setFont(new Font("SansSerif", Font.ITALIC, 20));
        add(type);


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
                frame.openWindow(frame.mainpageAdmin,frame.addInst);
            }});

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                institution=new Institution(666,name.getText(),location.getText(),type.getText());
                database.addInst(institution);
                name.setText("");
                location.setText("");
                type.setText("");
            }});
    }
}
