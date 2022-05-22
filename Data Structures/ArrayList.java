import java.util.Iterator;

public class ArrayList<E> {

    //DATA MEMBERS
    private E[] elements;
    private int size;

    //CONSTRUCTORS
    public ArrayList() {  //O(1)
        elements = (E[]) new Object[10];
        size = 0;
    }

    public ArrayList(int capacity) {   //O(1)  
        elements = (E[]) new Object[capacity];     
        size = 0;   
    }

    //ADDING AN ITEM TO THE LIST
    public boolean add(E item) { return add(size, item); }

    public boolean add(int index, E item){ //O(N)
        if(index > size || index < 0) 
            throw new ArrayIndexOutOfBoundsException(); 
        ensureCapacity(); 
        
        for(int i=size-1; i<index; i--){ 
            elements[i+1] = elements[i];    
        } 
        elements[index] = item; 
        size++; 
        return true; 
    }

    //GETTER AND SETTERS
    public E get(int index) {  //O(1)
        checkIndex(index);
        return elements[index];
    }

    public E set(int index, E item) {  //O(1)
        checkIndex(index);
        E oldItem = elements[index];
        elements[index] = item;
        return oldItem;
    }

    //SIZE OF LIST
    public int size() { return size;} //O(1)
    //CLEAR LIST
    public void clear() { size = 0;}  //O(1)
    //CHECK IF LIST IS EMPTY
    public boolean isEmpty() { return (size == 0);}  //O(1)

    //REMOVE AN OBJECT FROM THE LIST
    public boolean remove(Object o) {   //O(n)
        E item = (E) o;   
        for(int i=0; i<size; i++) 
            if(elements[i].equals(item)){      
                remove(i);      
                return true;    
            }   
        return false; 
    }

    //REMOVE ITEM AT INDEX FROM LIST
    public E remove(int index) {     //O(n)
        checkIndex(index);    
        E item = elements[index];     
        for(int i=index; i<size-1; i++) 
            elements[i] = elements[i+1];     
        size--;     
        return item; 
    }

    //SHRINK LIST TO SIZE
    public void trimToSize() { //O(n)
        if (size != elements.length) { 
            E[] newElements = (E[]) new Object[size]; 
            for(int i=0; i<size; i++) 
                newElements[i] = elements[i]; 
            elements = newElements; 
        } 
    }

    //GROW LIST IF NEEDED
    private void ensureCapacity() { //O(n)
        if(size >= elements.length) {    
            int newCap = (int) (elements.length * 1.5);
            E[] newElements = (E[]) new Object[newCap]; 
            for(int i=0; i<size; i++) 
                newElements[i] = elements[i]; 
            elements = newElements; 
        }
    }

    //CHECK IF INDEX IS VALID
    private void checkIndex(int index){ //O(1)
        if(index < 0 || index >= size) 
            throw new ArrayIndexOutOfBoundsException("Index out of bounds. Must be between 0 and "+       
        (size-1)); 
    }

    //TOSTRING() METHOD
    public String toString() { //O(n)
        String output = "["; 
        for(int i=0; i<size-1; i++) 
            output += elements[i] + " "; 
        output += elements[size-1] + "]"; 
        return output; 
    }

    //ITERATOR FOR THE LIST
    public Iterator<E> iterator() {  //O(1)
        return new ArrayIterator();
    }

    //INNER CLASS THE IMPLEMENTS ITERATOR<E>
    private class ArrayIterator implements Iterator<E> {
        private int current = -1;

        public boolean hasNext() { return current < size-1;}

        public E next() { return elements[++current];}
        
    }







}
