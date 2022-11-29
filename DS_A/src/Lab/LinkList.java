package Lab;

class Link {
	public Object data;
	public Link next;

	public Link(Object o) {
		this.data = o;
		this.next = null;
	}

	public String toString() {
		return data.toString();
	}
}

class LinkList {
	private Link head;

	public LinkList() {
		head = null;
	}

	public void insertFirst(Object o) {
		Link newLink = new Link(o);
		newLink.next = head;
		head = newLink;
	}

	public Object removeFirst() {
		Object res = head.data;
		head = head.next;
		return res;
	}

	public Object getFirst() {
		return head.data;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public String toString() {
		if (head == null)
			return "[ ]";
		String res = "[ " + head.data;
		Link current = head.next;
		while (current != null) {
			res += ", " + current.data;
			current = current.next;
		}
		res += " ]";
		return res;
	}

}
