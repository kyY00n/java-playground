package generics.fruitbox;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FruitBoxTest {

    class Banana extends Fruit {}
    @Test
    void addChildren() {
        FruitBox<Fruit> fruitFruitBox = new FruitBox<>();
        fruitFruitBox.add(new Banana());
    }
}