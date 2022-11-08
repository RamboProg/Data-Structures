package Pa1;

public class LinearArray {
  int[] a;
  int nItems;

  public LinearArray(int maxSize) {
    a = new int[maxSize];
  }

  public void insertLast(int x) {
    if (nItems < a.length)
      a[nItems++] = x;
    else
      System.out.println(
          "Array full!");
  }

  public void insertFirst(int x) {
    if (nItems < a.length) {
      for (int i = nItems; i > 0; i--) {
        a[i] = a[i - 1];
      }
      a[0] = x;
      nItems++;
    } else
      System.out.println("Array is full!");
  }

  public int linearSearch(int x) {
    for (int i = 0; i < nItems - 1; i++) {
      if (a[i] == x)
        return i;
    }
    return -1;
  }

  public void delete(int x) {
    int pos = linearSearch(x);
    if (pos == -1)
      System.out.println("Element not found!");
    else {
      for (int i = pos; i < nItems - 1; i++)
        a[i] = a[i + 1];
    }
  }

  public void display() {
    System.out.println("Array: ");
    for (int i = 0; i < a.length - 1; i++)
      System.out.println(a[i] + " ");
    System.out.println();
  }

  public static void main(String[] args) {
    LinearArray a = new LinearArray(10);
    a.insertLast(3);
    a.insertLast(7);
    a.insertFirst(8);
    a.display();
    System.out.println("Count: " + a.nItems);
    System.out.println("Position of 8: " + a.linearSearch(8));
    System.out.println("Position of 5: " + a.linearSearch(5));
    a.delete(33);
    a.delete(3);
    System.out.println("Count: " + a.nItems);
  }
}
