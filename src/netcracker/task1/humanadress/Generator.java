package netcracker.task1.humanadress;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Auxiliary class that generates a list of people
 *
 * @autor Bezruk Vladislav
 */
public class Generator {

    /**
     * A field that stores an array of people's first names
     */
    private final String[] names = {"Alex", "James", "Ivan", "Sergey", "Vladislav", "Vyacheslav", "Igor", "Mark"};
    /**
     * A field that stores an array of people's last names
     */
    private final String[] lastNames = {"Petrenko", "Sanchenkov", "Marchenko", "Aliev", "Kastruba", "Sidorov",
            "Ivanov", "Yun"};

    /**
     * A field that stores an array of people's city address
     */
    private final String[] cities = {"Moscow", "Novgorod", "New York", "London", "Kyoto", "Shanghai"};
    /**
     * A field that stores an array of people's street name
     */
    private final String[] streets = {"Pushkina", "Usachova", "Beer street", "Crown street"};

    /**
     * Procedure for creating a person object with a random set of data
     *
     * @return - returns a new human entity object with a random set of data
     */
    public Human generateHuman() {
        String randomName = names[(int) (Math.random() * (this.names.length))];
        String randomSecondName = lastNames[(int) (Math.random() * (this.lastNames.length))];
        String birthDate = this.randomDate();

        String randomCity = cities[(int) (Math.random() * (this.cities.length))];
        String randomStreet = streets[(int) (Math.random() * (this.streets.length))];
        int randomBuilding = (int) (Math.random() * ((100 - 1) + 1)) + 1;
        int randomRoom = (int) (Math.random() * ((100 - 1) + 1)) + 1;

        Address randomAddress = new Address(randomCity, randomStreet, randomBuilding, randomRoom);
        return new Human(randomName, randomSecondName, birthDate, randomAddress);
    }

    /**
     * Procedure for generating an array of human entities, with a random set of data
     *
     * @return - returns an array of human entities, with a random set of data
     */
    public static ArrayList<Human> generatePeople() {
        ArrayList<Human> people = new ArrayList<>();
        int peopleCount;
        System.out.println("Сколько людей сгенерировать?");
        Scanner peopleCountScanner = new Scanner(System.in);
        peopleCount = peopleCountScanner.nextInt();
        for (int index = 0; index < peopleCount; ++index) {
            people.add(new Generator().generateHuman());
        }
        return people;
    }

    /**
     * The procedure for generating a random date in the American format.
     * In this case, the date range starts with 1900-01-01 and ends with 2021-01-01
     *
     * @return - Returns a random date
     */
    private String randomDate() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2021, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        return String.valueOf(LocalDate.ofEpochDay(randomDay));
    }
}
