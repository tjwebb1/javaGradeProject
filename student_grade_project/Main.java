package student_grade_project;

import java.util.Scanner;

public class Main{
    Scanner input = new Scanner(System.in);
    static boolean done = false;
    static grade_entry grade = new grade_entry();

    public static void main(String[] args) {
        do{
            grade.enter_grade();
            
        } while (!(done));
    }
}