
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

    public char[] toCharArray(){
        return charArr.clone();
    }

    public boolean equals(MyString str){
        boolean isEqual = true;
        if(str.length() != this.length()){
            return false;
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

    public int length(){

        return charArr.length;
    }

    public MyString substring(int index1, int index2){

        return new MyString();
    }

    public MyString substring(int index1){

        return new MyString();
    }

    public MyString toLowerCase(){
        char[] lowerChars = this.toCharArray().clone();
        for(int i = 0; i < lowerChars.length; i++){
            if('A' < lowerChars[i] && lowerChars[i] <= 'Z'){
                lowerChars[i] += 'a' - 'A';
            }
        }
        return new MyString(lowerChars);
    }

    public MyString toUpperCase(){
        
        return new MyString();
    }
}