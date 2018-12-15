import java.util.*;
import java.io.*;
class WordCount {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Scanner sc = new Scanner(new File(args[0]));
        String line = sc.nextLine();
        sc.close();
        WordCount wc = new WordCount(line);

        FileWriter fw = new FileWriter(args[1]);
        fw.write("Number of words = " + wc.count + '\n');
        fw.write("Average length of a word = ");
        if((""+ wc.average).length() > 4) {
            fw.write(("" + wc.average).substring(0, 4) + "\n");
        }
        else {
            fw.write("" + wc.average + "\n");
        }
        fw.write("Number of words above the average length = " + wc.aboveCount + '\n');
        fw.close();
    }

    WordCount(String str) {
        strs = new ArrayList<String>();
        str = str.replace(',', ' ');
        str = str.replace('.', ' ');
        String[] tempstrs = str.split(" ");
        for(int i = 0; i < tempstrs.length; i++) {
            if(tempstrs[i].trim().length() != 0) {
                strs.add(tempstrs[i].trim());
            }
        }
        count = strs.size();
        int sum = 0;

        for (String s : strs) {
            s = s.trim();

            sum += s.length();
        }
        average = (float)sum / count;

        for (String s : strs) {
            if (average < s.length()) {
                aboveCount++;
            }
        }
    }

    List<String> strs ;
    int count;
    float average;
    int aboveCount;
}