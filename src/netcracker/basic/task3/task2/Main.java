package netcracker.basic.task3.task2;

import java.util.ArrayList;

/**
 * Main program's class
 *
 * @author Bezruk Vladislav
 */
public class Main {
    //Main function
    public static void main(String[] args) {
        //Create verification data
        ArrayList<Person> data = new ArrayList<>();
        data.add(new Person("Vladislav", "Pavlovich", "Ivanov"));
        data.add(new Person("", "Pavlovich", "Ivanov"));
        data.add(new Person("", "", "Ivanov"));
        data.add(new Person("", "", ""));
        data.add(new Person(null, "", "Ivanov"));
        data.add(new Person(null, null, "Ivanov"));
        data.add(new Person(null, null, null));
        for (Person datum : data) {
            System.out.println(datum.getFullName());
        }
    }
}