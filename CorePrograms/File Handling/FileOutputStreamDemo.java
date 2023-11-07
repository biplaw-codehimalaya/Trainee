import java.io.*;

public class FileOutputStreamDemo {
    public static void main(String[] args) {
        String source = "Now is the time for all good men\n"
        + " to come to the aid of their country\n"
        + " and pay their due taxes.";

        byte[] buf = source.getBytes();

        try(FileOutputStream f0 = new FileOutputStream("final.txt", false);
            FileOutputStream f1 = new FileOutputStream("hello.txt", false)){

            //Write to first file
            for(int i=0;i<buf.length;i++){
                f0.write(buf[i]);
            }
            //Write to second file
            f1.write(buf);

        }catch(IOException ex){
            System.out.println("Exception Occurred: " + ex);
        }

    }
}
