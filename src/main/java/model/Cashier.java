package model;

import view.*;

public class Cashier extends Employee {

    public Cashier() {
        super();
        this.options = new Option[]{
                new AddNewReceipt(),
                new ViewAllReceipts(),
                new ViewCashierReceipt(),
                new ViewPatientsReceipts(),
                new ChangePassword()};

    }

    @Override
    public int getJob() {
        return 1;
    }

    @Override
    public String getJobToString() {
        return "Cashier";
    }
}
