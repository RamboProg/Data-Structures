package Other;

import java.util.ArrayList;

public class QueueObj {
	private int maxsize;
	private int front;
	private int rear;
	private int nItems;
	private Object[] elements;

	public QueueObj(int maxSize) {
		this.maxsize = maxSize;
		front = 0;
		rear = -1;
		nItems = 0;
		elements = new Object[maxsize];
	}

	public void enqueue(Object x) {
		if (rear == maxsize - 1)
			rear = -1;

		elements[++rear] = x;
		nItems++;
	}

	public Object dequeue() {
		Object result = elements[front];
		front++;

		if (front == maxsize)
			front = 0;

		nItems--;
		return result;
	}

	public Object peek() {
		return elements[front];
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public boolean isFull() {
		return (nItems == maxsize);
	}

	public int size() {
		return nItems;
	}

	public void printQueue() {
		if (nItems == 0) {
			System.out.println("The queue is empty!");
			return;
		}
		for (int i = 0; i < nItems; i++) {
			System.out.print(elements[(front + i) % maxsize] + "  ");
		}
		System.out.println();
	}

	public static int multUnique(QueueObj q) {
		int uniqueCount[] = new int[q.size()];
		int temp;
		int lastNum = 0;
		int count;
		ArrayList<Integer> a = new ArrayList<>();
		int res = 1;
		for (int i = 0; i < q.size(); i++) {
			temp = (int) q.peek();
			count = 0;
			for (int j = 0; j < q.size(); j++) {
				while (lastNum == (int) q.peek()) {
					q.enqueue(q.dequeue());
					temp = (int) q.peek();
				}
				if (temp == (int) q.peek())
					count++;

				q.enqueue(q.dequeue());
			}
			lastNum = temp;
			if (count == 1)
				a.add(temp);
		}

		for (int i = 0; i < a.size(); i++) {
			res *= (int) a.get(i);
		}

		return res;

	}

	public static void main(String[] args) {
		QueueObj q = new QueueObj(6);
		q.enqueue(2);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(4);
		q.enqueue(5);

		System.out.println(multUnique(q));

	}
}
