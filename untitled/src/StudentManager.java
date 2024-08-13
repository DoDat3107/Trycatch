import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> studentList;
    private ReadAndWriteData readAndWriteData;

    public StudentManager() {
        this.readAndWriteData = new ReadAndWriteData();
        this.studentList = this.readAndWriteData.readData();
    }

    public void add(Student student) {
        this.studentList.add(student);
        this.readAndWriteData.WriteData(this.studentList);

    }

    public void remove(int id) {
        int index = findById(id);
        if (index != -1) {
            this.studentList.remove(index);
            this.readAndWriteData.WriteData(this.studentList);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public int findById(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void Edit(int id, String newName, int newAge, String newGender) {
        int index = findById(id);
        if (index != -1) {
            Student student = studentList.get(index);

            if (newName != null && !newName.isEmpty()) {
                student.setName(newName);
            }
            if (newAge > 0) {
                student.setAge(newAge);
            }
            if (newGender != null && !newGender.isEmpty()) {
                student.setGender(newGender);
            }

            this.readAndWriteData.WriteData(this.studentList);
            System.out.println("Sinh vien co " + id + " da dc thay doi");
        } else {
            System.out.println("Khong tim thay sinh vien co " + id);
        }
    }

    public List<Student> getStudentList() {
        return this.studentList;
    }

    public Student getStudentById(int id) {
        int index = findById(id);
        if (index != -1) {
            return studentList.get(index);
        }
        return null;
    }
}

