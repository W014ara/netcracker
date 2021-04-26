package netcracker.Task1.subTask3;

import netcracker.Task1.subTask1and2.Vectors;

import java.io.*;
import java.nio.file.Files;
import java.util.LinkedList;

/**
 * A class that implements the structure of an LinkedList of vectors (serializable)
 *
 * @author Bezruk Vladislav
 */
public class LinkedListVector implements Serializable {
    private LinkedList<Vectors> vecLList;

    /**
     * Constructor
     *
     * @param vecLList original vector's LinkedList
     */
    public LinkedListVector(LinkedList<Vectors> vecLList) {
        this.vecLList = vecLList;
    }

    /**
     * A method that implements the byte writing of an LinkedList of vectors to a file
     * (with the subsequent rewriting of the file, there is no additional writing)
     *
     * @param filename path to file
     * @throws IOException
     */
    public void writeToFile(String filename) throws IOException {
        File file = new File(filename);
        Files.deleteIfExists(file.toPath());
        FileOutputStream fos = new FileOutputStream(new File(filename));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Vectors el : this.vecLList) {
            oos.writeObject(el);
        }
        oos.close();
        fos.close();
    }

    /**
     * @param filename path to the file from which to read the LinkedList
     * @return returns a new vector LinkedList object
     * @throws IOException
     * @throws ClassNotFoundException
     * @see LinkedListVector#writeToFile(String)
     * Reverse operation of reading a vector LinkedList from a file
     */
    public LinkedListVector readFromFile(String filename) throws IOException, ClassNotFoundException {
        LinkedList<Vectors> preResult = new LinkedList<>();
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        boolean isExist = true;
        while (isExist) {
            if (fis.available() != 0) {
                Vectors obj = (Vectors) ois.readObject();
                preResult.add(obj);
            } else {
                isExist = false;
            }
        }
        return new LinkedListVector((preResult));
    }

    /**
     * An overridden method for the equivalence of two vector LinkedList objects.
     * The comparison is carried out in the following way: the length of each of the compared LinkedLists is compared,
     * after which the element-by-element comparison of the coordinates of each of the vectors is performed
     *
     * @param obj Vector LinkedList object to compare
     * @return compare result
     */
    @Override
    public boolean equals(Object obj) {
        boolean res = false;
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        LinkedListVector targetObj = (LinkedListVector) obj;
        if (this.vecLList.size() == targetObj.vecLList.size()) {
            for (int index = 0; index < this.vecLList.size(); ++index) {
                if (this.vecLList.get(index).getVectorSize().equals(targetObj.vecLList.get(index).getVectorSize())) {
                    if (this.vecLList.get(index).getVectorElements().equals(targetObj.vecLList.get(index).getVectorElements())) {
                        res = true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        return res;
    }
}
