
// Jeon Min Hyok 2018-10727

import java.io.*;
import java.util.Scanner;

class Affine_cipher {
    public static void main(String[] args) throws IOException {
        if(args.length < 1){
            System.out.println("Please write your input file's name as argument.");
            return;
        }
        if(args.length < 2){
            System.out.println("Please input desired output file name as argument.");
            return;
        }
        if(args.length > 3){
            System.out.println("Too many arguments! Exceeded argumnets will be discarded.");
        }
        File file = new File(args[0]);
        Scanner str = new Scanner(file);

        String originalString = str.nextLine();
        int multiplier = str.nextInt();
        int adder = str.nextInt();
        str.nextLine();
        String mode = str.nextLine();


        File outputFile = new File(args[1]);
        FileWriter output = new FileWriter(outputFile);
        if(mode.equals("e")){
            output.write(encryptString(originalString, multiplier, adder));
        }
        if(mode.equals("d")){

            output.write(decryptString(originalString, multiplier, adder));
        }

        output.close();

    }

    static String encryptString(String original, int mult, int add){
        String toReturn = new String();
        for(char ch : original.toCharArray()){
            int temp = toInternalNum(ch);
            if(temp == -1){
                toReturn = "Error, input value " + ch + " is out of range";
                break;
            }
            temp = ((mult * temp) + add + 6700) % 67;
            toReturn += toExternalChar(temp);
        }
        return toReturn;
    }
    static String decryptString(String original, int mult, int add){
        String toReturn = new String();
        int div = 1;
        for(int i = 0; i< 65; i++){
            div = (div * mult) % 67;
        }
        for(char ch : original.toCharArray()){
            int temp = toInternalNum(ch);
            if(temp == -1){
                toReturn = "Error, input value " + ch + " is out of range";
                break;
            }
            temp = (((temp - add + 6700) % 67) * div) % 67;
            toReturn += toExternalChar(temp);
        }
        return toReturn;
    }
    static int toInternalNum(char ch){
        if('a' <= ch && ch <= 'z'){
            return ch - 'a' + 1;
        }
        else if('A' <= ch && ch <= 'Z'){
            return ch - 'A' + 27;
        }
        else if('0' <= ch && ch <= '9'){
            return ch - '0' + 53;
        }
        else if(ch == '.'){
            return 63;
        }
        else if(ch == ','){
            return 64;
        }
        else if(ch == '!'){
            return 65;
        }
        else if(ch == '?'){
            return 66;
        }
        else if(ch == '#'){
            return 0;
        }
        else {
            return -1;
        }
    }
    static char toExternalChar(int i){
        if(1 <= i && i <= 26){
            return (char)(i + 'a' - 1);
        }
        else if(27 <= i && i <= 52){
            return (char)(i + 'A' - 27);
        }
        else if(53 <= i && i <= 62){
            return (char)(i + '0' - 53);
        }
        else if(i == 63){
            return '.';
        }
        else if(i == 64){
            return ',';
        }
        else if(i == 65){
            return '!';
        }
        else if(i == 66){
            return '?';
        }
        else if(i == 0){
            return '#';
        }
        else{
            assert false: "Error, input value " + i + "is out of range";
            return '#';
        }
    }
}

