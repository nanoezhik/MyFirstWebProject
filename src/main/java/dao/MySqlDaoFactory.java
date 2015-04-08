package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySqlDaoFactory implements DaoFactory {
//    private String user = "root";
//    private String password = "pass";
//    private String url = "jdbc:mysql://localhost:3306/reports";
//    private String driver = "com.mysql.jdbc.Driver";
    private static SessionFactory sessionFactory = null;

    public MySqlDaoFactory() {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(url, user, password);
//    }

    public ReportDao getReportDao() {
        return new MySqlReportDao(sessionFactory);
    }

}
