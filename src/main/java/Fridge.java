public class Fridge {
    private boolean isDoorOpen;
    private double limitHeight, limitWidth, limitLength, limitMass;
    private Animal animal;

    public Fridge(double limitHeight, double limitWidth, double limitLength, double limitMass) {
        this.limitHeight = limitHeight;
        this.limitWidth = limitWidth;
        this.limitLength = limitLength;
        this.limitMass = limitMass;
    }

    public double getLimitHeight() {
        return limitHeight;
    }

    public double getLimitLength() {
        return limitLength;
    }

    public double getLimitWidth() {
        return limitWidth;
    }

    // Лимит по массе в холодильнике
    public double getLimitMass() {
        return limitMass;
    }

    // Открыть дверь
    public boolean openDoor() {
        return isDoorOpen = true;
    }

    // Закрыть дверь
    public boolean closeDoor() {
        return isDoorOpen = false;
    }

    // Животное положили
    public void putAnimal() {
        return isFridgeEmpty = false;
    }

    // Животное достали
    public Animal getAnimal() {
        return an;
    }

}
