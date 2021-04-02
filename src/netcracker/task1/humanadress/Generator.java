package netcracker.task1.humanadress;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Generator {
    private final String[] names = {"Alex", "James", "Ivan", "Sergey", "Vladislav", "Vyacheslav", "Igor", "Mark"};
    private final String[] secondnames = {"Petrenko", "Sanchenkov", "Marchenko", "Aliev", "Kastruba", "Sidorov",
            "Ivanov", "Yun"};

    private final String[] cities = {"Moscow", "Novgorod", "New York", "London", "Kyoto", "Shanghai"};
    private final String[] streets = {"Pushkina", "Usachova", "Beer street", "Crown street"};

    public Human generateHuman() {
        String randomName = names[(int) (Math.random() * (this.names.length))];
        String randomSecondName = secondnames[(int) (Math.random() * (this.secondnames.length))];
        String birthDate = this.randomDate();

        String randomCity = cities[(int) (Math.random() * (this.cities.length))];
        String randomStreet = streets[(int) (Math.random() * (this.streets.length))];
        int randomBuilding = (int) (Math.random() * ((100 - 1) + 1)) + 1;
        int randomRoom = (int) (Math.random() * ((100 - 1) + 1)) + 1;

        Address randomAddress = new Address(randomCity, randomStreet, randomBuilding, randomRoom);
        return new Human(randomName, randomSecondName, birthDate, randomAddress);
    }

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

    private String randomDate() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        return String.valueOf(LocalDate.ofEpochDay(randomDay));
    }
}
