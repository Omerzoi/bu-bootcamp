import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String filePath = "numbers.txt";

        ReadFileContents(filePath);
    }

    private static void ReadFileContents(String filePath) {
        if (filePath == null) {
            System.out.println("filePath cannot be null.");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int intParsedValue = Integer.parseInt(line.trim());
                    double doubledParsedValue = Double.parseDouble(line.trim());

                    System.out.println("Original value:" + line + ", Parsed value to Int:"+intParsedValue+", Parsed value to double:" + doubledParsedValue);
                } catch (NumberFormatException  e) {
                    System.out.println("Failed to parse value, skipping line text:" + line);
                }
            }
        }
        catch(IOException e){
            System.out.println("Cannot read the file:"+ filePath + ", error:"+e.getMessage());
        }

    }
    
}