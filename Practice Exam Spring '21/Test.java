import java.util.*;
public class Test {

    public static void main(String[] args) {
        ShapeAL crescent = new ShapeAL();
        ShapeLL hexagon = new ShapeLL();

        crescent.add(new Pair(30,50));
        crescent.add(new Pair(25,40));
        crescent.add(new Pair(25,30));
        crescent.add(new Pair(30,20));
        crescent.add(new Pair(40,10));

        hexagon.add(new Pair(50,60));
        hexagon.add(new Pair(40,40));
        hexagon.add(new Pair(50,20));
        hexagon.add(new Pair(70,20));
        hexagon.add(new Pair(90,40));
        hexagon.add(new Pair(70,60));
        hexagon.add(new Pair(50,60));

        System.out.println("Shape Crescent: " +crescent.toString());

        Pair<Integer, Integer> key = new Pair(50,60);
        boolean contained = false; 
        boolean closed = false;

        contained = crescent.containsPoint(key);
        if (contained == true) {
            System.out.println("Crescent contains the point " +key.toString());
        }
        else if (contained == false) {
            System.out.println("Crescent does NOT contain the point " +key.toString());
        }

        closed = crescent.isClosed();
        if (closed == true) {
            System.out.println("Crescent is closed!");
        }
        else if (closed == false) {
            System.out.println("Crescent is open!");
        }

        System.out.println("Shape Hexagon: " +hexagon.toString());
        contained = hexagon.containsPoint(key);
        if (contained == true) {
            System.out.println("Hexagon contains the point " +key.toString());
        }
        else if (contained == false) {
            System.out.println("Hexagon does NOT contain the point " +key.toString());
        }

        closed = hexagon.isClosed();
        if (closed == true) {
            System.out.println("Hexagon is closed!");
        }
        else if (closed == false) {
            System.out.println("Hexagon is open!");
        }

    }
    
}