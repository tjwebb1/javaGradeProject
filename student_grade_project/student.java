package student_grade_project;

import java.util.Scanner;
import java.util.UUID;

public class student {
    UUID id; //static may be causing issues, kept it to have program run, will fix
    private String grade_level;
    private String name;
    private static Scanner input = new Scanner(System.in);
    UUID random_id = UUID.randomUUID(); // needs fixed, generates same uuid for each person, possibly due to static?
    grade_entry grade_entry = new grade_entry();

    @Override
    public String toString() { // for testing
        return "Student: name = " + name + "; grade level = " + grade_level + "; id = " + id + "; grade = " + grade_entry.get_grade() + "; class = " + grade_entry.get_student_class() + "; assignment = " + grade_entry.get_assignment_type();
    }

    public static int find_student() {
        int index = 0;
        System.out.print("Please enter name of student: ");
        String check = input.nextLine().toLowerCase(); // picks up empty string and bypasses student search
        for(student element : Main.student_list) {
            if(element.get_name().contains(check)) {
                System.out.println("Search successful");
                return index;
            } else {
                index++;
            }
        }
        System.out.println("Search failed");
        return -1; // crashes the program, needs fixed, exception case
    }

    public void enter_student_class() {
        System.out.print("Please enter class: ");
        grade_entry.set_student_class(input.nextLine().toLowerCase());
    }

    public void enter_assignment_type() {
        System.out.print("Please enter assignment type: ");
        grade_entry.set_assignment_type(input.nextLine().toLowerCase());
    }

    public void enter_grade() {
        System.out.print("Please enter grade: ");
        grade_entry.set_grade(Float.parseFloat(input.nextLine()));
    }

    public void create_student() {
        System.out.print("Please enter students name: ");
        set_name(input.nextLine().toLowerCase());
        set_id();
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

    public UUID get_id() {
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
