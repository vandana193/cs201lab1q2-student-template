public class SinglyLinkedList<E> {
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    // Write your codes below
    public String toString() {
        String sllStr = "";
        if (isEmpty()) {
            return sllStr;
        }
        for (Node<E> current = head; current != null; current = current.getNext()) {
            sllStr += current.getElement();
        }
        return sllStr;
    }

    public E removeLast(){
        if (isEmpty()){
            return null;
        }

        Node<E> last = tail;
        
        if (head == tail){
            head = null;
            tail = null;
            size--;
            return last.getElement();
        }

        Node<E> current = head;
        while (current.getNext() != tail){
            current = current.getNext();
        }
        current.setNext(null);
        tail = current;
        size--;
        return last.getElement();
    }

	
	
    public void reverse() {
        Node<E> previous = null; 
        Node<E> current = head; 
        Node<E> next = null; 
        
        tail = head; 
        while (current != null) {
			next = current.getNext(); 
			current.setNext(previous); 
			previous = current; 
			current = next; 
        }
        head = previous; 
    }
}