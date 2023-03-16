// Core learning 2 - Pangram checker
import java.util.Scanner;

public class Pangram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Keep prompting the user until user exits
        while (true) {
            System.out.println("Enter a phrase to check if it's a pangram (type 'exit' to quit):");
            String input = scanner.nextLine().toLowerCase();
            
            if (input.equals("exit")) {
                break;
            }
            
            boolean isPangram = isPangram(input);
            if (isPangram) {
                System.out.println("'" + input + "' is a pangram.");
            } else {
                System.out.println("'" + input + "' is not a pangram.");
            }
        }
        
        scanner.close();
    }
    
    public static boolean isPangram(String input) {
        // Remove all non-alphabetic characters
        input = input.replaceAll("[^a-zA-Z]", "");
        
        // Create a boolean array to track whether each letter has been seen
        boolean[] seen = new boolean[26];
        
        // Iterate over each character in the input string
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            
            // If the character is a letter, mark it as seen
            if (Character.isLetter(c)) {
                seen[c - 'a'] = true;
            }
        }
        
        // Check if all letters have been seen
        for (boolean b : seen) {
            if (!b) {
                return false;
            }
        }
        
        return true;
    }
}
