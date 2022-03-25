///////////////////////////////////////////////////////////////////////////////
//
// Main Class File: CSC245_Project2.java
// Semester:        Spring 2022
// Authors:         Arielle Collins, Morgan Otto, Rylan Peterson, Tim Oehrlein
//
///////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader; // needed to read text from character-input stream
import java.io.File; // needed to access file
import java.io.FileReader; // needed to read file
import java.io.IOException; // needed for exception handling
import java.text.Normalizer; // needed to normalize input

public class CSC245_Project2 {
    /**
     * parses through a file and returns the contents after it is sanitized
     * @param args - required by Java but not used
     * @throws Exception - IO exception
     * Canonicalize - cleans up the path by removing and resolving (., ..) etc. and returning a unique absolute path
     * Validation - the process of checking user input or the values from the database against specific constraints
     * Normalize - transform Unicode characters into an equivalent form, allowing for easier sorting and searching of text.
     * Sanitize - prevents the insertion of malicious data into a subsystem
     * Data Leakage - the unauthorized transmission of data to an external recipient
     */
    public static void main(String[] args) throws Exception {
        // Get canonical path from value that is configured in the FILE_PATH env variable
        String filename = new File(System.getenv("FILE_PATH")).getCanonicalPath();
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
                    // Only allow characters, digits, @ and .
                    if(Character.isLetterOrDigit(x) || x == '@' || x == '.') {
                        line.append(x);
                    }
                }
                fileLine = line.toString();
                
                System.out.println(fileLine);
            }
            //stacktrace removed from system.out.println to prevent data leakage
        } catch (IOException io) {
            System.out.println("Error reading file" + filename);
            //'Finally' block used to close the input stream
        } finally {
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
