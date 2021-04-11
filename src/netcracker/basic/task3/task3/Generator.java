package netcracker.basic.task3.task3;

/**
 * Auxiliary class that generates a list of people
 *
 * @autor Bezruk Vladislav
 */
public class Generator {

    /**
     * A field that stores an array of people's countries names
     */
    private final String[] countries = {"Russia", "USA", "United Kingdom", "Ukraine", "China", "Japan", "Greece"};
    /**
     * A field that stores an array of people's region names
     */
    private final String[] regions = {"California", "Kowloon", "Moscow region", "Volgograd region", "Cigar", "Changchun", "Salonika"};
    /**
     * A field that stores an array of people's city address
     */
    private final String[] cities = {"Moscow", "Novgorod", "New York", "London", "Kyoto", "Shanghai"};
    /**
     * A field that stores an array of people's street name
     */
    private final String[] streets = {"Pushkina", "Usachova", "Beer", "Crown"};

    /**
     * A field that stores an array of address delimiters
     */
    private final String[] delimiters = {",", ";", "-", "."};

    /**
     * Procedure for creating a random address
     *
     * @return - returns a new random Address object
     */
    public Address generateAddress() {
        return new Address(getRandomCountry(), getRandomRegion(), getRandomCity(), getRandomStreet(),
                getRandomDigit(), getRandomHousing(), getRandomDigit());
    }

    /**
     * Procedure for creating a random country
     *
     * @return - returns a new random country string
     * @see Generator#countries
     */
    private String getRandomCountry() {
        return countries[(int) (Math.random() * (this.countries.length))];
    }

    /**
     * Procedure for creating a random region
     *
     * @return - returns a new random region string
     * @see Generator#regions
     */
    private String getRandomRegion() {
        return regions[(int) (Math.random() * (this.regions.length))];
    }

    /**
     * Procedure for creating a random city
     *
     * @return - returns a new random city string
     * @see Generator#cities
     */
    private String getRandomCity() {
        return cities[(int) (Math.random() * (this.cities.length))];
    }

    /**
     * Procedure for creating a random street
     *
     * @return - returns a new random street string
     * @see Generator#streets
     */
    private String getRandomStreet() {
        return streets[(int) (Math.random() * (this.streets.length))];
    }

    /**
     * Procedure for creating a random digit to create an random building
     *
     * @return - returns a new random digit
     */
    private String getRandomDigit() {
        return String.format("%d", (int) ((Math.random() * ((100 - 1) + 1)) + 1));
    }

    /**
     * Procedure for creating a random housing letter
     *
     * @return - returns a new random housing string
     */
    private String getRandomHousing() {
        return String.format("%s", (char) ('a' + Math.random() * ('z' - 'a' + 1)));
    }

    /**
     * Procedure for creating a random delimiter from list
     *
     * @return - returns a new random delimiter string
     * @see Generator#delimiters
     */
    private String getRandomDelimiter() {
        return delimiters[(int) (Math.random() * (this.delimiters.length))];
    }


    /**
     * GGeneration of a standard address bar. A set of characters acts as a separator: `,` `-` `;` `.`
     *
     * @return - returns a new random address string
     */
    public String generateStringAddressWithDifferentTokens() {
        return String.format("%s%s%s%s%s%s%s%s%s%s%s%s%s",
                getRandomCountry(), getRandomDelimiter(), getRandomRegion(), getRandomDelimiter(),
                getRandomCity(), getRandomDelimiter(), getRandomStreet(), getRandomDelimiter(),
                getRandomDigit(), getRandomDelimiter(), getRandomHousing(), getRandomDelimiter(), getRandomDigit());
    }

    /**
     * Generation of a standard address bar. The symbol is used as a separator `,`
     *
     * @return - returns a new random address string
     */
    public String generateStringStandardAddress() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                getRandomCountry(), getRandomRegion(), getRandomCity(), getRandomStreet(),
                getRandomDigit(), getRandomHousing(), getRandomDigit());
    }

}
