
//A normal interface
interface WorkString{
    String action(String data);
}
//A generic INterface
interface Work<T, V>{
    T action(V data);
}

public class LambdaDemo {
    public static void main(String[] args) {
        //======================Normal INterface =================
        //Lambda to reverse the string
        WorkString reverseString = (data) -> new StringBuffer(data).reverse().toString();

        //Lambda to verify if its a palindrome
        Work<Boolean, String> palindromeString = (data) -> {
            if(data.equals(new StringBuilder(data).reverse().toString())){
                return true;
            }
            return false;
        };
        //Lambda to verify if the Number is Plaindrome
        Work<Integer, Integer> reverseNumber = (data)->{
            Integer result = 0;

            while(data>0){
                int digit = data % 10;
                result = result * 10 + digit;
                data /= 10;
            }
            return result;
        };


        ///********Use of Functional Interface */
        System.out.println("Reverse of 'Java': " + reverseString.action("Java"));

        System.out.println("Is 'racecar' palindrome: " + palindromeString.action("racecar"));
        System.out.println("Is 'hello' plaindrome: " + palindromeString.action("hello"));

        //Reversing a number
        System.out.println("Reverse of 12345 is: " + reverseNumber.action(12345));

    }
}
