import java.util.ArrayList;

public class CryoRoom {
    private int capacity;
    public ArrayList<Fridge> fridges = new ArrayList<Fridge>();
    private String[] key;

    public CryoRoom(int limitHeight, int limitWidth, int limitLength, int limitMass, int capacity) {
        for (int count = 0; count <= capacity; count++) {
            fridges.add(new Fridge(limitHeight, limitWidth, limitLength, limitMass));
        }
        key = new String[capacity];
        this.capacity = capacity;

    }

    public String toCryoRoom(Animal animal) throws SizeException, BusyException {
        for (int count = 0; count <= fridges.size(); count++) {
            if (fridges.get(count).getEmpty()) {
                animal.putAnimal(fridges.get(count));
                key[count] = Integer.toString(count);
                System.out.println("Fridge with number " + key[count] + " has been moved to Cryoroom");
                return key[count];
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public Animal fromCryoRoom(String k) throws NoKeyException, BusyException {
        Animal animal = null;
        for (int count = 0; count < fridges.size(); count++) {
            if (key[count].equals(k)) {
                System.out.println("The assistant opened the fridge with nummber = " + key[count]);
                animal = fridges.get(count).getAnimal();
                fridges.get(count).getAnimal().getAnimal(fridges.get(count));
                key[count] = null;
                return animal;
            }
        }
        throw new NoKeyException();
    }

    int usedCapacity() {
        int usedCapacity = 0;
        for (int count = 0; count < fridges.size(); count++) {
            if (!fridges.get(count).getEmpty())
                usedCapacity++;
        }
        return usedCapacity;
    }

}
