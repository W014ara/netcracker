package ru.skillbench.tasks.basics.entity;

public class LocationImpl implements Location {

    private String locName;
    private Type locType;
    private Location locParent;

    @Override
    public String getName() {
        return this.locName;
    }

    @Override
    public void setName(String name) {
        this.locName = name;
    }

    @Override
    public Type getType() {
        return locType;
    }

    @Override
    public void setType(Type type) {
        this.locType = type;
    }

    @Override
    public void setParent(Location parent) {
        this.locParent = parent;
    }

    @Override
    public String getParentName() {
        if (locParent == null) {
            return "--";
        } else {
            return locParent.getName();
        }
    }

    @Override
    public Location getTopLocation() {
        if (this.getParentName().equals("--")) {
            return this;
        } else {
            return locParent.getTopLocation();
        }
    }

    @Override
    public boolean isCorrect() {
        if (this.getParentName().equals("--")) {
            return true;
        } else {
            if (this.locParent.getType().compareTo(this.getType()) < 0) {
                return locParent.isCorrect();
            } else {
                return false;
            }
        }
    }

    @Override
    public String getAddress() {
        if (this.getParentName().equals("--")) {
            return this.getName();
        } else {
            int countMatches = this.getName().length() - this.getName().replace(" ", "").length();
            if (this.getName().indexOf('.') == -1 | countMatches > 1) {
                return this.getType().getNameForAddress() + this.getName() + ", " + locParent.getAddress();
            } else {
                return this.getName() + ", " + locParent.getAddress();
            }
        }
    }

    @Override
    public String toString() {
        return this.getName() + " (" + this.getType() + ")";
    }
}
