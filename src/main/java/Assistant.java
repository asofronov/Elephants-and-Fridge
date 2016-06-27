/**
 * Created by aleks on 21.06.2016.
 */
public class Assistant {

    public static void main(String[] args) throws SizeException, BusyException {
        CryoRoom c = new CryoRoom(200, 70, 100, 600, 2);
        Elephant Judo = new Elephant("Judo", 300, 50, 50, 1000);
        Gerafee Huan = new Gerafee("Huan", 300, 20, 40, 500);
        Monkey Zaza = new Monkey("Zaza", 200, 50, 30, 20);
        Elephant Cure = new Elephant("Cure", 100, 50, 100, 100);
        Elephant Muse = new Elephant("Muse", 100,50,50,50);
        putToCryo(Judo, c);
        putToCryo(Huan, c);
        putToCryo(Zaza, c);
        putToCryo(Cure, c);
        getFromCryo("1", c);
        putToCryo(Muse,c);

    }

    private static void putToCryo(Animal animal, CryoRoom c) throws SizeException, BusyException {
        try {
            System.out.println("key = " + c.toCryoRoom(animal));
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("There is no empty space for " + animal.getName() + " fridge");
            ex.printStackTrace();
        }
    }

    private static void getFromCryo(String k, CryoRoom c) throws BusyException {
        try {
            System.out.println("Animal " + c.fromCryoRoom(k).getName() + " has left cryoroom");
        } catch (NoKeyException ex) {
            ex.printStackTrace();
        }

    }


}
