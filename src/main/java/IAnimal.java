/**
 * Created by aleks on 21.06.2016.
 */
public interface IAnimal {
    boolean openDoor(Fridge fridge);
    void putAnimal(Fridge fridge, Animal animal) throws SizeException, FrozenException;
    void getAnimal(Fridge fridge);
    boolean hasFreeSpace(Fridge f, Animal a);
    boolean closeDoor(Fridge fridge);

}
