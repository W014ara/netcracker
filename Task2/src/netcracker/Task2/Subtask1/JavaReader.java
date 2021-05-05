package netcracker.Task2.Subtask1;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * The class responsible for the execution of sub-task 1
 *
 * @author Bezruk Vladislav
 */
public class JavaReader {
    private static String createdFileName;
    private static String currentPath = getWorkingPath();

    /**
     * The main method responsible for all the work of the class
     */
    public static void start(String fromJavaPath, String newJavaFileName, String newJavaFilePath) {
        Scanner operation = new Scanner(System.in);
        int choice;
        mainMenu();
        do {
            choice = operation.nextInt();
            switch (choice) {
                //Determine working directory
                case 1:
                    System.out.println(currentPath);
                    mainMenu();
                    break;
                //Determine the name of the created file
                case 2:
                    System.out.println(getFileName());
                    mainMenu();
                    break;
                //Go to the src directory of the project
                case 3:
                    setCurrentPath(getWorkingPath() + "\\src");
                    mainMenu();
                    break;
                //Putting the file together
                case 4:
                    constructJavaFile(fromJavaPath, newJavaFileName, newJavaFilePath);
                    mainMenu();
                    break;
                case 5:
                    System.out.println(readFromFile(createdFileName));
                    mainMenu();
                    break;
                case 6:
                    mainMenu();
                    break;
                case 7:
                    System.out.println("Bye bye");
                    break;
            }
        } while (choice != 7);
    }

    /**
     * Method that displays a menu of available options
     */
    public static void mainMenu() {
        System.out.println("Menu");
        System.out.println("1)Get current directory");
        System.out.println("2)Get current java file");
        System.out.println("3)Go into src directory");
        System.out.println("4)Create new *.java file based on another");
        System.out.println("5)Show created *.java file code");
        System.out.println("6)Show main menu again");
        System.out.println("7)Exit");
    }

    /**
     * Method that returns the current working directory
     *
     * @return returns the current working directory
     */
    public static String getWorkingPath() {
        return Paths.get(".").toAbsolutePath().normalize().toString();
    }

    /**
     * @return returns the generated java source file
     * @see JavaReader#createdFileName
     */
    public static String getFileName() {
        if (createdFileName != null) {
            return createdFileName;
        }
        return "No created file!";
    }

    /**
     * @param newPath sets a new path to the working directory
     * @see JavaReader#currentPath
     */
    public static void setCurrentPath(String newPath) {
        currentPath = newPath;
    }

    /**
     * Collects the file name with the program text into a * .java file
     *
     * @param fromJavaPath    path to the java file from which you want to copy the code
     * @param newJavaFileName new file name
     * @param newJavaFilePath path where the new file will be stored
     */
    public static void constructJavaFile(String fromJavaPath, String newJavaFileName, String newJavaFilePath) {

        try {
            String newLines = readFromFile(fromJavaPath);
            String filePath = newJavaFilePath + "\\" + newJavaFileName + ".java";
            createdFileName = filePath;
            FileWriter writer = new FileWriter(filePath, false);
            writer.write(newLines);
            writer.flush();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method that reads source code from a previously generated file
     *
     * @param filepath path to the created file
     * @return Returns the contents of a file as a string
     */
    public static String readFromFile(String filepath) {
        try {
            File file = new File(filepath);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            StringBuilder result = new StringBuilder();
            while (line != null) {
                result.append(line);
                result.append("\n");
                line = reader.readLine();
            }
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
