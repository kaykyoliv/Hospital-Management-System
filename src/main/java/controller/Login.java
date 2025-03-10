package controller;

import model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {

    private String email;
    private String password;
    private Database database;
    private User u;

    public Login(String email, String password, Database database) {
        this.email = email;
        this.password = password;
        this.database = database;
    }

    public boolean isLoggedIn(){
        boolean loggedIn = false;
        String select = "SELECT * FROM employee WHERE email = '" + email + "' AND password = '" + password + "'";
        try(ResultSet rs = database.getStatement().executeQuery(select)){
            loggedIn = rs.next();
            if(loggedIn){
                int job = rs.getInt("job");
                switch (job) {
                    case 0:
                        u = new Doctor();
                        ((Doctor) u).setSpecialization(rs.getString("specialization"));
                        break;
                    case 1:
                        u = new Cashier();
                        break;
                    case 2:
                        u = new Receptionist();
                        break;
                    default:
                        u = new User() {
                            @Override
                            public void showList(Scanner sc, Database database) {
                                System.out.println("Unknown job");
                            }
                        };
                }
                u.setID(rs.getInt("id"));
                u.setFirstName(rs.getString("first_name"));
                u.setLastName(rs.getString("last_name"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setPhoneNumber(rs.getString("phone_number"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return loggedIn;
    }

    public User getUser(){
        return u;
    }
}
