package netcracker.basic.task3.task5;

/**
 * A class that describes the essence of the format of telephone numbers, both international and Russian
 *
 * @author Bezruk vladislav
 */
public class PhoneNumber {
    private String number;

    /**
     * PhoneNumber class constructor
     *
     * @param number - phone's number
     */
    public PhoneNumber(String number) {
        this.number = number;
    }

    /**
     * The method that converts the number into a single one,
     * format + <Country code> <Three digits> - <Three digits> - <Four digits>
     *
     * @return - returns a new String format phone number
     * + <Country Code> <Three Digits> - <Three Digits> - <Four Digits>
     */
    public String transformNumber() {
        if (this.number == null) {
            return "There is not a phone number";
        }
        boolean result = this.number.matches("^\\+\\d+$");
        if (result && this.number.length() > 11) {
            return transformWorldNumber(this.number);
        } else {
            if (this.number.matches("^\\d+$") && this.number.length() > 10) {
                return transformRussianNumber(this.number);
            } else {
                return "There is not a phone number";
            }
        }
    }


    /**
     * a method that transforms the entered number into the Russian format, if it is such initially
     *
     * @param number - original phone number
     * @return - return new Russian phone number format +7<Three Digits> - <Three Digits> - <Four Digits>
     */
    public String transformRussianNumber(String number) {
        String main = number.substring(number.length() - 10);
        String firstBlock = main.substring(0, 3);
        String secondBlock = main.substring(3, 6);
        String thirdBlock = main.substring(6, 10);
        return String.format("+7%s-%s-%s", firstBlock, secondBlock, thirdBlock);
    }

    /**
     * a method that transforms the entered number into the World format, if it is such initially
     *
     * @param number - original phone number
     * @return - return new phone number format + <Country Code> <Three Digits> - <Three Digits> - <Four Digits>>
     */
    public String transformWorldNumber(String number) {
        String countryCode = number.substring(1, number.length() - 10);
        String main = number.substring(number.length() - 10);
        String firstBlock = main.substring(0, 3);
        String secondBlock = main.substring(3, 6);
        String thirdBlock = main.substring(6, 10);
        return String.format("+%s%s-%s-%s", countryCode, firstBlock, secondBlock, thirdBlock);
    }
}
