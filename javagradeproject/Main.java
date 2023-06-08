package studentgradeproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    static Scanner input = new Scanner(System.in);
    static boolean done = false;
    private static int initialChoice;
    private static int gradeChoice;
    private static int studentIndex;
    protected static List<Student> studentList = new ArrayList<>();


    public static int initialScreen(){
        try {
            System.out.println("\nPlease enter one of the options below.");
            System.out.println("1. Enter new student. ");
            System.out.println("2. Enter new grade. ");
            System.out.println("3. Check grades. ");
            System.out.println("4. Exit the program. ");
            System.out.print("Enter choice: ");
            initialChoice = Integer.parseInt(input.nextLine());
            return initialChoice;
        } catch(Exception e) {
            return -1;
        }
    }

    public static int gradeChoice(){
        try {
            System.out.println("\nPlease enter one of the options below.");
            System.out.println("1. Get all grades of student. ");
            System.out.println("2. Get specified class grades of student. ");
            System.out.println("3. Get assignment grades in specified class of student. ");
            System.out.print("Enter choice: ");
            gradeChoice = Integer.parseInt(input.nextLine());
            return gradeChoice;
        } catch(Exception e) {
            return -1;
        }
    }

    public static void gradeSwitchCase() {
        boolean gradeDone = false;
        String classChoice = "";
        do{
            gradeChoice = gradeChoice();
            switch(gradeChoice) {
                case 1: studentIndex = Student.findStudentCheck();
                        Student newStudent = studentList.get(studentIndex);
                        newStudent.gradeEntry.printStudentsFullGrades(newStudent);
                        gradeDone = true;
                        break;
                case 2: studentIndex = Student.findStudentCheck();
                        newStudent = studentList.get(studentIndex);
                        System.out.print("Please enter name of the class you'd like to see grades of: ");
                        classChoice = input.nextLine().toLowerCase();
                        newStudent.gradeEntry.printStudentsSingleClassGrades(newStudent, classChoice);
                        gradeDone = true;
                        break;
                case 3: studentIndex = Student.findStudentCheck();
                        newStudent = studentList.get(studentIndex);
                        System.out.print("Please enter name of the class you'd like to see grades of: ");
                        classChoice = input.nextLine().toLowerCase();
                        System.out.print("Please enter the assignment type you'd like to see the grades of: ");
                        String assignmentChoice = input.nextLine().toLowerCase();
                        newStudent.gradeEntry.printStudentsSingleAssignmentGrades(newStudent, classChoice, assignmentChoice);
                        gradeDone = true;
                        break;
                default: System.out.println("Invalid input, please enter valid input." + "\n");
                        break;  
            } 
        } while(!(gradeDone));
    }

    public static void storeStudent(Student newStudent) {
        studentList.add(newStudent);
    }

    public static int studentListCheck(int choice, int size) {
        if((choice == 2 || choice == 3) && size == 0) {
            System.out.println("\n" + "There are no students added, please enter a student first.");
            return 0;
        } else {
            return choice;
        }
    }

    public static void main(String[] args) {
        do{
            int screenCheck = initialScreen();
            initialChoice = studentListCheck(screenCheck, studentList.size());
            switch(initialChoice) {
                case 0: break;
                case 1: Student newStudent = new Student();
                        storeStudent(newStudent);
                        newStudent.createStudent();
                        break;
                case 2: studentIndex = Student.findStudentCheck();
                        if(studentIndex == -1) {
                            break;
                        }
                        Student student = studentList.get(studentIndex);     
                        student.enterStudentClass();     
                        student.enterAssignmentType();
                        student.enterGrade();
                        student.gradeEntry.addGrade(student.gradeEntry.getClassName(), student.gradeEntry.getAssignmentType(),student.gradeEntry.getGrade());
                        break;
                case 3: gradeSwitchCase();
                        break;
                case 4: done = true;
                        break;
                default: System.out.println("\nInvalid input, please enter valid input.\n");
                        break;
            }          
        } while (!(done));
        System.out.println("\nThank you for using the program!");
    }
} 