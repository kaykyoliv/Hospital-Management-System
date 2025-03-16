package controller;

import model.Database;
import model.Doctor;
import model.Operation;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadOperation {

    private Operation o;

    public ReadOperation(int id, Database database) {
        String select = "SELECT * FROM operation WHERE id = " + id;
        try (ResultSet rs = database.getStatement().executeQuery(select)) {
            o = new Operation();

            rs.next();
            o.setID(rs.getInt("id"));
            o.setDateTime(rs.getString("date_time"));
            o.setPaid(rs.getBoolean("paid"));
            o.setDiagnosis(rs.getString("diagnosis"));

            int doctorId = rs.getInt("doctor_id");
            int patientId = rs.getInt("patient_id");
            o.setDoctor((Doctor) new ReadEmployee(doctorId, database).getEmployee());
            o.setPatient(new ReadPatient(patientId, database).getPatient());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Operation getOperation() {
        return o;
    }
}
