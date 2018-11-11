
class LBST_Node {
    public int val;
    public LBST_Node l_child = null;
    public LBST_Node r_child = null;
    public LBST_Node next = null;

    public LBST_Node(int value){
        val = value;
    }

    public LBST_Node(int value, LBST_Node left, LBST_Node right){
        val = value;
        l_child = left;
        r_child = right;
    }

    public LBST_Node(int value, LBST_Node left, LBST_Node right, LBST_Node next){
        val = value;
        l_child = left;
        r_child = right;
        this.next = next;
    }

    public LBST_Node inorderLinkResolve(LBST_Node prev){
        if(l_child != null){
            prev = l_child.inorderLinkResolve(prev);
        }
        if(prev != null){
            prev.next = this;
        }
        prev = this;
        if(r_child != null){
            prev = r_child.inorderLinkResolve(prev);
        }

        return prev;
    }

    public LBST_Node getMostLeftNode(){
        if(l_child != null){
            return l_child.getMostLeftNode();
        }
        else {
            return this;
        }
    }

    public LBST_Node getMostRightNode(){
        if(r_child != null) {
            return r_child.getMostRightNode();
        }
        else {
            return this;
        }
    }

    public void removeMostLeftNode(){
        if(l_child != null){
            if(l_child.l_child != null){
                l_child.removeMostLeftNode();
            }
            else {
                l_child = null;
                return;
            }
        }
    }

    public void removeMostRightNode(){
        if(r_child != null){
            if(r_child.r_child != null){
                r_child.removeMostRightNode();
            }
            else {
                r_child = null;
                return;
            }
        }
    }
}