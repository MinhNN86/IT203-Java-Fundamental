package Session16.MiniProject;

public abstract class Pet {
    private String id;
    private String name;
    private int age;
    private double price;
    public static int totalPets = 0;

    public Pet(String id, String name, int age, double price) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.price = price;
        totalPets++;
    }

    public abstract void makeSound();

    public void displayInfo() {
        System.out.println("ID: " + id +
                " | Name: " + name +
                " | Age: " + age +
                " | Price: " + price);
    }

    // Getter & Setter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
