package dao;

public class JavaDaoFactory implements DaoFactory {
    public JavaDaoFactory() {
    }

    public ReportDao getReportDao() {
        return new JavaReportDao();
    }
}
