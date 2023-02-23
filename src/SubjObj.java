import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class SubjObj {

    public static Scanner scObj = new Scanner(System.in);
    public static Random rn = new Random();
    public static DecimalFormat df = new DecimalFormat("000.##");

    // function for Both
    public static void countAndWrite(Both[] arr) {

        // allocating random boolean to O and S
        for (Both x :
                arr) {
            x.setO(rn.nextBoolean());
            x.setS(rn.nextBoolean());
        }

        // calculating and assigning attrib
        for (Both x:
             arr) {

            if ( (x.isO()) && (x.isS()) )
                x.setAttrib('a');
            else if ( (x.isO()) && !(x.isS()) )
                x.setAttrib('b');
            else if ( !(x.isO()) && (x.isS()) )
                x.setAttrib('c');
            else if ( !(x.isO()) && !(x.isS()) )
                x.setAttrib('d');
        }

        // counting attrib
        int a = 0, b = 0, c = 0, d = 0;
        for (Both x :
                arr) {
            switch (x.getAttrib()) {
                case 'a' -> a++;
                case 'b' -> b++;
                case 'c' -> c++;
                case 'd' -> d++;
            }
        }

        // writing csv file
        try (FileWriter fw = new FileWriter("files/" + arr.length + "_Both.csv")) {

            fw.write(
                    "Selection, Consideration, Counts, Percentege\n" +
                            "Positive, Subjective and Objective," + df.format(a) + "," + df.format((a/ arr.length) * 100L) + "%\n" +
                            "Positive, Only Objective,"           + df.format(b) + "," + df.format((b/ arr.length) * 100L) + "%\n" +
                            "Positive, Only Subjective,"          + df.format(c) + "," + df.format((c/ arr.length) * 100L) + "%\n" +
                            "Negative, disqualified,"             + df.format(d) + "," + df.format((d/ arr.length) * 100L) + "%\n" +
                            "-, Total,"                           + df.format(arr.length) + "," + df.format(100) + "%\n"
            );

        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

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
