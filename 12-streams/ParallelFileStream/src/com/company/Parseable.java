package com.company;

import com.sun.tools.javac.util.List;

import java.text.ParseException;
import java.util.Arrays;

public class Parseable {
    public static void main(String[] args) {
        java.util.List<String> numbers = Arrays.asList("hello", "two", "12", "19", "fifty");
        int total = numbers.stream()
                .filter(Parseable::isParsable)
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .get();
        System.out.println("Total: " + total);
    }

    public static boolean isParsable(String input){
        boolean parsable = true;
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            parsable = false;
        }
        return parsable;
    }
}
