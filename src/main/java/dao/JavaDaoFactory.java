package dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Администратор on 30.03.2015.
 */
public class JavaDaoFactory implements DaoFactory {
    public JavaDaoFactory() {
    }

    public Connection getConnection() throws SQLException {
        return null;
    }

    public ReportDao getReportDao(Connection connection) {
        return new JavaReportDao();
    }
}
