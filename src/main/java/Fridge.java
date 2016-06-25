public class Fridge {
    private boolean isDoorOpen;
    private int limitHeight, limitWidth, limitLength, limitMass;
    private Animal animal;
    private boolean isEmpty = true;
    private int fridgeCapacity;

    public Fridge(int limitHeight, int limitWidth, int limitLength, int limitMass) {
        this.limitHeight = limitHeight;
        this.limitWidth = limitWidth;
        this.limitLength = limitLength;
        this.limitMass = limitMass;
    }

    private int getLimitHeight() {
        return limitHeight;
    }

    private int getLimitLength() {
        return limitLength;
    }

    private int getLimitWidth() {
        return limitWidth;
    }

    // Лимит по массе в холодильнике
    public int getLimitMass() {
        return limitMass;
    }

    public boolean getDoor() {
        return isDoorOpen;
    }

    public void animalSlot(Animal a) {
        animal = a;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void freeFridge() {
        animal = null;
    }

    // Пустой ли холодильник?
    public boolean getEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public void setDoor(boolean door) {
        isDoorOpen = door;
    }

    public int getFridgeCapacity() {
        fridgeCapacity = getLimitHeight() * getLimitWidth() * getLimitLength();
        return fridgeCapacity;
    }


}
