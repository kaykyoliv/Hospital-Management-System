package controller;

import model.Database;
import model.Doctor;
import model.Patient;
import model.Report;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadDoctorReport {

    private final ArrayList<Report> reports;

    public ReadDoctorReport(Doctor doctor, Database database) {
        String select = "SELECT * FROM report WHERE doctor_id = " + doctor.getID();
        reports = new ArrayList<>();
        ArrayList<Integer> patientIDs = new ArrayList<>();

        try (ResultSet rs = database.getStatement().executeQuery(select)) {
            while (rs.next()) {
                Report r = new Report();
                r.setID(rs.getInt("id"));
                patientIDs.add(rs.getInt("patient_id"));
                r.setDateTime(rs.getString("date_time"));
                r.setDoctor(doctor);
                r.setPaid(rs.getBoolean("paid"));
                r.setDiagnosis(rs.getString("diagnosis"));
                r.setTreatment(rs.getString("treatment"));
                reports.add(r);
            }

            for (int i = 0; i < reports.size(); i++) {
                reports.get(i).setPatient(new ReadPatient(patientIDs.get(i), database).getPatient());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Report> getReports(){
        return reports;
    }
}
