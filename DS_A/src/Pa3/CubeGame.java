package Pa3;

public class CubeGame {

  public static boolean check(ArrayStack s) {
    int size = s.size();
    int sum1 = 0, sum2 = 0, x = 0;
    ArrayStack temp = new ArrayStack(size);

    // popping the first half
    for (int i = 0; i < size / 2; i++) {
      x = s.pop();
      sum1 += x;
      temp.push(x);
    }

    // in case of an odd-sized stack
    if (size % 2 == 1)
      temp.push(s.pop());

    // popping the second half
    for (int i = 0; i < size / 2; i++) {
      x = s.pop();
      sum2 += x;
      temp.push(x);
    }

    // returning back the elements
    while (!temp.isEmpty())
      s.push(temp.pop());

    return sum1 == sum2;
  }

  public static void main(String[] args) {
    ArrayStack s = new ArrayStack(5);
    s.push(9);
    s.push(3);
    s.push(8);
    s.push(8);
    s.push(4);
    System.out.println(check(s));
  }
}
