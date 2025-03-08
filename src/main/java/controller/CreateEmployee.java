package controller;

import model.Database;
import model.Employee;

import java.sql.SQLException;

public class CreateEmployee {

    private Employee employee;
    private Database database;
    public CreateEmployee(Employee employee, Database database){
        this.employee = employee;
        this.database = database;
    }

    public boolean isCreated(){
        boolean created = false;
        String insert = "INSERT INTO employee (first_name, last_name, email, phone_number, password, salary, job) " +
                "VALUES ('" + employee.getFirstName() + "', '" + employee.getLastName() + "', '" +
                employee.getEmail() + "', '" + employee.getPhoneNumber() + "', '" +
                employee.getPassword() + "', " + employee.getSalary() + ", " + employee.getJob() + ")";
        try{
            database.getStatement().execute(insert);
            created = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return created;
    }
}
