package controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestDaoController {
    String startDate;
    String endDate;
    String performer;

    @Before
    public void setUp() {
        startDate = "apr 4, 2014";
        endDate = "jun 4, 2014";
        performer = "Ivanov";
    }

    @Test
    public void testGetParameterFromPage() {
        SimpleDateFormat formatIn =
                new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
        Date start = null;
        Date end = null;
        try {
            start = formatIn.parse(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            end = formatIn.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertNotNull(start);
        assertNotNull(end);
    }
}
