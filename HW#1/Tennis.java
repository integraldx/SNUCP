// Jeon Min Hyok 2018-10727
import java.io.*;
import java.util.Scanner;
import java.util.prefs.PreferenceChangeEvent;
import java.util.*;
import java.lang.Math;


class Tennis{
    File output;
    FileWriter outputWriter;

    File input;
    Scanner inputScanner;

    boolean isAustralian;
    boolean isMale;

    ArrayList<Set> sets = new ArrayList<Set>();

    int leftMatchScore = 0;
    int rightMatchScore = 0;
    
    static String toTennisScore(int i){
        switch(i){
            case 0:
                return "0";
            case 1:
                return "15";
            case 2:
                return "30";
            case 3:
                return "40";
            default:
                return "";
        }
    }
    class Set{
        int leftSetScore = 0;
        int rightSetScore = 0;

        int leftGameScore = 0;
        int rightGameScore = 0;
        boolean isDeuce = false;

        boolean tieBreak = false;

        int leftTieBreakScore = 0;
        int rightTieBreakScore = 0;
    }
    public Tennis(Scanner input, String fileName) throws IOException{
        output = new File(fileName);
        outputWriter = new FileWriter(output);
        inputScanner = input;

        inputScanner.useDelimiter("");

        if(inputScanner.next().equals("A")){
            isAustralian = true;
            outputWriter.write("Australian Open/");
        }
        else{
            isAustralian = false;
            outputWriter.write("US Open/");
        }

        if(inputScanner.next().equals("M")){
            isMale = true;
            outputWriter.write("Male chosen.\n");
        }
        else{
            isMale = false;
            outputWriter.write("Female chosen.\n");
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException{
        if(args.length < 2){
            System.out.println("not enough arguments!");
            return;
        }
        File file = new File(args[0]);
        Scanner scanner = new Scanner(file);
        Tennis tennis = new Tennis(scanner, args[1]);

        tennis.match();

        tennis.close();
        scanner.close();
        return;
    }


    public void match() throws IOException{
        if(isMale){

            while(leftMatchScore < 3 && rightMatchScore < 3){
                Set set = set();
                sets.add(set);

                if(set.leftSetScore > set.rightSetScore){
                    leftMatchScore++;
                }
                else{
                    rightMatchScore++;
                }
            }
        }
        else{

            while(leftMatchScore < 2 && rightMatchScore < 2){
                Set set = set();
                sets.add(set);
                
                if(set.leftSetScore > set.rightSetScore){
                    leftMatchScore++;
                }
                else{
                    rightMatchScore++;
                }
            }
        }


        writeCurrent(new Set());
        outputWriter.write("Game finished!\n");
    }


    private Set set() throws IOException{
        Set set = new Set();
        while((set.leftSetScore < 6 && set.rightSetScore < 6) || Math.abs(set.leftSetScore - set.rightSetScore) < 2){
     
            if(set.leftSetScore == 6 && set.rightSetScore == 6){
                if(sets.size() == (isMale ? 4 : 2) && isAustralian){
                    set.tieBreak = false;
                }
                else{
                    set.tieBreak = true;
                    break;
                }
            }
            

            char winner = game(set);

            if(winner == 'L'){
                set.leftSetScore++;
            }
            if(winner == 'R'){
                set.rightSetScore++;
            }

        }

        if(set.tieBreak){
            char winner = game(set);

            if(winner == 'L'){
                set.leftSetScore++;
            }
            if(winner == 'R'){
                set.rightSetScore++;
            }
        }
        return set;
    }
    private char game(Set set) throws IOException{

        set.leftGameScore = 0;
        set.rightGameScore = 0;

        if(set.tieBreak){
            while((set.leftGameScore < 7 && set.rightGameScore < 7) || Math.abs(set.leftGameScore - set.rightGameScore) < 2){
                writeCurrent(set);

                String winner = inputScanner.next();
                if(winner.equals("L")){
                    set.leftGameScore++;
                    outputWriter.write("Left wins\n");
                }
                else{
                    set.rightGameScore++;
                    outputWriter.write("Right wins\n");
                }
            }
        }
        else{
            while((set.leftGameScore < 4 && set.rightGameScore < 4) || Math.abs(set.leftGameScore - set.rightGameScore) < 2){

                writeCurrent(set);

                String winner = inputScanner.next();

                if(winner.equals("L")){
                    set.leftGameScore++;
                    outputWriter.write("Left wins\n");
                }
                else{
                    set.rightGameScore++;
                    outputWriter.write("Right wins\n");
                }
            }
        }

        if(set.leftGameScore > set.rightGameScore){
            return 'L';
        }
        else{
            return 'R';
        }
    }

    private void writeCurrent(Set set) throws IOException{
        String strToWrite = "Current: ";
        for(Set prevSet : sets){
            if(prevSet.tieBreak){
                strToWrite += prevSet.leftSetScore + "-" + prevSet.rightSetScore + "(";
                if(prevSet.leftGameScore > 5 && prevSet.rightGameScore > 5){
                    if(prevSet.leftGameScore > prevSet.rightGameScore){
                        strToWrite += "7-6) ";
                    }
                    else{
                        strToWrite += "6-7) ";
                    }
                }
                else {
                    strToWrite += prevSet.leftGameScore + "-" + prevSet.rightGameScore + ") ";
                }
            }
            else{
                strToWrite += prevSet.leftSetScore + "-" + prevSet.rightSetScore  + " ";
            }
        }


        if(!((sets.size() != 0) && set.leftGameScore == 0 && set.rightGameScore == 0 && set.leftSetScore == 0 && set.rightSetScore == 0)){
            strToWrite += set.leftSetScore + "-" + set.rightSetScore;
        }

        if(set.leftGameScore + set.rightGameScore != 0 ){
            if(set.tieBreak){
                if(set.leftGameScore >= 6 && set.rightGameScore >= 6){
                    strToWrite += "(" + "6" +
                    (set.leftGameScore > set.rightGameScore ? "A" : "") +
                    "-6" + 
                    (set.leftGameScore < set.rightGameScore ? "A" : "") +
                    ")";
                }
                else{
                    strToWrite += "(" + set.leftGameScore + "-" + set.rightGameScore + ")";
                }
            }
            else{
                if(set.leftGameScore >= 3 && set.rightGameScore >= 3){
                    strToWrite += "(" + "40" +
                    (set.leftGameScore > set.rightGameScore ? "A" : "") +
                    "-" + "40" +
                    (set.leftGameScore < set.rightGameScore ? "A" : "") +
                    ")";
                }
                else {
                    strToWrite += "(" + toTennisScore(set.leftGameScore) + "-" + toTennisScore(set.rightGameScore) + ")";
                }
            }
        }

        outputWriter.write(strToWrite + "\n");
    }

    public void close() throws IOException{
        outputWriter.close();
    }

}