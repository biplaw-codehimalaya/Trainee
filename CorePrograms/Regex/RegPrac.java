import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.util.Scanner;
import java.util.regex.*;


public class RegPrac {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String fileData = null;

        
        System.out.println("Enter the filename: ");
        String fileName = scanner.nextLine().strip();

        File newFile = new File(fileName);

        if(!newFile.exists()){
            System.out.println("File Does'nt exist.");
            return;
        }

        try (FileInputStream fin = new FileInputStream(newFile)) {
            byte[] readByte = new byte[fin.available()];

            fin.read(readByte);

            fileData = new String(readByte);


            Pattern emailPattern = Pattern.compile("[A-Za-z0-9.]*@[A-Za-z0-9.]*\\.[a-zA-Z]{2,4}");
            Pattern phonePattern = Pattern.compile("9\\d{9}");

            Matcher emailMatcher = emailPattern.matcher(fileData);
            Matcher phoneMatcher = phonePattern.matcher(fileData);


            List<String> emailList = new ArrayList<>();
            List<String> phoneList = new ArrayList<>();

            while(emailMatcher.find()){
                emailList.add(emailMatcher.group());
            }
            while (phoneMatcher.find()) {
                phoneList.add(phoneMatcher.group());
            }

            System.out.println("Emails: ");
            emailList.stream().forEach(System.out::println);

            System.out.println("\nPhone: ");
            phoneList.stream().forEach(System.out::println);


        } catch (Exception e) {
            // TODO: handle exception
        }

        scanner.close();
    }
}
