package student_grade_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    static Scanner input = new Scanner(System.in);
    static boolean done = false;
    static int initial_choice;
    static int grade_choice;
    static int student_index;
    public static List<student> student_list = new ArrayList<>();


    public static int initial_screen(){
        try {
            System.out.println("\nPlease enter one of the options below.");
            System.out.println("1. Enter new student. ");
            System.out.println("2. Enter new grade. ");
            System.out.println("3. Check grades. ");
            System.out.println("4. Exit the program. ");
            System.out.print("Enter choice: ");
            initial_choice = Integer.parseInt(input.nextLine());
            return initial_choice;
        } catch(Exception e) {
            return -1;
        }
    }

    public static int grade_choice(){
        try {
            System.out.println("\nPlease enter one of the options below.");
            System.out.println("1. Get all grades of student. ");
            System.out.println("2. Get specified class grades of student. ");
            System.out.println("3. Get assignment grades in specified class of student. ");
            System.out.print("Enter choice: ");
            grade_choice = Integer.parseInt(input.nextLine());
            return grade_choice;
        } catch(Exception e) {
            return -1;
        }
    }

    public static void grade_switch_case() {
        boolean grade_done = false;
        String class_choice = "";
        do{
            grade_choice = grade_choice();
            student_index = student.check_find_student();
            student new_student = student_list.get(student_index);
            switch(grade_choice) {
                case 1: new_student.grade_entry.print_student_full_grades(new_student);
                        grade_done = true;
                        break;
                case 2: System.out.print("Please enter name of the class you'd like to see grades of: ");
                        class_choice = input.nextLine().toLowerCase();
                        new_student.grade_entry.print_student_single_class_grades(new_student, class_choice);
                        grade_done = true;
                        break;
                case 3: System.out.print("Please enter name of the class you'd like to see grades of: ");
                        class_choice = input.nextLine().toLowerCase();
                        System.out.print("Please enter the assignment type you'd like to see the grades of: ");
                        String assignment_choice = input.nextLine().toLowerCase();
                        new_student.grade_entry.print_student_single_assignment_grades(new_student, class_choice, assignment_choice);
                        grade_done = true;
                        break;
                default: System.out.println("Invalid input, please enter valid input." + "\n");
                        break;  
            } 
        } while(!(grade_done));
    }

    public static void store_student(student new_student) {
        student_list.add(new_student);
    }

    public static int student_list_check(int choice, int size) {
        if((choice == 2 || choice == 3) && size == 0) {
            System.out.println("\n" + "There are no students added, please enter a student first.");
            return 0;
        } else {
            return choice;
        }
    }

    public static void main(String[] args) throws Exception{
        do{
            int screen_check = initial_screen();
            initial_choice = student_list_check(screen_check, student_list.size());
            switch(initial_choice) {
                case 0: break;
                case 1: student new_student = new student();
                        store_student(new_student);
                        new_student.create_student();
                        new_student.enter_grade_level();
                        break;
                case 2: student_index = student.check_find_student();
                        if(student_index == -1) {
                            break;
                        }
                        student student = student_list.get(student_index);     
                        student.enter_student_class();     
                        student.enter_assignment_type();
                        student.enter_grade();
                        student.grade_entry.add_grade(student.grade_entry.get_class_name(), student.grade_entry.get_assignment_type(),student.grade_entry.get_grade());
                        break;
                case 3: grade_switch_case();
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