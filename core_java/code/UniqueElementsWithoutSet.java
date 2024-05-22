package code;

import java.util.ArrayList;
import java.util.List;

/**
 *  You have an ArrayList of integers.
 *  Write function which will accept List and return new List with unique elements.
 *  You can't use Set Implementations.
 */

public class UniqueElementsWithoutSet {

    static void unique(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for(Integer i : list) {
            if(!result.contains(i)) {
                result.add(i);
            }
        }
        System.out.println(result); //[1, 2, 3, 5, 6]
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,2,5,1,6);
        unique(list);
    }

    
}
