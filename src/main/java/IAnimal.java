/**
 * Created by aleks on 21.06.2016.
 */
public interface IAnimal {
    boolean openDoor(Fridge fridge);

    void putAnimal(Fridge fridge) throws SizeException, BusyException;

    void getAnimal(Fridge fridge) throws BusyException;

    boolean closeDoor(Fridge fridge);

    boolean goodShape(Fridge fridge);
}
