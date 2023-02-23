import java.util.Scanner;

public class SubjObj {

    public static Scanner scObj = new Scanner(System.in);

    public static void main(String[] args) {

        try {

            System.out.println("Enter the number of animals: ");
            int size = scObj.nextInt();
            System.out.println("Generating " + size + " animals...");

        } catch (OutOfMemoryError e) {
            System.out.println("Memory not enough.\nAborting program.");
            System.exit(0);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!\nAborting program.");
            System.exit(0);
        }

    }
}
