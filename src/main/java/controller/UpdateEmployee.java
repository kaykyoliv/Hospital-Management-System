package controller;

import model.Database;
import model.Doctor;
import model.Employee;

import java.sql.SQLException;

public class UpdateEmployee {

    private final Database database;
    private final Employee e;

    public UpdateEmployee(Database database, Employee e) {
        this.database = database;
        this.e = e;
    }

    public boolean isUpdated() {
        boolean updated = false;
        String specialization = "";
        if (e.getJob() == 0) specialization = ((Doctor) e).getSpecialization();
        String update = "UPDATE employee SET first_name = '" + e.getFirstName() + "'" +
                ", last_name = '" + e.getLastName()+ "'" +
                ", email = '" + e.getEmail() + "'" +
                ", phone_number = '" + e.getPhoneNumber() + "'" +
                ", salary = '" + e.getSalary() + "'" +
                ", specialization =  '" + specialization + "'" +
                ", job = '" + e.getJob() + "'" +
                " WHERE id = " + e.getID();
        try {
            database.getStatement().execute(update);
            updated = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }
}
