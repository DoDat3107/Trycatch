import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteData {
    private File file = new File("Data/List.csv");
    public void WriteData(List<Student> StudentList) {
        try {
            String data = "";
            for (Student student : StudentList) {
                data += student.getId() + "," + student.getName() + "," + student.getAge() + "," + student.getGender() + "\n";
            }
            FileWriter fileWriter = new FileWriter(this.file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Student> readData() {
        List<Student> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(this.file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String Line;
            while ((Line = bufferedReader.readLine()) != null) {
                String[] data = Line.split(",");
                Student student = new Student(data[0], Integer.parseInt(data[1]), data[2]);
                list.add(student);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
