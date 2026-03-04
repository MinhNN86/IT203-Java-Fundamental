package Session16.MiniProject;

public class Cat extends Pet implements ITrainable{
    private String color;

    public Cat(String id, String name, int age, double price, String color) {
        super(id, name, age, price);
        this.color = color;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    @Override
    public void performTrick() {
        System.out.println("Cat nhảy qua vòng!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Color: " + color);
    }
}
