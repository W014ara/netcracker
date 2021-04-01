package ru.skillbench.tasks.basics.entity;

public class EmployeeImpl implements Employee {
    private int salary = 1000;
    private String firstName;
    private String lastName;
    private Employee manager;

    @Override
    public int getSalary() {
        return this.salary;
    }

    @Override
    public void increaseSalary(int value) {
        this.salary = this.salary + value;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public String getManagerName() {
        if (manager == null){
            return "No manager";
        }else{
            return manager.getFullName();
        }
    }

    @Override
    public Employee getTopManager() {
        if( manager == null){
            return this;
        }
        return manager.getTopManager();
    }
}
