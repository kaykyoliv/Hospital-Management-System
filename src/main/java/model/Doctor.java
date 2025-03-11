package model;

import view.ChangePassword;

public class Doctor extends Employee{

    private String specialization;

    public Doctor(){
        super();
        this.options = new Option[] {
                new ChangePassword()};
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
