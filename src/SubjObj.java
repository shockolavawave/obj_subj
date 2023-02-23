import java.util.Scanner;

public class SubjObj {

    public static Scanner scObj = new Scanner(System.in);
    public static Random rn = new Random();

    // function for Both
    public static void countAndWrite(Both[] arr) {
    }

    // function for ObjOnly
    public static void countAndWrite(ObjOnly[] arr) {
    }

    public static void main(String[] args) {

        try {

            // getting input from the user
            System.out.println("Enter the number of animals: ");
            int size = scObj.nextInt();
            System.out.println("Generating " + size + " animals...");

            countAndWrite(new Both[size]);
            countAndWrite(new ObjOnly[size]);


        } catch (OutOfMemoryError e) {
            System.out.println("Memory not enough.\nAborting program.");
            System.exit(0);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!\nAborting program.");
            System.exit(0);
        }

    }
}
