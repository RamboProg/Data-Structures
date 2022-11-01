public class Deque {
  int head;
  int rear;
  Object[] a;
  int nItems;
  int maxSize;

  public Deque(int maxSize) {
    this.maxSize = maxSize;
    a = new Object[maxSize];
    nItems = 0;
    head = 0;
    rear = 0;
  }

  public void insertFirst(Object o) {
    if (head == 0) head = maxSize - 1; else head--;
    nItems++;
    a[head] = o;
  }

  public void insertLast(Object o) {
    if (rear == maxSize - 1) rear = 0; else rear++;
    nItems++;
    a[rear] = o;
  }

  public Object removeFirst() {
    Object res = a[head];
    if (head == maxSize - 1) head = 0; else head++;
    nItems--;
    return res;
  }

  public Object removeLast() {
    Object res = a[rear];
    if (rear == 0) rear = maxSize - 1; else rear--;
    nItems--;
    return res;
  }

  public boolean isEmpty() {
    return nItems == 0;
  }

  public boolean isFull() {
    return nItems == maxSize;
  }

  public Object peekFront() {
    return a[head];
  }

  public Object peekRear() {
    return a[rear];
  }

  public int size() {
    return nItems;
  }
}
