package netcracker.task4.task3;

import java.util.Scanner;

/**
 * Main program's class
 *
 * @author Bezruk Vladislav
 */
public class Main {
    //Main function
    public static void main(String[] args) {
        Scanner in_1 = new Scanner(System.in);
        Scanner in_2 = new Scanner(System.in);
        Scanner in_3 = new Scanner(System.in);
        System.out.print("Input first row:");
        String str1 = in_1.nextLine();
        System.out.print("Input second row:");
        String str2 = in_2.nextLine();
        System.out.print("Enter the number of digits to shift:");
        int hash = in_3.nextInt();

        StringFrequency freq = new StringFrequency(str1, str2);
        System.out.println("Number of characters in the first line:");
        System.out.println(freq.symbolFriquency());

        System.out.println("\nNumber of words in the first line:");
        System.out.println(freq.wordsFriquencyCount());

        System.out.println("\nCharacters included in both the first and second lines----------1");
        System.out.println("Output as usual:");
        System.out.println(freq.printStandard(freq.symbolCrossing()));
        System.out.println("Reverse output:");
        System.out.println(freq.printReverse(freq.symbolCrossing()));
        System.out.println("Output in ascending hash code:");
        System.out.println(freq.printHash(freq.symbolCrossing(), hash));

        System.out.println("\nCharacters included in the first and not included in the second----------2");
        System.out.println("Output as usual:");
        System.out.println(freq.printStandard(freq.symbolFirstCrossing()));
        System.out.println("Reverse output:");
        System.out.println(freq.printReverse(freq.symbolFirstCrossing()));
        System.out.println("Вывод в со сдвигом hash кода по возрастанию:");
        System.out.println(freq.printHash(freq.symbolFirstCrossing(), hash));

        System.out.println("\nСимволы, содержающиеся хотя бы в одной строке----------3");
        System.out.println("Output as usual:");
        System.out.println(freq.printStandard(freq.symbolAnyCrossing()));
        System.out.println("Reverse output:");
        System.out.println(freq.printReverse(freq.symbolAnyCrossing()));
        System.out.println("Output in ascending hash code:");
        System.out.println(freq.printHash(freq.symbolAnyCrossing(), hash));
    }
}
