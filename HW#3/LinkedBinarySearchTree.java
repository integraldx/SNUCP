
class LinkedBinarySearchTree {
    public LBST_Node root = null;
    public LBST_Node first = null;
    int elementCounter = 0;

    public void insert(int num) {
        if(root == null){
            root = new LBST_Node(num);
            first = root;
            elementCounter++;
        }
        else {
            recursiveInsertion(root, num);
        }
        root.inorderLinkResolve(null);
        first = root.getMostLeftNode();
    }

    private void recursiveInsertion(LBST_Node node, int value){
        if(node.val == value) {
            return;
        }
        else if (value < node.val) {
            if(node.l_child == null){
                node.l_child = new LBST_Node(value);
                elementCounter++;
                return;
            }
            else {
                recursiveInsertion(node.l_child, value);
            }
        }
        else if (node.val < value){
            if(node.r_child == null){
                node.r_child = new LBST_Node(value);
                elementCounter++;
                return;
            }
            else {
                recursiveInsertion(node.r_child, value);
            }
        }
    }

    // public void remove(int num) {

    // }

    // private void recursiveRemove(LBST_Node node, int value){

    // }

    // public boolean search(int num) {

    // }

    // private boolean recursiveSearch(int value) {

    // }

    // public boolean range_search(int left_val, int right_val, int num) {

    // }

    // private boolean scan(LBST_Node leftBound, LBST_Node rightBound, int target){

    // }

    public LBST_Node[] list() {
        if(elementCounter == 0){
            return new LBST_Node[0];
        }
        LBST_Node[] nodes = new LBST_Node[elementCounter];
        nodes[0] = first;
        for(int i = 1; i < elementCounter; i++){
            nodes[i] = nodes[i - 1].next;
        }
        return nodes;
    }
}