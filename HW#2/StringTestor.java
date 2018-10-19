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
        System.out.println("String    : " + new String(input.toCharArray()));
        System.out.println("MyString  : " + new String(myString.toCharArray()));
        System.out.println("");
        for(int i = 0; i < input.length(); i++){
            if(input.toCharArray()[i] != myString.toCharArray()[i]){
                passed = false;
            }
        }

        System.out.println("equals() test");
        System.out.println("String(random String)    : " + input.equals("klaj;sdfjklfds afjsdk"));
        System.out.println("MyString(random String)  : " + myString.equals(new MyString("klaj;sdfjklfds afjsdk")));
        if(input.equals("klaj;sdfjklfds afjsdk") != myString.equals(new MyString("klaj;sdfjklfds afjsdk"))){
            passed = false;
        }
        System.out.println("String(equal String)    : " + input.equals(new String(input.toCharArray())));
        System.out.println("MyString(equal String)  : " + myString.equals(new MyString(input.toCharArray())));
        System.out.println();
        if(input.equals(new String(input.toCharArray())) != myString.equals(new MyString(input.toCharArray()))){
            passed = false;
        }

        System.out.println("toLowerCase() test");
        System.out.println("String    : " + input.toLowerCase());
        System.out.println("MyString  : " + new String(myString.toLowerCase().toCharArray()));
        System.out.println();
        for(int i = 0; i < input.length(); i++){
            if(input.toLowerCase().toCharArray()[i] != myString.toLowerCase().toCharArray()[i]){
                passed = false;
            }
        }

        System.out.println("toUpperCase() test");
        System.out.println("String    : " + input.toUpperCase());
        System.out.println("MyString  : " + new String(myString.toUpperCase().toCharArray()));
        System.out.println();        
        for(int i = 0; i < input.length(); i++){
            if(input.toUpperCase().toCharArray()[i] != myString.toUpperCase().toCharArray()[i]){
                passed = false;
            }
        }


        System.out.println("equalsIgnoreCase() test");
        System.out.println("String(random String)    : " + input.equalsIgnoreCase("klaj;sdfjklfds afjsdk"));
        System.out.println("MyString(random String)  : " + myString.equalsIgnoreCase(new MyString("klaj;sdfjklfds afjsdk")));
        if(input.equalsIgnoreCase("klaj;sdfjklfds afjsdk") != myString.equalsIgnoreCase(new MyString("klaj;sdfjklfds afjsdk"))){
            passed = false;
        }
        System.out.println("String(equal String)    : " + input.equalsIgnoreCase(new String(input.toCharArray()).toLowerCase()));
        System.out.println("MyString(equal String)  : " + myString.equalsIgnoreCase(new MyString(input.toCharArray()).toLowerCase()));
        System.out.println();
        if(input.equalsIgnoreCase(new String(input.toCharArray()).toLowerCase()) != myString.equalsIgnoreCase(new MyString(input.toCharArray()).toLowerCase())){
            passed = false;
        }

        int start = random.nextInt(input.length());
        int end = random.nextInt(input.length() - start) + start;
        System.out.println("substring(" + start + ", " + end + ") test");
        System.out.println("String    : " + input.substring(start, end));
        System.out.println("MyString  : " + new String(myString.substring(start, end).toCharArray()));
        System.out.println();
        if(!input.substring(start, end).equals(new String(myString.substring(start, end).toCharArray()))){
            passed = false;
        }
        
        start = random.nextInt(input.length());
        System.out.println("substring(" + start + ") test");
        System.out.println("String    : " + input.substring(start));
        System.out.println("MyString  : " + new String(myString.substring(start).toCharArray()));
        System.out.println();
        if(!input.substring(start).equals(new String(myString.substring(start).toCharArray()))){
            passed = false;
        }

        end = random.nextInt(input.length());
        System.out.println("startsWith() test");
        System.out.println("String(equal)    : " + input.startsWith(input.substring(0, end)));
        System.out.println("MyString(equal)  : " + myString.startsWith(myString.substring(0, end)));
        if(input.startsWith(input.substring(0, end)) != myString.startsWith(myString.substring(0, end))){
            passed = false;
        }
        System.out.println("String(inequal)    : " + input.startsWith("=-/v."));
        System.out.println("MyString(inequal)  : " + myString.startsWith(new MyString("=-/v.".toCharArray())));
        System.out.println();
        if(input.startsWith("=-/v.") != myString.startsWith(new MyString("=-/v."))){
            passed = false;
        }

        start = random.nextInt(input.length());
        System.out.println("endsWith() test");
        System.out.println("String(equal)    : " + input.endsWith(input.substring(start)));
        System.out.println("MyString(equal)  : " + myString.endsWith(myString.substring(start)));
        if(input.endsWith(input.substring(0, end)) != myString.endsWith(myString.substring(0, end))){
            passed = false;
        }
        System.out.println("String(inequal)    : " + input.endsWith("=-/v."));
        System.out.println("MyString(inequal)  : " + myString.endsWith(new MyString("=-/v.".toCharArray())));
        System.out.println();
        if(input.endsWith("=-/v.") != myString.endsWith(new MyString("=-/v."))){
            passed = false;
        }

        start = random.nextInt(input.length());
        end = random.nextInt(input.length() - start) + start;
        System.out.println("contains() test");
        System.out.println("String(contains)    : " + input.contains(input.substring(start, end)));
        System.out.println("MyString(contains)  : " + myString.contains(myString.substring(start, end)));
        if(input.contains(input.substring(start, end)) != myString.contains(myString.substring(start, end))){
            passed = false;
        }
        System.out.println("String(doesnot)    :" + input.contains("\\/,3"));
        System.out.println("MyString(doesnot)  :" + myString.contains(new MyString("\\/,3".toCharArray())));
        System.out.println();
        if(input.contains("\\/,3") != myString.contains(new MyString("\\/,3".toCharArray()))){
            passed = false;
        }
        return passed;
    }
}