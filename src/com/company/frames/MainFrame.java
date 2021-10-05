package com.company.frames;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    protected SignIn signIn;
    protected MainpageAdmin mainpageAdmin;
    protected AddUser addUser;
    protected ListUsers listUsers;
    protected EditUser editUser;
    protected AddInst addInst;
    protected ListInst listInst;
    protected EditInst editInst;

    public MainFrame(){
        signIn=new SignIn(this);
        add(signIn);
        signIn.setVisible(true);

        mainpageAdmin=new MainpageAdmin(this);
        add(mainpageAdmin);
        mainpageAdmin.setVisible(false);

        addUser=new AddUser(this);
        add(addUser);
        addUser.setVisible(false);

        listUsers=new ListUsers(this);
        add(listUsers);
        listUsers.setVisible(false);

        addInst=new AddInst(this);
        add(addInst);
        addInst.setVisible(false);

        listInst=new ListInst(this);
        add(listInst);
        listInst.setVisible(false);



//        editUser=new EditUser(this);
//        add(editUser);
//        editUser.setVisible(false);

        setSize(1019,729);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void openWindow(Container a, Container b) {
        b.setVisible(false);
        a.setVisible(true);
    }

    public void UpdatePageEdit(int i){
        editUser=new EditUser(this,i);
        add(editUser);
        editUser.setVisible(false);
    }

    public void UpdatePageEditInst(int i){
        editInst=new EditInst(this,i);
        add(editInst);
        editInst.setVisible(false);
    }


}
