
import java.util.*;
class MyString {
    Vector charVec;

    public MyString(){
        charVec = new Vector(0);
    }

    public MyString(String str){
        charVec = new Vector(0);

        for(int i = 0; i < str.length(); i++){
            charVec.addElement(str.toCharArray()[i]);
        }

    }
    public MyString(char[] chars){
        charVec = new Vector(0);

        for(int i = 0; i < chars.length; i++){
            charVec.addElement(chars[i]);
        }
    }

    public char[] toCharArray(){
        char[] toReturn = new char[charVec.size() + 1];

        int i = 0;
        for(Object ch : charVec){
            toReturn[i] = (char)ch;
            i++;
        }

        return toReturn;
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

        return true;
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

        return charVec.size();
    }

    public MyString substring(int index1, int index2){

        return new MyString();
    }

    public MyString substring(int index1){

        return new MyString();
    }

    public MyString toLowerCase(){

        return new MyString();
    }

    public MyString toUpperCase(){

        return new MyString();
    }
}