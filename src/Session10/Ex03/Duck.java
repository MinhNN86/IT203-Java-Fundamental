package Session10.Ex03;

public class Duck extends Animal implements Flyable, Swimmable {
    public Duck(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(name + " đang bay");
    }

    @Override
    public void swim() {
        System.out.println(name + " đang bơi");
    }
}
