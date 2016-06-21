/**
 * Created by aleks on 21.06.2016.
 */
public interface IAnimal {

    String putAnimal(IAnimal animal);
    IAnimal getAnimal(String key);
    boolean hasFreeSpace(Fridge f, Animal a);

}
