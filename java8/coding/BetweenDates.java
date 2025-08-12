package coding;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

// Problem: Given a List of logRecords write a method to find the log records between two DateTime using Java Streams API
// e.g. Given
// List<String> logRecords = Arrays.asList(
//             "2023-06-21 14:35:00 INFO Application started successfully",
//             "2023-06-21 14:40:00 DEBUG Loading configuration",
//             "2023-06-21 14:45:00 INFO Application shutdown",
//             "2023-06-21 14:50:00 ERROR Failed to load resource"
//         );
// Find records between “2023-06-21 14:35:0” and “2023-06-21 14:45:00”


public class BetweenDates {

    static void getResult(String beginDate, String endDate) {

        List<String> logRecords = Arrays.asList(
            "2023-06-21 14:35:00 INFO Application started successfully",
            "2023-06-21 14:40:00 DEBUG Loading configuration",
            "2023-06-21 14:45:00 INFO Application shutdown",
            "2023-06-21 14:50:00 ERROR Failed to load resource"
        );

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime starDateTime = LocalDateTime.parse(beginDate, formatter);
        LocalDateTime enDateTime = LocalDateTime.parse(endDate, formatter);

        logRecords.stream()
            .filter((records) -> {
                String dateTime = records.substring(0, 19);
                LocalDateTime recordDateTime = LocalDateTime.parse(dateTime, formatter);
                return (recordDateTime.isAfter(starDateTime) || recordDateTime.isEqual(starDateTime)) &&
                       (recordDateTime.isBefore(enDateTime) || recordDateTime.isEqual(enDateTime));
            })
            .forEach(System.out::println);
    }

    public static void main(String[] args) {

        String beginDate = "2023-06-21 14:35:00";
        String endDate = "2023-06-21 14:45:00";

        getResult(beginDate, endDate);

        // Scanner in  = new Scanner(System.in);

        // month = new int[15];

        // String s = in.nextLine();


        
    }

}
