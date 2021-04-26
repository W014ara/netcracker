package netcracker.Task1;

import netcracker.Task1.subTask1and2.Vectors;
import netcracker.Task1.subTask3.ArrayVector;
import netcracker.Task1.subTask3.LinkedListVector;
import netcracker.Task1.subTask4.DeserializeMyClassToBePersisted;
import netcracker.Task1.subTask4.SerializeMyClassToBePersisted;

import java.io.*;
import java.util.*;

/**
 * Main program's class
 * @author Bezruk Vladislav
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Task1
        double[] vector1elems = {1.0, 2.0, 3.0};
        double[] vector2elems = {3.0, 4.0, 5.0};
        double[] vector3elems = {10.0, 5.0, 7.0};
        Vectors vec1 = new Vectors(3.0, arrayToArrayList(vector1elems));
        Vectors vec2 = new Vectors(3.0, arrayToArrayList(vector2elems));
        Vectors vec3 = new Vectors(3.0, arrayToArrayList(vector3elems));
        System.out.println(Vectors.vectorScalar(vec1, 2.0)); //->[3.0, 2.0, 4.0, 6.0]
        System.out.println(Vectors.vectorAddition(vec1, vec2)); //->[3.0, 4.0, 6.0, 8.0]
        System.out.println(Vectors.dotVectorsProduct(vec1, vec2)); //->26;
        //Task2
        Vectors.outputVector(vec1, new ByteArrayOutputStream());
        //Task3
        Vectors[] vecArr = {vec1, vec2};
        Vectors[] vecArr0 = {vec3};
        //Create arrayVectors
        ArrayVector arrayVector = new ArrayVector(vecArr);
        ArrayVector arrayVector0 = new ArrayVector(vecArr0);
        //Create LinkedListVectors
        LinkedList<Vectors> linkList = new LinkedList<>(Arrays.asList(vecArr));
        LinkedList<Vectors> linkList0 = new LinkedList<>(Arrays.asList(vecArr0));
        LinkedListVector lLinked = new LinkedListVector(linkList);
        LinkedListVector lLinked0 = new LinkedListVector(linkList0);

        System.out.println("Compare different array vectors:");
        System.out.println(arrayVector.equals(arrayVector0));
        arrayVector.writeToFile("test.bin");
        System.out.println("Compare original array and array from file:");
        System.out.println(arrayVector.equals(arrayVector.readFromFile("test.bin")));

        System.out.println("Compare different linklist vectors:");
        System.out.println(lLinked.equals(lLinked0));
        lLinked.writeToFile("test.txt");
        System.out.println("Compare original linklist and linklist from file:");
        System.out.println(lLinked.equals(lLinked.readFromFile("test.bin")));

        //Task4
        System.out.println("Task4");
        SerializeMyClassToBePersisted.writeMyClassToFile("test4.bin", "fio", "lio");
        System.out.println(DeserializeMyClassToBePersisted.readFromFile("test4.bin"));
    }

    /**
     * Method of converting an array of type double to an ArrayList <Double>
     * @param arr original double array
     * @return new ArrayList <Double>
     */
    public static ArrayList<Double> arrayToArrayList(double[] arr){
        ArrayList<Double> array_list = new ArrayList<>();
        for(double el: arr){
            array_list.add(el);
        }
        return array_list;
    }
}

