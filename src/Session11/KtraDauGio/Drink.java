package Session11.KtraDauGio;

public abstract class Drink {
    protected String id;
    protected String name;
    protected int price; // Giá gốc

    public Drink(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public abstract double calculatePrice();

    public void displayInfo(){
        System.out.println("Mã: " + id + " | Tên: " + name + " | Giá gốc: " + price);
    }
}
