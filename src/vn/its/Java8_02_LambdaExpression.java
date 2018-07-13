package vn.its;

public class Java8_02_LambdaExpression {

    private final static String salutation = "Hey ";
    public static void main(String[] args) {
        Java8_02_LambdaExpression lambdaExpression = new Java8_02_LambdaExpression();
        MathOperation addition = (int a, int b) -> a + b;
        MathOperation subtraction = (int a, int b) -> a - b;
        MathOperation multiplication = (int a, int b) -> a * b;
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + lambdaExpression.operate(10, 5 , addition));
        System.out.println("20 - 10 = " + lambdaExpression.operate(20, 10 , subtraction));
        System.out.println("10 * 5 = " + lambdaExpression.operate(10, 5 , multiplication));
        System.out.println("20 / 5 = " + lambdaExpression.operate(20, 5 , division));

        GreetingService greetingService1 = message -> System.out.println("Hello " + message);
        GreetingService greetingService2 = message -> System.out.println("Hi " + message);

        greetingService1.sayMessage("Java 8");
        greetingService2.sayMessage("Java 9");

        // Scope
        GreetingService greetingService3 = message -> System.out.println(salutation + message);
        greetingService3.sayMessage("Java 10");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
