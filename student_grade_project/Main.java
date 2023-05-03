package student_grade_project;

import java.util.Scanner;

public class Main{
    static Scanner input = new Scanner(System.in);
    static boolean done = false;
    static grade_entry grade = new grade_entry();
    public int choice;
    static student student;

    public static int initial_screen() {
        System.out.println("Please enter one of the options below." + "\n");
        System.out.println("1. Enter Grade. ");
        System.out.println("2. Enter new student. ");
        System.out.println("3. Check grades: ");
        return input.nextInt();
    }
    public static void main(String[] args) {
        do{
            int choice = initial_screen();
            switch(choice) {
                case 1: student new_student = new student();
                        new_student.enter_name();
                        System.out.println(new_student.get_name());
                case 3: student.enter_name();
                        System.out.println(student.get_name());
            }

            
        } while (!(done));
    }
}