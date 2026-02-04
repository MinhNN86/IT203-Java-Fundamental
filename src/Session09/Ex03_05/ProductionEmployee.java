package Session09.Ex03_05;

public class ProductionEmployee extends Employee {
    private int productCount;
    private double pricePerProduct;

    public ProductionEmployee(String name, int productCount, double pricePerProduct) {
        super(name);
        this.productCount = productCount;
        this.pricePerProduct = pricePerProduct;
    }

    @Override
    public double calculateSalary() {
        return productCount * pricePerProduct;
    }
}