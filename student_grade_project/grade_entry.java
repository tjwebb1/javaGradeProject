package student_grade_project;

public class grade_entry {
    int id;
    float grade;
    String student_class;
    String assignment_type;

    public void set_id(int id){
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

    public int get_id() {
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