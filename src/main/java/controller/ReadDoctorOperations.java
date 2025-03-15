package controller;

import model.Database;
import model.Doctor;
import model.Operation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadDoctorOperations {

    ArrayList<Operation> operations = new ArrayList<>();

    public ReadDoctorOperations(Doctor doctor, Database database) {
        String select = "SELECT * FROM operation WHERE doctor_id = " + doctor.getID();
        ArrayList<Integer> patientsId = new ArrayList<>();
        try (ResultSet rs = database.getStatement().executeQuery(select)) {
            while (rs.next()) {
                Operation o = new Operation();
                o.setID(rs.getInt("id"));
                patientsId.add(rs.getInt("patient_id"));
                o.setDateTime(rs.getString("date_time"));
                o.setDoctor(doctor);
                o.setPaid(rs.getBoolean("paid"));
                o.setDiagnosis(rs.getString("diagnosis"));
                operations.add(o);
            }

            for (int i = 0; i < operations.size(); i++) {
                operations.get(i).setPatient(new ReadPatient(patientsId.get(i), database).getPatient());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Operation> getOperations() {
        return operations;
    }

}
