package netcracker.basic.task3.task5;

/**
 * Main program's class
 *
 * @author Bezruk Vladislav
 */
public class Main {
    //Main function
    public static void main(String[] args) {
        PhoneNumber number_0 = new PhoneNumber("+79254627344");
        PhoneNumber number_1 = new PhoneNumber("89254627344");
        PhoneNumber number_2 = new PhoneNumber("+104289652211");
        PhoneNumber number_3 = new PhoneNumber("+3334289652211");
        PhoneNumber number_4 = new PhoneNumber(null);
        PhoneNumber number_5 = new PhoneNumber("+4289652211");
        PhoneNumber number_6 = new PhoneNumber("dsdsdsdsd");
        PhoneNumber number_7 = new PhoneNumber("1");
        PhoneNumber number_8 = new PhoneNumber("9254627344");
        System.out.println(number_0.transformNumber());
        System.out.println(number_1.transformNumber());
        System.out.println(number_2.transformNumber());
        System.out.println(number_3.transformNumber());
        System.out.println(number_4.transformNumber());
        System.out.println(number_5.transformNumber());
        System.out.println(number_6.transformNumber());
        System.out.println(number_7.transformNumber());
        System.out.println(number_8.transformNumber());
    }
}
