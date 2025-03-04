// StudentManager.java
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    // Method to add a student
    public void addStudent(String prn, String name, String dob, double marks) {
        students.add(new Student(prn, name, dob, marks));
        System.out.println("Student added successfully!");
    }

    // Method to display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            s.displayStudent();
        }
    }

    // Search by PRN
    public Student searchByPrn(String prn) {
        for (Student s : students) {
            if (s.getPrn().equals(prn)) {
                return s;
            }
        }
        return null;
    }

    // Search by Name
    public Student searchByName(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    // Search by Position (Index)
    public Student searchByPosition(int index) {
        if (index >= 0 && index < students.size()) {
            return students.get(index);
        }
        return null;
    }

    // Update Student details
    public boolean updateStudent(String prn, String name, String dob, double marks) {
        Student s = searchByPrn(prn);
        if (s != null) {
            s.setName(name);
            s.setDob(dob);
            s.setMarks(marks);
            return true;
        }
        return false;
    }

    // Delete Student
    public boolean deleteStudent(String prn) {
        Student s = searchByPrn(prn);
        if (s != null) {
            students.remove(s);
            return true;
        }
        return false;
    }
}
