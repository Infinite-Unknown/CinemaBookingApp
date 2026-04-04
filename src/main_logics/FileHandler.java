package main_logics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles reading and writing data to text files.
 * Demonstrates: method overloading, exception handling.
 * @author Chan Hao Wen
 */
public class FileHandler {

    private static final String DATA_DIR = "src/data/";

    // Read all lines from a file.
    public static List<String> readLines(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        File file = new File(DATA_DIR + filename);
        if (!file.exists()) {
            return lines;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }
        }
        return lines;
    }

    // Method overloading, read lines with filter.
    public static List<String> readLines(String filename, String filterValue, int fieldIndex) throws IOException {
        List<String> allLines = readLines(filename);
        List<String> filtered = new ArrayList<>();
        for (String line : allLines) {
            String[] parts = line.split("\\|");
            if (parts.length > fieldIndex && parts[fieldIndex].equals(filterValue)) {
                filtered.add(line);
            }
        }
        return filtered;
    }

    // Write all lines to a file (overwrite).
    public static void writeLines(String filename, List<String> lines) throws IOException {
        File file = new File(DATA_DIR + filename);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        }
    }

    // Append a single line to a file.
    public static void appendLine(String filename, String line) throws IOException {
        File file = new File(DATA_DIR + filename);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(line);
            bw.newLine();
        }
    }

    // Update a specific line by ID (first field before |).
    public static void updateLine(String filename, String id, String newLine) throws IOException {
        List<String> lines = readLines(filename);
        List<String> updatedLines = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (parts[0].equals(id)) {
                updatedLines.add(newLine);
            } else {
                updatedLines.add(line);
            }
        }
        writeLines(filename, updatedLines);
    }

    // Delete a line by ID.
    public static void deleteLine(String filename, String id) throws IOException {
        List<String> lines = readLines(filename);
        List<String> updatedLines = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (!parts[0].equals(id)) {
                updatedLines.add(line);
            }
        }
        writeLines(filename, updatedLines);
    }

    // Generate next ID given prefix and filename (ex: "M" + movies.txt -> "M003").
    public static String generateNextId(String filename, String prefix) throws IOException {
        List<String> lines = readLines(filename);
        int maxNum = 0;
        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (parts[0].startsWith(prefix)) {
                try {
                    int num = Integer.parseInt(parts[0].substring(prefix.length()));
                    if (num > maxNum) {
                        maxNum = num;
                    }
                } catch (NumberFormatException e) {
                    // ignore those invalid IDs.
                }
            }
        }
        return prefix + String.format("%03d", maxNum + 1);
    }
}
