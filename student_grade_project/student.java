package student_grade_project;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class student {
    private int id;
    private int grade_level;
    private String name;
    private Scanner input = new Scanner(System.in);

    public void enter_name() {
        System.out.print("Please enter students name: ");
        set_name(input.nextLine());
    }

    public void set_id(int id) {
        this.id = id;
    }

    public void set_grade_level(int grade_level) {
        this.grade_level = grade_level;
    }

    public void set_name(String name) {
        this.name = name;
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
}
