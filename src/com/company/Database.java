package com.company;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private Connection connection;


    public Database(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8080/project22?useUnicode=true&serverTimezone=UTC", "root", "");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Users> getAllUsers(){
        ArrayList<Users> list = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from users");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String login = rs.getString("login");
                String password = rs.getString("password");
                String type = rs.getString("type");

                list.add(new Users( id, name, lastname, login , password, type));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }




    public void addUser(Users user){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users(id, name, lastname, login, password, type) VALUES(NULL, ?, ?, ?, ?, ?)");
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getLogin());
            ps.setString(4,user.getPassword());
            ps.setString(5, user.getType());


            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateUser(Users user){
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE users SET name=?, lastname=?, login=?, password=? WHERE id=?");
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getLogin());
            ps.setString(4,user.getPassword());
            ps.setInt(5,user.getId());

            int rowAffected = ps.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void deleteUser(int id){
        try {
            PreparedStatement statement=connection.prepareStatement("delete from users where id=?");
            statement.setInt(1, id);
            int rows=statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public ArrayList<Institution> getAllInst(){
        ArrayList<Institution> list = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from institution");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String location = rs.getString("location");
                String type = rs.getString("type");

                list.add(new Institution( id, name, location, type));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    public void addInst(Institution institution){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO institution(id, name, location, type) VALUES(NULL, ?, ?, ?)");
            ps.setString(1, institution.getName());
            ps.setString(2, institution.getLocation());
            ps.setString(3, institution.getType());



            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void updateInst(Institution institution){
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE institution SET name=?, location=?, type=?  WHERE id=?");
            ps.setString(1, institution.getName());
            ps.setString(2, institution.getLocation());
            ps.setString(3, institution.getType());
            ps.setInt(4,institution.getID());

            int rowAffected = ps.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteInst(int id){
        try {
            PreparedStatement statement=connection.prepareStatement("delete from institution where id=?");
            statement.setInt(1, id);
            int rows=statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
