package entity;

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
            reportList.add(new Report(1, formatDate.parse("2015-02-14"), "Ivanov", "Read"));
            reportList.add(new Report(2, formatDate.parse("2014-03-15"), "Sidorov", "Write"));
            reportList.add(new Report(3, formatDate.parse("2015-03-23"), "Petrov", "Read"));
            reportList.add(new Report(4, formatDate.parse("2014-06-02"), "Ivanov", "Write"));
            reportList.add(new Report(5, formatDate.parse("2014-06-15"), "Ivanov", "Read"));
            reportList.add(new Report(6, formatDate.parse("2014-11-01"), "Sidorov", "Read"));
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
