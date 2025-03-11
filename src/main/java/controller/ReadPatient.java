package controller;

import model.Database;
import model.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadPatient {

    private Patient p;
    public ReadPatient(int id, Database database) {
        String select = "SELECT * FROM patient WHERE id = " + id;

        try (ResultSet rs = database.getStatement().executeQuery(select)) {

            rs.next();
            p = new Patient();
            p.setID(rs.getInt("id"));
            p.setFirstName(rs.getString("first_name"));
            p.setLastName(rs.getString("last_name"));
            p.setEmail(rs.getString("email"));
            p.setPhoneNumber(rs.getString("phone_number"));
            p.setPassword(rs.getString("password"));
            p.setBloodGroup(rs.getString("blood_group"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Patient getPatient() {
        return p;
    }
}
