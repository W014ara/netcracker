package netcracker.basic.task3.task3;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * A test class created specifically for test generation of addresses and validation
 * of data parsing is configured in these lines.
 *
 * @autor Bezruk Vladislav
 */
public class JTest {

    /**
     * The main method for testing data in two formats.
     * The standard testing format is to generate a string with data separated by ",".
     * If the type token is entered, a data string is generated with any of the set of delimiters.
     *
     * @param type - a string parameter that specifies the type of data generation.
     *             When you enter the "token" parameter, the string is generated using random delimiters.
     *             Otherwise, the "," sign is used.
     * @see Generator
     * @see Generator#generateStringStandardAddress()
     * @see Generator#generateStringAddressWithDifferentTokens()
     */
    public static void testAddress(String type) {
        Scanner in = new Scanner(System.in);
        System.out.println("How many address should be generated?");
        int addCount = in.nextInt();
        ArrayList<Address> addresses = new ArrayList<>();
        ArrayList<String> addresses_strings = new ArrayList<>();
        for (int index = 0; index < addCount; ++index) {
            addresses.add(new Generator().generateAddress());
        }
        System.out.println("Generated addresses:");
        showAddresses(addresses);
        System.out.println("--------------------------");
        if (type.toLowerCase(Locale.ROOT).equals("token")) {
            generateStringByTokenWay(addresses_strings, addCount);
        } else {
            generateStringByStandardWay(addresses_strings, addCount);
        }
        System.out.println("Generated addresses strings:");
        showAddressesStrings(addresses_strings);
        System.out.println("--------------------------");
        setNewAddrByStringArray(addresses, addresses_strings);
        System.out.println("New addresses:");
        showAddresses(addresses);
    }

    /**
     * Method showing the generated Address object
     *
     * @param addresses - an array containing an object of type Address
     * @see Address#Address(String, String, String, String, String, String, String)
     */
    public static void showAddresses(ArrayList<Address> addresses) {
        for (Address adr : addresses) {
            System.out.println(adr.getFullAddress());
        }
    }

    /**
     * Method showing generated address strings
     *
     * @param addresses_strings - Array of generated new address strings
     */
    public static void showAddressesStrings(ArrayList<String> addresses_strings) {
        for (String adr_str : addresses_strings) {
            System.out.println(adr_str);
        }
    }

    /**
     * Method setting new data based on generated rows
     *
     * @param addresses         - an array containing an object of type Address
     * @param addresses_strings - Array of generated new address strings
     * @see Generator#generateStringAddressWithDifferentTokens()
     */
    public static void setNewAddrByStringArray(ArrayList<Address> addresses, ArrayList<String> addresses_strings) {
        for (int index = 0; index < addresses.size(); ++index) {
            addresses.get(index).setAddressByStringToken(addresses_strings.get(index));
        }
    }

    /**
     * Generating an array of address strings. The data in the string is separated by the character ','
     *
     * @param addresses_strings - Array of generated new address strings
     * @param addCount          - number of generated rows
     */
    public static void generateStringByStandardWay(ArrayList<String> addresses_strings, int addCount) {
        for (int index = 0; index < addCount; ++index) {
            addresses_strings.add(new Generator().generateStringStandardAddress());
        }
    }

    /**
     * Generating an array of address strings. The data in the string is separated by the character of list
     *
     * @param addresses_strings - Array of generated new address strings
     * @param addCount          - number of generated rows
     * @see Generator
     */
    public static void generateStringByTokenWay(ArrayList<String> addresses_strings, int addCount) {
        for (int index = 0; index < addCount; ++index) {
            addresses_strings.add(new Generator().generateStringAddressWithDifferentTokens());
        }
    }
}
