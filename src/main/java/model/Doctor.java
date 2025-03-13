package model;

import view.*;

public class Doctor extends Employee{

    private String specialization;

    public Doctor(){
        super();
        this.options = new Option[] {
                new AddNewOperation(),
                new AddNewReport(),
                new ViewPatientData(),
                new ViewPatientOperations(),
                new ChangePassword()
        };
    }

    @Override
    public int getJob() {
        return 0;
    }

    @Override
    public String getJobToString() {
        return "Doctor";
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
