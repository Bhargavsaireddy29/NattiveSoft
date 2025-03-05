import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;
    private String course;

    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public int getId() {
        return id;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course;
    }
}

public class StudentManagementSystem {
    private static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nStudent Management System:");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Remove Student");
            System.out.println("4. View Student Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    updateStudent(scanner);
                    break;
                case 3:
                    removeStudent(scanner);
                    break;
                case 4:
                    viewStudents();
                    break;
                case 5:
                    System.out.println("Exiting Student Management System...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student Course: ");
        String course = scanner.nextLine();

        Student student = new Student(id, name, age, course);
        studentList.add(student);
        System.out.println("Student added successfully!");
    }

    private static void updateStudent(Scanner scanner) {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Student student : studentList) {
            if (student.getId() == id) {
                System.out.print("Enter new Name: ");
                student.setName(scanner.nextLine());
                System.out.print("Enter new Age: ");
                student.setAge(scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.print("Enter new Course: ");
                student.setCourse(scanner.nextLine());
                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student with ID " + id + " not found.");
    }

    private static void removeStudent(Scanner scanner) {
        System.out.print("Enter Student ID to remove: ");
        int id = scanner.nextInt();

        for (Student student : studentList) {
            if (student.getId() == id) {
                studentList.remove(student);
                System.out.println("Student removed successfully!");
                return;
            }
        }

        System.out.println("Student with ID " + id + " not found.");
    }

    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }
}
