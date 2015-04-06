package dao;

import entity.Report;
import entity.ReportsData;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Администратор on 30.03.2015.
 */
public class JavaReportDao implements ReportDao {
    private ReportsData reportsData;

    public JavaReportDao() {
        reportsData = ReportsData.getReportsData();
    }

    public Report create() {
        return null;
    }

    public void update(Report report) {

    }

    public void delete(Report report) {

    }

    public Set<String> getListAllPerformers() throws SQLException {
        Set<String> set = new HashSet<String>();
        for (Report r : reportsData.getReportList()) {
            set.add(r.getPerformer());
        }
        return set;
    }

    public List<Report> getByPeriod(String startDate, String endDate) throws SQLException {
        List<Report> reportList = new ArrayList<Report>();
        SimpleDateFormat formatIn =
                new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        for (Report r : reportsData.getReportList()) {
            try {
                if (r.getCreatingDate().compareTo(formatIn.parse(startDate)) >= 0 && r.getCreatingDate().compareTo(formatIn.parse(endDate)) <= 0) {
                    reportList.add(r);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return reportList;
    }

    public List<Report> getByPeriodAndPerformer(String startDate, String endDate, String performer) throws SQLException {
        List<Report> reportList = new ArrayList<Report>();
        SimpleDateFormat formatIn =
                new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        for (Report r : reportsData.getReportList()) {
            try {
                if (r.getCreatingDate().compareTo(formatIn.parse(startDate)) >= 0 &&
                        r.getCreatingDate().compareTo(formatIn.parse(endDate)) <= 0 &&
                        r.getPerformer().equals(performer)) {
                    reportList.add(r);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return reportList;
    }

    public List<Report> getAll() throws SQLException {
        return reportsData.getReportList();
    }
}
