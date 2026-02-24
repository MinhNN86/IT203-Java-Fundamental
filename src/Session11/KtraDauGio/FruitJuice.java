package Session11.KtraDauGio;

public class FruitJuice extends Drink implements IMixable{
    private int discountPercent;

    public FruitJuice(String id, String name, int price, int  discountPercent) {
        super(id, name, price);
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculatePrice() {
        return price * (100 -  discountPercent) / 100.0;
    }

    @Override
    public void mix() {
        System.out.println("Đang ép trái cây tươi...");
    }
}
