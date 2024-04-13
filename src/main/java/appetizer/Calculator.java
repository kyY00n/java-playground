package appetizer;

public class Calculator {

    public int add(int a, int b) {
        return a - b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }


    /**
     * Production code와 Test Code가 클래스 하나에 존재한다. 클래스 크기가 커짐. 복잡도 증가함.
     * Test Code가 실 서비스에 같이 배포됨.
     * main method 하나에서 여러 개의 기능을 테스트 함. 복잡도 증가.
     * method 이름을 통해 어떤 부분을 테스트하는지에 대한 의도를 드러내기 힘듦.
     * 테스트 결과를 사람이 수동으로 확인
     * @param args
     */
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(1, 2));
        System.out.println(calculator.subtract(1, 2));
        System.out.println(calculator.multiply(1, 2));
        System.out.println(calculator.divide(1, 2));
    }

}
