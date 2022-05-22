import java.util.Comparator;

public class ComparatorByArea implements Comparator<Country>{

    @Override
    public int compare(Country o1, Country o2) {
        return (int) o1.getArea() - (int) o2.getArea();
    }
    
}
