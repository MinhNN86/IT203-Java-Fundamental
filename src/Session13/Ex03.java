package Session13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex03 {
    public static <T> List<T> findCommonPatients(List<T> listA, List<T> listB){
        List<T> result = new ArrayList<>();

        for(T item : listA){
            if(listB.contains(item)){
                result.add(item);
            }
        }

        return result;
    }
    public static void main(String[] args) {

        // Test Case 1: Integer
        List<Integer> ListA1 = Arrays.asList(101, 102, 105);
        List<Integer> ListB1 = Arrays.asList(102, 105, 108);

        List<Integer> commonPatients1 = findCommonPatients(ListA1, ListB1);
        System.out.println("Test Case 1: " + commonPatients1);

        // Test Case 2: String
        List<String> listA2 = Arrays.asList("DN01", "DN02", "DN03");
        List<String> listB2 = Arrays.asList("DN02", "DN04");

        List<String> commonPatients2 = findCommonPatients(listA2, listB2);
        System.out.println("Test Case 2 Output: " + commonPatients2);
    }
}
