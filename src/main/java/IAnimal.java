/**
 * Created by aleks on 21.06.2016.
 */
public interface IAnimal {
    boolean openDoor(Fridge fridge);

    void putAnimal(Fridge fridge) throws SizeException, BusyException;

    void getAnimal(Fridge fridge) throws BusyException;

    boolean compareSizes(Fridge f);

    boolean closeDoor(Fridge fridge);

}
