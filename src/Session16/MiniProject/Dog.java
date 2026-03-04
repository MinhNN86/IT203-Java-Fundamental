package Session16.MiniProject;

public class Dog extends Pet implements ITrainable{
    private String breed;

    public Dog(String id, String name, int age, double price, String breed) {
        super(id, name, age, price);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }

    @Override
    public void performTrick() {
        System.out.println("Dog lăn vòng!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Breed: " + breed);
    }
}


