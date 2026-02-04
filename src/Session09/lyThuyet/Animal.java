package Session09.lyThuyet;

public class Animal {
    private int age;
    private String color;
    private boolean gender;
    private String name;

    public Animal() {
    }

    public Animal(int age, String color, boolean gender, String name) {
        this.age = age;
        this.color = color;
        this.gender = gender;
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isGender() {
        return this.gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println("Animal is making a sound");
    }
}
