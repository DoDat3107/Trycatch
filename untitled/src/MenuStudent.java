import java.util.List;
import java.util.Scanner;

public class MenuStudent {
    private StudentManager studentManager = new StudentManager();
    private Scanner inputNumber = new Scanner(System.in);
    private Scanner inputString = new Scanner(System.in);

    public void selectMenu() {
        int choice;
        do {
            System.out.println("============Menu Quản Lý Sinh Viên===========");
            System.out.println("1.1: Thêm Sinh Viên");
            System.out.println("1.2: Sửa Sinh Viên");
            System.out.println("1.3: Xóa Sinh Viên");
            System.out.println("1.4: Tìm Kiếm Theo ID Sinh Viên");
            System.out.println("1.5: Hiển Thị Tất Cả");
            System.out.println("0. Thoát Menu Sinh Viên");
            System.out.print("Chọn phương thức thực hiện: ");
            choice = inputNumber.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    showMenuEdit();
                    break;
                case 3:
                    showMenuDelete();
                    break;
                case 4:
                    showFindById();
                    break;
                case 5:
                    showMenuList();
                    break;
                case 0:
                    System.out.println("Thoát khỏi menu.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);
    }

    private void showMenuList() {
        System.out.println("===========Danh sách Sinh Viên ============");
        List<Student> listStudent = studentManager.getStudentList();
        for (int i = 0; i < listStudent.size(); i++) {
            System.out.println((i + 1) + ". " + listStudent.get(i));
        }
    }

    private void addStudent() {
        System.out.print("Nhập tên sinh viên: ");
        String name = inputString.nextLine();
        System.out.print("Nhập tuổi sinh viên: ");
        int age = inputNumber.nextInt();
        System.out.print("Nhập giới tính sinh viên: ");
        String gender = inputString.nextLine();
        Student student = new Student(name, age, gender);
        studentManager.add(student);
        System.out.println("Thêm sinh viên thành công.");
    }

    private void showMenuDelete() {
        System.out.print("Nhập ID Sinh Viên cần xóa: ");
        int idDelete = inputNumber.nextInt();
        studentManager.remove(idDelete);
        System.out.println("Xóa sinh viên thành công.");
    }

    private void showFindById() {
        System.out.print("Nhập ID Sinh Viên cần tìm kiếm: ");
        int id = inputNumber.nextInt();
        Student student = studentManager.getStudentById(id);
        if (student == null) {
            System.out.println("Không tìm thấy sinh viên có ID = " + id);
        } else {
            System.out.println("Thông tin sinh viên:");
            System.out.println("ID: " + student.getId());
            System.out.println("Tên: " + student.getName());
            System.out.println("Tuổi: " + student.getAge());
            System.out.println("Giới tính: " + student.getGender());
        }
    }

    private void showMenuEdit() {
        System.out.print("Nhập ID sinh viên cần sửa: ");
        int idEdit = inputNumber.nextInt();
        Student student = studentManager.getStudentById(idEdit);
        if (student == null) {
            System.out.println("Sinh viên không tồn tại.");
            return;
        }
        System.out.print("Nhập tên mới (hiện tại: " + student.getName() + "): ");
        String name = inputString.nextLine();
        System.out.print("Nhập tuổi mới (hiện tại: " + student.getAge() + "): ");
        int age = inputNumber.nextInt();
        System.out.print("Nhập giới tính mới (hiện tại: " + student.getGender() + "): ");
        String gender = inputString.nextLine();
        studentManager.Edit(idEdit, name, age, gender);
        System.out.println("Thông tin sinh viên đã được cập nhật.");
    }
}
