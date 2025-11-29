// Name: Justin Baker
// Date: November 29th, 2025
// Description: Simple Journal Entry Program

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

public class Journal {

    // Define the file name where entries will be saved.
    private static final String JOURNAL_FILE = "Journal.txt";

    // Define the custom date and time format for entries.
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd, yyyy @ h:mma");

    // Writes a new timestamped entry to the journal file.
    public static void main(String[] args) {

        // Get current date and time for the entry's timestamp.
        LocalDateTime now = LocalDateTime.now();

        // Corrected syntax for formatting the timestamp.
        String timestamp = now.format(formatter);

        // Get input from user.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Journal (A record of things)");
        System.out.println("Date/Time: " + timestamp);
        System.out.print("Enter your journal entry: ");
        String entry = scanner.nextLine();

        // Close the scanner to release system resources.
        scanner.close();

        // Call the separate method to handle file writing.
        writeEntry(timestamp, entry);
    }

    // Handles the logic for writing the timestamped entry to the journal file.
    private static void writeEntry(String timestamp, String entry) {

        // Format the complete journal entry line.
        // %n adds a platform-independent newline character.
        String journalLine = String.format("[%s] %s%n", timestamp, entry);

        // Write the line to the Journal.txt file. 'true' enables append mode.
        try (
                // Use try-with-resources to ensure FileWriter and PrintWriter are closed automatically
                FileWriter fileWriter = new FileWriter(JOURNAL_FILE, true);
                PrintWriter printWriter = new PrintWriter(fileWriter)
        ) {
            printWriter.print(journalLine);

            // Add an extra blank line for separation in the file
            printWriter.println();

            System.out.println("\nEntry successfully saved to " + JOURNAL_FILE);

        } catch (IOException e) {
            // Use System.err for error messages
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}