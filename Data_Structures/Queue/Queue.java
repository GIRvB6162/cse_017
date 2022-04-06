package Queue;
import java.util.LinkedList;

public class Queue<E> {

    private LinkedList<E> list;

    public Queue() { //O(1)
        list = new LinkedList<>();
    }

    public void offer(E item){  //O(1)
        list.addLast(item); 
    }

    public E poll(){  //O(1)
        E value = list.getFirst();  
        list.removeFirst(); 
        return value;  
    }

    public E peek(){ return list.getFirst(); }  //O(1)

    public String toString(){  //O(n)
        return "Queue: " + list.toString();  
    }

    public int size(){ return list.size(); }  //O(1)
    public void clear(){ list.clear(); }  //O(1)
    public boolean isEmpty(){ return list.size()==0; }  //O(1)


    
}
