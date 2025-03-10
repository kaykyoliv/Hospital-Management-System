package model;

public class Doctor extends Employee{

    private String specialization;

    public Doctor(){
        super();
        this.options = new Option[] {};
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
