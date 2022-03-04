import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(System.in);
        Animal[] animals = readAnimals("animals.txt");
        printMenu();

        int input = kb.nextInt();

        if (input == 1){
            viewAllAnimals(animals);
        }
        else if (input == 2){
            viewFlyingAnimals(animals);
        }
        else if (input == 3){
            animals = sortByWeight(animals);
        }
        else if (input == 4){
            System.out.println("Goodbye!");
            System.exit(0);
        }




        
    }
    
    public static Animal[] readAnimals(String filename)throws FileNotFoundException{
        File f = new File(filename);
        int arrayLength = 0;
        int flyingSpeed = 0;
        Animal[] animals = new Animal[0];

        try {
            Scanner lengthScan = new Scanner(f);
            while (lengthScan.hasNextLine()) {
                lengthScan.nextLine();
                arrayLength++;
            }
            lengthScan.close();

            animals = new Animal[arrayLength];

            Scanner fileScan = new Scanner(f);
            for (int index = 0; index < animals.length; index++) {
                String type = fileScan.next();
                String name = fileScan.next();
                
                String w = fileScan.next();
                double weight = Double.parseDouble(w);

                String l = fileScan.next();
                int lifespan = Integer.parseInt(l);

                if (type.equals("Bat") || type.equals("Bird")){
                    String fly = fileScan.next();
                    flyingSpeed = Integer.parseInt(fly);
                }

                if (type.equals("Bat")){
                    animals[index] = new Bat(name, weight, lifespan, flyingSpeed);
                }
                else if (type.equals("Bird")){
                    animals[index] = new Bird(name, weight, lifespan, flyingSpeed);
                }
                else if (type.equals("Cat")){
                    animals[index] = new Cat(name, weight, lifespan);
                }
            }
            System.out.println("done");
            fileScan.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Cannot find file!");
        }
        return animals;
    }

    public static void printMenu(){
        System.out.println("Select an operation:");
        System.out.println("1: view all animals");
        System.out.println("2: view flying animals");
        System.out.println("3: sort animals by weight");
        System.out.println("4: exit");
        System.out.print("You selected option: ");
    }

    public static void viewAllAnimals(Animal[] animals){
        System.out.printf("%-7s %1s %17s %17s \n", "Type", "Name", "Weight", "Lifespan");

        for (int i = 0; i < animals.length; i++) {
            if (animals[i] instanceof Bird) {
                System.out.print("Bird \t");
            }
            else if (animals[i] instanceof Cat) {
                System.out.print("Cat \t");
            }
            else if (animals[i] instanceof Bat) {
                System.out.print("Bat \t");
            }
            System.out.println(animals[i]);
        }
    }

    public static void viewFlyingAnimals(Animal[] animals) {
        //read out list of only flying animals
        System.out.printf("%-7s %1s %17s %17s %19s \n", "Type", "Name", "Weight", "Lifespan", "Flying Speed");
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] instanceof CanFly){
                if (animals[i] instanceof Bat){
                    System.out.print("Bat \t");
                }
                else if (animals[i] instanceof Bird){
                    System.out.print("Bird \t");
                }
                System.out.println(animals[i]);
            }
        }
    }

    public static Animal[] sortByWeight(Animal[] animals) {
        Arrays.sort(animals);
        return animals;
    }
}
