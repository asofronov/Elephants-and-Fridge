public class Animal implements IAnimal {
    private String name;
    private double height;
    private double width;
    private double length;
    private double mass;
    private double maxCapacity;
    private double usedCapacity;

    //Конструктор
    public Animal(String name, double height, double width, double length, double mass) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.length = length;
        this.mass = mass;
    }


    //Дсотуп к переменной массы зверя
    public double getMass() {
        return mass;
    }

    public String putAnimal(Fridge f) {
        f.openDoor();
        try {
            if (f.) {
        }


        return null;
    }

    public IAnimal getAnimal(String key) {
        return null;
    }

    // Метод определения наличия свободного места
    public boolean hasFreeSpace(Fridge f, Animal a) {
        if (getMaxCapacity(f) > getUsedCapacity(a) && f.getLimitMass() > a.getMass()) {
            return true;
        } else System.out.println("Животное не помещается в холодильник");

        return false;
    }

    // Вычисление максимальной вместимости холодильника
    public double getMaxCapacity(Fridge f) {
        maxCapacity = f.getLimitHeight() * f.getLimitLength() * f.getLimitLength();
        return maxCapacity;
    }

    // Вычисление места занятого животным
    public double getUsedCapacity(Animal a) {
        usedCapacity = this.height * this.width * this.length;
        return usedCapacity;
    }

}