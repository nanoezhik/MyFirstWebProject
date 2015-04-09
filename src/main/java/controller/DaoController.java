package controller;

import dao.DaoFactory;
import dao.ReportDao;
import entity.Report;
import inject.DependencyInjectionServlet;
import inject.Inject;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class DaoController extends DependencyInjectionServlet {
    public static final Logger LOGGER = Logger.getLogger(DaoController.class);
    private static String startDate;
    private static String endDate;
    private static String performer;
    private static boolean allPerformers;

    @Inject("productDao")
    private DaoFactory daoFactory;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Report> reportList = null;
        getParameterFromPage(request);
        try {
            ReportDao rep = daoFactory.getReportDao();
            LOGGER.info("Successful connection to DAO '" + rep.getClass().getSimpleName() + "'");
            if (allPerformers) {
                reportList = rep.getByPeriod(startDate, endDate);
                LOGGER.info("Period to select: " + startDate + " - " + endDate + ", all performers");
            }
            else {
                reportList = rep.getByPeriodAndPerformer(startDate, endDate, performer);
                LOGGER.info("Period to select: " + startDate + " - " + endDate + ", performer - " + performer);
            }
        } catch (SQLException e) {
            LOGGER.warn("Error connection to DAO");
            e.printStackTrace();
        }

        request.setAttribute("report", reportList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Set<String> performerSet = null;

        try {
            ReportDao rep = daoFactory.getReportDao();
            LOGGER.info("Successful connection to DAO '" + rep.getClass().getSimpleName() + "'");
            performerSet = rep.getListAllPerformers();
        } catch (SQLException e) {
            LOGGER.warn("Error connection to DAO");
            e.printStackTrace();
        }

        request.setAttribute("perfs", performerSet);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    private static void getParameterFromPage(HttpServletRequest request){
        performer = request.getParameter("performer");
        if (performer.equals("All Performers"))
            allPerformers = true;

        String period = request.getParameter("period");
        SimpleDateFormat formatIn =
                new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
        SimpleDateFormat formatOut =
                new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        if (!period.isEmpty()) {
            if (period.equals("Last Qtr")) {
                LocalDate localDate = LocalDate.now();
                switch ((localDate.getMonthValue()-1)/3) {
                    case 0: {
                        startDate = "" + (localDate.getYear() - 1) +"-10-01";
                        endDate = "" + (localDate.getYear() - 1) +"-12-31";
                        break;
                    }
                    case 1: {
                        startDate = "" + localDate.getYear() +"-01-01";
                        endDate = "" + localDate.getYear() +"-03-31";
                        break;
                    }
                    case 2: {
                        startDate = "" + localDate.getYear() +"-04-01";
                        endDate = "" + localDate.getYear() +"-06-30";
                        break;
                    }
                    case 3: {
                        startDate = "" + localDate.getYear() +"-07-01";
                        endDate = "" + localDate.getYear() +"-09-30";
                        break;
                    }
                }
            }   else if (period.equals("Last Month")) {
                LocalDate localDate = LocalDate.now().minusMonths(1);
                String month;
                if (localDate.getMonthValue() < 10) {
                    month = "0" + localDate.getMonthValue();
                } else {
                    month = "" + localDate.getMonthValue();
                }
                startDate = "" + localDate.getYear() + "-" + month + "-01";
                endDate = "" + localDate.getYear() + "-" + month + "-" + localDate.getDayOfMonth();
            }   else if (period.equals("Last Calendar Year")) {
                LocalDate localDate = LocalDate.now().minusYears(1);
                String year = "" + localDate.getYear();
                startDate = year + "-01-01";
                endDate = year + "-12-31";
            }   else if (period.equals("Current Year to Date")) {
                LocalDate localDate = LocalDate.now();
                String year = "" + localDate.getYear();
                startDate = year + "-01-01";
                endDate = localDate.toString();
            }   else if (period.equals("Current Qtr to Date")) {
                LocalDate localDate = LocalDate.now();
                switch ((localDate.getMonthValue()-1)/3) {
                    case 0: {
                        startDate = "" + localDate.getYear() + "-01-01";
                        endDate = localDate.toString();
                        break;
                    }
                    case 1: {
                        startDate = "" + localDate.getYear() + "-04-01";
                        endDate = localDate.toString();
                        break;
                    }
                    case 2: {
                        startDate = "" + localDate.getYear() + "-07-01";
                        endDate = localDate.toString();
                        break;
                    }
                    case 3: {
                        startDate = "" + localDate.getYear() + "-10-01";
                        endDate = localDate.toString();
                        break;
                    }
                }
            }   else if (period.equals("Current Month to Date")) {
                LocalDate localDate = LocalDate.now();
                String month;
                if (localDate.getMonthValue() < 10) {
                    month = "0" + localDate.getMonthValue();
                } else {
                    month = "" + localDate.getMonthValue();
                }
                startDate = "" + localDate.getYear() + "-" + month + "-01";
                endDate = localDate.toString();
            }

        }
        else {
            try {
                startDate = formatOut.format(formatIn.parse(request.getParameter("startDate")));
            } catch (ParseException e) {
                startDate = "1970-01-01";
            }

            try {
                endDate = formatOut.format(formatIn.parse(request.getParameter("endDate")));
            } catch (ParseException e) {
                endDate = formatOut.format(new Date(new java.util.Date().getTime()));
            }
        }

    }
}
