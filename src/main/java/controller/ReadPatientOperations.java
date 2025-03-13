package controller;

import model.Database;
import model.Doctor;
import model.Operation;
import model.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadPatientOperations {

    private final ArrayList<Operation> operations;

    public ReadPatientOperations(Patient patient, Database database) {
        String select = "SELECT * FROM operation WHERE patient_id = " + patient.getID();
        operations = new ArrayList<>();
        ArrayList<Integer> doctorsIDs = new ArrayList<>();

        try (ResultSet rs = database.getStatement().executeQuery(select)) {
            while (rs.next()) {
                Operation o = new Operation();
                o.setID(rs.getInt("id"));
                doctorsIDs.add(rs.getInt("doctor_id"));
                o.setDateTime(rs.getString("date_time"));
                o.setPatient(patient);
                o.setPaid(rs.getBoolean("paid"));
                o.setDiagnosis(rs.getString("diagnosis"));
                operations.add(o);
            }

            for (int i = 0; i < operations.size(); i++) {
                operations.get(i).setDoctor((Doctor) new ReadEmployee(doctorsIDs.get(i), database).getEmployee());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Operation> getOperations() {
        return operations;
    }
}
