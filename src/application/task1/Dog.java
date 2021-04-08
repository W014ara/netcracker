package application.task1;

/**
 * Class that mimics the voice of a dog
 * @author Bezruk Vladislav
 */
public class Dog implements Voice{
    /**
     * Overridden method for text outputting `Dog's voice`
     */
    @Override
    public void voice() {
        System.out.println("Dog's voice");
    }
}
