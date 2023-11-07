import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class consoleReadWrite {
    public static void main(String[] args) {
        int i;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, System.console().charset()));
        FileOutputStream fout = null;

        if(args.length !=1){
            System.out.println("Please specify a filename.");
            return;
        }

        try{
            fout = new FileOutputStream(args[0], true);
            System.out.println("Enter the data ('q' to quit): ");
            do{
                i = br.read();
                fout.write(i);
            }while(i != 'q');

        }catch(IOException e){
            System.out.println("Io Exception occurred."+ e.getStackTrace());
            return;
        }finally{
            try{
                if(fout!=null) fout.close();
            }catch(IOException ex){
                System.out.println("Error Occurred while closing the file.");
            }
        }

    }
}
