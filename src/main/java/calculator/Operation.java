package calculator;

class Operation {
    private double a;
    private double b;
    private String operator;
    private double result;
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    public Operation(double a, double b, String operator) {
        this.a = a;
        this.b = b;
        this.operator = operator;
        this.result = calculate();
    }

    private double calculate() {
        double result;

        switch (operator) {
            case PLUS:
                result = a + b;
                break;
            case MINUS:
                result = a - b;
                break;
            case MULTIPLY:
                result = a * b;
                break;
            case DIVIDE:
                if (b == 0) {
                    throw new ArithmeticException("Nie można dzielić przez 0");
                }
                result = a / b;
                break;
            default:
                result = 0;
        }
        return result;
    }

    @Override
    public String toString() {
        return a + " " + operator +
                " " + b + " = " + result;
    }

}
