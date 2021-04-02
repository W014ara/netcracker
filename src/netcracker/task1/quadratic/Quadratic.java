package netcracker.task1.quadratic;

import java.util.HashMap;

/**
 * A class that implements the calculation of the roots of a quadratic equation
 *
 * @autor Bezruk Vladislav
 */
public class Quadratic {
    private final double a;
    private final double b;
    private final double c;

    /**
     * Constructor - Creating a new object with a set of coefficients
     *
     * @param a - coefficient at x^2
     * @param b - coefficient at x
     * @param c - free term function
     */
    public Quadratic(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Resulting function
     *
     * @return returns the roots of a quadratic equation
     */
    public HashMap<String, String> getResult() {
        HashMap<String, String> result = new HashMap<>();
        Discriminant d = new Discriminant();
        if (d.discriminant(this.a, this.b, this.c) < 0) {
            result.put("Result", "No rational solution");
        } else if (this.a == 0) {
            result.put("Result", "The equation is not square");
        } else {
            //Declare two roots according to the main theorem of algebra
            double result_1 = ((-1 * b) - Math.sqrt(d.discriminant(this.a, this.b, this.c))) / (2 * this.a);
            double result_2 = ((-1 * b) + Math.sqrt(d.discriminant(this.a, this.b, this.c))) / (2 * this.a);
            result.put("x1", String.valueOf(result_1));
            result.put("x2", String.valueOf(result_2));
        }
        return result;
    }

    /**
     * A class that implements the operation of calculating the discriminant
     *
     * @autor Bezruk Vladislav
     */
    public static class Discriminant {
        /**
         * Discriminant calculation function
         *
         * @param a - coefficient at x^2
         * @param b - coefficient at x
         * @param c - free term function
         * @return returns the value of the discriminant
         */
        public double discriminant(double a, double b, double c) {
            return Math.pow(b, 2) - (4 * a * c);
        }
    }
}
