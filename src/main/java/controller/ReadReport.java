package controller;

import model.Database;
import model.Doctor;
import model.Operation;
import model.Report;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadReport {
    private Report r;

    public ReadReport(int id, Database database) {
        String select = "SELECT * FROM report WHERE id = " + id;
        try (ResultSet rs = database.getStatement().executeQuery(select)) {
            r = new Report();

            rs.next();
            r.setID(rs.getInt("id"));
            r.setDateTime(rs.getString("date_time"));
            r.setPaid(rs.getBoolean("paid"));
            r.setDiagnosis(rs.getString("diagnosis"));

            int doctorId = rs.getInt("doctor_id");
            int patientId = rs.getInt("patient_id");
            r.setDoctor((Doctor) new ReadEmployee(doctorId, database).getEmployee());
            r.setPatient(new ReadPatient(patientId, database).getPatient());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Report getReport() {
        return r;
    }
}
