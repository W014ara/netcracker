package netcracker.Task1.subTask4;

import java.io.Serializable;

/**
 * A simple class to demonstrate serialization and deserialization later
 *
 * @author Bezruk Vladislav
 */
public class MyClassToBePersisted implements Serializable {
    private String profile;
    private String group;

    /**
     * Constructor
     *
     * @param profile class profile
     * @param group   class group
     */
    public MyClassToBePersisted(String profile, String group) {
        this.profile = profile;
        this.group = group;
    }

    /**
     * @return Returns the profile field of the created object
     * @see MyClassToBePersisted#profile
     * Profile obtaining method
     */
    public String getProfile() {
        return this.profile;
    }

    /**
     * @return Returns the group field of the created object
     * @see MyClassToBePersisted#group
     * Group obtaining method
     */
    public String getGroup() {
        return this.group;
    }

    /**
     * @param profile the string value of the new profile
     * @see MyClassToBePersisted#profile
     * Sets a new profile value
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * @param group the string value of the new group
     * @see MyClassToBePersisted#group
     * Sets a new group value
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * An overloaded method that gave a new representation of the object's data
     *
     * @return Returns the updated string representation of the object
     */
    @Override
    public String toString() {
        return String.format("Profile is:%s\nGroup is:%s", this.getProfile(), this.getGroup());
    }

    /**
     * Compares two created objects by comparing profile and group values
     *
     * @param obj compared object
     * @return compare result
     */
    @Override
    public boolean equals(Object obj) {
        MyClassToBePersisted targetObj = (MyClassToBePersisted) obj;
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return this.getGroup().equals(targetObj.getGroup()) && this.getProfile().equals(targetObj.getProfile());
    }
}
