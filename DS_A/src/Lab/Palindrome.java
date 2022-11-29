package Lab;

public class Palindrome {

  public static boolean checkPalindrome(String s) {
    QueueObj q = new QueueObj(s.length() / 2);
    StackObj stack = new StackObj(s.length() / 2);
    for (int i = 0; i < s.length(); i++) {
      // even length
      if (s.length() % 2 == 0) {
        if (i < s.length() / 2)
          stack.push(s.charAt(i));
        if (i >= s.length() / 2)
          q.enqueue(s.charAt(i));
      } // odd length
      else {
        if (i < s.length() / 2)
          stack.push(s.charAt(i));
        else if (i > s.length() / 2)
          q.enqueue(s.charAt(i));
        else
          continue;
      }
    }

    for (int i = 0; i < s.length() / 2; i++) {
      if (q.peek() == stack.top()) {
        stack.pop();
        q.dequeue();
      }
      if (stack.isEmpty() && q.isEmpty())
        return true;
    }
    return false;
  }

  public static void main(String[] args) {
    String s = "aabbaa";
    System.out.println(checkPalindrome(s));
  }
}
