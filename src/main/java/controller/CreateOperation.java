package controller;

import model.Database;
import model.Operation;

import java.sql.SQLException;

public class CreateOperation {

    private Operation o;
    private Database database;

    public CreateOperation(Operation o, Database database) {
        this.o = o;
        this.database = database;
    }

    public boolean isCreated() {
        boolean created = false;
        String insert = "INSERT INTO operation (doctor_id, patient_id, date_time, paid, diagnosis) " +
                "VALUES (" + o.getDoctor().getID() + ", " + o.getPatient().getID() + ", '" + o.getDateTime() + "'" +
                ", '" + o.isPaid() + "', '" + o.getDiagnosis() + "')";
        try {
            System.out.println(o.getDateTime());
            database.getStatement().execute(insert);
            created = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return created;
    }
}
