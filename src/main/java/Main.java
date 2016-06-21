/**
 * Created by aleks on 21.06.2016.
 */
public class Main {

    public static void main(String[] args) throws FrozenException, SizeException {
        Fridge Ariston = new Fridge(200,70,100,600);
        Elephant elephant = new Elephant("Joe",300,50,50,200);
        elephant.putAnimal(Ariston, elephant);
        elephant.getAnimal(Ariston);


    }

}
