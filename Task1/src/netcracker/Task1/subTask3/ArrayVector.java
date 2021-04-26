package netcracker.Task1.subTask3;

import netcracker.Task1.subTask1and2.Vectors;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * A class that implements the structure of an array of vectors (serializable)
 *
 * @author Bezruk Vladislav
 */
public class ArrayVector implements Serializable {
    private Vectors[] vecArr;

    /**
     * Constructor
     *
     * @param vecArr original vector's array
     */
    public ArrayVector(Vectors[] vecArr) {
        this.vecArr = vecArr;
    }

    /**
     * A method that displays all the components of an array vector
     */
    public void printAllVectors() {
        for (Vectors vectors : this.vecArr) {
            System.out.print(vectors.getVector() + " ");
        }
        System.out.print("\n");
    }

    /**
     * A method that implements the byte writing of an array of vectors to a file
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
        for (Vectors el : this.vecArr) {
            oos.writeObject(el);
        }
        oos.close();
        fos.close();
    }

    /**
     * @param filename path to the file from which to read the array
     * @return returns a new vector array object
     * @throws IOException
     * @throws ClassNotFoundException
     * @see ArrayVector#writeToFile(String)
     * Reverse operation of reading a vector array from a file
     */
    public ArrayVector readFromFile(String filename) throws IOException, ClassNotFoundException {
        ArrayList<Vectors> preResult = new ArrayList<>();
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
        Vectors[] result = new Vectors[preResult.size()];
        for (int index = 0; index < result.length; ++index) {
            result[index] = preResult.get(index);
        }
        return new ArrayVector(result);
    }

    /**
     * An overridden method for the equivalence of two vector array objects.
     * The comparison is carried out in the following way: the length of each of the compared arrays is compared,
     * after which the element-by-element comparison of the coordinates of each of the vectors is performed
     *
     * @param obj Vector array object to compare
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
        ArrayVector targetObj = (ArrayVector) obj;
        if (this.vecArr.length == targetObj.vecArr.length) {
            for (int index = 0; index < this.vecArr.length; ++index) {
                if (this.vecArr[index].getVectorSize().equals(targetObj.vecArr[index].getVectorSize())) {
                    if (this.vecArr[index].getVectorElements().equals(targetObj.vecArr[index].getVectorElements())) {
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
