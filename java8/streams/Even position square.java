import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class EvenPositionSquare {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        
        // Get square of numbers at even positions (considering zero-based indexing)
        List<Integer> squaredEvenPositionNumbers = IntStream.range(0, numbers.size())
                .filter(index -> index % 2 == 0) // Filter for even positions
                .mapToObj(numbers::get)        // Get the element at the index
                .map(num -> num * num)         // Square the number
                .toList();                     // Collect as a list
        
        // Print the result
        System.out.println(squaredEvenPositionNumbers);
    }
}
