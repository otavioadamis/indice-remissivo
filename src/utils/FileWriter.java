package utils;
import java.io.IOException;

public class FileWriter {
    public void writeLines(String newFilePath, String fileContent) throws IOException {
        java.io.FileWriter output = new java.io.FileWriter(newFilePath);
        output.write(fileContent);
        output.close();
    }
}
