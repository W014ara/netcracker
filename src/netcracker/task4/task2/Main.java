package netcracker.task4.task2;

import java.text.ParseException;

/**
 * Main program's class
 *
 * @author Bezruk Vladislav
 */
public class Main {
    //Main function
    public static void main(String[] args) throws ParseException {
        JUnit.testDates();
        System.out.println("\n/////////------generate Calendar types\n");
        JUnit.testCalendar();
    }
}
