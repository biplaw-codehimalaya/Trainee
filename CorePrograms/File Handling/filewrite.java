import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class filewrite {
    public static void main(String[] args) {
        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;

        if(args.length != 2){
            System.out.println("Please Specify the filenames.");
            return;
        }

        //Copy a file
        try {
            //Attempt to open a file
            fin = new FileInputStream(args[0]);
            fout = new FileOutputStream(args[1], true);

            do{
                i = fin.read();
                if(i!=-1) fout.write(i);
            }while(i!=-1);

        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("eXCEPTION OCCURRED: "+ e.getStackTrace());
        }finally{
            try{
                if(fin != null) fin.close();
            }catch(IOException e){
                System.out.println("Cannot close file 1.");
            }

            try{
                if(fout != null) fout.close();
            }catch(IOException e){
                System.out.println("Cannot close file 2.");
            }
        }
    }
    
}
