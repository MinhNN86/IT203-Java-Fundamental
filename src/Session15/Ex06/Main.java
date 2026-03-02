package Session15.Ex06;

public class Main {
    public static void main(String[] args) {

        System.out.println("===== 1. BỆNH NHÂN CHỜ KHÁM (Queue) =====");
        PatientWaitingQueue waitingQueue = new PatientWaitingQueue();

        waitingQueue.addPatient(new Patient("BN01", "Nguyen Van A", 30, "Nam"));
        waitingQueue.addPatient(new Patient("BN02", "Tran Thi B", 25, "Nữ"));

        System.out.println("Gọi bệnh nhân: " + waitingQueue.callNextPatient());
        System.out.println("Số bệnh nhân còn lại: " + waitingQueue.getTotalPatients());


        System.out.println("\n===== 2. LỊCH SỬ CHỈNH SỬA (Stack) =====");
        MedicalRecordHistory history = new MedicalRecordHistory("MR01");

        history.addEdit(new EditAction("Sửa chẩn đoán", "Bác sĩ A", "09:00"));
        history.addEdit(new EditAction("Cập nhật thuốc", "Bác sĩ B", "09:15"));

        System.out.println("Undo chỉnh sửa: " + history.undoLastEdit());


        System.out.println("\n===== 3. HỆ THỐNG GỌI SỐ (Queue) =====");
        TicketSystem ticketSystem = new TicketSystem();

        ticketSystem.issueTicket("08:00");
        ticketSystem.issueTicket("08:05");

        System.out.println("Gọi số: " + ticketSystem.callNext());
        System.out.println("Gọi số: " + ticketSystem.callNext());


        System.out.println("\n===== 4. UNDO NHẬP LIỆU (Stack) =====");
        UndoManager undoManager = new UndoManager(5);

        undoManager.addAction(new InputAction("Tên", "An", "Anh", "10:00"));
        undoManager.addAction(new InputAction("Tuổi", "20", "21", "10:05"));

        System.out.println("Undo thao tác: " + undoManager.undo());
        System.out.println("Undo thao tác: " + undoManager.undo());
    }
}
