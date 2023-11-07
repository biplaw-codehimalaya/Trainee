import java.io.*;

class filereader{
    public static void main(String[] args) {
        int i;
        FileInputStream fin;

        if(args.length !=1){
            System.out.println("Please specify a filename.");
        }

        try{
            fin = new FileInputStream(args[0]);

        }catch(FileNotFoundException ex){
            System.out.println("File Not FOund");
            return;
        }

        try {
            do{
                i = fin.read();
                if(i != -1) System.out.println((char)i);
            }while(i != -1);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("File cannot be read.");
        }

        try {
            fin.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("File cannot be closed.");
        }


        
    }
}