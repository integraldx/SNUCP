
class LBST_node {
    public int val;
    public LBST_node l_child = null;
    public LBST_node r_child = null;
    public LBST_node next = null;

    public LBST_node(int value){
        val = value;
    }

    public LBST_node(int value, LBST_node left, LBST_node right){
        val = value;
        l_child = left;
        r_child = right;
    }

    public LBST_node(int value, LBST_node left, LBST_node right, LBST_node next){
        val = value;
        l_child = left;
        r_child = right;
        this.next = next;
    }

    public LBST_node inorderLinkResolve(LBST_node prev){
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

    public LBST_node getMostLeftNode(){
        if(l_child != null){
            return l_child.getMostLeftNode();
        }
        else {
            return this;
        }
    }

    public LBST_node getMostRightNode(){
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