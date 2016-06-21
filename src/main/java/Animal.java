public class Animal implements IAnimal {
    private String name;
    private int height;
    private int width;
    private int length;
    private int mass;
    private int maxCapacity;
    private int usedCapacity;
    private boolean frozen = false;

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
    public void putAnimal(Fridge fridge, Animal animal) throws SizeException, FrozenException {
        try {
            openDoor(fridge);
            if (!fridge.getEmpty()) { // Если холодильник не пуст
                throw new FrozenException();
            } else {
                if (!hasFreeSpace(fridge, animal)) { // Если слон слишком большой
                    throw new SizeException();
                } else {
                    fridge.setEmpty(false);
                    fridge.animalSlot(this);
                    frozen = true;
                    System.out.println(animal.getName() + " was put to the fridge");
                }
            }
        } catch (FrozenException ex) {
            System.out.println("Oops, there is somebody in the fridge");
        } catch (SizeException ex) {
            System.out.println("Oops, your pet is too large");
        } finally {
            closeDoor(fridge);
        }
    }

    // Достать зверя
    public void getAnimal(Fridge fridge) {
        if (!fridge.getEmpty()) {
            frozen = false;
            openDoor(fridge);
            fridge.setEmpty(true);
            fridge.freeFridge();
            System.out.println(getName() + " come out from the fridge");
            closeDoor(fridge);
        }
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

    // Получение имени
    private String getName() {
        return name;
    }

    // Открыть дверь
    public boolean openDoor(Fridge fridge) {
        if (fridge.getDoor()) {
            System.out.println("Fridge door is already open!");
            return false;
        } else {
            fridge.setDoor(true);
            System.out.println(getName() + " opened the door");
            return true;
        }
    }

    // Закрыть дверь
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