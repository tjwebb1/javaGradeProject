package student_grade_project;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class student {
    private int id;
    private int grade_level;
    private String name;
    private Scanner input = new Scanner(System.in);
    grade_entry grade_entry = new grade_entry();
    Main main;

    public void enter_name() {
        System.out.print("Please enter students name: ");
        if(main.choice == 1) {
            set_name(input.nextLine());
        } else {
            get_name();
        }
    }


    public void enter_assignment() {
        System.out.print("Please enter assingment type: ");
        grade_entry.set_assignment_type(input.nextLine());
    }

    public void enter_class() {
        System.out.print("Please enter class: ");
        grade_entry.set_student_class(input.nextLine());
    }

    public void generate_id() {

    }

    public void set_id(int new_id) {
        id = new_id;
    }

    public void set_grade_level(int new_grade_level) {
        grade_level = new_grade_level;
    }

    public void set_name(String new_name) {
        name = new_name;
    }

    public int get_id() {
        return id;
    }
    
    public int get_grade_level() {
        return grade_level;
    }

    public String get_name() {
        return name;
    }

    public String get_name(String name) {
        return this.name;
    }
}
