package study;

import org.junit.jupiter.api.Test;

public class HashcodeTest {
    private class A {
        private final int value;

        public A(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            A a = (A) o;

            return value == a.value;
        }

        @Override
        public int hashCode() {
            return value;
        }
    }

    @Test
    void printReference() {
        A first = new A(1);
        A second = new A(1);

        System.out.println(first);
        System.out.println(second);

        System.out.println(first == second);
        System.out.println(System.identityHashCode(first));
        System.out.println(System.identityHashCode(second));
    }
}
