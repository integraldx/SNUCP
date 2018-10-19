
import java.util.*;
class MyString {
    char[] charArr;

    public MyString(){
        charArr = new char[0];
    }

    public MyString(String str){
        charArr = str.toCharArray();
    }
    public MyString(char[] chars){
        charArr = chars.clone();
    }

    //done
    public char[] toCharArray(){
        return charArr.clone();
    }

    //done
    public boolean equals(MyString str){
        boolean isEqual = true;
        if(str.length() != this.length()){
            isEqual = false;
        }
        else{
            for(int i = 0; i < str.length(); i++){
                if(this.toCharArray()[i] != str.toCharArray()[i]){
                    isEqual = false;
                }
            }
        }
        return isEqual;
    }

    //done
    public boolean equalsIgnoreCase(MyString str){
        return this.toLowerCase().equals(str.toLowerCase());
    }

    public boolean startswith(MyString str){

        return true;
    }

    public boolean endsWith(MyString str){

        return true;
    }

    public boolean contains(MyString str){

        return true;
    }

    public int indexOf(MyString str){

        return 0;
    }

    //done
    public int length(){

        return charArr.length;
    }

    public MyString substring(int index1, int index2){
        char[] subArr = new char[index2 - index1];

        for(int i = index1; i < index2; i++){
            subArr[i - index1] = charArr[i];
        }

        return new MyString(subArr);
    }

    public MyString substring(int index1){

        return new MyString();
    }

    //done
    public MyString toLowerCase(){
        char[] lowerChars = this.toCharArray();
        for(int i = 0; i < lowerChars.length; i++){
            if('A' < lowerChars[i] && lowerChars[i] <= 'Z'){
                lowerChars[i] += 'a' - 'A';
            }
        }
        return new MyString(lowerChars);
    }

    // done
    public MyString toUpperCase(){
        char[] upperChars = this.toCharArray();
        for(int i = 0; i < upperChars.length; i++){
            if('a' <= upperChars[i] && upperChars[i] <= 'z'){
                upperChars[i] -= 'a' - 'A';
            }
        }
        return new MyString(upperChars);
    }
}