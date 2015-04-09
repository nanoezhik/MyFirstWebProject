package dao;

import entity.Report;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MySqlReportDao implements ReportDao {
    private final SessionFactory sessionFactory;

    public MySqlReportDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Report create() {
        return null;
    }

    public void update(Report report) {

    }

    public void delete(Report report) {

    }

    public Set<String> getListAllPerformers() throws SQLException {
        Session session = null;
        Set<String> set = null;
        try {
            session = sessionFactory.openSession();
            List<String> list = session.createSQLQuery("SELECT Performer FROM reports.reports;").list();
            set = new HashSet<String>(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return set;
    }

    public List<Report> getByPeriod(String startDate, String endDate) throws SQLException {
        Session session = null;
        List<Report> list = new ArrayList<Report>();
        try {
            session = sessionFactory.openSession();
            Query query = session.createSQLQuery("SELECT * FROM reports.reports WHERE CreatingDate >= ? AND CreatingDate <= ?;").addEntity(Report.class);
            list = query.setString(0, startDate).setString(1, endDate).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return list;
    }

    public List<Report> getByPeriodAndPerformer(String startDate, String endDate, String performer) throws SQLException {
        Session session = null;
        List<Report> list = new ArrayList<Report>();
        try {
            session = sessionFactory.openSession();
            Query query = session.createSQLQuery("SELECT * FROM reports.reports WHERE CreatingDate >= ? AND CreatingDate <= ? AND Performer = ?;").addEntity(Report.class);
            list = query.setString(0, startDate).setString(1, endDate).setString(2, performer).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return list;
    }

    public List<Report> getAll() throws SQLException {
        Session session = null;
        List<Report> list = new ArrayList<Report>();
        try {
            session = sessionFactory.openSession();
            list = session.createSQLQuery("SELECT * FROM reports.reports;").addEntity(Report.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return list;
    }
}
