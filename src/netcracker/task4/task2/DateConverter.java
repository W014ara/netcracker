package netcracker.task4.task2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


/**
 * Class that implements the conversion of the string representation of a date to Date and Calendar formats
 *
 * @author Bezruk Vladislav
 */
public class DateConverter {
    /**
     * Method that converts the string representation of a date in the <Year><Month><Digit> or <Hours><Minutes>
     * format into a Date object
     *
     * @param formative - source string in <Year><Month><Digit> or <Hours><Minutes> format without space symbols
     * @return - returns a new Date object
     */
    public static Date CreateDateFormatObject(String formative) {

        DateFormat formatOne = new SimpleDateFormat("yyyyMMMMdd", Locale.ENGLISH);
        DateFormat formatSecond = new SimpleDateFormat("hhmm", Locale.ENGLISH);
        DateFormat[] formats = new DateFormat[]{
                formatOne,
                formatSecond
        };
        Date result = null;
        for (DateFormat format : formats) {
            try {
                result = format.parse(formative);
                break;
            } catch (Exception e) {

            }
        }
        return result;
    }

    /**
     * Method that converts the string representation of a date in the <Year><Month><Digit> or <Hours><Minutes>
     * format into a Calendar object
     *
     * @param formative - source string in <Year><Month><Digit> or <Hours><Minutes> format without space symbols
     * @return - returns a new Calendar object
     */
    public static Calendar CreateCalendarFormatObject(String formative) {
        Calendar result = new GregorianCalendar();
        result.setTime(CreateDateFormatObject(formative));
        return result;
    }
}
