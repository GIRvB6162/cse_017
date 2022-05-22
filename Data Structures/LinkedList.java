import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> {

    //DATA MEMBERS
    private Node head, tail;
    int size;

    //INNER CLASS NODE
    private class Node {
        E value;
        Node next;
        Node(E initialValue) {
            value = initialValue; 
            next = null;
        }
    }

    //CONSTRUCTOR
    public LinkedList() {  //O(1)
        head = tail = null;
        size = 0;
    }

    //ADDING AN ITEM TO THE LIST
    public boolean addFirst(E item) {  //O(1)
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        }
        else { 
            newNode.next = head;
            head = newNode;
        }
        size++;
        return true;
    }

    public boolean addLast(E item) {  //O(1)
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    public boolean add(E item) {
        return addFirst(item);
    }

    //RETREIVING AN ITEM FROM THE LIST
    public E getFirst() {  //O(1)
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.value;
    }

    public E getLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return tail.value;
    }

    //REMOVE AN ITEM FROM THE LIST
    public boolean removeFirst() {  //O(1)
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return true;
    }

    public boolean removeLast() {  //O(N)
        if (head == null) throw new NoSuchElementException(); 
        if(size == 1) return removeFirst(); 
        Node current = head; 
        Node previous = null; 
        while(current.next != null) { 
            previous = current; 
            current = current.next; 
        } 
        previous.next = null; 
        tail = previous; 
        size--; 
        return true;
    }

    //TOSTRING()
    public String toString() { //O(N)
        String output = "[";
        Node node = head; 
        while(node != null) { 
            output += node.value + " "; 
            node = node.next; 
        } 
        output += "]"; 
        return output; 
    }

    public void clear() { head = tail = null; size = 0; }  //O(1)
    public boolean isEmpty() { return (size == 0); }  //O(1)
    public int size() { return size; } //O(1)

    public Iterator<E> iterator(){  return new LinkedListIterator(); }
    
    private class LinkedListIterator implements Iterator<E>{ 
        private Node current = head; 
        
        public boolean hasNext() { return (current != null); } 
        public E next() { 
            if(current == null)  throw new NoSuchElementException(); 
            E value = current.value; 
            current = current.next; 
            return value;
        } 
    }
    
}
