package student_grade_project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

public class grade_entry {
    UUID id;
    List<Float> grades = new ArrayList<>();
    Set<String> student_class = new HashSet<>();
    Set<String> assignment_type = new HashSet<>();
    private Scanner input = new Scanner(System.in);

    public void set_id(UUID id){
        this.id = id;
    }
    public void set_grade(Float new_grades){
        this.grades.add(new_grades);
    }
    public void set_student_class(String new_student_class){
        this.student_class.add(new_student_class);
    }
    public void set_assignment_type(String new_assignment_type){
        this.assignment_type.add(new_assignment_type);
    }

    public UUID get_id() {
        return id;
    }
    public List<Float> get_grade() {
        return grades;
    }
    public Set<String> get_student_class() {
        return student_class;
    }
    public Set<String> get_assignment_type() {
        return assignment_type;
    }
}