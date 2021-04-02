package netcracker.task1.humanadress;

/**
 * A class that implements the essence of a human address
 *
 * @autor Bezruk Vladislav
 */
public class Address {
    /**
     * A field that means the human's city address
     */
    private String city;
    /**
     * A field that means the human's street name
     */
    private String street;
    /**
     * A field that means the human's building number
     */
    private int building;
    /**
     * A field that means the human's room number
     */
    private int room;

    /**
     * Constructor - create new object
     *
     * @see Address#Address(String, String, int, int)
     */
    public Address(String city, String street, int building, int room) {
        this.city = city;
        this.street = street;
        this.building = building;
        this.room = room;
    }

    /**
     * Method for getting the field value {@link Address#city}
     *
     * @return returns the human's city address
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Method for getting the field value {@link Address#street}
     *
     * @return returns the human's street name
     */
    public String getStreet() {
        return street;
    }

    /**
     * Method for getting the full human's address
     *
     * @return returns the concatenation of the person's address values
     */
    public String getFullAddress() {
        return "city." + this.city + ", street." + this.street + ", building." + this.building + ", room." + this.room;
    }

    /**
     * Method for getting the field value {@link Address#building}
     *
     * @return returns the human's building number
     */
    public int getBuilding() {
        return building;
    }

    /**
     * Method for getting the field value {@link Address#room}
     *
     * @return returns the human's room number
     */
    public int getRoom() {
        return room;
    }

    /**
     * First name determination procedure {@link Address#city}
     *
     * @param city - new human's city address
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * First name determination procedure {@link Address#street}
     *
     * @param street - new human's street name
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * First name determination procedure {@link Address#building}
     *
     * @param building - new human's building number
     */
    public void setBuilding(int building) {
        this.building = building;
    }

    /**
     * First name determination procedure {@link Address#room}
     *
     * @param room - new human's room number
     */
    public void setRoom(int room) {
        this.room = room;
    }
}