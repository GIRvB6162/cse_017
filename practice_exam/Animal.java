public abstract class Animal implements Comparable<Animal>{

    private String name;
    private double weight;
    private int lifespan;

    protected Animal(String name, double weight, int lifespan){
        this.name = name;
        this.weight = weight;
        this.lifespan = lifespan;
    }

    public String toString(){

        return String.format("%-7s %13s %13d \n", name, weight, lifespan);
    }

    public int compareTo(Animal a){
        if (this.weight - a.weight > 0.0){
            return 1;
        }
        else if (this.weight - a.weight == 0.0){
            return 0;
        }
        else {
            return -1;
        }
    }
    
}
