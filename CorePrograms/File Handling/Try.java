import java.io.FileInputStream;

public class Try {
    public static void main(String[] args) {
        int size;

        try(FileInputStream f = new FileInputStream("filereader.java")){

            //Gives the number of byets availabe to read. 
            System.out.println("Total Available bytes: "+ (size=f.available()));

            int n = size/40;

            System.out.println("First "+ n + " bytes of the file on read() at a time");
            for(int i=0;i<n;i++){
                System.out.println((char) f.read());
            }

            System.out.println("Still Available: "+ f.available());

            System.out.println("Reading the next "+n + " with one read(b[])");
            byte[] b = new byte[n];
            if(f.read(b) != n){
                System.out.println("Couldn't read "+ n + " bytes.");
            }



        }catch (Exception e) {
            // TODO: handle exception
        }
    }
}
