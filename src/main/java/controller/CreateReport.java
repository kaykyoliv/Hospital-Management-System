package controller;

import model.Database;
import model.Report;

import java.sql.SQLException;

public class CreateReport {

    private final Report report;
    private final Database database;

    public CreateReport(Report report, Database database) {
        this.report = report;
        this.database = database;
    }

    public boolean isCreated() {
        boolean created = false;
        String insert = "INSERT INTO report (doctor_id, patient_id, date_time, paid, diagnosis, treatment) " +
                "VALUES (" + report.getDoctor().getID() + ", " + report.getPatient().getID() + ", '" + report.getDateTime() + "'" +
                ", '" + report.isPaid() + "', '" + report.getDiagnosis() + "', '" + report.getTreatment() + "')";
        try {
            database.getStatement().execute(insert);
            created = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return created;
    }
}
