public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Welcome to the Enhanced HelloWorld Program!");
        
        // Display a message with a variable
        String message = "Hello, World!";
        System.out.println(message);

        // Display numbers from 1 to 5
        for (int i = 1; i <= 5; i++) {
            System.out.println("Number: " + i);
        }

        // Perform a simple calculation
        int result = addNumbers(5, 7);
        System.out.println("Result of adding 5 and 7: " + result);

        // Display a closing message
        System.out.println("Thank you for using the Enhanced HelloWorld Program!");
    }

    // Method to add two numbers
    private static int addNumbers(int a, int b) {
        return a + b;
    }
}

