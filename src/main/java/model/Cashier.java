package model;

import view.AddNewReceipt;
import view.ChangePassword;
import view.ViewAllReceipts;

public class Cashier extends Employee {

    public Cashier() {
        super();
        this.options = new Option[]{
                new AddNewReceipt(),
                new ViewAllReceipts(),
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
