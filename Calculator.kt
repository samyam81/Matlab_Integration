import com.mathworks.engine.MatlabEngine
import java.util.Scanner

fun main() {
    try {
        // Start MATLAB engine
        val matlab = MatlabEngine.startMatlab()

        val scanner = Scanner(System.`in`)
        println("Enter operation (+, -, *, /):")
        val operation = scanner.nextLine()

        println("Enter first number:")
        val num1 = scanner.nextDouble()

        println("Enter second number:")
        val num2 = scanner.nextDouble()

        // Perform calculation based on the operation
        val result: Double = when (operation) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> {
                // Perform division using MATLAB
                matlab.feval("mldivide", num1, num2).get(0).toDouble()
            }
            else -> {
                println("Invalid operation!")
                return
            }
        }

        // Print the result
        println("Result: $result")

        // Close MATLAB engine
        matlab.close()
    } catch (e: Exception) {
        println("An error occurred: ${e.message}")
    }
}
