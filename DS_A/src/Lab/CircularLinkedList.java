package Lab;

public class CircularLinkedList {
    private Link last;

    public CircularLinkedList() {
        last = null;
    }

    public void insertFirst(Object k) {
        Link newLink = new Link(k);
        newLink.next = last.next;
        last.next = newLink;
    }

    public void insertLast(Object k) {
        Link newLink = new Link(k);
        newLink.next = last.next;
        last.next = newLink;
        last = newLink;
    }

    public Object removeFirst() {
        if (last.next == last) {
            Object o = last;
            last = null;
            return o;
        }
        Object tmp = last.next;
        last.next = last.next.next;
        return tmp;
    }

    public Object removeLast() {
        if (last.next == last) {
            Object o = last;
            last = null;
            return o;
        }
        Link curr = last.next;
        Object o;
        while (curr.next != last) {
            curr = curr.next;
        }
        o = last.data;
        curr.next = last.next;
        last = curr;
        return o;
    }

    void append(CircularLinkedList l) {
        Link tmp = last.next;
        last.next = l.last.next;
        l.last.next = tmp;

    }

}
