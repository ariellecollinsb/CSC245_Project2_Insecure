import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.text.Normalizer;

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
                // Normalize data
                fileLine = Normalizer.normalize(fileLine, Normalizer.Form.NFKC);
                
                // Sanitize each character before printing
                StringBuilder line = new StringBuilder(fileLine.length());
                for(int i = 0; i < fileLine.length(); i++) {
                    char x = fileLine.charAt(i);
                    if(Character.isLetterOrDigit(x) || x == ' ' || x == '\'') {
                        line.append(x);
                    }
                }
                fileLine = line.toString();
                
                System.out.println(fileLine);
            }
        } catch (IOException io) {
            System.out.println("File IO exception" + io.getMessage());
        } finally {
            // Need another catch for closing
            // the streams
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException io) {
                System.out.println("Issue closing the Files" + io.getMessage());
            }

        }
    }

}
