package com.targetindia.day_3.programs.assignment_2;

import java.io.*;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class TextFileAnalyzer {
    // Method to find the longest line in the array of strings
    public static String findLongestLine(String[] lines) throws IndexOutOfBoundsException{
        String longestLine = "";
        for (String line : lines) {
            if (line.length() > longestLine.length()) {
                longestLine = line;
            }
        }
        return longestLine;
    }

    // Method to find the shortest line in the array of strings
    public static String findShortestLine(String[] lines) throws IndexOutOfBoundsException{
        String shortestLine = lines[0];
        for (String line : lines) {
            if (line.length() < shortestLine.length()) {
                shortestLine = line;
            }
        }
        return shortestLine;
    }

    // Method to count the number of words in each line and store them in an ar
    public static int[] countWords(String[] lines) throws ArrayIndexOutOfBoundsException{
        int[] wordCounts = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            String[] words = lines[i].split("\\s+");
            wordCounts[i] = words.length;
            System.out.println("Line "+i+": "+words.length);
        }
        return wordCounts;
    }

    // Method to sort the array of word counts in descending order
    public static void sortWordCount(int[] wordCounts) {
        Arrays.sort(wordCounts);
        for (int i = 0; i < wordCounts.length / 2; i++) {
            int temp = wordCounts[i];
            wordCounts[i] = wordCounts[wordCounts.length - 1 - i];
            wordCounts[wordCounts.length - 1 - i] = temp;
        }
    }

    // Main method to execute the program
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("TextFileAnalyzer <filename>");
            return;
        }
        String fileName = args[0];
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String[] lines = sb.toString().split("\n");

            // Find longest line
            String longestLine = findLongestLine(lines);
            System.out.println("Longest line: " + longestLine);

            // Find shortest line
            String shortestLine = findShortestLine(lines);
            System.out.println("Shortest line: " + shortestLine);

            // Count words in each line
            int[] wordCounts = countWords(lines);

            // Sort word counts in descending order
            sortWordCount(wordCounts);
            System.out.println("Word counts in descending order:");
            for (int count : wordCounts) {
                System.out.println(count);
            }
        } catch (IOException | IndexOutOfBoundsException e) {
            log.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}
