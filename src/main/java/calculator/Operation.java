package calculator;

class Operation {
    double a;
    double b;
    String operator;

    public Operation(double a, double b, String operator) {
        this.a = a;
        this.b = b;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return a + " " + operator +
                " " + b + " = ";
    }

}
