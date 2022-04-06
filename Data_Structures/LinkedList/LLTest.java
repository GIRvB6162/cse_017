package LinkedList;
import java.util.Iterator;

public class LLTest{ 
    public static void main(String[] args) {   
        LinkedList<String> cityList;   
        cityList = new LinkedList<>();   
        cityList.addFirst("Boston");   
        cityList.addFirst("Philadelphia");   
        cityList.addFirst("San Francisco");   
        cityList.addFirst("Washington");   
        cityList.addFirst("Portland");   
        System.out.println(cityList.toString()); 
       
        Iterator<String> LLIterator = cityList.iterator(); 
        System.out.print("LinkedList (iterator): "); 
        while(LLIterator.hasNext()) { 
            System.out.print(LLIterator.next() + " "); 
        } 
    }
}