import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<E> {

    private ArrayList<E> elements;

    public Stack() {  //O(1)
        elements = new ArrayList<>();
    }

    public Stack(int capacity) {  //O(1)
        elements = new ArrayList<>(capacity);
    }

    public int size() { return elements.size();}  //O(1)
    public boolean isEmpty() {return elements.isEmpty();}  //O(1)
    public void push(E item) {elements.add(item);}  //O(1)

    public E peek() {  //O(1)
        if(isEmpty()){
            throw new EmptyStackException();
        }  
        return elements.get(size()-1);
    }

    public E pop() {  //O(1)
        if(isEmpty()) 
            throw new EmptyStackException(); 
        E value = peek(); 
        elements.remove(size()-1); 
        return value;
    }

    public String toString() {  //O(n)
        return "Stack: " +elements.toString();
    }


    
}
