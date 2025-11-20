package map_interface;

import java.util.*;

public class InvertMap {
    public static void main(String[] args) {

        // Original map
        Map<String, Integer> original = new HashMap<>();
        original.put("A", 1);
        original.put("B", 2);
        original.put("C", 1);

        // Inverted map: value -> list of keys
        Map<Integer, List<String>> inverted = new HashMap<>();

        for (Map.Entry<String, Integer> entry : original.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            // If value not present, create new list
            inverted.putIfAbsent(value, new ArrayList<>());

            // Add key to the list
            inverted.get(value).add(key);
        }

        System.out.println(inverted);
    }
}
