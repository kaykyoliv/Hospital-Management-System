package controller;

import model.Cashier;
import model.Database;
import model.Employee;
import model.Receptionist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadEmployee {

    private ArrayList<Employee> employees;

    public ReadEmployee(Database database) {
        String select = "SELECT * FROM employees";
        employees = new ArrayList<>();

        try (ResultSet rs = database.getStatement().executeQuery(select)) {
            while (rs.next()) {
                Employee e;
                int job = rs.getInt("job");
                switch (job) {
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
