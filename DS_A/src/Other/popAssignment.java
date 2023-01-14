package Other;

import java.util.ArrayList;

public class popAssignment {

  // Two arrays, compare all elements, by checking with the second array then
  // create the final return array
  public static int[] removeDuplicates(int[] a) {
    ArrayList uniqueL = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      int count = 0;
      for (int j = 0; j < a.length; j++) {
        if (a[i] == a[j]) {
          count++;
          uniqueL.add(a[i]);
          i++;
        }
      }
    }
    int[] finalA = new int[uniqueL.size()];
    for (int i = 0; i < uniqueL.size() - 1; i++)
      finalA[i] = (int) uniqueL.get(i);
    return finalA;
  }

  public static void display(int[] a) {
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i] + " ");
    }
  }

  public static void main(String[] args) {
    int[] a = new int[5];
    a[0] = 12;
    a[1] = 3;
    a[2] = 5;
    a[3] = 12;
    a[4] = 1;
    // display(a);
    display(removeDuplicates(a));
  }
}
