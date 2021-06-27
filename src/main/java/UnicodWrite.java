import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class UnicodWrite {

    public static void main(String[] args) {

        String fileName = "D:\\final year project\\New folder\\test.html";
        List<String> lines = Arrays.asList("line 1", "line 2", "line 3", "আমার প্রথম শিরোনাম");
        try (FileWriter fw = new FileWriter(new File(fileName), StandardCharsets.UTF_8);
             BufferedWriter writer = new BufferedWriter(fw)) {

            for (String line : lines) {
                writer.append(line);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

      //  writeUnicodeJava11(fileName, lines);
        //writeUnicodeJava8(fileName, lines);
        //writeUnicodeJava11(fileName, lines);
        //writeUnicodeClassic(fileName, lines);

        System.out.println("Done");
    }

    // Java 11 adds Charset to FileWriter
 /*   public static void writeUnicodeJava11(String fileName, List<String> lines) {

        try (FileWriter fw = new FileWriter(new File(fileName), StandardCharsets.UTF_8);
             BufferedWriter writer = new BufferedWriter(fw)) {

            for (String line : lines) {
                writer.append(line);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/

}