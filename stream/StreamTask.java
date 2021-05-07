package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class StreamTask {
    public static void main(String[] args) {
        ArrayList<String> text = new ArrayList<>();
        Collections.addAll(text, "madina", "anna", "pavel", "carrac", "react", "tenet");

        System.out.println(text.stream()
                .filter((s1-> s1.equals(new StringBuilder(s1).reverse().toString())))
                .collect(Collectors.toList()));
    }
}
