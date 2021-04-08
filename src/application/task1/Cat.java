package application.task1;

/**
 * Class that mimics the voice of a cat
 * @author Bezruk Vladislav
 */
public class Cat implements Voice{
    /**
     * Overridden method for text outputting `Cat's voice`
     */
    @Override
    public void voice() {
        System.out.println("Cat's voice");
    }
}
