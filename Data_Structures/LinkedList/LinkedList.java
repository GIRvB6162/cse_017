package LinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> {

    //data members
    private Node head, tail;
    int size;

    //inner class Node
    private class Node {
        E value;
        Node next;
        Node (E initialValue) {
            value = initialValue;
            next = null;
        }
    }

    //constructor
    public LinkedList() {  //O(1)
        head = tail = null;
        size = 0;
    }

    //adding an item to the list
    public boolean addFirst(E item) {  //O(1)
        Node newNode = new Node (item);
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

    public boolean addLast (E item) {  //O(1)
        Node newNode = new Node (item);
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

    public boolean add (E item) {  //O(1)
        return addFirst(item);
    }

    //retrieving an item from the list
    public E getFirst() {  //O(1)
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.value;
    }

    public E getLast() {  //O(1)
        if (head == null) {
            throw new NoSuchElementException();
        }
        return tail.value;
    }

    //removing an item from the list
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

    public boolean removeLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        if (size == 1) {
            return removeFirst();
        }

        Node current = head;
        Node previous = null;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail = previous;
        size--;
        return true;        
    }

    //toString method
    public String toString() {  //O(n)
        String output = "[";
        Node node = head;

        while (node != null) {
            output += node.value + " ";
            node = node.next;
        }
        output += "]";
        return output;
    }

    //clear
    public void clear() {  //O(1)
        head = tail = null;
        size = 0;
    }

    //check if empty
    public boolean isEmpty() {  //O(1)
        return (size == 0);
    }

    //return size of list
    public int size() {  //O(1)
        return size;
    }

    //implementing an interator for the list
    public Iterator<E> iterator() {  //O(1)
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node current = head;

        public boolean hasNext() {
            return (current != null);
        }

        public E next () {
            if (current == null) {
                throw new NoSuchElementException();
            }
            E value = current.value;
            current = current.next;
            return value;
        }
    }
    
}
