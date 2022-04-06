package ArrayList;
//package Data_Structures;

import java.util.Iterator;
import java.util.ArrayList;

public class ALTest {
    
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("New York");
        cities.add("San Diego");
        cities.add("Atlanta");
        cities.add("Baltimore");
        cities.add("Pittsburg");

        // display the content of the list 
        System.out.println("\n" + cities.toString() + "\n"); 

        // iterator to display the elements of the list
        Iterator<String> cityIterator = cities.iterator(); 

        while(cityIterator.hasNext()) {
             System.out.print(cityIterator.next() + " "); 
        } 
        System.out.println("\n"); 

        // get(index) to display the elements of the list 
        for(int i=0; i<cities.size(); i++) { 
            System.out.print(cities.get(i) + " "); 
        }
        System.out.println("\n");

    }
}
