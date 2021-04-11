package netcracker.basic.task3.task1;

/**
 * Class that provides access to SQL queries
 *
 * @author Bezruk Vladislav
 */
public class StudentQuery {
    /**
     * A function that generates a SQL query which
     * inserts rows into table T_GroupSelected <id_Student,
     * firstName, lastName, id_Group> from table
     * T_Student <id_Student, firstName, lastName, id_Group,
     * dolgCount> those students who belong to a group
     * (string parameter) and amount of debts (integer parameter)
     * which exceeds the specified value.
     *
     * @param idGroup   - a string parameter that is responsible for the student's belonging to a specific group
     * @param dolgCount - an integer parameter showing the limiting number of student debts
     * @return - if successful, returns the generated query string. In case of failure, an error
     */
    public String insertStudentsWithDolgCount(String idGroup, int dolgCount) {
        String query = "";
        try {
            query = String.format("INSERT INTO T_GroupSelected (id_Student, firstName, lastName, id_Group) " +
                    "VALUES(SELECT id_Student, firstName, lastName, id_Group FROM T_Student WHERE dolgCount > " +
                    "%d AND id_Group='%s');", dolgCount, idGroup);
            return query;
        } catch (Exception e) {
            return e.toString();
        }
    }
}