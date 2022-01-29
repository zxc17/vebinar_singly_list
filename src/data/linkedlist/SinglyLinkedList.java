package data.linkedlist;

/**
 * Singly linked list.
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class SinglyLinkedList<T> {
	class Node<T> {
		T value;
		Node<T> next;

		public Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}
	}

	Node head;

	public static void main(String[] args) {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
//		list.add("A");
//		list.add("B");
//		list.add("C");
//		boolean result = list.remove("A");
//		boolean result = list.remove("B");
		boolean result = list.remove("C");
		list.print();
		// A C
	}

	private void print() { // O(n)
		if (head == null) {
			return;
		}
		Node<T> e = head;
		while (e.next != null) {
			System.out.println(e.value);
			e = e.next;
		}
		System.out.println(e.value);
	}

	private boolean remove(T value) { // O(n)
//		if (head == null) {
//			return false;
//		}
		Node<T> current = head;
		Node<T> prev = null;
		do {
			if (current.value.equals(value)) {
				if (prev == null) {
					head = current.next; // Список из 1 элемента
				} else {
					prev.next = current.next;
				}
				return true;
			}
			prev = current;
			current = current.next;
		} while (current != null);

		return false;
	}

	private void add(T value) { // O(n)
		final Node<T> newNode = new Node<>(value, null);
		if (head == null) {
			head = newNode;
			return;
		}

		Node<T> last = head;
		while (last.next != null) {
			last = last.next;
		}

		last.next = newNode;
	}

}
