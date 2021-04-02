package netcracker.task1.quadratic;

/**
 * The main class of the package for solving quadratic equations
 *
 * @autor Bezruk Vladislav
 */
public class Main {
    //Main function
    public static void main(String[] args) {
        Quadratic expression = new Quadratic(1,-4,4);
        System.out.println(expression.getResult());
    }
}
