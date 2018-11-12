import java.util.Scanner;

class Testor {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        LinkedBinarySearchTree tree = new LinkedBinarySearchTree();
        while(true){
            String command;
            int[] arguments = new int[3];
            if(scanner.hasNextLine()){
                Scanner line = new Scanner(scanner.nextLine());
                command = line.next();
                int counter = 0;
                while(line.hasNextInt()){
                    arguments[counter] = line.nextInt();
                    counter++;
                }
            }
            else {
                break;
            }
            switch(command){
            case "insert":
                tree.insert(arguments[0]);
                break;
            case "list":
                var list = tree.list();
                for(LBST_Node node : list){
                    System.out.print(node.val + " ");
                }
                System.out.println();
                break;
            case "remove":
                tree.remove(arguments[0]);
                break;
            case "search":
                System.out.println(tree.search(arguments[0]));
                break;
            case "range_search":
                System.out.println(tree.range_search(arguments[0], arguments[1], arguments[2]));
                break;
            case "quit":
            case "exit":
                return;
            }

        }
    }
}