package Session15.Ex03;

import java.util.Stack;

public class MedicationProcessChecker {
    private Stack<String> stack = new Stack<>();

    public boolean checkProcess(String[] actions){
        for(int i = 0; i < actions.length; i++){
            String action = actions[i];
            if(action.equalsIgnoreCase("PUSH")){
                stack.push("MED");
            } else if(action.equalsIgnoreCase("POP")){
                if(stack.isEmpty()){
                    System.out.println("Lỗi tại bước " + (i + 1) + ": POP khi Stack");
                    return false;
                }
                stack.pop();
            } else {
                System.out.println("Hành động không hợp lệ tại bước " + (i + 1) + ": " + action);
                return false;
            }
        }

        // Kết thúc ca trực
        if(!stack.isEmpty()){
            System.out.println("Quy trình không hợp lệ: Còn thuốc chưa hoàn tất.");
            return false;
        }

        System.out.println("Quy trình hợp lệ.");
        return true;
    }

    // Reset stack
    public void reset(){
        stack.clear();
    }
}
