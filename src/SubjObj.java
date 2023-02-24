import org.jetbrains.annotations.NotNull;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SubjObj {

    public static Scanner scObj = new Scanner(System.in);
    public static Random rn = new Random();
    public static DecimalFormat df = new DecimalFormat("000.##");

    // function for Both
    public static void countAndWrite(Both @NotNull [] arr) {

        // allocating random boolean to O and S
        Arrays.stream(arr).forEachOrdered(x -> {
            x.setO(rn.nextBoolean());
            x.setS(rn.nextBoolean());
        });

        // calculating and assigning attrib
        Arrays.stream(arr).forEachOrdered(x -> {
            if ((x.isO()) && (x.isS()))
                x.setAttrib('a');
            else if ((x.isO()) && !(x.isS()))
                x.setAttrib('b');
            else if (!(x.isO()) && (x.isS()))
                x.setAttrib('c');
            else if (!(x.isO()) && !(x.isS()))
                x.setAttrib('d');
        });

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
                    "Selection, Consideration, Counts, Percentage\n" +
                            "Positive, Subjective and Objective," + df.format(a) + "," + df.format(((float)a/ arr.length) * 100L) + "%\n" +
                            "Positive, Only Objective,"           + df.format(b) + "," + df.format(((float)b/ arr.length) * 100L) + "%\n" +
                            "Positive, Only Subjective,"          + df.format(c) + "," + df.format(((float)c/ arr.length) * 100L) + "%\n" +
                            "Negative, disqualified,"             + df.format(d) + "," + df.format(((float)d/ arr.length) * 100L) + "%\n" +
                            "-, Total,"                           + df.format(arr.length) + "," + df.format(100) + "%\n"
            );

        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

    }

    // function for ObjOnly
    public static void countAndWrite(ObjOnly @NotNull [] arr) {

        /*  ---     assigning random boolean to R
        *           assigning respective attrib
        *           counting a and b simultaneously
        *   ---     */
        int a = 0, b = 0;
        for (ObjOnly x :
                arr) {

            x.setR(rn.nextBoolean());

            if ((x.isR()))
                a++;
            else
                b++;
        }

        // writing csv file
        try (FileWriter fw = new FileWriter("files/" + arr.length + "_ObjOnly.csv")) {

            fw.write(
                    "Selection, Counts, Percentage\n" +
                            "Positive," + df.format(a) +          "," + df.format(((float)a/ arr.length) * 100L) + "%\n" +
                            "Negative," + df.format(b) +          "," + df.format(((float)b/ arr.length) * 100L) + "%\n" +
                            "Total,"    + df.format(arr.length) + "," + df.format(100) + "%\n"
            );

        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

    }

    public static void main(String[] args) {

        try {

            // getting input from the user
            System.out.print("Enter the number of animals: ");
            int size = scObj.nextInt();
            System.out.println("Generating " + size + " animals...");

            if (size < 50)
                throw new RuntimeException("Size must be >= 50.");

            // creating object arrays
            Both[] arr1 = new Both[size];
            ObjOnly[] arr2 = new ObjOnly[size]; 
            
            // initialising objects
            for (int i = 0; i < size; i++) {
                arr1[i] = new Both();
                arr2[i] = new ObjOnly();
            }
            
            countAndWrite(arr1);
            countAndWrite(arr2);


        } catch (OutOfMemoryError e) {
            System.out.println("Memory not enough.\nAborting program.");
            System.exit(0);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!\nAborting program.");
            System.exit(0);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

    }
}
