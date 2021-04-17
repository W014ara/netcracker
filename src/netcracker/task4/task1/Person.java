package netcracker.task4.task1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Class that mimics the date of birth
 *
 * @author Bezruk Vladislav
 */
public class Person {

    private Calendar date;

    /**
     * Person class constructor
     *
     * @param date - a parameter in the format Calendar
     */
    public Person(Calendar date) {
        this.date = date;
    }

    /**
     * Method for getting integer year of birth
     *
     * @return - returns an integer representing the year of birth
     */
    public int getYear() {
        return this.date.get(Calendar.YEAR);
    }

    /**
     * Method that returns an integer that is the number of the day in the month
     *
     * @return - returns an integer that is the number of the day in the month
     */
    public int getDayNumber() {
        return this.date.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Method that returns the number of the month
     *
     * @return - returns an integer month number
     */
    public int getMonthNumber() {
        return this.date.get(Calendar.MONTH);
    }


    /**
     * Method that returns the string name of the month
     *
     * @return - Returns the string name of the month
     */
    public String getMonthName() {
        return this.date.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
    }

    /**
     * Method that returns the string value of the day of the week
     *
     * @return - Returns the string value of the day of the week
     */
    public String getDayName() {
        int day = this.date.get(Calendar.DAY_OF_WEEK);
        String result = "";
        switch (day) {
            case 1:
                result = "Sunday";
                break;
            case 2:
                result = "Monday";
                break;
            case 3:
                result = "Tuesday";
                break;
            case 4:
                result = "Wednesday";
                break;
            case 5:
                result = "Thursday";
                break;
            case 6:
                result = "Friday";
                break;
            case 7:
                result = "Saturday";
                break;
        }
        return result;
    }

    /**
     * Method that returns a string date of birth representation
     *
     * @return - Returns a string representation of the date of birth according
     * to the date format entered into the method
     * (e.g. short, medium and full date format)
     */
    public static Date getDate(String formative) throws ParseException {
        /*
            Sample formats:
            01.03.2000 - short example
            01 March 2000 - middle example
            01 March 2000 00:00:00 - full example
         */
        DateFormat[] formats = new DateFormat[]{
                new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH),
                new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH),
                new SimpleDateFormat("dd MMMM yyyy hh:mm:ss", Locale.ENGLISH),
        };
        Date result = null;
        for (DateFormat format : formats) {
            try {
                result = format.parse(formative);
            } catch (Exception ignored) {

            }
        }
        return result;
    }

    /**
     * An overridden method that returns a string representation of object values
     *
     * @return - returning a string representation of the object's values
     */
    @Override
    public String toString() {
        int month;
        if (this.date.get(Calendar.MONTH) % 12 == 0) {
            month = 12;
        } else {
            month = Integer.parseInt(this.padZeroLeft(this.date.get(Calendar.MONTH)));
        }
        return String.format("%s.%s.%s %s:%s:%s",
                this.padZeroLeft(this.date.get(Calendar.DAY_OF_MONTH)),
                this.padZeroLeft(month),
                this.date.get(Calendar.YEAR),
                this.padZeroLeft(this.date.get(Calendar.SECOND)),
                this.padZeroLeft(this.date.get(Calendar.MINUTE)),
                this.padZeroLeft(this.date.get(Calendar.MILLISECOND)));
    }

    /**
     * Method that adds zero to the left of a number if the original number is one-digit
     *
     * @param digit - original number
     * @return - returns a new modified two-digit number
     */
    private String padZeroLeft(int digit) {
        if (Integer.toString(digit).length() == 1) {
            return "0" + digit;
        } else {
            return Integer.toString(digit);
        }
    }
}
