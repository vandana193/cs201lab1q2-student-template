public class SinglyLinkedList<E> {

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (isEmpty()) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return answer;
    }

    // Write your methods here

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        E answer = tail.getElement();
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node<E> walk = head;
            while (walk.getNext() != tail) {
                walk = walk.getNext();
            }
            walk.setNext(null);
            tail = walk;
        }
        size--;
        return answer;
    }

    public void reverse() {
        Node<E> prev = null;
        Node<E> current = head;
        tail = head;
        while (current != null) {
            Node<E> next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> walk = head;
		if (isEmpty()) {
			return ""
		}
        while (walk != null) {
            sb.append(walk.getElement());
            walk = walk.getNext();
        }
        return sb.toString();
    }
}
