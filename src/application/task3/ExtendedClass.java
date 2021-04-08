package application.task3;

/**
 * A special class that has several fields of different types
 * @author Bezruk Vladislav
 */
public class ExtendedClass {
    //main class fields
    byte b;
    int i;
    double d;
    String s;

    /**
     * Constructor - create new object with special values
     * @param b - byte field
     * @param i - int field
     * @param d - double field
     * @param s - String field
     * @see ExtendedClass#ExtendedClass(byte b, int i, double d, String s)
     */
    ExtendedClass(byte b, int i, double d, String s){
        this.b = b;
        this.i = i;
        this.d = d;
        this.s = s;
    }


    /**
     * An Overridden method equals that compares the created object with another
     * @param obj - the object with which to compare the current
     * @return true if the objects are equal and false otherwise
     */
    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        ExtendedClass target = (ExtendedClass) obj;
        return (this.b == target.b) &&
                (this.i == target.i) &&
                (this.d == target.d) &&
                (this.s.equals(target.s));
    }

    /**
     * Overridden method that obtains the hash function of the created object
     * @return int hash function of the created object
     */
    @Override
    public int hashCode() {
        return 31 * b << Double.valueOf(d).hashCode() ^ i + s.hashCode();
    }

    /**
     * Overridden method that performs concatenation of object fields
     * @return String concatenation of object fields
     */
    @Override
    public String toString(){
        return this.b + " " + this.i + " " + this.d + " " + this.s;
    }
}
