package Session15.Ex06;

import java.util.Stack;

public class MedicalRecordHistory {
    private Stack<EditAction> editStack = new Stack<>();
    private String recordId;

    public MedicalRecordHistory(String recordId) {
        this.recordId = recordId;
    }

    public void addEdit(EditAction action) {
        editStack.push(action);
    }

    public EditAction undoLastEdit() {
        if (!editStack.isEmpty()) {
            return editStack.pop();
        }
        return null;
    }
}
