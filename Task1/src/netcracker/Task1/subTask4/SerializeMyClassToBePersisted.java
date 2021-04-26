package netcracker.Task1.subTask4;


import java.io.*;
import java.nio.file.Files;

/**
 * The class, the main method of which, creates an instance of the
 * MyClassToBePersisted class and serializes it to a file
 *
 * @author Bezruk Vladislav
 */
public class SerializeMyClassToBePersisted implements Serializable {

    /**
     * @param filepath target file path
     * @param profile  target object profile name
     * @param group    target object group name
     * @throws IOException
     * @see MyClassToBePersisted
     * creates an instance of the class MyClassToBePersisted and serializes it to a file
     */
    public static void writeMyClassToFile(String filepath, String profile, String group) throws IOException {
        File file = new File(filepath);
        Files.deleteIfExists(file.toPath());
        FileOutputStream fos = new FileOutputStream(filepath);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        MyClassToBePersisted obj = new MyClassToBePersisted(profile, group);
        oos.writeObject(obj);
        oos.close();
        fos.close();
    }
}
