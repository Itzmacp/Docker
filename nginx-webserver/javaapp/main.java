import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDateTime {
    public static void main(String[] args) {
        // 1. Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // 2. Define the format you want
        // Example: "yyyy-MM-dd HH:mm:ss" -> 2026-04-15 17:50:04
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 3. Format the date and time
        String formattedDate = now.format(formatter);

        // 4. Display the result
        System.out.println("Current Date and Time: " + formattedDate);
    }
}