package generics.fruitbox;

import java.util.ArrayList;

public class FruitBox<T extends Fruit> {

    /**
     * 여전히 한 종류의 타입만 담을 수 있지만 Fruit의 자손만 타입으로 지정할 수 있다.
     */
    private ArrayList<T> fruits = new ArrayList<>();

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public ArrayList<T> getList() {
        return fruits;
    }
}
