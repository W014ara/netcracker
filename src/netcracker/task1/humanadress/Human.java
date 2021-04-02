package netcracker.task1.humanadress;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * A class that implements the essence of a human
 *
 * @autor Bezruk Vladislav
 */
public class Human {
    /**
     * A field that means the human's first name
     */
    private String firstName;
    /**
     * A field that means the human's last name
     */
    private String lastName;
    /**
     * A field that means the human's date of birth (US format like YYYY-MM-DD)
     */
    private String birthDate;
    /**
     * Address field containing the address object
     */
    private Address address;

    /**
     * Constructor - create new object
     *
     * @see Human#Human(String, String, String, Address)
     */
    public Human(String firstName, String lastName, String birthDate, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
    }

    /**
     * Method for getting the field value {@link Human#firstName}
     *
     * @return returns the first name of the human
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method for getting the field value {@link Human#lastName}
     *
     * @return returns the last name of the human
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method for getting the field value {@link Human#birthDate}
     *
     * @return returns the birth date of the human
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Method for getting the full name
     *
     * @return returns the full name (First name, Last name)  of the human
     */
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    /**
     * Method for getting the field value {@link Human#address}
     *
     * @return returns the address  of the human
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Method for getting the age of a person
     *
     * @return int
     */
    public int getAge() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dtTarget = LocalDate.parse(this.getBirthDate(), format);
        return (int) ChronoUnit.YEARS.between(dtTarget, LocalDate.now());
    }

    /**
     * First name determination procedure {@link Human#firstName}
     *
     * @param firstName - new human first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Second name determination procedure {@link Human#lastName}
     *
     * @param lastName - new human second name
     */
    public void setSecondName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Birth data determination procedure {@link Human#birthDate}
     *
     * @param birthDate - new human birth date
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Address determination procedure {@link Human#address}
     *
     * @param address - new human address object
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * The procedure for searching in the generated list of people by last name.
     * Returns the last person found by the specified last name
     * Displays either the found person or a message that the person is missing
     *
     * @param people   - ArrayList of generated people
     * @param lastName - Target last name
     */
    public static void findHumanBySecondName(ArrayList<Human> people, String lastName) {
        Human targetHuman = null;
        for (Human human : people) {
            if (human.getLastName().toLowerCase(Locale.ROOT).equals(lastName.toLowerCase(Locale.ROOT))) {
                targetHuman = human;
            }
        }
        if (targetHuman == null) {
            System.out.println("There is no human with this last name in the system");
        } else {
            System.out.println("Citizen found: " + targetHuman.getFullName());
        }
    }

    /**
     * The search procedure in the generated list of people by the selected city name.
     * Returns the last person found in the list.
     * If there is no such person in the list , the corresponding message is displayed
     *
     * @param people - ArrayList of generated people
     * @param city   - Target city name
     */
    public static void findHumanByCity(ArrayList<Human> people, String city) {
        Human targetHuman = null;
        for (Human human : people) {
            if (human.getAddress().getCity().toLowerCase(Locale.ROOT).equals(city.toLowerCase(Locale.ROOT))) {
                targetHuman = human;
            }
        }
        if (targetHuman == null) {
            System.out.println("There is no person in the system with such a city");
        } else {
            System.out.println("Citizen found: " + targetHuman.getFullName());
        }
    }

    /**
     * The procedure for searching in the generated list of people corresponding to the street.
     * Returns the last person found. Otherwise, it displays an absence message.
     *
     * @param people - ArrayList of generated people
     * @param street - Target street name
     */
    public static void findHumanByStreet(ArrayList<Human> people, String street) {
        Human targetHuman = null;
        for (Human human : people) {
            if (human.getAddress().getStreet().toLowerCase(Locale.ROOT).equals(street.toLowerCase(Locale.ROOT))) {
                targetHuman = human;
            }
        }
        if (targetHuman == null) {
            System.out.println("There is no person in the system whose address contains this street");
        } else {
            System.out.println("Citizen found: " + targetHuman.getFullName());
        }
    }

    /**
     * The procedure for searching in the generated list of people corresponding to build number.
     * Returns the last person found. Otherwise, it displays an absence message.
     *
     * @param people   - ArrayList of generated people
     * @param building - Target building number
     */
    public static void findHumanByBuilding(ArrayList<Human> people, String building) {
        Human targetHuman = null;
        for (Human human : people) {
            if (human.getAddress().getBuilding() == Integer.parseInt(building)) {
                targetHuman = human;
            }
        }
        if (targetHuman == null) {
            System.out.println("There is no person with this building number in the system");
        } else {
            System.out.println("Citizen found: " + targetHuman.getFullName());
        }
    }

    /**
     * The procedure for searching in the generated list of people corresponding to room number.
     * Returns the last person found. Otherwise, it displays an absence message.
     *
     * @param people - ArrayList of generated people
     * @param room   - Target room number
     */
    public static void findHumanByRoom(ArrayList<Human> people, String room) {
        Human targetHuman = null;
        for (Human human : people) {
            if (human.getAddress().getRoom() == Integer.parseInt(room)) {
                targetHuman = human;
            }
        }
        if (targetHuman == null) {
            System.out.println("There is no person with this room number in the system");
        } else {
            System.out.println("Citizen found: " + targetHuman.getFullName());
        }
    }

    /**
     * The procedure for searching for a person in the generated list by the type of address attribute
     *
     * @param people    - ArrayList of generated people
     * @param type      - Attribute type (city, street, building, room)
     * @param typeValue - Attribute type value
     */
    public static void findHumanByAddressAttribute(ArrayList<Human> people, String type, String typeValue) {
        type = type.toLowerCase();
        switch (type) {
            case "city":
                findHumanByCity(people, typeValue);
                break;
            case "street":
                findHumanByStreet(people, typeValue);
                break;
            case "building":
                findHumanByBuilding(people, typeValue);
                break;
            case "room":
                findHumanByRoom(people, typeValue);
                break;
            default:
                System.out.println("This parameter is missing in the human's address");
                break;
        }
    }

    /**
     * A procedure for searching for people born between specified dates.
     * The algorithm is that the number of days between the interval dates must be strictly positive.
     * Otherwise, the person was born in a different time period
     * The method outputs the number of people found, the date of birth of each of them,
     * as well as the age relative to the current date {@link Human#getAge()}
     * Input dates must be in American format (as YYYY-MM-DD)
     *
     * @param people     - ArrayList of generated people
     * @param dateOne    - Source date and end date
     * @param dateSecond - End date
     */
    public static void findPeopleAmongDates(ArrayList<Human> people, String dateOne, String dateSecond) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate dt = LocalDate.parse(dateOne, format);
            LocalDate dt1 = LocalDate.parse(dateSecond, format);
            ArrayList<Human> targetPeople = new ArrayList<>();
            for (Human human : people) {
                String humanDate = human.getBirthDate();
                LocalDate dtTarget = LocalDate.parse(humanDate, format);
                int elapsedDays = (int) ChronoUnit.DAYS.between(dt, dtTarget);
                int elapsedDays_1 = (int) ChronoUnit.DAYS.between(dtTarget, dt1);
                if ((elapsedDays > 0) && (elapsedDays_1) > 0) {
                    targetPeople.add(human);
                }
            }
            if (targetPeople.size() == 0) {
                System.out.println("No such people found!");
            } else {
                System.out.println("Number of people found: " + targetPeople.size());
                for (Human human : targetPeople) {
                    System.out.println(human.getFullName() + ", Date of birth: "
                            + human.getBirthDate() + ", (" + human.getAge() + " years)");
                }
            }
        } catch (Exception e) {
            System.out.println("Error\n" + e);
        }
    }

    /**
     * The procedure for searching in the generated list of the oldest people.
     * The algorithm is similar to finding people born between two dates.
     * However, in this method, we collect all the information in years, put it in a third-party array,
     * and search for the maximum element. After that, in the source array,
     * we output the desired human by the corresponding index
     * <p>
     * Displays the name, date of birth, and age of the oldest human on the screen
     *
     * @param people - ArrayList of generated people
     */
    public static void findElderHuman(ArrayList<Human> people) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate dt = LocalDate.now();
            ArrayList<Integer> peopleYears = new ArrayList<>();
            for (Human human : people) {
                String humanDate = human.getBirthDate();
                LocalDate dtTarget = LocalDate.parse(humanDate, format);
                int elapsedDays = (int) ChronoUnit.YEARS.between(dtTarget, dt);
                peopleYears.add(elapsedDays);
            }
            System.out.println("The oldest human named: " + people.get(getMax(peopleYears).get(0)).getFullName()
                    + "\nHe was born: " + people.get(getMax(peopleYears).get(0)).getBirthDate()
                    + "\nAt the moment, he is " + getMax(peopleYears).get(1) + " years old");
        } catch (Exception e) {
            System.out.println("Error\n" + e);
        }
    }

    /**
     * The procedure for finding people who live on the same street.
     * The algorithm boils down to comparing each person with each other. At the same time,
     * their cities and their streets must match.
     * <p>
     * The method is responsible for checking the equivalence {@link Human#isStreetEquals(Human, Human)}
     *
     * @param people - ArrayList of generated people
     */
    public static void findPeopleByCommonStreet(ArrayList<Human> people) {
        HashMap<String, HashSet<String>> result = new HashMap<>();
        for (int currentIndex = 0; currentIndex < people.size(); ++currentIndex) {
            for (int nextIndex = currentIndex + 1; nextIndex < people.size(); ++nextIndex) {
                if (isStreetEquals(people.get(currentIndex), people.get(nextIndex))) {
                    HashSet<String> currentValue;
                    //If the street key already exists in the HashSet
                    if (result.containsKey(people.get(currentIndex).getAddress().getStreet())) {
                        currentValue = result.get(people.get(currentIndex).getAddress().getStreet());
                        currentValue.add(people.get(currentIndex).getFullName());
                    } else {
                        //Creating new key as street and push new human values
                        currentValue = new HashSet<>();
                        currentValue.add(people.get(currentIndex).getFullName());
                        currentValue.add(people.get(nextIndex).getFullName());
                    }
                    result.put(people.get(currentIndex).getAddress().getStreet(), currentValue);
                }
            }
        }
        if (result.size() == 0) {
            System.out.println("No matches found!");
        } else {
            System.out.println("Matches found: " + result.size());
            System.out.println(result);
        }
    }

    /**
     * Procedure for checking the equivalence of two people on the street
     * {@link Human#findPeopleByCommonStreet(ArrayList)}
     *
     * @param humanOne - The first human object
     * @param humanTwo - The second human object
     * @return - returns the equivalence value
     */
    private static boolean isStreetEquals(Human humanOne, Human humanTwo) {
        return (humanOne.getAddress().getCity().equals(humanTwo.getAddress().getCity())) &&
                (humanOne.getAddress().getStreet().equals(humanTwo.getAddress().getStreet()));
    }

    /**
     * Standard procedure for finding the maximum in an array
     *
     * @param inputArray - The source array
     * @return - Returns an array with the index of the returned element in the first place,
     * and the maximum value in the second place
     */
    private static ArrayList<Integer> getMax(ArrayList<Integer> inputArray) {
        ArrayList<Integer> targetArray = new ArrayList<>();
        int maxValue = inputArray.get(0);
        int maxIndex = 0;
        for (int index = 1; index < inputArray.size(); ++index) {
            if (inputArray.get(index) > maxValue) {
                maxIndex = index;
                maxValue = inputArray.get(index);
            }
        }
        targetArray.add(maxIndex);
        targetArray.add(maxValue);
        return targetArray;
    }
}
