import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class CSC245_Project2 {
    // Read the filename from the command line argument
    public static void main(String[] args) throws Exception {

        String filename = System.getenv("FILE_PATH");
        if (filename == null) {
            throw new Exception(".env file not found or Invalid Key");
        }
        BufferedReader inputStream = null;

        String fileLine;
        try {
            inputStream = new BufferedReader(new FileReader(filename));

            System.out.println("Email Addresses:");
            // Read one Line using BufferedReader
            while ((fileLine = inputStream.readLine()) != null) {
                System.out.println(fileLine);
            }
        } catch (IOException io) {
            System.out.println("Error reading file" + filename);
        } finally {
            // Need another catch for closing
            // the streams
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException io) {
                System.out.println("Issue closing the Files" + filename);
            }

        }
    }

}
