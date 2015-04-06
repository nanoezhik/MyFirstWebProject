package entity;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Report {
    private int id;
    private Date creatingDate;
    private String performer;
    private String activity;

    public Report(int id, Date creatingDate, String performer, String activity) {
        this.id = id;
        this.creatingDate = creatingDate;
        this.performer = performer;
        this.activity = activity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(Date creatingDate) {
        this.creatingDate = creatingDate;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Report report = (Report) o;

        if (id != report.id) return false;
        if (!activity.equals(report.activity)) return false;
        if (!performer.equals(report.performer)) return false;
        if (!creatingDate.equals(report.creatingDate)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + creatingDate.hashCode();
        result = 31 * result + performer.hashCode();
        result = 31 * result + activity.hashCode();
        return result;
    }

    @Override
    public String toString() {
        SimpleDateFormat format =
                new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        return "Report{" +
                "id=" + id +
                ", creatingDate=" + format.format(creatingDate) +
                ", performer='" + performer + '\'' +
                ", activity='" + activity + '\'' +
                '}';
    }
}