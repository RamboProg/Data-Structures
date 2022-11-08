package Pa1;

public class LinearSortedArray {
  int[] a;
  int nItems;

  public LinearSortedArray(int maxSize) {
    a = new int[maxSize];
  }

  public void orderedInsert(int x) {
    if (nItems < a.length) {
      int insertPos = 0;
      while (insertPos < nItems && a[insertPos] < x) {
        insertPos++;
      }
      for (int i = nItems; i > insertPos; i--)
        a[i] = a[i - 1];

      a[insertPos] = x;
      nItems++;
    }
  }

  public int binarySearchIter(int x) {
    int upperLimit = nItems - 1;
    int lowerLimit = 0;
    int pos = 0;

    while (lowerLimit <= upperLimit) {
      pos = lowerLimit + ((upperLimit - lowerLimit) / 2);
      if (a[pos] == x)
        return pos;
      else if (x > a[pos])
        lowerLimit = pos + 1;
      else
        upperLimit = pos - 1;
    }

    return -1;
  }

  public int binarySearchRec(int x) {
    return binary(0, nItems - 1, x);
  }

  public int binary(int lowerBound, int upperBound, int x) {
    int pos = lowerBound + (upperBound - lowerBound) / 2;
    if (lowerBound > upperBound)
      return -1;
    else if (a[pos] == x)
      return pos;
    else if (x > a[pos])
      return binary(
          pos + 1,
          upperBound,
          x);
    else
      return binary(lowerBound, pos - 1, x);
  }

  public void delete(int x) {
    int pos = binarySearchIter(x);
    if (pos == -1)
      System.out.println("Element not found!");
    else {
      for (int i = pos; i < nItems - 1; i--)
        a[i] = a[i + 1];
      nItems--;
    }
  }

  public void displayArray() {
    // print the array
    System.out.print("Sorted Array: ");
    for (int i = 0; i < nItems; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    LinearSortedArray b = new LinearSortedArray(10);
    b.orderedInsert(5);
    b.orderedInsert(3);
    b.orderedInsert(1);
    b.orderedInsert(44);
    b.displayArray();
    System.out.println("Iteratively 5 at: " + b.binarySearchIter(5));
    System.out.println("Recursively 6 at: " + b.binarySearchRec(6));
    System.out.println("Recursively 5 at: " + b.binarySearchRec(5));
  }
}
