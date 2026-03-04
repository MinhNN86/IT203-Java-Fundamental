package Session16.MiniProject1.service;

import java.util.Stack;

public class ActivityLog {
    private Stack<String> stack = new Stack<>();

    public void addLog(String action) {
        stack.push(action);
    }

    public String undo() {
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return "No actions to undo.";
    }

    public void showLogs() {
        for (String log : stack) {
            System.out.println(log);
        }
    }
}
