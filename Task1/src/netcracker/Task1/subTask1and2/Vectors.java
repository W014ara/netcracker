package netcracker.Task1.subTask1and2;

import java.io.*;
import java.util.ArrayList;

/**
 * Vector class
 *
 * @author Bezruk Vladislav
 */
public class Vectors implements Serializable {

    private ArrayList<Double> vector;
    private Double vectorSize;

    /**
     * Class constructor
     *
     * @param vectorSize Original vector size
     * @param vector     Vector elements
     */
    public Vectors(Double vectorSize, ArrayList<Double> vector) {
        if (vectorSize == (double) vector.size()) {
            this.vectorSize = vectorSize;
            this.vector = vector;
        } else {
            System.out.println("Vector size does not match the number of elements ");
        }
    }

    /**
     * Method for getting a vector as an array
     *
     * @return returns a complete representation of a vector, the first element of which is its dimension,
     * and the rest are the elements of the vector
     */
    public ArrayList<Double> getVector() {
        ArrayList<Double> result = new ArrayList<>();
        result.add(this.vectorSize);
        for (int index = 0; index < this.vectorSize; ++index) {
            result.add(this.vector.get(index));
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(this.getVectorSize().toString());
        for (Double el : this.getVectorElements()) {
            result.append(" ").append(el);
        }
        return result.toString();
    }

    /**
     * Method for obtaining the dimension of a vector
     *
     * @return Returns the dimension of a vector (Double)
     */
    public Double getVectorSize() {
        return this.vectorSize;
    }

    /**
     * Method that returns all elements of the vector
     *
     * @return Returns all elements of the vector (ArrayList<Double>)
     */
    public ArrayList<Double> getVectorElements() {
        return this.vector;
    }

    /**
     * Static method for performing the procedure of multiplying a vector by a scalar (number)
     *
     * @param vec   The original vector, the first parameter of which defines its dimension
     * @param digit Scalar value by which to multiply the vector
     * @return - Returns a modified vector that is an ArrayList<Double>, the first element of which is its dimension
     */
    public static Vectors vectorScalar(Vectors vec, Double digit) {
        if (vec != null) {
            if ((vec.getVectorSize() - vec.getVectorElements().size()) == 0) {
                for (int index = 0; index < vec.getVectorElements().size(); ++index) {
                    vec.getVectorElements().set(index, vec.getVectorElements().get(index) * digit);
                }
            } else {
                System.out.println("The dimension of the vector does not match the number of elements ");
            }
        }
        assert vec != null;
        return vec;
    }

    /**
     * A method that implements the logic of adding two vectors
     *
     * @param vec1 the original first vector, the first element must be the size of the current vector
     *             (example: [1.0,1.0], [3.0,1.0,2.0,3.0] and so on)
     * @param vec2 the original second vector, the first element must be the size of the current vector
     *             (example: [1.0,1.0], [3.0,1.0,2.0,3.0] and so on)
     * @return returns a new array, the first element of which is the size of the new vector
     * (matches the size of any of the input parameters)
     */
    public static Vectors vectorAddition(Vectors vec1, Vectors vec2) {
        ArrayList<Double> result = new ArrayList<>();
        if (vec1 != null && vec2 != null) {
            double vec1SizeCheck = vec1.getVectorSize() - vec1.getVectorElements().size();
            double vec2SizeCheck = vec2.getVectorSize() - vec2.getVectorElements().size();
            if (vec1.getVectorSize().equals(vec2.getVectorSize()) && (vec1SizeCheck == 0) && (vec2SizeCheck == 0)) {
                for (int index = 0; index < vec1.getVectorSize(); ++index) {
                    result.add(vec1.getVectorElements().get(index) + vec2.getVectorElements().get(index));
                }
            } else {
                System.out.println("An error occurred with adding vectors. Possible reasons are as follows.\n" +
                        "1) The dimension of both vectors must be the same\n" +
                        "2) The dimension of one of the vectors does not correspond to the number of internal elements ");
            }

        }
        assert vec1 != null;
        return new Vectors(vec1.getVectorSize(), result);
    }


    /**
     * A method that performs the operation of the dot product of two vectors
     *
     * @param vec1 the original first vector, the first element must be the size of the current vector
     *             (example: [1.0,1.0], [3.0,1.0,2.0,3.0] and so on)
     * @param vec2 the original second vector, the first element must be the size of the current vector
     *             (example: [1.0,1.0], [3.0,1.0,2.0,3.0] and so on)
     * @return - returns a number that is the result of the dot product of two vectors
     */
    public static Double dotVectorsProduct(Vectors vec1, Vectors vec2) {
        double result = 0.0;
        if (vec1 != null && vec2 != null) {
            double vec1SizeCheck = vec1.getVectorSize() - vec1.getVectorElements().size();
            double vec2SizeCheck = vec2.getVectorSize() - vec2.getVectorElements().size();
            if (vec1.getVectorSize().equals(vec2.getVectorSize()) && (vec1SizeCheck == 0) && (vec2SizeCheck == 0)) {
                for (int index = 0; index < vec1.getVectorSize(); ++index) {
                    result = result + vec1.getVectorElements().get(index) * vec2.getVectorElements().get(index);
                }
            } else {
                System.out.println("An error occurred with adding vectors. Possible reasons are as follows.\n" +
                        "1) The dimension of both vectors must be the same\n" +
                        "2) The dimension of one of the vectors does not correspond to the number of internal elements ");
            }

        }
        return result;
    }

    /**
     * A method that implements writing a vector to a byte stream
     *
     * @param v   the original vector
     * @param out byte stream of output
     * @throws IOException
     */
    public static void outputVector(Vectors v, OutputStream out) throws IOException {
        ArrayList<Double> vec = new ArrayList<>();
        vec.add(v.getVectorSize());
        vec.addAll(v.getVectorElements());
        byte[] buffer = new byte[vec.size()];
        for (int i = 0; i < vec.size(); i++) {
            buffer[i] = vec.get(i).byteValue();
        }
        try {
            out.write(buffer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Simple example
        byte[] array = ((ByteArrayOutputStream) out).toByteArray();
        for (byte b: array) {
            System.out.println((double) b);
        }
    }

    /**
     * A method that implements reading a vector from a byte stream
     *
     * @param in get data from a byte array
     * @return returns a new vector object
     * @throws IOException
     */
    public static Vectors inputVector(InputStream in) throws IOException {
        byte[] array = in.readAllBytes();
        ArrayList<Double> resVecList = new ArrayList<>();
        for (byte b : array) {
            resVecList.add((double) b);
        }
        return new Vectors(resVecList.get(0), new ArrayList<>(resVecList.subList(1, resVecList.size())));
    }

    /**
     * Performs symbolic writing of the source vector
     *
     * @param v   original vector
     * @param out provides support for character stream writing in the same way as it does OutPutStream
     * @throws IOException
     */
    public static void writeVector(Vectors v, Writer out) throws IOException {
        String vecStr = v.toString();
        BufferedWriter bw = new BufferedWriter(out);
        out.write(vecStr);
        out.close();
    }

    /**
     * Method for reading a vector from a character stream
     *
     * @param in provides support for character stream
     * @return returns a new vector object
     * @throws IOException
     */
    public static Vectors readVector(Reader in) throws IOException {
        ArrayList<Double> result = new ArrayList<>();
        in = new InputStreamReader(System.in);
        while (in.read() != -1) {
            result.add(Double.parseDouble(String.valueOf(in.read())));
        }
        return new Vectors(result.get(0), new ArrayList<>(result.subList(1, result.size())));
    }
}
