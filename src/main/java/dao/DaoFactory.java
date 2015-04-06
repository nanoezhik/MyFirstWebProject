package dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Администратор on 23.03.2015.
 */
public interface DaoFactory {
    public Connection getConnection() throws SQLException;

    public ReportDao getReportDao(Connection connection);
}
