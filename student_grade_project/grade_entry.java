package student_grade_project;

import java.util.Scanner;
import java.util.UUID;

public class grade_entry {
    static UUID id; //static may be causing issues, kept it to have program run, will fix
    static float grade;
    static String student_class;
    static String assignment_type;
    private Scanner input = new Scanner(System.in);
    Main main;

    public int find_student() {
        int index = 0;
        System.out.print("Please enter name of student: ");
        String name = input.nextLine().toLowerCase();
        for(student element : Main.student_list) {
            if(element.get_name().contains(name) && student.get_id() == get_id()) { // for testing
                System.out.println("Search successful");
                return index;
            } else {
                System.out.println("Search failed");
                index++;
            }
        }
        return -1;
    }

    public void set_id(UUID id){
        this.id = id;
    }
    public void set_grade(float grade){
        this.grade = grade;
    }
    public void set_student_class(String student_class){
        this.student_class = student_class;
    }
    public void set_assignment_type(String assignment_type){
        this.assignment_type = assignment_type;
    }

    public UUID get_id() {
        return id;
    }
    public float get_grade() {
        return grade;
    }
    public String get_student_class() {
        return student_class;
    }
    public String get_assignment_type() {
        return assignment_type;
    }
}