package Session15.Ex01;

public class Main {
    public static void main(String[] args) {
        MedicalRecordHistory history = new MedicalRecordHistory();

        history.addEdit(new EditAction("Thêm chuẩn đoán mới", "10:00"));
        history.addEdit(new EditAction("Cập nhật toa thuốc", "10:15"));
        history.addEdit(new EditAction("Chỉnh sửa liều lượng", "10:30"));

        history.displayHistory();

        System.out.println("\nUndo");
        EditAction undone = history.undoEdit();

        System.out.println("\nChỉnh sửa gần nhất:");
        System.out.println(history.getLatestEdit());

        System.out.println("\nTrạng thía hiện tại:");
        history.displayHistory();
    }
}
