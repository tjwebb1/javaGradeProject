package student_grade_project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class grade_entry {
    UUID id;
    List<Float> grades = new ArrayList<>();
    Set<String> assignment_type = new HashSet<>();
    Set<String> student_class = new HashSet<>();
    

    public void set_id(UUID id){
        this.id = id;
    }

    public void set_student_class(String new_student_class){
        student_class.add(new_student_class);
    }

    public void set_grade(Float new_grade){
        grades.add(new_grade);
    }

    public void set_assignment_type(String new_assignment_type){
        assignment_type.add(new_assignment_type);
    }

    public Set<String> get_assignment_type() {
        return assignment_type;
    }

    public List<Float> get_grade() {
        return grades;
    }

    public UUID get_id() {
        return id;
    }

    public Set<String> get_student_class() {
        return student_class;
    }
}