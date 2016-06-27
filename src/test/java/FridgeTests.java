import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FridgeTests {
    Fridge Ariston;
    Elephant Slon;

    @BeforeMethod
    public void beforeClass() {
        Ariston = new Fridge(100, 100, 100, 400);
        Slon = new Elephant("Slon", 50, 50, 50, 100);
    }

    @Test
    public void openDoorTest() {
        Slon.openDoor(Ariston);
        Assert.assertTrue(Ariston.getDoor(), "Door was not opened!");
    }

    @Test
    public void closeDoorTest() {
        Ariston.setDoor(true);
        Slon.closeDoor(Ariston);
        Assert.assertFalse(Ariston.getDoor(), "Door is still opened!");
    }

    @Test
    public void UnsuccessfulOpenDoor() {
        Ariston.setDoor(true);
        Assert.assertFalse(Slon.openDoor(Ariston), Slon.getName() + " opens opened door");

    }

    @Test
    public void UnsuccessfulCloseDoor() {
        Assert.assertFalse(Slon.closeDoor(Ariston), Slon.getName() + " closed closed door");
    }

}
