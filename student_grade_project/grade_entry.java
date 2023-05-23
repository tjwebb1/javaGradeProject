package student_grade_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.List;

public class grade_entry {
    UUID id;
    private String class_name;
    private String assignment_type;
    private Float grade;
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

    public String get_class_name() {
        return class_name;
    }

    public String get_assignment_type() {
        return assignment_type;
    }

    public float get_grade() {
        return grade;
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
            return assignments.getOrDefault(assignment_type, Collections.emptyList());
        }
        return Collections.emptyList();
    }

    public void print_student_full_grades(student student) { 
        Map<String, Map<String, List<Float>>> student_class = student.grade_entry.get_student_class();
        for(Map.Entry<String, Map<String, List<Float>>> class_entry : student_class.entrySet()) {
            String class_name = class_entry.getKey();
            Map<String, List<Float>> assignments = class_entry.getValue();
            System.out.println("In your " + class_name + " class: ");
            for(Map.Entry<String, List<Float>> assignment_entry : assignments.entrySet()) {
                String assignment_type = assignment_entry.getKey();
                List<Float> grade = assignment_entry.getValue();
                for(int i = 0; i < grade.size(); i++) {
                    System.out.println("- You received a grade of " + grade.get(i) + " on " + assignment_type + " number " + (i+1) + "\n");
                }
            }
        }
    }

    public void print_student_single_class_grades(student student_name, String class_input) { 
        Map<String, Map<String, List<Float>>> student_class = student_name.grade_entry.get_student_class();
        for(Map.Entry<String, Map<String, List<Float>>> class_entry : student_class.entrySet()) {
            String class_name = class_entry.getKey();
            if(class_name.equals(class_input)) {
                Map<String, List<Float>> assignments = class_entry.getValue();
                System.out.println("In your " + class_name + " class: ");
                for(Map.Entry<String, List<Float>> assignment_entry : assignments.entrySet()) {
                    String assignment_type = assignment_entry.getKey();
                    List<Float> grade = assignment_entry.getValue();
                    for(int i = 0; i < grade.size(); i++) {
                        System.out.println("- You received a grade of " + grade.get(i) + " on " + assignment_type + " number " + (i+1) + "\n");
                    }
                }
            }
        }
    }

    public void print_student_single_assignment_grades(student student_name, String class_input, String assignment_input) { 
        Map<String, Map<String, List<Float>>> student_class = student_name.grade_entry.get_student_class();
        for(Map.Entry<String, Map<String, List<Float>>> class_entry : student_class.entrySet()) {
            String class_name = class_entry.getKey();
            if(class_name.equals(class_input)) {
                Map<String, List<Float>> assignments = class_entry.getValue();
                System.out.println("In your " + class_name + " class: ");
                for(Map.Entry<String, List<Float>> assignment_name : assignments.entrySet()) {
                    String assignment_type = assignment_name.getKey();
                    if(assignment_type.equals(assignment_input)) {
                        List<Float> grade = assignment_name.getValue();
                        for(int i = 0; i < grade.size(); i++) {
                            System.out.println("- You received a grade of " + grade.get(i) + " on " + assignment_type + " number " + (i+1) + "\n");
                        }
                    }
                }
            }
        }
    }
}