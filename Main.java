package sample;

public class Main {
    public static void main(String[] args) {
        Group group = new Group("Java-101");

        try {
           
            group.addStudent(new Student("Anna", "Ivanova", Gender.FEMALE, 1, "Java-101"));
            group.addStudent(new Student("Ivan", "Petrov", Gender.MALE, 2, "Java-101"));

           
            System.out.println("Searching for student: " + group.searchStudentByLastName("Ivanova"));

          
            boolean removed = group.removeStudentByID(2);
            System.out.println("Student removed: " + removed);

          
            for (int i = 3; i <= 11; i++) {
                group.addStudent(new Student("Student" + i, "LastName" + i, Gender.MALE, i, "Java-101"));
            }

          
            group.addStudent(new Student("Overflow", "Student", Gender.MALE, 999, "Java-101"));

        } catch (GroupOverflowException | StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        
        System.out.println("\nCurrent group members:");
        System.out.println(group);
    }
}