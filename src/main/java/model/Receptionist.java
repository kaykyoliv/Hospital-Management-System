package model;

import view.*;

public class Receptionist extends Employee {

    public Receptionist() {
        super();
        this.options = new Option[]{
                new addNewEmployee(),
                new viewEmployee(),
                new EditEmployee(),
                new ChangePassword(),
                new FireEmployee(),
                new AddNewPatient()
        };
    }

    @Override
    public int getJob() {
        return 2;
    }

    @Override
    public String getJobToString() {
        return "Receptionist";
    }
}
