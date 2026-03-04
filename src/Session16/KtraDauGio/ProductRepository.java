package Session16.KtraDauGio;

import java.util.*;

public class ProductRepository implements IRepository<Product> {
    private List<Product> products = new ArrayList<>();
    private HashMap<String, Product> productMap = new HashMap<>();

    @Override
    public boolean add(Product item) {
        if (findById(item.getId()) != null) {
            return false; // Sản phẩm đã tồn tại
        }
        products.add(item);
        productMap.put(item.getId(), item);
        return true;
    }

    @Override
    public boolean removeById(String id) {
        Product p = findById(id);
        if (p != null) {
            products.remove(p);
            productMap.remove(p.getId());
            return true;
        }
        return false; // Không tìm thấy sản phẩm
    }

    @Override
    public Product findById(String id) {
        return productMap.get(id); // Trả về sản phẩm nếu tồn tại, ngược lại trả về null
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products); // Trả về bản sao của danh sách sản phẩm
    }
}
