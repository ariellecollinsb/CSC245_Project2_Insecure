//Tim Oehrlein
//Secure Software Development
//Program to identify and mitigate several possible errors

import java.io.*;       //Importing all the java.io classes

public class CSC245_Project2 {

    public static void main(String[] args) {
        // Read the filename from the command line argument
        String fileName = args[0];                 //assigning fileName to argument 0
        BufferedReader inputStream;         //buffered reader class
        File file;                          //File class
        String fileLine;        //String variable to read through the file

        try {

            file = new File(System.getenv("c:\\Users\\kapta\\IdeaProjects\\CSC245_Project2_Secure") + fileName).getCanonicalFile();
            inputStream = new BufferedReader(new FileReader(fileName));

            if (!file.getPath().startsWith("c:\\Users")) {                  //if the file doesn't start with a specific string access is denied
                System.out.println("Access denied");
                return;
            }

            while ((fileLine = inputStream.readLine()) != null) {       //loop to read through the file selected
                System.out.println(fileLine);

            }

        } catch (IOException x) {
            System.out.println("Invalid File");
        }
//        try {
//            FileInputStream fileInputStream = new FileInputStream(file);
//        } catch (FileNotFoundException x) {
//            System.out.println("Invalid file");
//        }
    }

}
