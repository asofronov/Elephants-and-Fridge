/**
 * Created by aleks on 21.06.2016.
 */
public interface IAnimal {
    boolean openDoor(Fridge fridge);
    void putAnimal(Fridge fridge, Animal animal);
    void getAnimal(String key);
    boolean hasFreeSpace(Fridge f, Animal a);
    boolean closeDoor(Fridge fridge);

}
