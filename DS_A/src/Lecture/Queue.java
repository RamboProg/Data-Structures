package Lecture;

public class Queue {
  int[] a;
  int maxSize;
  int front;
  int rear;
  int nItems;

  public Queue(int maxxSize) {
    this.a = new int[maxxSize];
    this.maxSize = maxxSize;
    this.front = 0;
    this.rear = -1;
    this.nItems = 0;
  }

  public boolean isEmpty() {
    return nItems == 0;
  }

  public boolean isFull() {
    return nItems == maxSize;
  }

  public void enqueue(int k) {
    if (!isFull()) {
      nItems++;
      if (rear == maxSize - 1) rear = -1;
      a[++rear] = k;
    }
  }

  public int dequeue() {
    nItems--;
    if (front == maxSize - 1) {
      front = 0;
      return a[maxSize - 1];
    } else return a[front++];
  }

  public static void main(String[] args) {
    Queue q = new Queue(3);
    q.enqueue(3);
    q.enqueue(2);
    q.enqueue(5);
    q.dequeue();
    q.dequeue();
    System.out.println(q.nItems);
    System.out.println(q.a[0]);
    System.out.println(q.isEmpty());
  }
}
