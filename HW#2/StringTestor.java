import java.sql.Time;
import java.util.*;

class StringTestor{
    public static void main(String[] args){
        if(examineMyString("Hello World!")){
            System.out.println("test passed!");
            
        }
        else {
            System.out.println("test failed.");
        }

        
    }
    
    public static boolean examineMyString(String input){
        MyString myString = new MyString(input.toCharArray());
        boolean passed = true;

        Random random = new Random(System.currentTimeMillis());
        System.out.println("Input String : " + input + "\n");

        System.out.println("toCharArray() test");
        System.out.println("String : " + new String(input.toCharArray()));
        System.out.println("MyString: " + new String(myString.toCharArray()));
        System.out.println("");
        for(int i = 0; i < input.length(); i++){
            if(input.toCharArray()[i] != myString.toCharArray()[i]){
                passed = false;
            }
        }

        System.out.println("equals() test");
        System.out.println("String(random String) : " + input.equals("klaj;sdfjklfds afjsdk"));
        System.out.println("MyString(random String) : " + myString.equals(new MyString("klaj;sdfjklfds afjsdk")));
        if(input.equals("klaj;sdfjklfds afjsdk") != myString.equals(new MyString("klaj;sdfjklfds afjsdk"))){
            passed = false;
        }
        System.out.println("String(equal String) : " + input.equals(new String(input.toCharArray())));
        System.out.println("MyString(equal String) : " + myString.equals(new MyString(input.toCharArray())));
        System.out.println();
        if(input.equals(new String(input.toCharArray())) != myString.equals(new MyString(input.toCharArray()))){
            passed = false;
        }

        System.out.println("toLowerCase() test");
        System.out.println("String : " + input.toLowerCase());
        System.out.println("MyString : " + new String(myString.toLowerCase().toCharArray()));
        System.out.println();
        for(int i = 0; i < input.length(); i++){
            if(input.toLowerCase().toCharArray()[i] != myString.toLowerCase().toCharArray()[i]){
                passed = false;
            }
        }

        System.out.println("toUpperCase() test");
        System.out.println("String : " + input.toUpperCase());
        System.out.println("MyString : " + new String(myString.toUpperCase().toCharArray()));
        System.out.println();        
        for(int i = 0; i < input.length(); i++){
            if(input.toUpperCase().toCharArray()[i] != myString.toUpperCase().toCharArray()[i]){
                passed = false;
            }
        }


        System.out.println("equalsIgnoreCase() test");
        System.out.println("String(random String) : " + input.equalsIgnoreCase("klaj;sdfjklfds afjsdk"));
        System.out.println("MyString(random String) : " + myString.equalsIgnoreCase(new MyString("klaj;sdfjklfds afjsdk")));
        if(input.equalsIgnoreCase("klaj;sdfjklfds afjsdk") != myString.equalsIgnoreCase(new MyString("klaj;sdfjklfds afjsdk"))){
            passed = false;
        }
        System.out.println("String(equal String) : " + input.equalsIgnoreCase(new String(input.toCharArray()).toLowerCase()));
        System.out.println("MyString(equal String) : " + myString.equalsIgnoreCase(new MyString(input.toCharArray()).toLowerCase()));
        System.out.println();
        if(input.equalsIgnoreCase(new String(input.toCharArray()).toLowerCase()) != myString.equalsIgnoreCase(new MyString(input.toCharArray()).toLowerCase())){
            passed = false;
        }

        int start = random.nextInt(input.length());
        int end = random.nextInt(input.length() - start) + start;
        System.out.println("substring(" + start + ", " + end + ") test");
        System.out.println("String : " + input.substring(start, end));
        System.out.println("MyString : " + new String(myString.substring(start, end).toCharArray()));
        if(!input.substring(start, end).equals(new String(myString.substring(start, end).toCharArray()))){
            passed = false;
        }
        
        return passed;
    }
}