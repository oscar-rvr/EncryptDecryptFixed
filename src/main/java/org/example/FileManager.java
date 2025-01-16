package org.example;


import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileManager {
    public static String readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename) )) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString().trim();
        } catch (IOException e) {
            System.out.println("Error: Unable to read file -> " + filename);
            return null;
        }
    }

    public static void writeFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter((new FileWriter(filename))      ) ) {

            writer.write(content);
        } catch (IOException e) {
            System.out.println("Error: Unable to write to file -> " + filename);
        }
    }
}
