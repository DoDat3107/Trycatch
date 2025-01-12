public class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private static int nextId = 1;
    public Student(String name, int age, String gender) {
        this.id = nextId++;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Student.nextId = nextId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", || name='" + name + '\'' +
                ", || age=" + age +
                ", || gender='" + gender + '\'' +
                '}';
    }
}
