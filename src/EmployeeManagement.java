import java.util.Scanner;

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class EmployeeManagement {
    private List<Employee> students;
    private Scanner scanner;

    public EmployeeManagement() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addEmployee() {
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();


        Employee student = new Employee(name, age, id);
        students.add(student);
        System.out.println("add successfully");
    }

    public void searchEmployee() {
        System.out.println("Enter search query:");
        String query = scanner.nextLine();
        List<Employee> results = new ArrayList<>();
        for (Employee student : students) {
            if (student.getName().contains(query)) {
                results.add(student);
            }
        }
        if (results.isEmpty()) {
            System.out.println("No results found.");
        } else {
            System.out.println("Search results:");
            for (Employee result : results) {
                System.out.println(result.toString());
            }
        }
    }

    public void editEmployee() {
        System.out.println("Enter id of student to update: ");
        int id = scanner.nextInt();
        for (Employee student : students) {
            if (id == student.getId()) {
                System.out.println("Enter Name: ");
                String name = scanner.nextLine();
                System.out.println("Enter Age: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                student.setName(name);
                student.setAge(age);
            } else {
                System.out.println("Student not found !");
            }
        }
    }
    public void deleteEmployee() {
        System.out.println("Enter Roll Number of student to delete:");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean removed = students.removeIf(student -> student.getId() == id);
        if (removed) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
    public void displayAllEmployee() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("List of students:");
            for (Employee student : students) {
                System.out.println(student.toString());
            }
        }
    }

    public void run(){
        System.out.println("1 : Add Employee");
        System.out.println("2 : seach Employee");
        System.out.println("3 : edit Employee");
        System.out.println("4 : delete Employee");
        System.out.println("5 : Display Employee");
        System.out.println("6 : Exit");
        System.out.println("your choice : ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addEmployee();
                break;
            case 2:
                searchEmployee();
            case 3:
                editEmployee();
                break;
            case 4:
                deleteEmployee();
                break;
            case 5:
                displayAllEmployee();
                break;
            case 6:
                boolean run = false;
                break;
        }
    }

    public static void main(String[] args) {
        EmployeeManagement sc = new EmployeeManagement();
        sc.run();
    }
}





