// Name: Nidhi Pandit
// PRN: 23070126081
// Batch: B1

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search by PRN");
            System.out.println("4. Search by Name");
            System.out.println("5. Search by Position");
            System.out.println("6. Update Student");
            System.out.println("7. Delete Student");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter PRN: ");
                    String prn = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter DOB: ");
                    String dob = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    manager.addStudent(prn, name, dob, marks);
                    break;
                
                case 2:
                    manager.displayStudents();
                    break;

                case 3:
                    System.out.print("Enter PRN to search: ");
                    Student foundByPrn = manager.searchByPrn(sc.nextLine());
                    if (foundByPrn != null) foundByPrn.displayStudent();
                    else System.out.println("Student not found.");
                    break;

                case 4:
                    System.out.print("Enter Name to search: ");
                    Student foundByName = manager.searchByName(sc.nextLine());
                    if (foundByName != null) foundByName.displayStudent();
                    else System.out.println("Student not found.");
                    break;

                case 5:
                    System.out.print("Enter Position: ");
                    Student foundByPos = manager.searchByPosition(sc.nextInt());
                    if (foundByPos != null) foundByPos.displayStudent();
                    else System.out.println("Invalid Position.");
                    break;

                case 6:
                    System.out.print("Enter PRN to update: ");
                    String updatePrn = sc.nextLine();
                    System.out.print("Enter new Name: ");
                    String updateName = sc.nextLine();
                    System.out.print("Enter new DOB: ");
                    String updateDob = sc.nextLine();
                    System.out.print("Enter new Marks: ");
                    double updateMarks = sc.nextDouble();
                    if (manager.updateStudent(updatePrn, updateName, updateDob, updateMarks)) {
                        System.out.println("Student updated successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 7:
                    System.out.print("Enter PRN to delete: ");
                    if (manager.deleteStudent(sc.nextLine())) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 8:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
