package model;

import view.addNewEmployee;
import view.viewEmployee;

import java.util.Scanner;

public class Receptionist extends Employee{

    public Receptionist() {
        super();
        this.options = new Option[] {
                new addNewEmployee(),
                new viewEmployee()
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
