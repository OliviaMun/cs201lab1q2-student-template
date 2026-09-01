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

    public String toString(){
        StringBuilder sb = new StringBuilder("");
        Node curr = head;
        while (curr != null){
            sb.append(curr.getElement());
            curr = curr.getNext();
        }
        return sb.toString();
    }

    public E removeLast(){
        if (isEmpty()){
            return null;
        }
        E last = tail.getElement();
        if (head == tail){
            head = null;
            tail = null;
        } else {
            Node<E> walker = head;
            while (walker.getNext() != tail){
                walker = walker.getNext();
            }
            walker.setNext(null);
            tail = walker;
        }
        size -= 1;
        return last;
    }

    public void reverse(){       
        if (head == null || head.getNext() == null){
            return;
        }

        Node prev = null;
        Node curr = head;
        Node next = null;

        tail = head;
        while (curr != null){
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }

        head = prev;
    }
}