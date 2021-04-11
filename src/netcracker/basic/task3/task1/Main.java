package netcracker.basic.task3.task1;

/**
 * Main program's class
 *
 * @author Bezruk Vladislav
 */
public class Main {
    //Main function
    public static void main(String[] args) {
        StudentQuery query = new StudentQuery();
        System.out.println(query.insertStudentsWithDolgCount("10", 5));
    }
}