import java.io.*;

public class directory {
    public static void main(String[] args) {
        File f1 = new File("C:\\Users\\beepl\\Desktop\\Trainee");

        if(f1.isDirectory()){
            Object[] data = f1.listFiles();

            for(var each: data){
                System.out.println(each);
            }
        }

    }
}
