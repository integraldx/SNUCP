public class Main {
    public static void main(String[] args) {
        LinkedBinarySearchTree LBST = new LinkedBinarySearchTree();
        System.out.println("[Test about insert]");
        LBST.insert(5);
        if (LBST.first.val == 5 && LBST.first.next == null) {
            System.out.println("Test 1 : passed");
        }
        else {
            System.out.println("Test 1 : failed");
        }
        LBST.insert(3);

        if (LBST.first.val == 3 && LBST.first.next.val == 5 && LBST.first.next.next == null) {
            System.out.println("Test 2 : passed");
        }
        else {
            System.out.println("Test 2 : failed");
        }
        LBST.insert(6);

        if (LBST.first.val == 3 && LBST.first.next.val == 5 && LBST.first.next.next.val == 6 && LBST.first.next.next.next == null) {
            System.out.println("Test 3 : passed");
        }
        else {
            System.out.println("Test 3 : failed");
        }
        LBST.insert(2);

        if (LBST.first.val == 2 && LBST.first.next.val == 3 && LBST.first.next.next.val == 5 && LBST.first.next.next.next.val == 6 && LBST.first.next.next.next.next == null) {
            System.out.println("Test 4 : passed");
        }
        else {
            System.out.println("Test 4 : failed");
        }
        LBST.insert(7);

        LBST.insert(9);

        System.out.println("[Test about search]");
        if (LBST.search(2)) {
            System.out.println("Test 1 : passed");
        }
        else {
            System.out.println("Test 1 : failed");
        }
        if (LBST.search(3)) {
            System.out.println("Test 2 : passed");
        }
        else {
            System.out.println("Test 2 : failed");
        }
        if (LBST.search(5)) {
            System.out.println("Test 3 : passed");
        }
        else {
            System.out.println("Test 3 : failed");
        }
        if (LBST.search(6)) {
            System.out.println("Test 4 : passed");
        }
        else {
            System.out.println("Test 4 : failed");
        }
        if (LBST.search(7)) {
            System.out.println("Test 5 : passed");
        }
        else {
            System.out.println("Test 5 : failed");
        }
        if (LBST.search(9)) {
            System.out.println("Test 6 : passed");
        }
        else {
            System.out.println("Test 6 : failed");
        }
        System.out.println("[Test about remove]");
        if (LBST.search(5) && LBST.search(3) && LBST.search(6) && LBST.search(2) && LBST.search(7) && LBST.search(9)) {
            System.out.println("Test 1 : passed");
        }
        else {
            System.out.println("Test 1 : failed");
        }
        LBST.remove(5);

        if (!LBST.search(5) && LBST.search(3) && LBST.search(6) && LBST.search(2) && LBST.search(7) && LBST.search(9)) {
            System.out.println("Test 2 : passed");
        }
        else {
            System.out.println("Test 2 : failed");
        }
        LBST.remove(3);
        if (!LBST.search(5) && !LBST.search(3) && LBST.search(6) && LBST.search(2) && LBST.search(7) && LBST.search(9)) {
            System.out.println("Test 3 : passed");
        }
        else {
            System.out.println("Test 3 : failed");
        }
        LBST.remove(6);
        if (!LBST.search(5) && !LBST.search(3) && !LBST.search(6) && LBST.search(2) && LBST.search(7) && LBST.search(9)) {
            System.out.println("Test 4 : passed");
        }
        else {
            System.out.println("Test 4 : failed");
        }
        LBST.remove(2);
        if (!LBST.search(5) && !LBST.search(3) && !LBST.search(6) && !LBST.search(2) && LBST.search(7) && LBST.search(9)) {
            System.out.println("Test 5 : passed");
        }
        else {
            System.out.println("Test 5 : failed");
        }
        LBST.remove(7);
        if (!LBST.search(5) && !LBST.search(3) && !LBST.search(6) && !LBST.search(2) && !LBST.search(7) && LBST.search(9)) {
            System.out.println("Test 6 : passed");
        }
        else {
            System.out.println("Test 6 : failed");
        }
        LBST.remove(9);
        if (!LBST.search(5) && !LBST.search(3) && !LBST.search(6) && !LBST.search(2) && !LBST.search(7) && !LBST.search(9)) {
            System.out.println("Test 7 : passed");
        }
        else {
            System.out.println("Test 7 : failed");
        }
        if (LBST.root == null && LBST.first == null) {
            System.out.println("Test 8 : passed");
        }
        else {
            System.out.println("Test 8 : failed");
        }

        System.out.println("[Test about range_search]");
        LBST.insert(3);
        LBST.insert(2);
        LBST.insert(5);
        LBST.insert(4);
        LBST.insert(1);
        LBST.insert(8);
        if (LBST.range_search(0, 5, 1) && !LBST.range_search(1, 5, 1)) {
            System.out.println("Test 1 : passed");
        }
        else {
            System.out.println("Test 1 : failed");
        }
        if (LBST.range_search(0, 5, 2) && !LBST.range_search(2, 5, 2) && !LBST.range_search(0, 0, 2)) {
            System.out.println("Test 2 : passed");
        }
        else {
            System.out.println("Test 2 : failed");
        }
        if (LBST.range_search(0, 5, 3) && !LBST.range_search(3, 5, 3) && !LBST.range_search(0, 1, 3)) {
            System.out.println("Test 3 : passed");
        }
        else {
            System.out.println("Test 3 : failed");
        }
        if (LBST.range_search(0, 5, 4) && !LBST.range_search(4, 5, 4) && !LBST.range_search(0, 2, 4)) {
            System.out.println("Test 4 : passed");
        }
        else {
            System.out.println("Test 4 : failed");
        }
        if (LBST.range_search(0, 5, 5) && !LBST.range_search(5, 5, 5) && !LBST.range_search(0, 3, 5)) {
            System.out.println("Test 5 : passed");
        }
        else {
            System.out.println("Test 5: failed");
        }
        if (LBST.range_search(0, 5, 8) && !LBST.range_search(0, 4, 8)) {
            System.out.println("Test 6 : passed");
        }
        else {
            System.out.println("Test 6 : failed");
        }//      3
        //   2         5
        //1         4       8
        //                      12
        //                    9    16
        //                    11  15 18
        //                       14
        LBST.insert(12);
        LBST.insert(9);
        LBST.insert(11);
        LBST.insert(16);
        LBST.insert(15);
        LBST.insert(14);
        LBST.insert(18);
        LBST.remove(12);
        System.out.println("[Test about more Strong case about remove]");
        if (LBST.search(1) && LBST.search(2) && LBST.search(3) && LBST.search(4) && LBST.search(5) && LBST.search(8) && LBST.search(9) && LBST.search(11) && !LBST.search(12) && LBST.search(14) && LBST.search(15) && LBST.search(16) && LBST.search(18)) {
            System.out.println("Test 1 : passed");
        }
        else {
            System.out.println("Test 1 : failed");
        }
        LBST.remove(9);
        if (LBST.search(1) && LBST.search(2) && LBST.search(3) && LBST.search(4) && LBST.search(5) && LBST.search(8) && !LBST.search(9) && LBST.search(11) && !LBST.search(12) && LBST.search(14) && LBST.search(15) && LBST.search(16) && LBST.search(18)) {
            System.out.println("Test 2 : passed");
        }
        else {
            System.out.println("Test 2 : failed");
        }
        LBST.remove(5);
        if (LBST.search(1) && LBST.search(2) && LBST.search(3) && LBST.search(4) && !LBST.search(5) && LBST.search(8) && !LBST.search(9) && LBST.search(11) && !LBST.search(12) && LBST.search(14) && LBST.search(15) && LBST.search(16) && LBST.search(18)) {
            System.out.println("Test 3 : passed");
        }
        else {
            System.out.println("Test 3 : failed");
        }
        LBST.remove(14);
        if (LBST.search(1) && LBST.search(2) && LBST.search(3) && LBST.search(4) && !LBST.search(5) && LBST.search(8) && !LBST.search(9) && LBST.search(11) && !LBST.search(12) && !LBST.search(14) && LBST.search(15) && LBST.search(16) && LBST.search(18)) {
            System.out.println("Test 4 : passed");
        }
        else {
            System.out.println("Test 4 : failed");
        }
    }
}
