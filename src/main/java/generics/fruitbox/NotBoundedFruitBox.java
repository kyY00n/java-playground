package generics.fruitbox;

import java.util.ArrayList;

public class NotBoundedFruitBox<T> {
    private ArrayList<T> list = new ArrayList<>();

}

class JuiceMaker {
    class Juice {
        private String name;

        public Juice(String name) {
            this.name = name;
        }
    }

    public Juice makeJuice(NotBoundedFruitBox<?> box) {
        return new Juice("hi");
    }
}
