import java.util.Comparator;

public class ComparatorByName implements Comparator<Country>{

    @Override
    public int compare(Country o1, Country o2) {
        return o1.getName().compareTo(o2.getName());
    }
    
}
