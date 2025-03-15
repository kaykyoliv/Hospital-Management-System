package controller;

import model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadPatientReport {

    private final ArrayList<Report> reports;

    public ReadPatientReport(Patient patient, Database database) {
        String select = "SELECT * FROM report WHERE patient_id = " + patient.getID();
        reports = new ArrayList<>();
        ArrayList<Integer> doctorsIDs = new ArrayList<>();

        try (ResultSet rs = database.getStatement().executeQuery(select)) {
            while (rs.next()) {
                Report r = new Report();
                r.setID(rs.getInt("id"));
                doctorsIDs.add(rs.getInt("doctor_id"));
                r.setDateTime(rs.getString("date_time"));
                r.setPatient(patient);
                r.setPaid(rs.getBoolean("paid"));
                r.setDiagnosis(rs.getString("diagnosis"));
                r.setTreatment(rs.getString("treatment"));
                reports.add(r);
            }

            for (int i = 0; i < reports.size(); i++) {
                reports.get(i).setDoctor((Doctor) new ReadEmployee(doctorsIDs.get(i), database).getEmployee());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Report> getReports(){
        return reports;
    }
}
