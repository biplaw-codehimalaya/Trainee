import java.io.FileInputStream;
import java.util.regex.Pattern;
import java.util.regex.*;
import java.util.*;

public class Regex {
    //Extract the phone numbers out of the texts
    

    //Split the text on period.
    static List<String> splitOnPeriod(String text){


        //Creating a pettern.
        Pattern pattern = Pattern.compile("\\.");
        //Create a matcher for matching
        String[] returnData = pattern.split(text);

        return Arrays.asList(returnData);
    }

    //Extract the emails
    static List<String> extractEmails(String text){
        //Defining a return list
        List<String> returnEmails = new ArrayList<>();
        //Creating a pattern for emails
        Pattern pattern = Pattern.compile("[a-zA-Z.0-9]+@[a-zA-Z.0-9]+\\.[a-zA-Z]{2,5}");
        //Creating a matcher to match with the patern.
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            returnEmails.add(matcher.group());
        }
        return returnEmails;
    }
    public static void main(String[] args) {
        String readData = null;

        //OPen the file containing emails 
        try (FileInputStream fin = new FileInputStream("demo.txt")) {
            //Create a byte array of the available input read size 
            byte[] readDataByte = new byte[fin.available()];
            //Read the data from the file into the byte array.
            fin.read(readDataByte);
            //Construct a string from the byte array.
            readData = new String(readDataByte);

        } catch (Exception e) {
            // TODO: handle exception
        }

        // Call the method to extract emails
        // List<String> extractedEmails = extractEmails(readData);

        // //Extracted emails printing
        // System.out.println("Extracted Emails: ");
        // for(String email: extractedEmails){
        //     System.out.println(email);
        // }


            // Call the split method
            List<String> splitData = splitOnPeriod(readData);

            //Extracted emails printing
            System.out.println("Splited Data: ");
            for(String line: splitData){
                System.out.println(line);
                System.out.println("\n");
            }
    }
}
