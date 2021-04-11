package netcracker.basic.task3.task2;

public class Person {
    private final String firstname;
    private final String surname;
    private final String lastname;

    public Person(String firstname, String surname, String lastname) {
        this.firstname = firstname;
        this.surname = surname;
        this.lastname = lastname;
    }

    /**
     * The function should take into account the possibility of
     * missing values in the Name and Patronymic fields.
     *
     * @return - returning Surname I.O.
     */
    public String getFullName() {
        //check the data for validity
        if (this.firstname == null || this.surname == null || this.lastname == null) {
            return "Name cannot contain null";
        }
        //check if firstname field is empty
        if (this.firstname.equals("")) {
            //check if surname field is empty
            if (this.surname.equals("")) {
                return this.lastname;
            }
            return String.format("%s %s.", this.lastname, this.surname.charAt(0));
        }
        //check if surname field is empty
        if (this.surname.equals("")) {
            return String.format("%s %s.", this.lastname, this.firstname.charAt(0));
        }
        return String.format("%s %s.%s.", this.lastname, this.firstname.charAt(0), this.surname.charAt(0));
    }
}
