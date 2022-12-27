package Lab;

import java.util.ArrayList;
import java.util.HashSet;

public class ex11_2 {
    public static ArrayList<Integer> removeDuplicate(int a[]) {
        HashSet<Integer> h = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (!h.contains(a[i])) {
                result.add(a[i]);
                h.add(a[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int a[] = { 2, 2, 4, 4, 3, 5, 6, 22, 77 };
        System.out.println(removeDuplicate(a));
    }
}
