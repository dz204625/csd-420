package module5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.NavigableSet;
import java.util.TreeSet;

public class DisplayFruits {
    public static void main(String[] args){
        TreeSet<String> ts = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/module5/collection_of_words.txt"))) {
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                ts.add(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
        NavigableSet<String> descendingOrder = ts.descendingSet();
        System.out.println(ts);
        System.out.println(descendingOrder);
    }
}
