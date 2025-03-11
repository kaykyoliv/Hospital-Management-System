package controller;

import model.Database;
import model.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadPatients {

    private final ArrayList<Patient> patients = new ArrayList<>();

    public ReadPatients(Database database) {
        String select = "SELECT * FROM patient";

        try (ResultSet rs = database.getStatement().executeQuery(select)) {
            while (rs.next()) {
                Patient p = new Patient();
                p.setID(rs.getInt("id"));
                p.setFirstName(rs.getString("first_name"));
                p.setLastName(rs.getString("last_name"));
                p.setEmail(rs.getString("email"));
                p.setPhoneNumber(rs.getString("phone_number"));
                p.setPassword(rs.getString("password"));
                p.setBloodGroup(rs.getString("blood_group"));
                patients.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }
}
