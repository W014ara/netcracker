package netcracker.Task2.Subtask4;

import java.io.*;

/**
 * A class whose only method is to count a character in a file
 *
 * @author Bezruk Vladislav
 */
public class WordCounter {
    /**
     * Method that returns the number of characters in the file
     *
     * @param e        source character to search
     * @param filepath path to the file being searched
     * @return returns the number of matches to the original character
     */
    public static int charFileCounter(char e, String filepath) {
        int chr;
        int result = 0;
        try {
            Reader in = new FileReader(filepath);
            while ((chr = in.read()) != -1) {
                if ((char) chr == e) {
                    result++;
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return result;
    }
}
