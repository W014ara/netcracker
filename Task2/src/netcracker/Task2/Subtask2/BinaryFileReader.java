package netcracker.Task2.Subtask2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The class whose implementation writes to a typed file
 * integers, then reads and recursively calculates the average
 *
 * @author Bezruk Vladislav
 */
public class BinaryFileReader {
    /**
     * The main method of the class that performs all the basic operations and displays the result on the screen
     *
     * @param filePath - path to the created file
     * @throws IOException
     */
    public static void start(String filePath) throws IOException {
        writeDigitsToFile(filePath);
        ArrayList<ArrayList> result = filterReadDigits(readFromFile(filePath));
        System.out.println(result);
        System.out.print("Number of int numbers: " + result.get(0).size() + "\n");
        recurrentAVG(result.get(3));
    }

    /**
     * Writes integers to a file. The recording is carried out through a space
     *
     * @param filePath - path to the created file
     * @throws IOException
     */
    public static void writeDigitsToFile(String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath, false);
        Scanner inCount = new Scanner(System.in);
        System.out.print("How many elements to enter:");
        int digitsCount = inCount.nextInt();
        System.out.println("Enter the elements:");
        while (digitsCount != 0) {
            Scanner newDigit = new Scanner(System.in);
            writer.write(newDigit.next());
            writer.write(" ");
            digitsCount--;
        }
        writer.flush();
    }

    /**
     * Method that reads all numbers from a file
     *
     * @param filePath - path to the created file
     * @return returns a string array of integers
     */
    public static ArrayList<String> readFromFile(String filePath) {
        Path file = Paths.get(filePath);
        ArrayList<String> arrNew = null;
        if (Files.exists(file)) {
            try {
                byte[] bytes = Files.readAllBytes(file);
                String text = new String(bytes, StandardCharsets.UTF_8);
                arrNew = new ArrayList<>(Arrays.asList(text.split(" ")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return arrNew;
    }

    /**
     * Filters a string array. Splits the array into four separate ones. The first array - stores parsed integer
     * elements, the second - parsed bytes, the third - parsed float values. The last array stores all the numbers
     * parsed in float format. This is done for the method that calculates the average values.
     *
     * @param strArr - original array storing string representations of integers
     * @return returns an array of arrays of integers, bytes and floats
     */
    public static ArrayList<ArrayList> filterReadDigits(ArrayList<String> strArr) {
        ArrayList<ArrayList> result = new ArrayList<>();
        ArrayList<Integer> arrInteger = new ArrayList<>();
        ArrayList<Byte> arrByte = new ArrayList<>();
        ArrayList<Float> arrFloat = new ArrayList<>();
        ArrayList<Float> targetResult = new ArrayList<>();
        if (strArr != null) {
            for (String el : strArr) {
                try {
                    arrByte.add(Byte.parseByte(el));
                } catch (Exception byteException) {
                    try {
                        arrInteger.add(Integer.parseInt(el));
                    } catch (Exception integerException) {
                        try {
                            arrFloat.add(Float.parseFloat(el));
                        } catch (Exception floatException) {
                            System.out.println(floatException.getMessage());
                        }
                    }
                } finally {
                    targetResult.add(Float.parseFloat(el));
                }
            }
        }
        result.add(arrInteger);
        result.add(arrByte);
        result.add(arrFloat);
        result.add(targetResult);
        return result;
    }

    /**
     * calculates various averages (average of the second half and three-sevenths)
     *
     * @param targetArr - array of float numbers
     * @see BinaryFileReader#filterReadDigits(ArrayList)
     */
    public static void recurrentAVG(ArrayList<Float> targetArr) {
        int middleIndex = (int) Math.floor(targetArr.size() / 2);
        int threeSevenths = (int) Math.floor((targetArr.size() * 3) / 4);
        System.out.println("Second half average: " +
                targetArr.subList(middleIndex, targetArr.size()).stream().reduce(Float::sum).get() / targetArr.size());
        System.out.println("Third quarter average:" +
                targetArr.subList(0, threeSevenths).stream().reduce(Float::sum).get() / targetArr.size());
    }
}

