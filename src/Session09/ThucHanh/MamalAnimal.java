package Session09.ThucHanh;

import java.util.Scanner;

public class MamalAnimal extends Animal {
    private String foodType;
    private boolean isLiveWithHuman;
    private String mamalSound;

    // Constructor không tham số
    public MamalAnimal() {
        super();
        this.foodType = "";
        this.isLiveWithHuman = false;
        this.mamalSound = "";
    }

    // Constructor có tham số
    public MamalAnimal(String animalName, int numberOfLegs, String furColor, int everageLifeExpectancy, String foodType,
            boolean isLiveWithHuman, String mamalSound) {
        super(animalName, numberOfLegs, furColor, everageLifeExpectancy);
        this.foodType = foodType;
        this.isLiveWithHuman = isLiveWithHuman;
        this.mamalSound = mamalSound;
    }

    // Getter methods
    public String getFoodType() {
        return foodType;
    }

    public boolean isLiveWithHuman() {
        return isLiveWithHuman;
    }

    public String getMamalSound() {
        return mamalSound;
    }

    // Setter methods
    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public void setLiveWithHuman(boolean liveWithHuman) {
        isLiveWithHuman = liveWithHuman;
    }

    public void setMamalSound(String mamalSound) {
        this.mamalSound = mamalSound;
    }

    // Override method input
    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập kiểu thức ăn: ");
        this.foodType = sc.nextLine();
        System.out.print("Có sống với con người không (true/false): ");
        this.isLiveWithHuman = sc.nextBoolean();
        sc.nextLine();
        System.out.print("Nhập tiếng kêu: ");
        this.mamalSound = sc.nextLine();
    }

    // Override method display
    @Override
    public void display() {
        super.display();
        System.out.println("Kiểu thức ăn: " + foodType);
        System.out.println("Có sống với con người: " + isLiveWithHuman);
        System.out.println("Tiếng kêu: " + mamalSound);
    }
}
