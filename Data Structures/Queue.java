public class Queue<E> {

    private LinkedList<E> list;  
    
    public Queue(){ list=new LinkedList<>(); }  //O(1)
    
    public void offer(E item){ list.addLast(item); }  //O(1)
    
    public E poll(){  //O(1)
        E value = list.getFirst();  
        list.removeFirst(); 
        return value;  
    } 
    
    public E peek(){ return list.getFirst(); }  //O(1)
    
    public String toString(){  return "Queue: " + list.toString();  }  //O(n)
    
    public int size(){ return list.size(); }  //O(1)
    
    public void clear(){ list.clear(); }  //O(1)
    
    public boolean isEmpty(){ return list.size()==0; }  //O(1)
    
}
