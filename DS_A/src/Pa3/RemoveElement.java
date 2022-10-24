package Pa3;

import java.util.Scanner;

public class RemoveElement {

  //Fix it
  public static void removeNth(ArrayStack s, int n) {
    ArrayStack temp = new ArrayStack(s.size());
    while (!s.isEmpty()) temp.push(s.pop());

    int count = 2;
    while (!temp.isEmpty()) {
      if (count == n) temp.pop(); else s.push(temp.pop());
    }
  }

  public static void main(String[] args) {
    int size = 5;
    ArrayStack s = new ArrayStack(size);
    s.push(1);
    s.push(2);
    s.push(3);
    s.printStack();
    removeNth(s, 1);
    s.printStack();
  }
}
