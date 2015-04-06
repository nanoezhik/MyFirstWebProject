package dao;

import entity.Report;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDaoFactory implements DaoFactory {
    private String user = "root";
    private String password = "pass";
    private String url = "jdbc:mysql://localhost:3306/reports";
    private String driver = "com.mysql.jdbc.Driver";

    public MySqlDaoFactory() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public ReportDao getReportDao(Connection connection) {
        return new MySqlReportDao(connection);
    }

}
