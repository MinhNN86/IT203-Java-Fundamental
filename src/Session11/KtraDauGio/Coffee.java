package Session11.KtraDauGio;

public class Coffee extends Drink {
    private boolean hasMilk = false;

    public Coffee(String id, String name, int price, boolean hasMilk) {
        super(id, name, price);
        this.hasMilk = hasMilk;
    }

    @Override
    public double calculatePrice() {
        if (hasMilk) {
            return price + 5000;
        } else {
            return price;
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Giá thực tế: " + calculatePrice());
        if(hasMilk){
            System.out.println("Loại: Có sữa");
        } else {
            System.out.println("Loại: Đen đá");
        }
    }
}
