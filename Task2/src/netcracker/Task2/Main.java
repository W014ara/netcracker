package netcracker.Task2;

import netcracker.Task2.Subtask1.JavaReader;
import netcracker.Task2.Subtask2.BinaryFileReader;
import netcracker.Task2.Subtask3.JavaDocReader;
import netcracker.Task2.Subtask4.WordCounter;

import java.io.IOException;

/**
 * Main program's class
 *
 * @author Bezruk Vladislav
 */
public class Main {
    //Main method
    public static void main(String[] args) throws IOException {
        //Task 1
//        JavaReader.start("C:\\xampp\\htdocs\\___www\\__netcracker\\JavaSE\\Task2\\src\\netcracker\\Task2\\Main.java",
//                "Task1",
//                "C:\\xampp\\htdocs\\___www\\__netcracker\\JavaSE\\Task2\\src\\netcracker\\Task2");

        //Task 2
//        BinaryFileReader.start("task2.txt");

        //Task 3
//        JavaDocReader.start("Java Documentation.txt","task3.txt");

        //Task 4
        System.out.println(WordCounter.charFileCounter('e',"task4.txt"));
    }
}
