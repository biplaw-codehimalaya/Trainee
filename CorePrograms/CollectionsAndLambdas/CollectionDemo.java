import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        //Creating a list 
        List<Integer> data1 = new ArrayList<>();
        data1.add(4);
        data1.add(5);
        data1.add(1);
        data1.add(20);
        data1.add(15);
        data1.add(17);

        //Creating a list using the factory method(unmutable)
        List<Integer> unmutableList = List.of(1, 2, 3, 4, 5);

        System.out.println("Data1 is empty: " + data1.isEmpty());

        //Using the Collectins algorithm
        Collections.shuffle(data1);
        //OBtaining the iterator
        Iterator<Integer> iterator = data1.iterator();
        System.out.println("Shuffled Data: ");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //Sorting the in reverse order
        Collections.sort(data1, Comparator.reverseOrder());

        //Obtaining the splititerator
        Spliterator<Integer> iter = data1.spliterator();
        //Sorted Data
        System.out.println("Sorted Data in reverse Order : ");
        while (iter.tryAdvance(System.out::println));

        //Converting to array ofobjects
        Object[] data1ArrayObject = data1.toArray();
        System.out.println("COnverting the lsit to array of OBjects: ");
        for(var each: data1ArrayObject){
            System.out.println(each);
        }

        Integer[] data1Array = data1.toArray(new Integer[0]);
        System.out.println("COnverting the lsit to array: ");
        for(var each: data1Array){
            System.out.println(each);
        }

        ///******** ARRAYS ******************/
        String[] data2 = {"A", "Z", "B", "P", "Y"};

        //Serchingin array:
        if(Arrays.binarySearch(data2, "B") != -1){
            System.out.println("Found in array");
        }else{
            System.out.println("Data not found in array.");
        }

        //Sorting the array
        Arrays.sort(data2);

        //Obtaining the splititerator for the array 
        System.out.println("Sorted data in array: ");
        Spliterator<String> iter1 = Arrays.asList(data2).spliterator();
        iter1.forEachRemaining(System.out::println);

        ///Creating a map using Factory method
        Map<Integer, String> map1 = Map.of(1, "A", 2, "B", 3, "C");

        //Iterating and displaying the map 
        System.out.println("Data in Map: ");
        for(Map.Entry<Integer, String> each: map1.entrySet()){
            System.out.println(each.getKey()+" : " + each.getValue());
        }

        //Obtaining the keySet
        Set<Integer> keySet = map1.keySet();
        //Obtaining the values
        String[] valueSet =  map1.values().toArray(new String[0]);
    }
}
