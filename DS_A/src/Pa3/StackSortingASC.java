package Pa3;

public class StackSortingASC {

  public static void stackSort(ArrayStack s) {
    int count = s.size();
    ArrayStack s2 = new ArrayStack(count);
    int temp = 0;

    while (count > 0) {
      int min = s.pop();
      for (int i = 1; i < count; i++) {
        temp = s.pop();
        if (temp < min) {
          s2.push(min);
          min = temp;
        } else
          s2.push(temp);
      }
    }
    s.push(temp);
    while (!s2.isEmpty()) {
      s.push(s2.pop());
    }
    count--;
  }

  public static void main(String[] args) {
    ArrayStack s = new ArrayStack(8);
    s.push(6);
    s.push(9);
    s.push(3);
    s.push(5);
    s.push(4);
    s.push(1);
    s.push(2);
    s.push(7);
    s.printStack();
    stackSort(s);
    s.printStack();
  }
}
