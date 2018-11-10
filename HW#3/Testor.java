import java.util.Scanner;

class Testor {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        LinkedBinarySearchTree tree = new LinkedBinarySearchTree();
        while(true){
            String command;
            int value = 0;
            if(scanner.hasNextLine()){
                Scanner line = new Scanner(scanner.nextLine());
                command = line.next();
                if(line.hasNextInt()){
                    value = line.nextInt();
                }
            }
            else {
                break;
            }
            switch(command){
            case "insert":
                tree.insert(value);
                break;
            case "list":
                var list = tree.list();
                for(LBST_Node node : list){
                    System.out.print(node.val + " ");
                }
                System.out.println();
                break;
            }

        }
    }
}