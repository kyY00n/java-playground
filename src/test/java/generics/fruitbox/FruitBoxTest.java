package generics.fruitbox;

import org.junit.jupiter.api.Test;

class FruitBoxTest {

    class Banana extends Fruit {
    }

    class Strawberry extends Fruit {
    }

    @Test
    void addChildren() {
        FruitBox<Fruit> fruitFruitBox = new FruitBox<>();
        fruitFruitBox.add(new Banana());
    }

    class Juice {
        private String name;

        public Juice(String name) {
            this.name = name;
        }
    }

    <T extends Fruit> Juice makeJuice(FruitBox<T> box) {
        return new Juice("hi");
    }

//    Juice makeJuice(FruitBox<?> box) {
//        String names = box.getList().stream()
//                .map(Fruit::toString).collect(joining(", "));
//        return new Juice(names);
//    }

}