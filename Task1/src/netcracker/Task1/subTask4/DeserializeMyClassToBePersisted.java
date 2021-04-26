package netcracker.Task1.subTask4;

import java.io.*;

/**
 * A class that implements a method that reads a serialized file and deserializes it into an instance
 * class MyClassToBePersisted
 *
 * @author Bezruk Vladislav
 */
public class DeserializeMyClassToBePersisted implements Serializable {
    /**
     * Reads a serialized file and deserializes it into an instance class MyClassToBePersisted
     *
     * @param filepath target file path
     * @return new MyClassToBePersisted object
     * @throws IOException
     * @throws ClassNotFoundException
     * @see MyClassToBePersisted
     */
    public static MyClassToBePersisted readFromFile(String filepath) throws IOException, ClassNotFoundException {
        MyClassToBePersisted res = null;
        FileInputStream fis = new FileInputStream(filepath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        boolean isExist = true;
        while (isExist) {
            if (fis.available() != 0) {
                res = (MyClassToBePersisted) ois.readObject();
            } else {
                isExist = false;
            }
        }
        return res;
    }
}
