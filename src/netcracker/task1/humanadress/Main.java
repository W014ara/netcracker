package netcracker.task1.humanadress;

import java.util.ArrayList;

import static netcracker.task1.humanadress.Generator.generatePeople;
import static netcracker.task1.humanadress.Human.findHumanBySecondName;
import static netcracker.task1.humanadress.Human.findHumanByAddressAttribute;
import static netcracker.task1.humanadress.Human.findPeopleAmongDates;
import static netcracker.task1.humanadress.Human.findElderHuman;
import static netcracker.task1.humanadress.Human.findPeopleByCommonStreet;

public class Main {
    public static void main(String[] args) {
        ArrayList<Human> people = generatePeople();
        //Task_1
        findHumanBySecondName(people, "Ivanov");
        //Task_2
        findHumanByAddressAttribute(people, "city", "moscow");
        //Task_3
        findPeopleAmongDates(people, "2000-01-01", "2021-04-02");
        //Task_4
        findElderHuman(people);
        //Task_5
        findPeopleByCommonStreet(people);
    }
}
