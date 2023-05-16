package student_grade_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    static Scanner input = new Scanner(System.in);
    static boolean done = false;
    static int choice;
    static int student_index;
    public static List<student> student_list = new ArrayList<>();


    public static int initial_screen() {
        System.out.println("Please enter one of the options below." + "\n");
        System.out.println("1. Enter Grade. ");
        System.out.println("2. Enter new student. ");
        System.out.println("3. Check grades: ");
        choice = Integer.parseInt(input.nextLine());
        return choice;
    }

    public static void store_student(student new_student) {
        student_list.add(new_student);
    }

    public static void main(String[] args) throws Exception {
        do{
            choice = initial_screen();
            switch(choice) {
                case 1: student_index = student.find_student(); // for testing     
                        student_list.get(student_index).enter_student_class();     
                        student_list.get(student_index).enter_assignment_type();
                        student_list.get(student_index).enter_grade();
                        student_list.get(student_index).grade_entry.add_grade(grade_entry.class_name, grade_entry.assignment_type,grade_entry.grade);
                        break;
                case 2: student new_student = new student();
                        store_student(new_student);
                        new_student.create_student();
                        new_student.enter_grade_level();
                        break;
                case 3: for(int i = 0; i < student_list.size(); i++) {
                        System.out.println(student_list.get(i)); // for testing
                        }   
                        break;
                default:
                        System.out.println("Invalid input, please enter valid input.");
                        break;
            }          
        } while (!(done));
    }
}