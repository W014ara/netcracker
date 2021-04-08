package application.task1;

/**
 * Main class of the program
 * @author Bezruk Vladislav
 */
public class Main {
    /**
     * Main method of the program
     */
    public static void main(String[] args) {
        //initialize the created entities in the dog, cat, cow classes
        // and call the voice method on each object
        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();
        dog.voice();
        cat.voice();
        cow.voice();
    }
}
