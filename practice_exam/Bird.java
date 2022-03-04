public class Bird extends Animal implements CanFly<Animal>{
   
    private int flyingSpeed;
    
    protected Bird(String name, double weight, int lifespan, int flyingSpeed) {
        super(name, weight, lifespan);
        this.flyingSpeed = flyingSpeed;
    }

    @Override
    public int flies() {
        return this.flyingSpeed;
    }

    
}