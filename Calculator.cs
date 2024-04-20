using System;
using MathWorks.MATLAB.NET.Arrays;
using MathWorks.MATLAB.NET.Utility;
using MathWorks.MATLAB.NET.Execution;
using MathWorks.MATLAB.NET.Arrays.Generic;

class Calculator {
    static void Main() {
        // Start MATLAB engine
        MWArray result;
        MLApp.MLApp matlab = new MLApp.MLApp();
        
        // Initialize variables
        double num1, num2;
        char op;

        // Prompt user for input
        Console.WriteLine("Enter an operator (+, -, *, /): ");
        op = Convert.ToChar(Console.ReadLine());

        Console.WriteLine("Enter two numbers: ");
        num1 = Convert.ToDouble(Console.ReadLine());
        num2 = Convert.ToDouble(Console.ReadLine());

        // Call MATLAB function based on the operator
        switch (op) {
            case '+':
                matlab.Execute($"result = {num1} + {num2};");
                break;
            case '-':
                matlab.Execute($"result = {num1} - {num2};");
                break;
            case '*':
                matlab.Execute($"result = {num1} * {num2};");
                break;
            case '/':
                matlab.Execute($"result = {num1} / {num2};");
                break;
            default:
                Console.WriteLine("Invalid operator!");
                return;
        }

        // Get result from MATLAB
        result = (MWArray)matlab.GetVariable("result");

        // Display the result
        Console.WriteLine($"Result: {result.ToString()}");
        
        // Close MATLAB engine
        matlab.Quit();
    }
}
