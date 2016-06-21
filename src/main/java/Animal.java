public class Animal implements IAnimal {
    private String name;
    private int height;
    private int width;
    private int length;
    private int mass;
    private int maxCapacity;
    private int usedCapacity;

    //Конструктор
    public Animal(String name, int height, int width, int length, int mass) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.length = length;
        this.mass = mass;
    }


    //Дсотуп к переменной массы зверя
    private double getMass() {
        return mass;
    }

    // Положить зверя
    public void putAnimal(Fridge fridge, Animal animal) {
        try {
            openDoor(fridge);
            if (!fridge.getEmpty()) { // Если холодильник не пуст
                System.out.println("There is no empty space. " + animal.getName() + " is in the fridge");
            } else {
                if (!hasFreeSpace(fridge, animal)) { // Если слон слишком большой
                    System.out.println(animal.getName() + " is too big for this fridge");
                } else {
                fridge.setEmpty(false);
                fridge.animalSlot(this);
                System.out.println(animal.getName() + " was put to the fridge");
                }
            }
        } finally {
            closeDoor(fridge);
        }
    }

    public void getAnimal(String key) {

    }

    // Метод определения наличия свободного места
    public boolean hasFreeSpace(Fridge fridge, Animal animal) {
        return getMaxCapacity(fridge) > getUsedCapacity() && fridge.getLimitMass() > animal.getMass();
    }

    // Вычисление максимальной вместимости холодильника
    private int getMaxCapacity(Fridge fridge) {
        maxCapacity = fridge.getLimitHeight() * fridge.getLimitLength() * fridge.getLimitLength();
        return maxCapacity;
    }

    // Вычисление места занятого животным
    private int getUsedCapacity() {
        usedCapacity = this.height * this.width * this.length;
        return usedCapacity;
    }

    private String getName() {
        return name;
    }

    public boolean openDoor(Fridge fridge) {
        if (fridge.getDoor()) {
            System.out.println("Fridge door is already open!");
            return false;
        } else { fridge.setDoor(true);
            System.out.println(getName() + " opened the door");
            return true;
        }
    }

    public boolean closeDoor(Fridge fridge) {
        if (!fridge.getDoor()) {
            System.out.println("The door is already closed");
            return false;
        } else {
            fridge.setDoor(false);
            System.out.println(getName() + " closed the door");
            return true;
        }
    }

}