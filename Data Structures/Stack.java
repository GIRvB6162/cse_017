import java.util.EmptyStackException;

public class Stack<E> {

    private ArrayList<E> elements; 

    public Stack() { elements = new ArrayList<>();}  //O(1)
    public Stack(int capacity) { elements = new ArrayList<>(capacity);}  //O(1)
    
    public int size() { return elements.size();} //O(1)
    public boolean isEmpty() {return elements.isEmpty();}   //O(1)
    
    public void push(E item) {elements.add(item);} //O(1)/O(n)
    
    public E peek() {  //O(1)
        if(isEmpty()) 
            throw new EmptyStackException();
         return elements.get(size()-1);
    } 
    
    public E pop() {  //O(1)
        if(isEmpty()) 
            throw new EmptyStackException(); 
        E value = peek(); 
        elements.remove(size()-1); 
        return value;
    } 
    
    public String toString() { return "Stack: " + elements.toString();}  //O(n)
    
}
