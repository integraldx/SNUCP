
import java.util.*;
class MyString {
    char[] charArr;

    public MyString(){
        charArr = new char[0];
    }

    public MyString(char[] chars){
        charArr = chars.clone();
    }

    //done
    public char[] toCharArray(){
        return charArr.clone();
    }


    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(o instanceof MyString){
            return equals((MyString) o);
        }
        else {
            return false; 
        }
    }

    //done
    public boolean equals(MyString str){
        if(str == null){
            return false;
        }
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
        if(str == null){
            return false;
        }
        return this.toLowerCase().equals(str.toLowerCase());
    }

    public boolean startsWith(MyString str){
        char[] target = str.toCharArray();

        boolean toReturn = true;

        if(target.length > this.length()){
            return false;
        }
        for(int i = 0; i < target.length; i++){
            if(target[i] != charArr[i]){
                toReturn = false;
            }
        }
        return toReturn;
    }

    public boolean endsWith(MyString str){
        char[] target = str.toCharArray();
        if(this.length() < str.length()){
            return false;
        }
        boolean toReturn = true;
        for(int i = 0; i < target.length; i++){
            if(target[i] != charArr[i + charArr.length - target.length]){
                toReturn = false;
            }
        }
        return toReturn;
    }

    public boolean contains(MyString str){
        boolean toReturn = false;

        for(int i = 0; i < this.length() - str.length() + 1; i++){
            if(this.substring(i).startsWith(str)){
                toReturn = true;
            }
        }
        return toReturn;
    }

    public int indexOf(MyString str){
        int returnIndex = 0;
        while(true){
            if(this.substring(returnIndex).startsWith(str)){
                return returnIndex;
            }
            else {
                returnIndex++;
                if(returnIndex >= this.length()){
                    return -1;
                }
            }
        }
    }

    //done
    public int length(){
        return charArr.length;
    }

    //done
    public MyString substring(int index1, int index2){
        char[] subArr = new char[index2 - index1];

        for(int i = index1; i < index2; i++){
            subArr[i - index1] = charArr[i];
        }

        return new MyString(subArr);
    }

    //done
    public MyString substring(int index1){
        char[] subArr = new char[charArr.length - index1];

        for(int i = index1; i < charArr.length; i++){
            subArr[i - index1] = charArr[i];
        }

        return new MyString(subArr);
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