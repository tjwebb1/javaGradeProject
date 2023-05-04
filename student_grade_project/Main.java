package student_grade_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    static Scanner input = new Scanner(System.in);
    static boolean done = false;
    static int choice;
    static int index;
    public static List<student> student_list = new ArrayList();


    public static int initial_screen() {
        System.out.println("Please enter one of the options below." + "\n");
        System.out.println("1. Enter Grade. ");
        System.out.println("2. Enter new student. ");
        System.out.println("3. Check grades: ");
        return input.nextInt();
    }

    public static void store_student(student new_student) {
        student_list.add(new_student);
    }

    public static void main(String[] args) {
        do{
            int choice = initial_screen();
            switch(choice) {

                case 1: grade_entry grade = new grade_entry();
                        index = grade.find_student(); // for testing
                        
                        break;
                case 2: student new_student = new student();
                        student_list.add(new_student);
                        new_student.create_student();
                        new_student.enter_grade_level();
                        break;
                case 3: for(int i = 0; i < student_list.size(); i++) { // for testing
                            System.out.println(student_list.get(i));
                        } 
                        break;
                default:
                        System.out.println("Invalid input, please enter valid input.");
                        continue;
            }          
        } while (!(done));
    }
}