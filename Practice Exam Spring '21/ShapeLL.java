import java.util.*;


public class ShapeLL {
    private LinkedList<Pair<Integer, Integer>> points;

    public ShapeLL() {
        points = new LinkedList<>();
    }

    public void add (Pair<Integer, Integer> p) {
        points.add(p);
    }

    public boolean isClosed() {
        if (points.getFirst().equals(points.getLast())) {
            return true;
        }
        return false;
    }

    public boolean containsPoint(Pair<Integer, Integer> p) {
        boolean found = false;
        int index = 0;
        found = containsPointHelper(points, p, index);
        return found;
    }

    public boolean containsPointHelper(LinkedList<Pair<Integer, Integer>> points, Pair<Integer, Integer> p, int index) {
        Iterator<Pair<Integer, Integer>> iter = points.iterator();
        Pair<Integer,Integer> currentElement = (Pair<Integer,Integer>) new Pair<>(0,0);  //initialize 
        int j = -1;

        while (iter.hasNext() && j < index) {
            currentElement = iter.next();
            j++;
        }

        if (index < points.size()) {
            index++;
            if (currentElement.getFirst().equals(p.getFirst())) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        Iterator<Pair<Integer, Integer>> LLIterator = points.iterator(); 

        String output = "[";
        while(LLIterator.hasNext()) { 
            output += LLIterator.next() + " ";
        }
        output += "]";
        return output;
    }
}
