package Session13.LyThuyet;

import java.util.ArrayList;
import java.util.List;

public class MyGeneric<T> {
    private final List<T> list;

    public MyGeneric(){
        list = new ArrayList<>();
    }

    public boolean add(T t){
        return list.add(t);
    }

    public T get(int index){
        return list.get(index);
    }

    public List<T> getList(){
        return list;
    }

    public void showList(){
        for (T t : list) {
            System.out.println(t);
        }
    }
}
