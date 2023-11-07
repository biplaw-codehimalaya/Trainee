


//First class

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.*;

class Person implements Comparable<Person>{
    String name;
    String address;
    int age;

    Person(String name, String address, int age){
        this.name = name;
        this.address = address;
        this.age = age;
    }

    //Getters
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getAddress(){
        return address;
    }

    //OVerriding the to string method
    public String toString(){
        return "Name: " + name + ", Age: " + age + ", Addresss: "+ address;
    }

    //Overrriding the method of compareable to compare by age
    public int compareTo(Person p1){
        return Integer.compare(getAge(), p1.getAge());
    }

}

class Student{
    String name;
    int age;

    Student(String name, int age){
        this.name = name;
        this.age = age;
    }

        //OVerriding the to string method
    public String toString(){
        return "Name: " + name + ", Age: " + age ;
    }
}
public class CustomComparatorAndStream{
    public static void main(String[] args) {
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("Ram", "KTM", 21));
        personList.add(new Person("Gita", "Pokhara", 18));
        personList.add(new Person("Janak", "Jhapa", 20));
        personList.add(new Person("Yogi", "Pokhara", 30));
        personList.add(new Person("Sita", "KTM", 18));


        //**********STREAM********** */
        //Sorted by using the Comparable
        System.out.println("Sorted Based on Age:");
        personList.stream().sorted().forEach(System.out::println);

        ////Creating a comparator based on name
        Comparator<Person> nameComparator = (Person p1, Person p2) -> p1.getName().compareTo(p2.getName());
        //Sorting based on name
        System.out.println("Sorted Based on Name: ");
        personList.stream().sorted(nameComparator).forEach(System.out::println);

        //Sorting using Collections Algorithm
        System.out.println("Sorting using name using Collections Algorithm:");
        Collections.sort(personList, nameComparator);

        //Shuffling the colleciton
        Collections.shuffle(personList);

        //Age Comparator
        Comparator<Person> ageComparator = (Person p1, Person p2) -> Integer.compare(p1.getAge(), p2.getAge());
        //Getting the max age out of the list
        Optional<Person> maxAgePerson = personList.stream().max(ageComparator);
        if(maxAgePerson.isPresent()){
            System.out.println("Person with max age: " + maxAgePerson.get());
        }

        //Filtering the colleciton
        System.out.println("Filtering age>20: ");
        personList.stream().filter(person -> person.age>20).forEach(System.out::println);

        //Limiting the result
        System.out.println("Limiting the result to 2: ");
        personList.stream().limit(2).forEach(System.out::println);

        //-------------------REDUCE OPERATION-----------
        List<Integer> intList = List.of(1, 2, 3, 4, 5);
        //Getting the sum of data in a list
        Optional<Integer> sumOfData = intList.stream().reduce((res, val) -> res+val);
        if(sumOfData.isPresent()){
            System.out.println("Sum of data in: " + intList +" is " + sumOfData.get());
        }

        //Mapping the Person to Student
        System.out.println("Person -> Student: ");
        personList.stream().map(person -> new Student(person.getName(), person.getAge())).forEach(System.out::println);

        //Collecting
        System.out.println("Collecting to list");
        List<Person> filteredPersonList = personList.stream().filter(person -> person.age>20).collect(Collectors.toList());
        for (var each : filteredPersonList) {
            System.out.println(each);
        }

        //Partitioning the data based on age
        Map<Boolean, List<Person>> partitionedPerson = personList.stream().collect(Collectors.partitioningBy(person-> person.getAge()>20));
        //Iterating and displaying the map
        System.out.println("PArtitioned based on age > 20: ");
        for(Map.Entry<Boolean, List<Person>> each: partitionedPerson.entrySet()){
            System.out.println(each.getKey() + " : " + each.getValue());
        }

        //Grouping By
        Map<Integer, List<Person>> groupingList = personList.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println("Grouping based on age: ");
        for(Map.Entry<Integer, List<Person>> each: groupingList.entrySet()){
            System.out.println(each.getKey() + " : " + each.getValue());
        }

        //Creating a map using the name as the key
        Map<String, Person> personMap = personList.stream().collect(Collectors.toMap(Person::getName, person-> person));
        System.out.println("Creating a Map out of list: ");
        for(Map.Entry<String, Person> each: personMap.entrySet()){
            System.out.println(each.getKey() + " : " + each.getValue());
        }
    }
}