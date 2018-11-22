import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FinalDriver {
    public static void main(String[] args) {
        tensor(args[0],args[1]);
    }

    public static void tensor(String input, String output) {
        Scanner sc = new Scanner(readfile(input));
        int operandCount = sc.nextInt();
        int operationCount = sc.nextInt();

        Tensor[] operands = new Tensor[operandCount];
        for(int iter = 0; iter < operandCount; iter++) {
            switch(sc.next()) {
            case "S":
                operands[iter] = new MyScalar(sc.nextInt());
                break;

            case "V":
                int[] vecValues = new int[sc.nextInt()];
                for(int i = 0; i < vecValues.length; i++) {
                    vecValues[i] = sc.nextInt();
                }
                operands[iter] = new MyVector(vecValues);
                break;

            case "M":
                int[][] matValues = new int[sc.nextInt()][sc.nextInt()];
                for(int i = 0; i < matValues.length; i++) {
                    for(int j = 0; j < matValues[0].length; j++) {
                        matValues[i][j] = sc.nextInt();
                    }
                }
                operands[iter] = new MyMatrix(matValues);
                break;

            }

        }

        StringBuilder outputContent = new StringBuilder();

        for (int iter = 0; iter < operationCount; iter++) {
            int index1 = sc.nextInt();
            String operator = sc.next();
            int index2 = sc.nextInt();

            Tensor operand1 = operands[index1 - 1];
            System.out.println(operand1.toString());
            outputContent.append(operand1.toString());

            Tensor operand2 = operands[index2 - 1];
            System.out.println(operand2.toString());
            outputContent.append(operand2.toString());
            Tensor result;
            switch (operator) {
            case "+":
                result = operand1.add(operand2);
                if(result != null) {
                    outputContent.append(result.toString() + "\n");
                }
                else {
                    outputContent.append("Null return has occured at " + index1 + " " + operator + " " + index2 + "\n");
                }
            
                break;

            case "*":
                result = operand1.multiply(operand2);
                if(result != null) {
                    outputContent.append(result.toString() + "\n");
                }
                else {
                    outputContent.append("Null return has occured at " + index1 + operator + index2 + "\n");
                }

                break;

            case "p=":
                boolean compResult = ((MyVector)operand1).permuteCompare((MyVector)operand2);
                outputContent.append(compResult + "\n\n");

                break;

            }
        }
        sc.close();
        writefile(output, outputContent.toString());
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
