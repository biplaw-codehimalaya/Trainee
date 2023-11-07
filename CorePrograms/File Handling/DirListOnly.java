import java.io.*;

class OnlyExt implements FilenameFilter{
    String ext;

    public OnlyExt(String s){
        ext = s;
    }

    public boolean accept(File dir, String name){
        return name.endsWith(ext);
    }
}

public class DirListOnly {
    public static void main(String[] args) {
        File f1 = new File("C:\\Users\\beepl\\Desktop\\Trainee");

        FilenameFilter only = new OnlyExt("docx");

        String[] s = f1.list(only);

        for(var each: s){
            System.out.println(each);
        }
    }
}
