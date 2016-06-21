public class Animal implements IAnimal {
    private String name;
    private int height;
    private int width;
    private int length;
    private int mass;
    private int animalSize;
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
    private int getMass() {
        return mass;
    }

    // Положить зверя
    public void putAnimal(Fridge fridge, Animal animal) throws SizeException, FrozenException {
        try {
            openDoor(fridge);
            if (!fridge.getEmpty()) { // Если холодильник не пуст
                throw new FrozenException();
            } else {
                if (!compareSizes(fridge, animal)) { // Если слон слишком большой
                    throw new SizeException();
                } else {
                    fridge.setEmpty(false);
                    fridge.animalSlot(this);
                    setFrozen(true);
                    System.out.println(animal.getName() + " was put to the fridge");
                }
            }
        } catch (FrozenException ex) {
            System.out.println("Oops, there is " + fridge.getAnimal().name + " in the fridge");
        } catch (SizeException ex) {
            System.out.println("Oops, your pet is too large");
        } finally {
            closeDoor(fridge);
        }
    }

    // Достать зверя
    public void getAnimal(Fridge fridge) throws FrozenException {
        try {
            openDoor(fridge);
            if (!fridge.getEmpty()) {
                setFrozen(false);
                fridge.setEmpty(true);
                fridge.freeFridge();
                System.out.println(getName() + " come out from the fridge");
            } else {
                throw new FrozenException();
            }
        } catch (FrozenException ex) {
            System.out.println("There is no animals in the fridge");
        } finally {
            closeDoor(fridge);
        }
    }

    // Метод определения наличия свободного места
    public boolean compareSizes(Fridge fridge, Animal animal) {
        return fridge.getFridgeCapacity() >= getAnimalSize() && fridge.getLimitMass() >= animal.getMass();
    }

    // Вычисление места занятого животным
    private int getAnimalSize() {
        animalSize = this.height * this.width * this.length;
        return animalSize;
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
            System.out.println(this.name + " opened the door");
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
            System.out.println(this.name + " closed the door");
            return true;
        }
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public boolean isFrozen() {
        return frozen;
    }
}