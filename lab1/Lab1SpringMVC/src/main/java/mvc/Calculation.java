package mvc;

public class Calculation {

    private int num1;
    private int num2;
    private String op;
    private double result;

    public Calculation() {
    }

    public Calculation(int num1, int num2, String op) {
        this.num1 = num1;
        this.num2 = num2;
        this.op = op;
    }

    public double calculate(int num1, int num2, String op) {
        switch (op) {
            case "+":
                result = sum(num1,num2);
                break;
            case "-":
                result = sub(num1, num2);
                break;
            case "*":
                result= mul(num1, num2);
                break;
            case "/":
                result = div(num1,num2);
                break;
            default:
                break;
        }

        return result;
    }

    public double sum(int a, int b) {
        return a + b;
    }

    public double sub(int a, int b) {
        return a - b;
    }

    public double mul(int a, int b) {
        return a * b;
    }

    public double div(int a, int b) {
        return a / b;
    }

}
