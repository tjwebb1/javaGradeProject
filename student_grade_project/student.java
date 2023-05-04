package student_grade_project;

import java.util.Scanner;
import java.util.UUID;

public class student {
    static UUID id; //static may be causing issues, kept it to have program run, will fix
    private String grade_level;
    private String name;
    private Scanner input = new Scanner(System.in);
    UUID random_id = UUID.randomUUID(); // needs fixed, generates same uuid for each person, possibly due to static?
    grade_entry grade_entry = new grade_entry();
    Main main;

    @Override
    public String toString() { // for testing
        return "Student: name = " + name + "; grade level = " + grade_level + "; id = " + id + "; grade = " + grade_entry.grade + "; class = " + grade_entry.student_class + "; assignment = " + grade_entry.assignment_type;
    }


    public void create_student() {
        System.out.print("Please enter students name: ");
        set_name(input.nextLine());
        set_id();
    }

    public void enter_assignment() {
        System.out.print("Please enter assingment type: ");
        grade_entry.set_assignment_type(input.nextLine().toLowerCase());
    }

    public void enter_class() {
        System.out.print("Please enter class: ");
        grade_entry.set_student_class(input.nextLine().toLowerCase());
    }
    
    public void enter_grade_level() {
        System.out.print("Please enter students grade level: ");
        set_grade_level(input.nextLine().toLowerCase());
    }

    public void set_id() {
        this.id = random_id;
        grade_entry.set_id(id);
    }

    public void set_grade_level(String new_grade_level) {
        grade_level = new_grade_level;
    }

    public void set_name(String new_name) {
        name = new_name;
    }

    public static UUID get_id() {
        return id;
    }
    
    public String get_grade_level() {
        return grade_level;
    }

    public String get_name() {
        return name;
    }

    public String get_name(String name) {
        return this.name;
    }
}
