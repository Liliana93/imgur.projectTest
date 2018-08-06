package classes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.*;

public class FileWriter {
    public static void writeToFile(String filename, String data) {
        Path path = Paths.get(filename);
        try (OutputStream os = new BufferedOutputStream(
                Files.newOutputStream(path, CREATE, APPEND))) {
            os.write(data.getBytes(), 0, data.length());
            System.out.println("Successfully copied response to a json file...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
