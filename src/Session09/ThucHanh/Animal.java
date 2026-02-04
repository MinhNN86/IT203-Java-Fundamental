package Session09.ThucHanh;

import java.util.Scanner;

public class Animal {
    protected String animalName;
    protected int numberOfLegs;
    protected String furColor;
    protected int everageLifeExpectancy;

    // Constructor không tham số
    public Animal() {
        this.animalName = "";
        this.numberOfLegs = 0;
        this.furColor = "";
        this.everageLifeExpectancy = 0;
    }

    // Constructor có tham số
    public Animal(String animalName, int numberOfLegs, String furColor, int everageLifeExpectancy) {
        this.animalName = animalName;
        this.numberOfLegs = numberOfLegs;
        this.furColor = furColor;
        this.everageLifeExpectancy = everageLifeExpectancy;
    }

    // Getter methods
    public String getAnimalName() {
        return animalName;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public String getFurColor() {
        return furColor;
    }

    public int getEverageLifeExpectancy() {
        return everageLifeExpectancy;
    }

    // Setter methods
    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    public void setEverageLifeExpectancy(int everageLifeExpectancy) {
        this.everageLifeExpectancy = everageLifeExpectancy;
    }

    // Phương thức input
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên động vật: ");
        this.animalName = sc.nextLine();
        System.out.print("Nhập số chân: ");
        this.numberOfLegs = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập màu lông: ");
        this.furColor = sc.nextLine();
        System.out.print("Nhập tuổi thọ trung bình: ");
        this.everageLifeExpectancy = sc.nextInt();
        sc.nextLine();
    }

    // Phương thức display
    public void display() {
        System.out.println("Tên động vật: " + animalName);
        System.out.println("Số chân: " + numberOfLegs);
        System.out.println("Màu lông: " + furColor);
        System.out.println("Tuổi thọ trung bình: " + everageLifeExpectancy);
    }
}
