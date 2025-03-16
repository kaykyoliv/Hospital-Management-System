package model;

import view.*;

import javax.swing.text.View;
import java.util.ArrayList;

public class Patient extends User {

    private String bloodGroup;
    public Patient() {
        super();
        this.options = new Option[]{
                new ChangePatientPassword(),
                new ViewPatientUserData(),
                new ViewPatientUserOperations(),
                new ViewPatientPaidOperations(),
                new ViewPatientPaidReports(),
                new ViewPatientUnpaidReport(),
                new ViewPatientUnpaidOperation(),
                new ViewUserReceipts(),
                new ViewPatientUserReports()
        };
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

}
