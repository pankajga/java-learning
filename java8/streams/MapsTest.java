package streams;

import java.util.HashMap;
import java.util.Map;

public class MapsTest {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        Map<String, String> map1 = new HashMap<>();
        map1.put("England", "London");
        map1.put("Netherland", "Amsterdam");
        map1.put("France", "Paris");

        Map<String, String> map2 = new HashMap<>();
        map2.put("India", "New Delhi");
        map2.put("England", "London");
        map2.put("France", "Italy");

        map1.forEach((k,v) -> {
            map2.merge(k, v, (o, n) -> o + "->"+n);
        });

        System.out.println(map1); // {Netherland=Amsterdam, England=London, France=Paris}
        System.out.println(map2); // {Netherland=Amsterdam, England=London->London, France=Italy->Paris, India=New Delhi}

    }
}
