package student_grade_project;

import java.util.Scanner;
import java.util.UUID;

public class Student {
    UUID id;
    private String gradeLevel;
    private String name;
    private static Scanner input = new Scanner(System.in);
    UUID randomID = UUID.randomUUID();
    GradeEntry gradeEntry = new GradeEntry();

    public static int findStudentCheck() {
        int check = findStudent();
        if(check == -1) {
            return -1;
        }
        else if(check == -2) {
            return findStudentCheck();
        } else {
            return check;
        }
    }

    public static int findStudent(){
        int index = 0;
        System.out.print("\nPlease enter name of student (or enter -1 to exit): ");
        String check = input.nextLine().toLowerCase();
        if(check.equals("-1")) {
            return -1;
        }
        for(Student element : Main.studentList) {
            if(element.getName().equals(check)) {
                System.out.println("\nStudent found successfully.\n");
                return index;
            } else {
                index++;
            }
        }
        System.out.println("\nStudent not found.");
        return -2;
    }

    public void enterStudentClass() {
        System.out.print("Please enter class: ");
        gradeEntry.setClassName(input.nextLine().toLowerCase());
    }

    public void enterAssignmentType() {
        System.out.print("Please enter assignment type: ");
        gradeEntry.setAssignmentType(input.nextLine().toLowerCase());
    }

    public void enterGrade() {
        Boolean check = false;
        while(Boolean.FALSE.equals((check))) {
            System.out.print("Please enter grade: ");
            String gradeCheck = input.nextLine();
            try {
                float grade = Float.parseFloat(gradeCheck);
                gradeEntry.setGrade(grade);
                check = true;
            } catch(NumberFormatException e) {
                System.out.println("\nNot a valid grade, please enter an a valid grade.\n");
            }
        }
    }

    public void createStudent() {
        System.out.print("\nPlease enter students name: ");
        setName(input.nextLine().toLowerCase());
        setID();
        enterGradeLevel();
    }
    
    public void enterGradeLevel() {
        System.out.print("Please enter students grade level: ");
        setGradeLevel(input.nextLine().toLowerCase());
    }

    public void setID() {
        this.id = randomID;
        gradeEntry.setID(id);
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getID() {
        return id;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public String getName() {
        return name;
    }
}
