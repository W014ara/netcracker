package netcracker.basic.task3.task3;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * A class that implements the essence of a human address
 *
 * @autor Bezruk Vladislav
 */
public class Address {

    /**
     * A field that means the human's country name
     */
    private String country;
    /**
     * A field that means the human's region name
     */
    private String region;
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
    private String building;
    /**
     * A field that means the human's housing name
     */
    private String housing;
    /**
     * A field that means the human's room number
     */
    private String room;


    /**
     * Constructor - create new object
     *
     * @see Address#Address(String, String, String, String, String, String, String)
     */
    public Address(String country, String region, String city, String street, String building, String housing, String room) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.building = building;
        this.housing = housing;
        this.room = room;
    }

    /**
     * Method for getting the field value {@link Address#country}
     *
     * @return returns the human's country name
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Method for getting the field value {@link Address#region}
     *
     * @return returns the human's region name
     */
    public String getRegion() {
        return this.region;
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
        return String.format("%s, %s, city.%s, street.%s, building %s/%s, room.%s",
                this.country, this.region, this.city, this.street, this.building, this.housing, this.room);
    }

    /**
     * Method for getting the field value {@link Address#building}
     *
     * @return returns the human's building number
     */
    public String getBuilding() {
        return building;
    }

    /**
     * Method for getting the field value {@link Address#housing}
     *
     * @return returns the human's housing name
     */
    public String getHousing() {
        return this.housing;
    }

    /**
     * Method for getting the field value {@link Address#room}
     *
     * @return returns the human's room number
     */
    public String getRoom() {
        return room;
    }

    /**
     * Country name determination procedure {@link Address#country}
     *
     * @param country - new human's country name
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Region name determination procedure {@link Address#region}
     *
     * @param region - new human's region name
     */
    public void setRegion(String region) {
        this.region = region;
    }


    /**
     * City name determination procedure {@link Address#city}
     *
     * @param city - new human's city name
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Street name determination procedure {@link Address#street}
     *
     * @param street - new human's street name
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Building number determination procedure {@link Address#building}
     *
     * @param building - new human's building number
     */
    public void setBuilding(String building) {
        this.building = building;
    }

    /**
     * Housing number determination procedure {@link Address#housing}
     *
     * @param housing - new human's housing number
     */
    public void setHousing(String housing) {
        this.housing = housing;
    }

    /**
     * Room number determination procedure {@link Address#room}
     *
     * @param room - new human's room number
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * A method that changes the address of a person depending on the parameters of the passed string.
     * In this case, the words in the line are separated by a `,` symbol. Separation by `,` symbol
     *
     * @param address - original address string
     */
    public void setAddressBySplitStandard(String address) {
        String[] target = address.trim().split(",");
        this.country = target[0];
        this.region = target[1];
        this.city = target[2];
        this.street = target[3];
        this.building = target[4];
        this.housing = target[5];
        this.room = target[6];
    }

    /**
     * A method that changes the address of a person depending on the parameters of the passed string.
     * In this case, string parameters can be separated by symbols `,` `;` `.` `-`
     *
     * @param address - original address string
     */
    public void setAddressByStringToken(String address) {
        StringTokenizer tokenizer = new StringTokenizer(address.trim(), ",;.-");
        ArrayList<String> target = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            target.add(token);
        }
        this.country = target.get(0);
        this.region = target.get(1);
        this.city = target.get(2);
        this.street = target.get(3);
        this.building = target.get(4);
        this.housing = target.get(5);
        this.room = target.get(6);
    }
}