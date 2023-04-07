package generics;

public class Box<T> {

//    static T staticItem;
    private T item;

    private T[] hihi;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
