package model;

import view.ChangePassword;
import view.EditEmployee;
import view.addNewEmployee;
import view.viewEmployee;

public class Receptionist extends Employee {

    public Receptionist() {
        super();
        this.options = new Option[]{
                new addNewEmployee(),
                new viewEmployee(),
                new EditEmployee(),
                new ChangePassword()
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
