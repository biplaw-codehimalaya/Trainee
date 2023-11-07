import java.io.*;

class OnlyExtension implements FilenameFilter{

    String ext;

    public OnlyExtension(String s){
        ext = s;
    }

    public boolean accept(File dir, String name){
        return name.endsWith(ext);
    }
}
public class MyDir {
    public static void main(String[] args) {
        File f2 = new File("C:\\Users\\beepl\\Desktop\\Trainee\\OCT10\\Test");
        
        if(f2.mkdirs()){
            System.out.println("Directory Created Successfully.");
        }else{
            System.out.println("Directory Couldn't be created.");
        }

        if(f2.delete()){
            System.out.println("Directory Deleted.");
        }
        else{
            System.out.println("Directory couldn't be deleted.");
        }

        File f1 = new File("C:\\Users\\beepl\\Desktop\\Trainee\\OCT10\\Test\\Demo");
        f1.mkdir();

        FilenameFilter only = new OnlyExtension("class");
        String[] data = f1.list(only);

        for(var each: data){
            System.out.println(each);
        }

        
    }
}
