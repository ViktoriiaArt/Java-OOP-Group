package sample;

public class Group {
    private String groupName;
    private Student[] students = new Student[10];

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group() {}

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void addStudent(Student student) throws GroupOverflowException {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return;
            }
        }
        throw new GroupOverflowException("Группа переполнена, нельзя добавить студента.");
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (Student student : students) {
            if (student != null && student.getLastName().equalsIgnoreCase(lastName)) {
                return student;
            }
        }
        throw new StudentNotFoundException("Студент с фамилией '" + lastName + "' не найден.");
    }

    public boolean removeStudentByID(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getId() == id) {
                students[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Group: " + groupName + "\n");
        for (Student student : students) {
            if (student != null) {
                sb.append(student.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}