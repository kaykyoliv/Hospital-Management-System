package controller;

import model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadEmployees {

    private ArrayList<Employee> employees;

    public ReadEmployees(Database database) {
        String select = "SELECT * FROM employee";
        employees = new ArrayList<>();

        try (ResultSet rs = database.getStatement().executeQuery(select)) {
            while (rs.next()) {
                Employee e;
                int job = rs.getInt("job");
                switch (job) {
                    case 0:
                        e = new Doctor();
                        ((Doctor) e).setSpecialization(rs.getString("specialization"));
                        break;
                    case 1:
                        e = new Cashier();
                        break;
                    case 2:
                        e = new Receptionist();
                        break;
                    default:
                        e = new Employee() {

                            @Override
                            public int getJob() {
                                return -1;
                            }

                            @Override
                            public String getJobToString() {
                                return "Unknown Job";
                            }
                        };
                }
                e.setID(rs.getInt("id"));
                e.setFirstName(rs.getString("first_name"));
                e.setLastName(rs.getString("last_name"));
                e.setEmail(rs.getString("email"));
                e.setPassword(rs.getString("password"));
                e.setPhoneNumber(rs.getString("phone_number"));
                e.setSalary(rs.getDouble("salary"));
                employees.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Employee> getEmployees(){
        return employees;
    }


}
