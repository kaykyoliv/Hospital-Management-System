package controller;

import model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ReadEmployee {

    private Employee e;

    public ReadEmployee(int ID, Database database) {
        String select = "SELECT * FROM employee WHERE id = '" + ID + "'";
        try (ResultSet rs = database.getStatement().executeQuery(select)) {

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
                            return null;
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee getEmployee(){
        return e;
    }
}
