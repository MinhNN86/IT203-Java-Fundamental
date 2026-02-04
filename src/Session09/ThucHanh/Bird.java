package Session09.ThucHanh;

import java.util.Scanner;

public class Bird extends Animal {
    private boolean isFly;
    private String birdSound;

    // Constructor không tham số
    public Bird() {
        super();
        this.isFly = false;
        this.birdSound = "";
    }

    // Constructor có tham số
    public Bird(String animalName, int numberOfLegs, String furColor, int everageLifeExpectancy, boolean isFly,
            String birdSound) {
        super(animalName, numberOfLegs, furColor, everageLifeExpectancy);
        this.isFly = isFly;
        this.birdSound = birdSound;
    }

    // Getter methods
    public boolean isFly() {
        return isFly;
    }

    public String getBirdSound() {
        return birdSound;
    }

    // Setter methods
    public void setFly(boolean fly) {
        isFly = fly;
    }

    public void setBirdSound(String birdSound) {
        this.birdSound = birdSound;
    }

    // Override method input
    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Có bay được không (true/false): ");
        this.isFly = sc.nextBoolean();
        sc.nextLine();
        System.out.print("Nhập tiếng hót: ");
        this.birdSound = sc.nextLine();
    }

    // Override method display
    @Override
    public void display() {
        super.display();
        System.out.println("Có bay được: " + isFly);
        System.out.println("Tiếng hót: " + birdSound);
    }
}
