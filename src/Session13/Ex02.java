package Session13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex02 {
    public static List<String> removeDuplicatesAndSort(List<String> inputList) {
        List<String> uniqueList = new ArrayList<>();

        // 1. Loại bỏ phần tử trùng lặp
        for (String medicine : inputList) {
            if (!uniqueList.contains(medicine)) {
                uniqueList.add(medicine);
            }
        }

        // 2. Sắp xếp A-Z
        Collections.sort(uniqueList);
        return uniqueList;
    }

    public static void main(String[] args) {
        List<String> medicines = new ArrayList<>();
        medicines.add("Paracetamol");
        medicines.add("Ibuprofen");
        medicines.add("Panadol");
        medicines.add("Paracetamol");
        medicines.add("Aspirin");
        medicines.add("Ibuprofen");

        System.out.println("Input: " + medicines);

        List<String> result = removeDuplicatesAndSort(medicines);

        System.out.println("Output: " + result);
    }
}
