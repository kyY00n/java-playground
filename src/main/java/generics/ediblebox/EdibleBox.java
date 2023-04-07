package generics.ediblebox;

import java.util.ArrayList;

/**
 * @param <T>
 *     Edible을 구현한 클래스를 타입변수로 받는다.
 */
public class EdibleBox<T extends Edible> {
    private ArrayList<Edible> edibles = new ArrayList<>();

    public void add(Edible edible) {
        edibles.add(edible);
    }
}