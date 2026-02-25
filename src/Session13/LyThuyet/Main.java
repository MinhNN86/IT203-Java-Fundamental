package Session13.LyThuyet;

public class Main {
    public static void main(String[] args) {
        MyGeneric<Integer> intList = new MyGeneric<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        System.out.println("\nInteger List:");
        intList.showList();

        MyGeneric<String> stringList = new MyGeneric<>();
        stringList.add("Hello");
        stringList.add("World");
        System.out.println("String List:");
        stringList.showList();

    }
}
