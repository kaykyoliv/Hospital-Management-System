package model;

import view.ChangePatientPassword;
import view.ViewPatientUserData;
import view.ViewPatientUserOperations;
import view.ViewPatientUserReports;

import java.util.ArrayList;

public class Patient extends User {

    private String bloodGroup;
 //   private ArrayList<Operation> operations;
 //   private ArrayList<Report> reports;
 //   private ArrayList<Operation> unpaidOperations;
 //   private ArrayList<Report> unpaidReports;

    public Patient() {
        super();
        this.options = new Option[]{
                new ChangePatientPassword(),
                new ViewPatientUserData(),
                new ViewPatientUserOperations(),
                new ViewPatientUserReports()
        };
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

/*public ArrayList<Operation> getOperations() {
        return operations;
    }

    public void addOperation(Operation operation) {
        operations.add(operation);
    }

    public void removeOperation(Operation operation) {
        operations.remove(operation);
    }

    public ArrayList<Report> getReports() {
        return reports;
    }

    public void addReport(Report report) {
        reports.add(report);
    }

    public void removeReport(Report report) {
        reports.remove(report);
    }

    public ArrayList<Operation> getUnpaidOperations() {
        return unpaidOperations;
    }

    public void addUnpaidOperations(Operation operation) {
        unpaidOperations.add(operation);
    }

    public void removeUnpaidOperations(Operation operation) {
        unpaidOperations.remove(operation);
    }

    public ArrayList<Report> getUnpaidReports() {
        return unpaidReports;
    }

    public void addUnpaidReports(Report report) {
        unpaidReports.add(report);
    }

    public void removeUnpaidReports(Report report) {
        unpaidReports.remove(report);
    }*/
}
