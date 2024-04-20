import com.mathworks.engine.MatlabEngine;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Calculator {
    public static void main(String[] args) {
        try {
            // Start MATLAB engine
            MatlabEngine matlab = MatlabEngine.startMatlab();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter operation (+, -, *, /):");
            String operation = scanner.nextLine();

            System.out.println("Enter first number:");
            double num1 = scanner.nextDouble();

            System.out.println("Enter second number:");
            double num2 = scanner.nextDouble();

            // Perform calculation based on the operation
            switch (operation) {
                case "+":
                    System.out.println("Result: " + (num1 + num2));
                    break;
                case "-":
                    System.out.println("Result: " + (num1 - num2));
                    break;
                case "*":
                    System.out.println("Result: " + (num1 * num2));
                    break;
                case "/":
                    // Perform division using MATLAB
                    double result = matlab.feval("mldivide", num1, num2).get(0).doubleValue();
                    System.out.println("Result: " + result);
                    break;
                default:
                    System.out.println("Invalid operation!");
            }

            // Close MATLAB engine
            matlab.close();
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
