package netcracker.task4.task2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Check Class DateConverter
 *
 * @author Bezruk Vladislav
 */
public class JUnit {

    /**
     * Method that creates multiple original string dates, comparing them to the converted Date object
     *
     * @throws ParseException
     */
    public static void testCalendar() throws ParseException {
        DateFormat formatSecond = new SimpleDateFormat("hhmm", Locale.ENGLISH);

        Calendar date1 = DateConverter.CreateCalendarFormatObject("1300January25");
        Calendar date2 = DateConverter.CreateCalendarFormatObject("2021February27");
        Calendar date3 = DateConverter.CreateCalendarFormatObject("2021February27");
        Calendar date4 = DateConverter.CreateCalendarFormatObject("1950February31");
        Calendar date5 = DateConverter.CreateCalendarFormatObject("2430");


        Calendar checkdate1 = new GregorianCalendar(1300, Calendar.JANUARY, 25);
        Calendar checkdate2 = new GregorianCalendar(2021, Calendar.FEBRUARY, 27);
        Calendar checkdate3 = null;
        Calendar checkdate4 = new GregorianCalendar(1950, Calendar.FEBRUARY, 31);
        Calendar checkdate5 = new GregorianCalendar();
        checkdate5.setTime(formatSecond.parse("2430"));


        System.out.println(date1.getTime() + "    " + checkdate1.getTime() + "  = " + date1.equals(checkdate1));
        System.out.println(date2.getTime() + "    " + checkdate2.getTime() + "  = " + date2.equals(checkdate2));
        System.out.println(date3.getTime() + "    " + checkdate3 + "  = " + (date3 == checkdate3));
        System.out.println(date4.getTime() + "    " + checkdate4.getTime() + "  = " + date4.equals(checkdate4));
        System.out.println(date5.getTime() + "    " + checkdate5.getTime() + "  = " + date5.equals(checkdate5));
    }


    /**
     * Method that creates multiple original string dates, comparing them to the converted Calendar object
     *
     * @throws ParseException
     */
    public static void testDates() throws ParseException {
        DateFormat formatSecond = new SimpleDateFormat("hhmm", Locale.ENGLISH);

        Date date1 = DateConverter.CreateDateFormatObject("1300January25");
        Date date2 = DateConverter.CreateDateFormatObject("2021February27");
        Date date3 = DateConverter.CreateDateFormatObject("2021February27");
        Date date4 = DateConverter.CreateDateFormatObject("1950February31");
        Date date5 = DateConverter.CreateDateFormatObject("2430");


        Date checkdate1 = new Date(-600, Calendar.JANUARY, 25);
        Date checkdate2 = new Date(121, Calendar.FEBRUARY, 27);
        Date checkdate3 = null;
        Date checkdate4 = new Date(50, Calendar.FEBRUARY, 31);
        Date checkdate5 = formatSecond.parse("2430");


        System.out.println(date1 + "    " + checkdate1 + "  = " + date1.equals(checkdate1));
        System.out.println(date2 + "    " + checkdate2 + "  = " + date2.equals(checkdate2));
        System.out.println(date3 + "    " + checkdate3 + "  = " + (date3 == checkdate3));
        System.out.println(date4 + "    " + checkdate4 + "  = " + date4.equals(checkdate4));
        System.out.println(date5 + "    " + checkdate5 + "  = " + date5.equals(checkdate5));
    }

}
