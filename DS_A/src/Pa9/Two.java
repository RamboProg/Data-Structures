package Pa9;

public class Two {

    public static void addMiddle(int start, int end, int[] s, BTree t1) {
        if (end < start)
            return;

        int mid = start + (end - start / 2);
        t1.add(s[mid]);
        addMiddle(start, mid - 1, s, t1);// adds to the left
        addMiddle(mid + 1, end, s, t1);// adds to the right
    }

    public static BTree idealTop(int[] s) {
        BTree t1 = new BTree();
        int start = 0;
        int end = s.length - 1;
        addMiddle(start, end, s, t1);
        return t1;
    }

    public static void main(String[] args) {
        // assume that the input array is always sorted
        int[] seq = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 60, 65, 70, 75, 80, 95, 100 };
        BTree t = idealTop(seq);
        t.displayTree();
    }
}