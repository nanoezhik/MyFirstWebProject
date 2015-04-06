package entity;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Администратор on 30.03.2015.
 */
public class ReportsData {
    private static final ReportsData reportsData = new ReportsData();
    private List<Report> reportList;

    {
        SimpleDateFormat formatDate =
                new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        reportList = new ArrayList<Report>();
        try {
            reportList.add(new Report(1, new Date(formatDate.parse("2015-02-14").getTime()), "Ivanov", "Read"));
            reportList.add(new Report(2, new Date(formatDate.parse("2014-03-15").getTime()), "Sidorov", "Write"));
            reportList.add(new Report(3, new Date(formatDate.parse("2015-03-23").getTime()), "Petrov", "Read"));
            reportList.add(new Report(4, new Date(formatDate.parse("2014-06-02").getTime()), "Ivanov", "Write"));
            reportList.add(new Report(5, new Date(formatDate.parse("2014-06-15").getTime()), "Ivanov", "Read"));
            reportList.add(new Report(6, new Date(formatDate.parse("2014-11-01").getTime()), "Sidorov", "Read"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private ReportsData() {
    }

    public static ReportsData getReportsData() {
        return reportsData;
    }

    public List<Report> getReportList() {
        return reportList;
    }
}
