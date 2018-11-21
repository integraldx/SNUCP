import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FinalDriver {
    public static void main(String[] args) {
        tensor(args[0],args[1]);
    }

    public static void tensor(String input, String output) {
        /**
         * String input = input file name
         * String output = output file name
         */
    }

    public static String readfile(String file) {
        String everything = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return everything;
    }

    public static void writefile(String file, String everything) {
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.print(everything);
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
