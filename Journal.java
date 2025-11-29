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

    private static final String JOURNAL_FILE = "Journal.txt";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd, yyyy @ h:mma");

    // Writes a new timestamped entry to the journal file.
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(formatter);

        // Format the journal entry
        String journalLine = String.format("[%s] %s%n", timestamp, entry);

        // Write the line to the Journal.txt file.
        try {
            FileWriter fileWriter = new FileWriter(JOURNAL_FILE, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(journalLine);
            printWriter.println();

            printWriter.close();
            fileWriter.close();

            System.out.println("\nEntry successfully saved to " + JOURNAL_FILE);

        } catch (IOException e) {
            System.err.println("An error occured while writing to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // Gets current date and time for entry.
        String timestamp = LocalDateTime.now()format.(formatter);

        // Get input from user.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Journal (A record of things)");
        System.out.println("Date/Time: " + timestamp);
        System.out.print("Enter your journal entry: ");
        String entry = scanner.nextLine();
        scanner.close();
        
        writeEntry(entry);
    }
}