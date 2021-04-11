package netcracker.basic.task3.task4;

/**
 * Class that implements the shirt description entity
 *
 * @author Bezruk Vladislav
 */
public class Shirt {

    private String id;
    private String description;
    private String color;
    private String size;

    /**
     * Shirt class constructor
     *
     * @param id          - shirt id
     * @param description - shirt description
     * @param color       - shirt color
     * @param size        - shirt size
     * @see Shirt#id
     * @see Shirt#description
     * @see Shirt#color
     * @see Shirt#size
     */
    public Shirt(String id, String description, String color, String size) {
        this.id = id;
        this.description = description;
        this.color = color;
        this.size = size;
    }

    /**
     * Displays the explanation and meaning of the fields line by line
     *
     * @return - return the explanation and meaning of the fields line by line
     * @see Shirt#id
     * @see Shirt#description
     * @see Shirt#color
     * @see Shirt#size
     */
    @Override
    public String toString() {
        return String.format("id:%s\ndescription:%s\ncolor:%s\nsize:%s\n",
                this.id, this.description, this.color, this.size);
    }
}
