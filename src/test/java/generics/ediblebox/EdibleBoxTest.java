package generics.ediblebox;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Apple implements Edible {

}

class EdibleBoxTest {
    @Test
    void create() {
        EdibleBox<Edible> hi = new EdibleBox();
        hi.add(new Apple());
    }
}