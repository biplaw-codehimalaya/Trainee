import java.io.File;

public class FIlePorperty {
    static void p(String s){
        System.out.println(s);
    }

    public static void main(String[] args) {
        File f1 = new File("C:\\Users\\beepl\\Desktop\\Trainee\\learn.docx");

        p("File Name: "+ f1.getName());
        p("Path: "+ f1.getPath());
        p("Absolute Path: "+ f1.getAbsolutePath());
        p("Parent: "+ f1.getParent());
        p("If : "+ f1.getAbsolutePath());
        p(f1.exists()?"exists":"does not exist");
        p(f1.canRead()? "Can read": "cannot read");
        p(f1.canWrite()?"Can Write":"Cannot write");
        p("is"+(f1.isDirectory()?"":"not"+"directory"));

        p("is" + f1.isFile());
        p("Last modified: " + f1.lastModified());
        p("Size: "+f1.length());

    }
}
