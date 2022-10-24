package Pa3;

public class StackSearching {

  public static int searchFor(ArrayStack s, int target) {
    int position = 0;
    boolean found = false;

    //used to return stack to original state
    ArrayStack sTemp = new ArrayStack(s.size());

    //search
    while (!s.isEmpty()) {
      if (s.top() == target) {
        found = true;
        break;
      }
      sTemp.push(s.pop());
      position++;
    }

    //Return s to its original position
    while (!sTemp.isEmpty() && !s.isFull()) s.push(sTemp.pop());

    if (!found) position = -1;

    return position;
  }

  public static void main(String[] args) {
    ArrayStack s = new ArrayStack(10);
    s.push(4);
    s.push(20);
    s.push(7);
    s.push(1);
    s.printStack();
    int internalVal = s.search(12);
    int externalVal = searchFor(s, 12);

    System.out.println(
      12 + ": internally " + internalVal + ", externally: " + externalVal
    );

    internalVal = s.search(1);
    externalVal = searchFor(s, 1);

    System.out.println(
      1 + ": internally " + internalVal + ", externally: " + externalVal
    );

    internalVal = s.search(20);
    externalVal = searchFor(s, 20);

    System.out.println(
      20 + ": internally " + internalVal + ", externally: " + searchFor(s, 20)
    );
  }
}
