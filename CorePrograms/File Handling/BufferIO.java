import java.io.*;

public class BufferIO {
    public static void main(String[] args) {
        
        try(FileInputStream f0 = new FileInputStream("hello.txt");
            BufferedInputStream b0 = new BufferedInputStream(f0);
            FileOutputStream f1 = new FileOutputStream("outputs.txt");
            BufferedOutputStream b1 = new BufferedOutputStream(f1)){
            
            byte[] arr1 = new byte[f0.available()];
            int c;
            
            b0.read(arr1);
            b1.write(arr1);

            // while( (c= b0.read(arr1)) != -1){
            //     b1.write(arr1,0,c);
            // }
            b1.flush();
            

            /*Custom reading the input from the user.

            // Scanner scanner = new Scanner(System.in);
            // System.out.println("Enter the data to write: ");
            // String data = scanner.nextLine();
            // //Gettting the Bytes array from the data
            // byte[] readBytes = data.getBytes();  
            */

    

        }catch(IOException ex){
            System.out.println("Exception Occurred.");
        }
    }
}
