
import java.io.*;

class MyClass implements Serializable{
    String s;
    int i;
    double d;

    public MyClass(String s, int i, double d){
        this.s = s;
        this.i = i;
        this.d = d;
    }

    public String toString(){
        return "s= " +s + "; i= "+i+"; d= "+ d +";";
    }
}

public class SerializationDemo{
public static void main(String[] args) {
    try(ObjectOutputStream ob1 = new ObjectOutputStream(new FileOutputStream("serial.txt"))){
    MyClass object1 = new MyClass("Someone", 1, 1000.123);

    System.out.println("Object: "+ object1);
    ob1.writeObject(object1);

    }catch(IOException ex){
        System.out.println("Exception Occurred.");
    }

    try(ObjectInputStream ob2 = new ObjectInputStream(new FileInputStream("serial.txt"))){
        try{
            MyClass data = (MyClass) ob2.readObject();
            System.out.println(data);
        }catch(ClassNotFoundException ex){
            System.out.println("Class not found.");
        }
        
    }catch(IOException ex){
        ex.printStackTrace();
    }
}



}
