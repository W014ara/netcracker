package netcracker.task1.humanadress;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Human {
    private String firstName;
    private String secondName;
    private String birthDate;
    private Address address;

    public Human(String firstName, String secondName, String birthDate, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getFullName() {
        return this.firstName + " " + this.secondName;
    }

    public Address getAddress() {
        return address;
    }

    public int getAge() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dtTarget = LocalDate.parse(this.getBirthDate(), format);
        return (int) ChronoUnit.YEARS.between(dtTarget, LocalDate.now());
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static void findHumanBySecondName(ArrayList<Human> people, String secondName) {
        Human targetHuman = null;
        for (Human human : people) {
            if (human.getSecondName().equals(secondName)) {
                targetHuman = human;
            }
        }
        if (targetHuman == null) {
            System.out.println("В системе нет человека с такой фамилией");
        } else {
            System.out.println("Найден гражданин: " + targetHuman.getFullName());
        }
    }

    public static void findHumanByCity(ArrayList<Human> people, String city) {
        Human targetHuman = null;
        for (Human human : people) {
            if (human.getAddress().getCity().toLowerCase(Locale.ROOT).equals(city.toLowerCase(Locale.ROOT))) {
                targetHuman = human;
            }
        }
        if (targetHuman == null) {
            System.out.println("В системе нет человека с таким городом");
        } else {
            System.out.println("Найден гражданин: " + targetHuman.getFullName());
        }
    }

    public static void findHumanByStreet(ArrayList<Human> people, String street) {
        Human targetHuman = null;
        for (Human human : people) {
            if (human.getAddress().getStreet().equals(street)) {
                targetHuman = human;
            }
        }
        if (targetHuman == null) {
            System.out.println("В системе нет человека с такой улицей");
        } else {
            System.out.println("Найден гражданин: " + targetHuman.getFullName());
        }
    }

    public static void findHumanByBuilding(ArrayList<Human> people, String building) {
        Human targetHuman = null;
        for (Human human : people) {
            if (human.getAddress().getBuilding() == Integer.parseInt(building)) {
                targetHuman = human;
            }
        }
        if (targetHuman == null) {
            System.out.println("В системе нет человека с такой улицей");
        } else {
            System.out.println("Найден гражданин: " + targetHuman.getFullName());
        }
    }

    public static void findHumanByRoom(ArrayList<Human> people, String room) {
        Human targetHuman = null;
        for (Human human : people) {
            if (human.getAddress().getRoom() == Integer.parseInt(room)) {
                targetHuman = human;
            }
        }
        if (targetHuman == null) {
            System.out.println("В системе нет человека с такой квартирой");
        } else {
            System.out.println("Найден гражданин: " + targetHuman.getFullName());
        }
    }

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
                System.out.println("Нет такого параметра");
                break;
        }
    }

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
                System.out.println("Не найдено таких людей!");
            } else {
                System.out.println("Надено количество людей: " + targetPeople.size());
                for (Human human : targetPeople) {
                    System.out.println(human.getFullName() + ", Дата рождения: "
                            + human.getBirthDate() + ", (" + human.getAge() + " лет)");
                }
            }
        } catch (Exception e) {
            System.out.println("Error\n" + e);
        }
    }

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
            System.out.println("Самый старый человек с именем: " + people.get(getMax(peopleYears).get(0)).getFullName()
                    + "\nОн был рожден: " + people.get(getMax(peopleYears).get(0)).getBirthDate()
                    + "\nНа данный момент ему " + getMax(peopleYears).get(1) + " лет");
        } catch (Exception e) {
            System.out.println("Error\n" + e);
        }
    }

    public static void findPeopleByCommonStreet(ArrayList<Human> people) {
        HashMap<String, HashSet<String>> result = new HashMap<>();
        for (int currentIndex = 0; currentIndex < people.size(); ++currentIndex) {
            for (int nextIndex = currentIndex + 1; nextIndex < people.size(); ++nextIndex) {
                if (isStreetEquals(people.get(currentIndex), people.get(nextIndex))) {
                    HashSet<String> currentValue;
                    if (result.containsKey(people.get(currentIndex).getAddress().getStreet())) {
                        currentValue = result.get(people.get(currentIndex).getAddress().getStreet());
                        currentValue.add(people.get(currentIndex).getFullName());
                    } else {
                        currentValue = new HashSet<>();
                        currentValue.add(people.get(currentIndex).getFullName());
                        currentValue.add(people.get(nextIndex).getFullName());
                    }
                    result.put(people.get(currentIndex).getAddress().getStreet(), currentValue);
                }
            }
        }
        if (result.size() == 0) {
            System.out.println("Совпадений не найдено!");
        } else {
            System.out.println("Найдено совпадений: " + result.size());
            System.out.println(result);
        }
    }

    private static boolean isStreetEquals(Human humanOne, Human humanTwo) {
        return (humanOne.getAddress().getCity().equals(humanTwo.getAddress().getCity())) &&
                (humanOne.getAddress().getStreet().equals(humanTwo.getAddress().getStreet()));
    }

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
