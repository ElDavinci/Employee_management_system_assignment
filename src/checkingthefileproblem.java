import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class checkingthefileproblem {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");
            File outputFile = new File("output.txt");

            System.out.println("Input file exists: " + inputFile.exists());
            System.out.println("Output file exists: " + outputFile.exists());

            System.out.println("Input file path: " + inputFile.getAbsolutePath());
            System.out.println("Output file path: " + outputFile.getAbsolutePath());

            Scanner sc = new Scanner(inputFile);
            PrintWriter pw = new PrintWriter(outputFile);
            System.out.println(sc.nextLine());

            // Perform file operations here

            sc.close();
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
