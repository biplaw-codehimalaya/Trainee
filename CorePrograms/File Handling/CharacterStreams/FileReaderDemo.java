package CharacterStreams;

import java.io.*;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        
        try(FileReader fr = new FileReader("hello.txt")){
                int c;

                while((c= fr.read()) != -1){
                    System.out.println((char) c);
                }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
