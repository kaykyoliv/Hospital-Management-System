package controller;

import model.Database;
import model.Patient;

import java.sql.SQLException;

public class CreatePatient {

    private final Patient patient;
    private final Database database;

    public CreatePatient(Patient patient, Database database) {
        this.patient = patient;
        this.database = database;
    }

    public boolean isCreated(){
        boolean created = false;
        String insert = "INSERT INTO patient (first_name, last_name, email, phone_number, password, blood_group) " +
                "VALUES ('" + patient.getFirstName() + "', '" + patient.getLastName() + "', '" +
                patient.getEmail() + "', '" + patient.getPhoneNumber() + "', '" +
                patient.getPassword() + "', '" + patient.getBloodGroup() + "')";
        try{
            database.getStatement().execute(insert);
            created = true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return created;
    }
}
