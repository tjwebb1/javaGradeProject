import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.List;

public class GradeEntry {
    UUID id;
    private String className;
    private String assignmentType;
    private Float grade;
    Map<String, Map<String, List<Float>>> studentClass = new LinkedHashMap<>();

    public void setID(UUID id) {
        this.id = id;
    }

    public void addGrade(String className, String assignmentType, float grade) {
        Map<String, List<Float>> assignments = studentClass.computeIfAbsent(className, key -> new LinkedHashMap<>());
        List<Float> grades = assignments.computeIfAbsent(assignmentType, key -> new ArrayList<>());
        grades.add(grade);
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public String getClassName() {
        return className;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public float getGrade() {
        return grade;
    }

    public Map<String, Map<String, List<Float>>> getStudentClass() {
        return studentClass;
    }

    public void printStudentsFullGrades(Student student) { 
        studentClass = student.gradeEntry.getStudentClass();
        for(Map.Entry<String, Map<String, List<Float>>> classEntry : studentClass.entrySet()) {
            className = classEntry.getKey();
            Map<String, List<Float>> assignments = classEntry.getValue();
            System.out.println("In your " + className + " class: ");
            for(Map.Entry<String, List<Float>> assignmentEntry : assignments.entrySet()) {
                assignmentType = assignmentEntry.getKey();
                List<Float> gradeList = assignmentEntry.getValue();
                for(int i = 0; i < gradeList.size(); i++) {
                    System.out.println("- You received a grade of " + gradeList.get(i) + " on " + assignmentType + " number " + (i+1) + "\n");
                }
            }
        }
    }

    public void printStudentsSingleClassGrades(Student studentName, String classInput) { 
        Map<String, Map<String, List<Float>>> studentClassList = studentName.gradeEntry.getStudentClass();
        for(Map.Entry<String, Map<String, List<Float>>> classEntry : studentClassList.entrySet()) {
            className = classEntry.getKey();
            if(className.equals(classInput)) {
                Map<String, List<Float>> assignments = classEntry.getValue();
                System.out.println("In your " + className + " class: ");
                for(Map.Entry<String, List<Float>> assignmentEntry : assignments.entrySet()) {
                    assignmentType = assignmentEntry.getKey();
                    List<Float> gradeList = assignmentEntry.getValue();
                    for(int i = 0; i < gradeList.size(); i++) {
                        System.out.println("- You received a grade of " + gradeList.get(i) + " on " + assignmentType + " number " + (i+1) + "\n");
                    }
                }
            }
        }
    }

    public void printStudentsSingleAssignmentGrades(Student studentName, String classInput, String assignmentInput) { 
        Map<String, Map<String, List<Float>>> studentClassList = studentName.gradeEntry.getStudentClass();
        for(Map.Entry<String, Map<String, List<Float>>> classEntry : studentClassList.entrySet()) {
            className = classEntry.getKey();
            if(className.equals(classInput)) {
                Map<String, List<Float>> assignments = classEntry.getValue();
                System.out.println("In your " + className + " class: ");
                for(Map.Entry<String, List<Float>> assignmentName : assignments.entrySet()) {
                    assignmentType = assignmentName.getKey();
                    if(assignmentType.equals(assignmentInput)) {
                        List<Float> gradeList = assignmentName.getValue();
                        for(int i = 0; i < gradeList.size(); i++) {
                            System.out.println("- You received a grade of " + gradeList.get(i) + " on " + assignmentType + " number " + (i+1) + "\n");
                        }
                    }
                }
            }
        }
    }
}