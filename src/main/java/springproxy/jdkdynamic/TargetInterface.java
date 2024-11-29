package springproxy.jdkdynamic;

public interface TargetInterface {

    default void print() {
        System.out.println("The original print() logic.");
    }


}
