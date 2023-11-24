public class HelloWorld {
    public static void main(String[] args) {
        // Print a welcome message
        System.out.println("Welcome to the Extended HelloWorld Program!");

        // Loop to print "Hello, World!" multiple times
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello, World! - Iteration " + (i + 1));
        }

        // Call a method to demonstrate function invocation
        printCustomMessage("This is a custom message!");

        // Calculate and print the sum of numbers
        int sum = calculateSum(5, 10);
        System.out.println("The sum of 5 and 10 is: " + sum);
    }

    // Method to print a custom message
    private static void printCustomMessage(String message) {
        System.out.println("Custom Message: " + message);
    }

    // Method to calculate the sum of two numbers
    private static int calculateSum(int a, int b) {
        return a + b;
    }
}
