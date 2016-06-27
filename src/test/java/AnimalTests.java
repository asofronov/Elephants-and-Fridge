import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AnimalTests {
    Animal Slon;
    Animal Monkey;
    Fridge Ariston;

    @BeforeMethod
    public void beforeClass() {
        Ariston = new Fridge(20, 20, 20, 100);
    }

    @Test
    public void successfulPutAnimal() throws BusyException, SizeException {
        Slon = new Elephant("First", 10, 10, 10, 50);
        Slon.putAnimal(Ariston);
        Assert.assertEquals(Ariston.getAnimal().getName(), "First", "Elephant is not in the fridge");
        Assert.assertFalse(Ariston.getEmpty(), "The fridge is empty!");
        Assert.assertTrue(Slon.getFrozen(), "Slon isn't in the fridge!");
    }

    @Test
    public void successfulGetAnimal() throws BusyException, SizeException {
        Slon = new Elephant("Second", 10, 10, 10, 50);
        Slon.putAnimal(Ariston);
        Slon.getAnimal(Ariston);
        Assert.assertTrue(Ariston.getEmpty(), "The animal is still in the fridge!");
        Assert.assertFalse(Slon.getFrozen(), "The animal is still in the fridge!");
    }

    @Test
    public void successfulPutEqualAnimal() throws BusyException, SizeException {
        Slon = new Elephant("Third", 20, 20, 20, 100);
        Slon.putAnimal(Ariston);
        Assert.assertEquals(Ariston.getAnimal().getName(), "Third", "Elephant is not in the fridge!");
        Assert.assertTrue(Slon.getFrozen(), "Elephant isn't in the fridge");
        Assert.assertFalse(Ariston.getEmpty(), "The fridge is empty!");
    }

    @Test(expectedExceptions = SizeException.class)
    public void unsuccessfulPutTallAnimal() throws BusyException, SizeException {
        Slon = new Elephant("Fourth", 21, 20, 20, 100);
        Slon.putAnimal(Ariston);
        Assert.assertTrue(Ariston.getEmpty(), "The fridge is not empty");
        Assert.assertFalse(Slon.getFrozen(), "The elephant is in the fridge");
    }

    @Test(expectedExceptions = SizeException.class)
    public void unsuccessfulPutWideAnimal() throws BusyException, SizeException {
        Slon = new Elephant("Fifth", 20, 21, 20, 100);
        Slon.putAnimal(Ariston);
        Assert.assertTrue(Ariston.getEmpty(), "The fridge is not empty");
        Assert.assertFalse(Slon.getFrozen(), "The elephant is in the fridge");
    }

    @Test(expectedExceptions = SizeException.class)
    public void unsuccessfulPutLongAnimal() throws BusyException, SizeException {
        Slon = new Elephant("Sixth", 20, 20, 21, 100);
        Slon.putAnimal(Ariston);
        Assert.assertTrue(Ariston.getEmpty(), "The fridge is not empty");
        Assert.assertFalse(Slon.getFrozen(), "The elephant is in the fridge");
    }

    @Test(expectedExceptions = SizeException.class)
    public void unsuccessfulPutMassiveAnimal() throws BusyException, SizeException {
        Slon = new Elephant("Seventh", 20, 20, 20, 101);
        Slon.putAnimal(Ariston);
        Assert.assertTrue(Ariston.getEmpty(), "The fridge is not empty");
        Assert.assertFalse(Slon.getFrozen(), "The elephant is in the fridge");
    }

    @Test(expectedExceptions = BusyException.class)
    public void unsuccessfulPutSecondAnimal() throws BusyException, SizeException {
        Slon = new Elephant("Eighth", 20, 20, 20, 100);
        Monkey = new Monkey("Chacha", 5, 5, 5, 5);
        Slon.putAnimal(Ariston);
        Monkey.putAnimal(Ariston);
        Assert.assertFalse(Ariston.getEmpty(), "The fridge is empty");
        Assert.assertTrue(Slon.getFrozen(), "The elephant isn't in the fridge");
        Assert.assertEquals(Ariston.getAnimal().getName(), "Eighth", "There is somebody else in the fridge");
    }

    @Test(expectedExceptions = BusyException.class)
    public void unsuccessfulGetNothing() throws BusyException {
        Slon = new Elephant("Nineth", 20, 20, 20, 100);
        Assert.assertTrue(Ariston.getEmpty(), "The fridge is not empty");
        Assert.assertFalse(Slon.getFrozen(), "There fridge is not empty");
        Slon.getAnimal(Ariston);
    }
}
