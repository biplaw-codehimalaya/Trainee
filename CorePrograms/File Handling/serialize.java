import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable{
    private String name;
    private transient int age;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    String getName(){
        return this.name;
    }

    int getAge(){
        return this.age;
    }
}
public class serialize {
    public static void main(String[] args) {
        
        // Serialize an object to a file
        try (FileOutputStream fileOut = new FileOutputStream("student.ser");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            Student student = new Student("Alice", 20);
            objectOut.writeObject(student);

            System.out.println("Serialized: " + student.getName() + ", Age: " + student.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the object from the file
        try (FileInputStream fileIn = new FileInputStream("student.ser");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            Student loadedStudent = (Student) objectIn.readObject();
            System.out.println("Deserialized: " + loadedStudent.getName() + ", Age: " + loadedStudent.getAge());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
