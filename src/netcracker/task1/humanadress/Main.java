package netcracker.task1.humanadress;

import java.util.ArrayList;

//Importing static methods from other classes
import static netcracker.task1.humanadress.Generator.generatePeople;
import static netcracker.task1.humanadress.Human.findHumanBySecondName;
import static netcracker.task1.humanadress.Human.findHumanByAddressAttribute;
import static netcracker.task1.humanadress.Human.findPeopleAmongDates;
import static netcracker.task1.humanadress.Human.findElderHuman;
import static netcracker.task1.humanadress.Human.findPeopleByCommonStreet;

/**
 * The main class of the program package is the address of the person
 *
 * @autor Bezruk Vladislav
 */
public class Main {
    //Main function
    public static void main(String[] args) {
        ArrayList<Human> people = generatePeople();
        //Task_1
        System.out.println("Task 1:");
        findHumanBySecondName(people, "Ivanov");
        //Task_2
        System.out.println("\n\nTask 2:");
        findHumanByAddressAttribute(people, "city", "moscow");
        //Task_3
        System.out.println("\n\nTask 3:");
        findPeopleAmongDates(people, "2000-01-01", "2021-04-02");
        //Task_4
        System.out.println("\n\nTask 4:");
        findElderHuman(people);
        //Task_5
        System.out.println("\n\nTask 5:");
        findPeopleByCommonStreet(people);
    }
}
