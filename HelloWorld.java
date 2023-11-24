import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        // Print a welcome message
        System.out.println("Welcome to the Complex HelloWorld Program!");

        // Get user input for their name
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        // Greet the user
        System.out.println("Hello, " + userName + "!");

        // Demonstrate a loop with user interaction
        for (int i = 0; i < 3; i++) {
            System.out.println("Iteration " + (i + 1) + ": Have a great day, " + userName + "!");
            askForFeedback();
        }

        // Display a farewell message
        System.out.println("Thank you for using the Complex HelloWorld Program!");
    }

    // Method to ask the user for feedback
    private static void askForFeedback() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Did you enjoy the greeting? (yes/no): ");
        String feedback = scanner.nextLine();
        System.out.println("Feedback: " + feedback);
    }
}
