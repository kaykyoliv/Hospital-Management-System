package model;

import java.sql.*;

public class Database {

    private String user = "postgres";
    private String pass = "1234567";
    private String url = "jdbc:postgresql://localhost:5432/hospital";
    private Statement statement;

    public Database() {
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}
