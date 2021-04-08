package application.task1;

/**
 * Class that mimics the voice of a cow
 * @author Bezruk Vladislav
 */
public class Cow implements Voice{
    /**
     * Overridden method for text outputting `Cow's voice`
     */
    @Override
    public void voice() {
        System.out.println("Cow's voice");
    }
}
