package Pa3;

public class StackDecompose {

  public static ArrayStack decompose(ArrayStack x) {
    ArrayStack y = new ArrayStack(x.size() / 2);
    ArrayStack odd = new ArrayStack(x.size() / 2 + 1);
    ArrayStack even = new ArrayStack(x.size() / 2);

    while (!x.isEmpty()) {
      odd.push(x.pop());
      if (!x.isEmpty())
        even.push(x.pop());
    }

    while (!odd.isEmpty())
      x.push(odd.pop());

    while (!even.isEmpty())
      y.push(even.pop());
    return y;
  }

  public static ArrayStack decomposeAlt(ArrayStack x) {
    ArrayStack reverse = new ArrayStack(x.size());
    ArrayStack y = new ArrayStack(x.size() / 2);

    boolean isOddSized = x.size() % 2 == 1;
    while (!x.isEmpty())
      reverse.push(x.pop());

    while (!reverse.isEmpty()) {
      if (isOddSized) {
        x.push(reverse.pop());
        if (!reverse.isEmpty())
          y.push(reverse.pop());
      } else {
        y.push(reverse.pop());
        x.push(reverse.pop());
      }
    }
    return y;
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
    ArrayStack y = decomposeAlt(s);
    s.printStack();
    y.printStack();
  }
}
