package application.task3;

/**
 * Main class of the program
 * @author Bezruk Vladislav
 */
public class Main {
    //Main function
    public static void main(String[] args) {
        ExtendedClass s = new ExtendedClass((byte) 0F, 1, 3, "test0");
        ExtendedClass s1 = new ExtendedClass((byte) 0F, 1, 3, "test3");
        System.out.println(s.equals(s1));
        System.out.println(s.hashCode() + " " + s1.hashCode());
        System.out.println(s.toString());
    }
}
