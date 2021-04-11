package netcracker.basic.task3.task4;

import java.util.Arrays;

/**
 * Main program's class
 *
 * @author Bezruk Vladislav
 */
public class Main {
    //Main function
    public static void main(String[] args) {
        Shirt sh = new Shirt("S001", "Black Polo Shirt", "Black", "XL");
        //Testing the overloaded method toString()
        System.out.println(sh.toString());
        String[] data = {
                "S001,Black Polo Shirt,Black,XL",
                "S002,Black Polo Shirt,Black,L",
                "S003,Blue Polo Shirt,Blue,XL",
                "S004,Blue Polo Shirt,Blue,M",
                "S005,Tan Polo Shirt,Tan,XL",
                "S006,Black T-Shirt,Black,XL",
                "S007,White T-Shirt,White,XL",
                "S008,White T-Shirt,White,L",
                "S009,Green T-Shirt,Green,S",
                "S010,Orange T-Shirt,Orange,S",
                "S011,Maroon Polo Shirt,Maroon,S"};
        Shirt[] result = new Shirt[data.length];
        for (int index = 0; index < data.length; ++index) {
            result[index] = parseShirt(data[index]);
        }
        System.out.println(Arrays.toString(result));
    }

    /**
     * Parses the passed data string into a shirt object
     *
     * @param data - original string with data separated by ","
     * @return - returns a new shirt object
     * @see Shirt#Shirt(String, String, String, String)
     */
    public static Shirt parseShirt(String data) {
        String[] parsedData = data.split(",");
        return new Shirt(parsedData[0], parsedData[1], parsedData[2], parsedData[3]);
    }
}
