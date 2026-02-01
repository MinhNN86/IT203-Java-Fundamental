package Session07;

public class Ex04 {
    static class ClassRoom {
        private static double classFund = 0;
        private String nameStudent;

        public ClassRoom(String nameStudent) {
            this.nameStudent = nameStudent;
        }

        public void payFund(double amount) {
            if (amount > 0) {
                classFund += amount;
                System.out.println(this.nameStudent + " đã đóng góp: $" + amount);
            } else {
                System.out.println("Số tiền đóng góp phải lớn hơn 0!");
            }
        }

        public static double getClassFund() {
            return classFund;
        }
    }

    public static void main(String[] args) {

        ClassRoom s1 = new ClassRoom("Minh");
        ClassRoom s2 = new ClassRoom("An");
        ClassRoom s3 = new ClassRoom("Hoa");

        s1.payFund(100);
        s2.payFund(150);
        s3.payFund(200);

        // Gọi biến static qua tên lớp
        System.out.println("Tổng quỹ lớp: " + ClassRoom.getClassFund());
    }
}
