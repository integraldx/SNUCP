
class LinkedBinarySearchTree {
    public LBST_Node root = null;
    public LBST_Node first = null;

    public void insert(int num) {
        if(root == null){
            root = new LBST_Node(num);
            first = root;
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
                return;
            }
            else {
                recursiveInsertion(node.l_child, value);
            }
        }
        else if (node.val < value){
            if(node.r_child == null){
                node.r_child = new LBST_Node(value);
                return;
            }
            else {
                recursiveInsertion(node.r_child, value);
            }
        }
    }

    public void remove(int num) {
        if(root != null){
            if(root.val == num){
                LBST_Node replace;
                boolean leftChildReplace = false;
                boolean rightChildReplace = false;
                if(root.r_child != null){
                    replace = root.r_child.getMostLeftNode();
                    root.r_child.removeMostLeftNode();

                    if(replace == root.r_child){
                        rightChildReplace = true;
                    }
                }
                else if (root.l_child != null) {
                    replace = root.l_child.getMostRightNode();
                    root.l_child.removeMostRightNode();

                    if(replace == root.l_child){
                        leftChildReplace = true;
                    }
                }
                else {
                    root = null;
                    first = null;
                    return;
                }
                root.val = replace.val;
                if(leftChildReplace) {
                    root.l_child = replace.l_child;
                }
                if(rightChildReplace) {
                    root.r_child = replace.r_child;
                }
            }
            else {
                recursiveRemove(root, num);
            }

            root.inorderLinkResolve(null);
            first = root.getMostLeftNode();
        }

    }

    private void recursiveRemove(LBST_Node node, int value){
        if(value < node.val){
            if (node.l_child != null) {
                if (value == node.l_child.val) {
                    var toRemove = node.l_child;
                    LBST_Node replace;
                    boolean leftChildReplace = false;
                    boolean rightChildReplace = false;
                    if(toRemove.r_child != null){
                        replace = toRemove.r_child.getMostLeftNode();
                        toRemove.r_child.removeMostLeftNode();
                        if(replace == toRemove.r_child){
                            rightChildReplace = true;
                        }
                    }
                    else if (toRemove.l_child != null){
                        replace = toRemove.l_child.getMostRightNode();
                        toRemove.l_child.removeMostRightNode();
                        if(replace == toRemove.l_child){
                            leftChildReplace = true;
                        }
                    }
                    else {
                        node.l_child = null;
                        return;
                    }

                    toRemove.val = replace.val;
                    if(leftChildReplace){
                        toRemove.l_child = replace.l_child;
                    }
                    if(rightChildReplace) {
                        toRemove.r_child = replace.r_child;
                    }
                    return;
                } 
                else {
                    recursiveRemove(node.l_child, value);
                }
            }
        }
        else if (node.val < value){
            if (node.r_child != null) {
                if (value == node.r_child.val) {
                    var toRemove = node.r_child;
                    LBST_Node replace;
                    boolean rightChildReplace = false;
                    boolean leftChildReplace = false;
                    if(toRemove.r_child != null){
                        replace = toRemove.r_child.getMostLeftNode();
                        toRemove.r_child.removeMostLeftNode();
                        if(replace == toRemove.r_child){
                            rightChildReplace = true;
                        }
                    }
                    else if (toRemove.l_child != null){
                        replace = toRemove.l_child.getMostRightNode();
                        toRemove.l_child.removeMostRightNode();
                        if(replace == toRemove.l_child) {
                            leftChildReplace = true;
                        }
                    }
                    else {
                        node.r_child = null;
                        return;
                    }

                    toRemove.val = replace.val;
                    if(leftChildReplace){
                        toRemove.l_child = replace.l_child;
                    }
                    if(rightChildReplace){
                        toRemove.r_child = replace.r_child;
                    }
                    return;
                } 
                else {
                    recursiveRemove(node.r_child, value);
                }
            }

        }

    }

    public boolean search(int num) {
        if(root == null){
            return false;
        }
        else {
            return recursiveSearch(root, num);
        }
    }

    private boolean recursiveSearch(LBST_Node node, int value) {
        if(node.val == value){
            return true;
        }
        else if (value < node.val){
            if(node.l_child != null){
                return recursiveSearch(node.l_child, value);
            }
            else {
                return false;
            }
        }
        else {
            if(node.r_child != null) {
                return recursiveSearch(node.r_child, value);
            }
            else {
                return false;
            }
        }
    }

    public boolean range_search(int left_val, int right_val, int num) {
        if(root == null){
            return false;
        }
        else {
            if(num < left_val || right_val < num){
                return false;
            }
            LBST_Node leftBound = leftBound(root, left_val);
            LBST_Node rightBound = rightBound(root, right_val);

            return scan(leftBound, rightBound, num);
        }
    


    }

    private LBST_Node leftBound(LBST_Node node, int left_val){
        if(node.val == left_val){
            return node;
        }
        else {
            if (node.l_child != null) {
                if (node.l_child.val < left_val) {
                    return node;
                } else {
                    return leftBound(node.l_child, left_val);
                }
            } 
            else {
                return node;
            }
        }
    }

    private LBST_Node rightBound(LBST_Node node, int right_val){
        if(node.val == right_val){
            return node;
        }
        else {
            if (node.r_child != null) {
                if (right_val < node.r_child.val) {
                    return node;
                }
                else {
                    return rightBound(node.r_child, right_val);
                }
            }
            else {
                return node;
            }
        }

    }

    private boolean scan(LBST_Node leftBound, LBST_Node rightBound, int target){
        LBST_Node current = leftBound;

        while(current.val <= rightBound.val && current != null){
            if(target == current.val){
                return true;
            }
            else {
                current = current.next;
            }
        }
        return false;

    }

    public LBST_Node[] list() {
        int count = length();
        if(count == 0){
            return new LBST_Node[0];
        }
        LBST_Node[] nodes = new LBST_Node[count];
        nodes[0] = first;
        for(int i = 1; i < count; i++){
            nodes[i] = nodes[i - 1].next;
        }
        return nodes;
    }

    public int length(){
        int count = 0;
        LBST_Node current = first;
        while(current != null){
            count++;
            current = current.next;
        }

        return count;
    }
}