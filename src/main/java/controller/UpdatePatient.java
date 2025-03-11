package controller;

import model.Database;
import model.Patient;

import java.sql.SQLException;

public class UpdatePatient {

    private final Patient p;
    private final Database database;

    public UpdatePatient(Patient p, Database database) {
        this.p = p;
        this.database = database;
    }

    public boolean isUpdated() {
        boolean updated = false;
        String update = "UPDATE patient SET first_name = '" + p.getFirstName() + "'" +
                ", last_name = '" + p.getLastName() + "'" +
                ", email = '" + p.getEmail() + "'" +
                ", phone_number = '" + p.getPhoneNumber() + "'" +
                ", blood_group = '" + p.getBloodGroup() + "'" +
                " WHERE id = " + p.getID();
        try {
            database.getStatement().execute(update);
            updated = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }
}
