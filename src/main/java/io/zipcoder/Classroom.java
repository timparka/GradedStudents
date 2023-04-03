package io.zipcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Classroom {
    Student[] students;
    private int maxNumberOfStudents;
    public Classroom(int maxNumberOfStudents){
        this.students = new Student[maxNumberOfStudents];
        this.maxNumberOfStudents = maxNumberOfStudents;
    }
    public Classroom(Student[] students){
        this.students = students;
        this.maxNumberOfStudents = students.length;
    }
    public Classroom(){
        this.students = new Student[30];
        this.maxNumberOfStudents = 30;
    }
    public Student[] getStudents(){
        Student[] noNull = new Student[maxNumberOfStudents];
        int index = 0;
        for (Student a: students){
            if (a != null){
                noNull[index] = a;
                index++;
            }
        }
        return Arrays.copyOf(noNull,index);
    }
    public double getAverageExamScore(){
        double sum = 0;
        int count = 0;
        for (Student a: students){
            if (a != null){
                sum += a.getAverageExamScore();
                count++;
            }
        }
        if (count == 0){
            return 0;
        }
        return sum/count;
    }
    public void addStudent(Student student){
        for (int i = 0; i < maxNumberOfStudents; i++){
            if (students[i] == null){
                students[i] = student;
                break;
            }
        }
    }
    public void removeStudent(String firstName, String lastName){
        for (int i = 0; i < students.length; i++){
            if (students[i] != null && students[i].getFirstName().equals(firstName) && students[i].getLastName().equals(lastName)){
                students[i] = null;
                for (int j = 0; j < students.length - 1; j++){
                    if (students[j + 1] != null){
                        students[j] = students[j + 1];
                        students[j + 1] = null;
                    }
                }
                break;
            }
        }
    }
    public Student[] getStudentsByScore() {
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getAverageExamScore(), s1.getAverageExamScore());
            }
        });

        return students;
    }

    public Map<Student, String> getGradeBook() {
        // Create a map to hold the Student objects and their corresponding grades
        Map<Student, String> gradeBook = new HashMap<>();

        // Sort the students by average exam score
        Student[] sortedStudents = getStudentsByScore();

        // Define the cutoff scores for each letter grade
        double aCutoff = 90.0;
        double bCutoff = 80.0;
        double cCutoff = 70.0;
        double dCutoff = 60.0;

        // Assign a letter grade to each student based on their class average
        for (Student student : sortedStudents) {
            double classAverage = student.getAverageExamScore();
            String grade = "";
            if (classAverage >= aCutoff) {
                grade = "A";
            } else if (classAverage >= bCutoff) {
                grade = "B";
            } else if (classAverage >= cCutoff) {
                grade = "C";
            } else if (classAverage >= dCutoff) {
                grade = "D";
            } else {
                grade = "F";
            }
            gradeBook.put(student, grade);
        }

        return gradeBook;
    }


                private double calculatePercentile(Student[] sortedStudents, double percentile) {
        int count = 0;
        int total = 0;
        for (Student student : sortedStudents) {
            if (student != null) {
                total++;
                if (student.getAverageExamScore() <= percentile) {
                    count++;
                }
            }
        }
        return (double) count / total * 100;
    }


}
