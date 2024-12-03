package springproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class CglibProxyExample {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetClass.class); // 프록시 대상 클래스 설정

        MethodInterceptor methodInterceptor = (obj, method, args1, proxy) -> {
            System.out.println("Before method execution: " + method.getName());
            Object result = proxy.invokeSuper(obj, args1); // 실제 메서드 호출
            System.out.println("After method execution: " + method.getName());
            return result;
        };
        enhancer.setCallback(methodInterceptor);

        TargetClass proxy = (TargetClass) enhancer.create();
        proxy.sayHello("World");
    }

}
