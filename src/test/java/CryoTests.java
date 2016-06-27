import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CryoTests {
    Elephant Kodo;
    Elephant Mofo;
    Monkey Rufus;
    Gerafee Naden;
    CryoRoom cryo;


    @BeforeMethod
    public void beforeClass() {
        cryo = new CryoRoom(20, 20, 20, 100, 3);
        Kodo = new Elephant("Kodo", 10, 10, 10, 50);
    }

    @Test
    public void successfulToCryoTest() throws BusyException, SizeException {
        cryo.toCryoRoom(Kodo);
        assertEquals(cryo.usedCapacity(), 1, "There is more or less than one animal");
        assertTrue(Kodo.getFrozen(), "Kodo is not in the fridge");
    }

    @Test
    public void successfulfromCryoTest() throws BusyException, SizeException, NoKeyException {
        cryo.toCryoRoom(Kodo);
        cryo.fromCryoRoom("0");
        assertEquals(cryo.usedCapacity(), 0, "Cryoroom isn't empty");
        assertFalse(Kodo.getFrozen(), "Kodo is in the fridge");
    }

    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void unsuccessfulToCryoTest() throws BusyException, SizeException {
        Mofo = new Elephant("Kodo", 10, 10, 10, 50);
        Rufus = new Monkey("Rufus", 10, 10, 10, 50);
        Naden = new Gerafee("Naden", 10, 10, 10, 50);
        cryo.toCryoRoom(Kodo);
        cryo.toCryoRoom(Mofo);
        cryo.toCryoRoom(Rufus);
        cryo.toCryoRoom(Naden);
        assertEquals(cryo.usedCapacity(), 3, "CryoRoom isn't full");
    }

}