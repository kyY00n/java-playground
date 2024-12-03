package springproxy.cglib;

public class TargetClass {
    public String sayHello(String name) {
        System.out.println("sayHello() is called!");
        return "Hello" + name;
    }

}
