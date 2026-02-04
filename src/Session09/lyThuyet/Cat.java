package Session09.lyThuyet;

public class Cat extends Animal {
    private String species;

    public Cat() {
    }

    public Cat(String species, String name, int age, boolean gender, String color) {
        super(age, color, gender, name);
        this.species = species;
    }

    public String getSpecies() {
        return this.species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public void makeSound() {
        System.out.println("Meo Meo");
    }
}