package Session16.MiniProject1.manager;

import Session16.MiniProject1.model.Customer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomerManager {
    private Map<String, Customer> customerMap = new HashMap<>();
    private Set<String> phoneSet = new HashSet<>();

    public boolean register(Customer customer) {
        if (customerMap.containsKey(customer.getId())) {
            System.out.println("Loi: ID khach hang da ton tai!");
            return false;
        }
        if (phoneSet.contains(customer.getPhone())) {
            System.out.println("Loi: So dien thoai da duoc dang ky!");
            return false;
        }
        customerMap.put(customer.getId(), customer);
        phoneSet.add(customer.getPhone());
        return true;
    }

    public Customer findById(String id) {
        return customerMap.get(id);
    }

    public void showAll() {
        if (customerMap.isEmpty()) {
            System.out.println("Chua co khach hang nao.");
            return;
        }
        for (Customer customer : customerMap.values()) {
            System.out.println(customer);
        }
    }
}
