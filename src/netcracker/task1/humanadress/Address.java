package netcracker.task1.humanadress;

public class Address {
    private String city;
    private String street;
    private int building;
    private int room;

    public Address(String city, String street, int building, int room) {
        this.city = city;
        this.street = street;
        this.building = building;
        this.room = room;
    }

    public String getCity() {
        return this.city;
    }

    public String getStreet() {
        return street;
    }

    public String getFullAddress() {
        return "г." + this.city + ", ул." + this.street + ", д." + this.building + ", кв." + this.room;
    }

    public int getBuilding() {
        return building;
    }

    public int getRoom() {
        return room;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public void setRoom(int room) {
        this.room = room;
    }
}