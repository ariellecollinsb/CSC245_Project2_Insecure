import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;

public class CSC245_Project2 {
    // Read the filename from the command line argument
    public static void main(String[] args) throws Exception {

        String filename = System.getenv("FILE_PATH");
        if (filename == null) {
            //exception message written so it can be read and understood by any user
            throw new Exception("Environment file not found or is in an incorrect format.");
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
            //stacktrace removed from system.out.println to prevent data leakage
        } catch (IOException io) {
            System.out.println("Error reading file" + filename);
        } finally {
            // Need another catch for closing
            // the streams
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                //stacktrace removed from system.out.println to prevent data leakage
            } catch (IOException io) {
                System.out.println("Issue closing the Files" + filename);
            }

        }
    }

}
