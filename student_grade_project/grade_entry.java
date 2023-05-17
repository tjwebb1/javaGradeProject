package student_grade_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.List;

public class grade_entry {
    UUID id;
    private static String class_name;
    private static String assignment_type;
    private static Float grade;
    static Map<String, Map<String, List<Float>>> student_class = new LinkedHashMap<>();
    
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

    public static String get_class_name() {
        return class_name;
    }

    public static String get_assignment_type() {
        return assignment_type;
    }

    public static float get_grade() {
        return grade;
    }

    public static Map<String, Map<String, List<Float>>> get_student_class() {
        return student_class;
    }

    public static Map<String, List<Float>> get_assignment(String class_name) {
        return student_class.getOrDefault(class_name, Collections.emptyMap());
    }

    public static List<Float> get_grade(String class_name, String assignment_type) {
        Map<String, List<Float>> assignments = student_class.get(class_name);
        if(assignments != null) {
            return assignments.getOrDefault(assignment_type, Collections.emptyList());
        }
        return Collections.emptyList();
    }

    public static void print_student_grades() { // needs a major revamp with getKey() and getValue() and other types, Grade can keep k though
        for(int i = 0; i < student_class.size(); i++) {
            for(int j = 0; j < get_assignment(get_class_name()).size(); j++) {
                for(int k = 0; k < get_grade(get_class_name(),get_assignment_type()).size(); k++) {
                    System.out.println("In your " + get_student_class().get(i) + "class, for your " + get_assignment(get_class_name()).get(j) + 
                    " assignment type, you got an " +  get_grade(get_class_name(),get_assignment_type()).get(k) + " on assignment " + (k+1));
                }
            }
        }
    }
}