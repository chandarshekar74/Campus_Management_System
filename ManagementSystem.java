import java.util.*;

class Student {
    int id;
    String name;
    String department;

    Student(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Dept: " + department);
    }
}

class Course {
    int id;
    String courseName;

    Course(int id, String courseName) {
        this.id = id;
        this.courseName = courseName;
    }

    void display() {
        System.out.println("Course ID: " + id + ", Course Name: " + courseName);
    }
}

public class ManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Course> courses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Default Admin Credentials
    static String adminUsername = "Chandru";
    static String adminPassword = "1234";

    public static void main(String[] args) {

        if (!adminLogin()) {
            System.out.println("Too many failed attempts. Exiting...");
            return;
        }

        int choice;

        do {
            System.out.println("\n--- ADMIN PANEL ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Course");
            System.out.println("4. View Courses");
            System.out.println("5. Delete Student");
            System.out.println("6. Delete Course");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    addCourse();
                    break;
                case 4:
                    viewCourses();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    deleteCourse();
                    break;
                case 7:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);
    }

    static boolean adminLogin() {
        int attempts = 3;

        while (attempts > 0) {
            System.out.println("\n--- ADMIN LOGIN ---");
            System.out.print("Username: ");
            String username = sc.next();
            System.out.print("Password: ");
            String password = sc.next();

            if (username.equals(adminUsername) && password.equals(adminPassword)) {
                System.out.println("Login successful!");
                return true;
            } else {
                attempts--;
                System.out.println("Invalid credentials! Attempts left: " + attempts);
            }
        }
        return false;
    }

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        students.add(new Student(id, name, dept));
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            s.display();
        }
    }

    static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        students.removeIf(s -> s.id == id);
        System.out.println("Student deleted (if existed).");
    }

    static void addCourse() {
        System.out.print("Enter Course ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course Name: ");
        String name = sc.nextLine();

        courses.add(new Course(id, name));
        System.out.println("Course added successfully!");
    }

    static void viewCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }

        System.out.println("\n--- Course List ---");
        for (Course c : courses) {
            c.display();
        }
    }

    static void deleteCourse() {
        System.out.print("Enter Course ID to delete: ");
        int id = sc.nextInt();

        courses.removeIf(c -> c.id == id);
        System.out.println("Course deleted (if existed).");
    }
}
