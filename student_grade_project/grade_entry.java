package student_grade_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.List;

public class grade_entry {
    UUID id;
    public static String class_name;
    public static String assignment_type;
    public static Float grade;
    Map<String, Map<String, List<Float>>> student_class = new LinkedHashMap<>();
    
    public void set_id(UUID id) {
        this.id = id;
    }

    public void add_grade(String class_name, String assignment_type, float grade) {
        Map<String, List<Float>> assignments = student_class.computeIfAbsent(class_name, key -> new LinkedHashMap<>());
        List<Float> grades = assignments.computeIfAbsent(assignment_type, key -> new ArrayList<>());
        grades.add(grade);
    }

    public void set_class_name(String class_name) {
        this.class_name = class_name;
    }

    public void set_assignment_type(String assignment_type) {
        this.assignment_type = assignment_type;
    }

    public void set_grade(Float grade) {
        this.grade = grade;
    }

    public Map<String, Map<String, List<Float>>> get_student_class() {
        return student_class;
    }

    public Map<String, List<Float>> get_assignment(String class_name) {
        return student_class.getOrDefault(class_name, Collections.emptyMap());
    }

    public List<Float> get_grade(String class_name, String assignment_type) {
        Map<String, List<Float>> assignments = student_class.get(class_name);
        if(assignments != null) {
            return assignments.getOrDefault(assignment_type, new ArrayList<>());
        }
        return new ArrayList<>();
    }
}