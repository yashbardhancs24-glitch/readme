package map_interface;

import java.io.*;
import java.util.*;

public class WordFrequencyCounte {
    public static void main(String[] args) {
        
        String filePath = "input.txt";

        
        Map<String, Integer> wordCount = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = br.readLine()) != null) {
                
                line = line.toLowerCase().replaceAll("[^a-z0-9 ]", " ");

                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.length() > 0) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(wordCount);
    }
}
