package springproxy.jdkdynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JdkDynamicProxyTest {

    @Test
    void checkInstanceOfProxy() {
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

        assertAll(
                () -> assertDoesNotThrow(() -> (TargetInterface) proxyObject),
                () -> assertDoesNotThrow(() -> ((TargetClass) proxyObject))
        );
    }

}
