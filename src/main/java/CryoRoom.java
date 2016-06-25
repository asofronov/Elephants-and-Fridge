import java.util.ArrayList;

public class CryoRoom {
    private int limitHeight, limitWidth, limitLength, limitMass, capacity;
    public ArrayList<Fridge> fridges = new ArrayList<Fridge>();
    private String[] key;

    public CryoRoom(int limitHeight, int limitWidth, int limitLength, int limitMass, int capacity) {
        this.limitHeight = limitHeight;
        this.limitWidth = limitWidth;
        this.limitLength = limitLength;
        this.limitMass = limitMass;
        this.capacity = capacity;
        for (int count = 0; count < capacity; count++) {
            fridges.add(new Fridge(limitHeight, limitWidth, limitLength, limitMass));
        }
        key = new String[capacity];

    }

    public void toCryoRoom(Animal animal) throws CapacityOverException, FrozenException, SizeException {
        for (int count = 0; count < fridges.size(); count++) {
            if (fridges.get(count).getEmpty()) {
                animal.putAnimal(fridges.get(count));
                key[count] = Integer.toString(count);
                System.out.println("Key number = " + key[count] + ". Don't miss it!");
            }
        }
        throw new CapacityOverException();
    }

    public Animal fromCryoroom(String k) throws FrozenException, NoKeyException {
        Animal a = null;
        for (int count = 0; count < fridges.size(); count++) {
            if (key[count].equals(k)) {
                System.out.println(key[count]);
                a = fridges.get(count).getAnimal();
                fridges.get(count).getAnimal().getAnimal(fridges.get(count));
                key[count] = null;
                return a;
            }
        }
        throw new NoKeyException();
    }

    public boolean hasFreeSpace() {
        for (int count = 0; count < fridges.size(); count++) {
            if (fridges.get(count).getEmpty())
                return true;
        }
        return false;
    }

    public int maxCapacity() {
        return capacity;
    }

    int usedCapacity() {
        int usedCapacity = 0;
        for (int i = 0; i < fridges.size(); i++) {
            if (!fridges.get(i).getEmpty())
                usedCapacity++;
        }
        return usedCapacity;
    }

    public int getCapacity() {
        return capacity;
    }

}
