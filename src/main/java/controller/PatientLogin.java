package controller;

import model.Database;
import model.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientLogin {

    private String email, password;
    private Database database;
    private Patient patient;

    public PatientLogin(String email, String password, Database database) {
        this.email = email;
        this.password = password;
        this.database = database;
    }

    public boolean isLoggedIn(){
        String select = "SELECT * FROM patient WHERE email = '" + email + "' AND password = '" + password + "'";
        boolean loggedIn = false;
        try(ResultSet rs = database.getStatement().executeQuery(select)){
            loggedIn = rs.next();
            if(loggedIn){
                patient = new Patient();
                patient.setID(rs.getInt("id"));
                patient.setFirstName(rs.getString("first_name"));
                patient.setLastName(rs.getString("last_name"));
                patient.setEmail(rs.getString("email"));
                patient.setPassword(rs.getString("password"));
                patient.setPhoneNumber(rs.getString("phone_number"));
                patient.setBloodGroup(rs.getString("blood_group"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return loggedIn;
    }

    public Patient getPatient(){
        return patient;
    }
}
