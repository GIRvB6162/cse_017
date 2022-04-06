import java.util.*;

public class ShapeAL {
    private ArrayList<Pair<Integer, Integer>> points;

    public ShapeAL() {
        points = new ArrayList<Pair<Integer, Integer>>();
    }
    
    public void add(Pair<Integer, Integer> p) {
        points.add(p);
    }

    public boolean isClosed() {
        if (points.get(0).equals(points.get(points.size()-1))) {
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

    public boolean containsPointHelper(ArrayList<Pair<Integer, Integer>> points, Pair<Integer, Integer> p, int index) {
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

    @Override
    public String toString() {
        String output = "[";
        
        for (int i = 0; i < points.size(); i++) {
            output += points.get(i).toString();
        }

        output += "]";

        return output;
    }
}
