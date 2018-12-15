public class Final1Test {
    public static void main(String[] args) {

        Node tree1 = test0();

        EncodeTree ins1 = new EncodeTree(tree1);
        String str1 = ins1.encode();

        System.out.println(str1);
    }

    private static Node test0(){
        char testSet[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        Node nodearr[] = new Node[8];
        for(int i = 0; i < 8; i++){
            nodearr[i] = new Node(testSet[i]);
        }
        nodearr[0].setLeft(nodearr[3]);
        nodearr[0].setRight(nodearr[7]);
        nodearr[3].setLeft(nodearr[2]);
        nodearr[3].setRight(nodearr[1]);
        nodearr[1].setRight(nodearr[4]);
        nodearr[7].setLeft(nodearr[6]);
        nodearr[7].setRight(nodearr[5]);

        return nodearr[0];
    }

}
