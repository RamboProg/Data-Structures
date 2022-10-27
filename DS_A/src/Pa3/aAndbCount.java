package Pa3;

public class aAndbCount {

  public static boolean sameNumberOfAandB(String s) {
    ArrayStack st = new ArrayStack(s.length());

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'a') st.push(s.charAt(i));
    }

    for (int i = 0; i < s.length(); i++) {
      if (st.isEmpty()) return false;
      if (s.charAt(i) == 'b') st.pop();
    }
    if (st.isEmpty()) return true;

    return false;
  }

  public static void main(String[] args) {
    System.out.println(sameNumberOfAandB("aabbb"));
  }
}
