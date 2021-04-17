package netcracker.task4.task1;

import java.text.ParseException;
import java.util.GregorianCalendar;

/**
 * Main program's class
 *
 * @author Bezruk Vladislav
 */
public class Main {
    //Main function
    public static void main(String[] args) throws ParseException {
        Person person = new Person(new GregorianCalendar(1999, 03, 01));
        System.out.println(person);
        System.out.println(Person.getDate("01.03.1999"));
        System.out.println(Person.getDate("01 March 1999"));
        System.out.println(Person.getDate("01 March 1999 00:00:00"));
    }
}