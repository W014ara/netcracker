package netcracker.Task2.Subtask3;

import java.io.*;
import java.util.Locale;

/**
 * A class that copies at least one page of the java documentation.
 * Reads a character stream until the word "java" is encountered a third time.
 *
 * @author Bezruk Vladislav
 */
public class JavaDocReader {
    /**
     * The main method of the class that reads the documentation and writes the resulting string to a file
     *
     * @param filepath    path to source documentation
     * @param newFileName path to the file where you want to write the documentation
     * @see JavaDocReader#readJavaDoc(String)
     * @see JavaDocReader#writeJavaDoc(String, StringBuilder)
     */
    public static void start(String filepath, String newFileName) {
        System.out.println(readJavaDoc(filepath));
        writeJavaDoc(newFileName, readJavaDoc(filepath));
    }

    /**
     * Writes information to a file
     *
     * @param newFile path to the file where you want to write the documentation
     * @param text    text to write to file
     */
    public static void writeJavaDoc(String newFile, StringBuilder text) {
        try {
            FileWriter writer = new FileWriter(newFile, false);
            writer.write(String.valueOf(text));
            writer.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Reads information from documentation or other text document
     *
     * @param filepath path to source documentation
     * @return returns a string representation of the read information
     */
    public static StringBuilder readJavaDoc(String filepath) {
        int javaCounter = 0;
        StringBuilder result = new StringBuilder();
        try {
            Reader in = new FileReader(filepath);
            BufferedReader reader = new BufferedReader(in);
            String line = reader.readLine();

            while (line != null && javaCounter != 3) {
                if (line.toLowerCase(Locale.ROOT).contains("java")) {
                    javaCounter++;
                }
                line = reader.readLine();
                result.append(line);
                result.append("\n");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return result;
    }
}
