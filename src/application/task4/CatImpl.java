package application.task4;

/**
 * A cat entity class that implements the cat interface methods
 * @author Bezruk Vladislav
 */
public class CatImpl implements Cat {
    //A private field that simulates the feed method call counter
    private int feed_counter = 0;

    /**
     * An overloaded feed method, the essence of which is to increment the
     * feed_counter with each call of the current method
     * @see CatImpl#feed_counter
     */
    @Override
    public void feed() {
        this.feed_counter = this.feed_counter + 1;
    }

    /**
     * An overloaded voice method that calls the `I’m hungry, bro!` caption if the feed_counter field is less than 0.
     * Otherwise, the `I just want to sleep for a bit, OK?` caption is displayed
     */
    @Override
    public void hungry() {
        if(this.feed_counter > 0){
            System.out.println("I just want to sleep for a bit, OK?");
        }else {
            System.out.println("I’m hungry, bro!");
        }
    }
}
