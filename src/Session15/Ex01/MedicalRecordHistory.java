package Session15.Ex01;

import java.util.Stack;

public class MedicalRecordHistory {
    private Stack<EditAction> history = new Stack<>();

    // Thêm chỉnh sửa mới
    public void addEdit(EditAction action){
        history.push(action);
        System.out.println("Đã thêm chỉnh sửa.");
    }

    // Undo chỉnh sửa gần nhất
    public EditAction undoEdit(){
        if(history.isEmpty()){
            System.out.println("Không có chỉnh sửa nào để undo.");
            return null;
        }
        return history.pop();
    }

    // Xem chỉnh sửa gần nhất
    public EditAction getLatestEdit(){
        if(history.isEmpty()){
            System.out.println("Không có chỉnh sửa nào.");
            return null;
        }
        return history.peek();
    }

    // Kiểm tra rỗng
    public boolean isEmpty(){
        return history.isEmpty();
    }

    public void displayHistory(){
        if(history.isEmpty()){
            System.out.println("Lịch sử chỉnh sửa trống.");
            return;
        }
        System.out.println("Lịch sử chỉnh sửa:");
        for(EditAction action : history){
            System.out.println(action);
        }
    }
}
