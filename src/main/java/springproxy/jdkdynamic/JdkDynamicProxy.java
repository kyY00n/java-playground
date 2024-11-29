package springproxy.jdkdynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JdkDynamicProxy {

    public static void main(String[] args) {
        TargetClass target = new TargetClass();

        InvocationHandler invocationHandler = (proxy, method, args1) -> {
            System.out.println("This is a logic before the method is called.");

            if (method.getName().equals("print")) {
                method.invoke(target);
            }

            System.out.println("This is a logic after the method is called.");
            return null;
        };

        Object proxyObject = Proxy.newProxyInstance(TargetClass.class.getClassLoader(), new Class[]{TargetInterface.class},
                invocationHandler);

        try {
            TargetInterface proxy = (TargetInterface) proxyObject;
            proxy.print();
            /**
             * 결과:
             * This is a logic before the method is called.
             * The original print() logic.
             * This is a logic after the method is called.
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
