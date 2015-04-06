package dao;

import entity.Report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MySqlReportDao implements ReportDao {
    private final Connection connection;

    public MySqlReportDao(Connection connection) {
        this.connection = connection;
    }

    public Report create() {
        return null;
    }

    public void update(Report report) {

    }

    public void delete(Report report) {

    }

    public Set<String> getListAllPerformers() throws SQLException {
        String sql = "SELECT Performer FROM reports.reports;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        Set<String> set = new HashSet<String>();
        while (rs.next()) {
            String s = rs.getString("Performer");
            set.add(s);
        }
        return set;
    }

    public List<Report> getByPeriod(String startDate, String endDate) throws SQLException {
        String sql = "SELECT * FROM reports.reports WHERE CreatingDate >= ? AND CreatingDate <= ?;";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, startDate);
        stm.setString(2, endDate);

        ResultSet rs = stm.executeQuery();
        List<Report> list = new ArrayList<Report>();
        while (rs.next()) {
            Report r = new Report(rs.getInt("ID"), rs.getDate("CreatingDate"), rs.getString("Performer"), rs.getString("Activity"));
            list.add(r);
        }
        return list;
    }

    public List<Report> getByPeriodAndPerformer(String startDate, String endDate, String performer) throws SQLException {
        String sql = "SELECT * FROM reports.reports WHERE CreatingDate >= ? AND CreatingDate <= ? AND Performer = ?;";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, startDate);
        stm.setString(2, endDate);
        stm.setString(3, performer);

        ResultSet rs = stm.executeQuery();
        List<Report> list = new ArrayList<Report>();
        while (rs.next()) {
            Report r = new Report(rs.getInt("ID"), rs.getDate("CreatingDate"), rs.getString("Performer"), rs.getString("Activity"));
            list.add(r);
        }
        return list;
    }

    public List<Report> getAll() throws SQLException {
        String sql = "SELECT * FROM reports.reports;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Report> list = new ArrayList<Report>();
        while (rs.next()) {
            Report r = new Report(rs.getInt("ID"), rs.getDate("CreatingDate"), rs.getString("Performer"), rs.getString("Activity"));
            list.add(r);
        }
        return list;
    }
}
