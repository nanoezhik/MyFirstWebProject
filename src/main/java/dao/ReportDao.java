package dao;

import entity.Report;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * Created by Администратор on 23.03.2015.
 */
public interface ReportDao {
    public Report create();

    public void update(Report report);

    public void delete(Report report);

    public Set<String> getListAllPerformers() throws SQLException;

    public List<Report> getByPeriod(String startDate, String endDate) throws SQLException;

    public List<Report> getByPeriodAndPerformer(String startDate, String endDate, String performer) throws SQLException;

    public List<Report> getAll() throws SQLException;
}
