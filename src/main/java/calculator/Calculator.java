package calculator;

public class Calculator {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    static double calculate(Operation operation) {
        double result = 0;

        switch (operation.operator) {
            case PLUS:
                result = operation.a + operation.b;
                break;
            case MINUS:
                result = operation.a - operation.b;
                break;
            case MULTIPLY:
                result = operation.a * operation.b;
                break;
            case DIVIDE:
                if (operation.b == 0) {
                    throw new ArithmeticException("Nie można dzielić przez 0");
                }
                result = operation.a / operation.b;
                break;
        }
        return result;
    }
}
