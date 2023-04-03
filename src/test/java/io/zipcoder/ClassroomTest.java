package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ClassroomTest {

    @Test
    public void testGetAverageExamScore(){
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double output = classroom.getAverageExamScore();

        // Then
        System.out.println(output);
    }

    @Test
    public void testAddStudent(){
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
    }
    @Test
    public void testRemoveStudent() {
        // Given
        int maxNumberOfStudents = 2;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student("Leon", "Hunter", examScores);
        classroom.addStudent(student);
        Double[] examScoresa = {300.0, 150.0, 250.0, 100.0};
        Student studenta = new Student("Tim", "Park", examScoresa);
        classroom.addStudent(studenta);

        // When
        classroom.removeStudent("Leon", "Hunter");
        Student[] postRemove = classroom.getStudents();

        // Then
        assertEquals(1, postRemove.length);
        assertEquals(studenta, postRemove[0]);
    }
    @Test
    public void testGetStudentsByScore(){
        // Given
        Double[] examScores1 = { 200.0, 200.0, 200.0, 200.0 };
        Double[] examScores2 = { 100.0, 100.0, 100.0, 100.0 };
        Double[] examScores3 = { 300.0, 300.0, 300.0, 300.0 };

        Student student1 = new Student("", "", examScores1);
        Student student2 = new Student("", "", examScores2);
        Student student3 = new Student("", "", examScores3);

        Student[] expectedBeforeSort = {student1,student2,student3};
        Student[] expectedAfterSort = {student3,student1,student2};

        // When
        Classroom classroom = new Classroom(new Student[]{student1,student2,student3});

        Student[] actualBeforeSort = classroom.getStudents();
        assertEquals(expectedBeforeSort,actualBeforeSort);

        classroom.getStudentsByScore();
        Student[] actualAfterSort = classroom.getStudents();

        // Then
        assertEquals(expectedAfterSort,actualAfterSort);
    }

    @Test
    public void testGetGradeBook() {
        Classroom classroom = new Classroom(5);

        Student student1 = new Student("Alice", "Smith", new Double[]{95.0, 90.0});
        Student student2 = new Student("Bob", "Johnson", new Double[]{85.0, 80.0});
        Student student3 = new Student("Charlie", "Williams", new Double[]{75.0, 70.0});
        Student student4 = new Student("Diana", "Brown", new Double[]{65.0, 60.0});
        Student student5 = new Student("Eva", "Jones", new Double[]{55.0, 50.0});

        classroom.addStudent(student1);
        classroom.addStudent(student2);
        classroom.addStudent(student3);
        classroom.addStudent(student4);
        classroom.addStudent(student5);

        Map<Student, String> gradeBook = classroom.getGradeBook();

        assertEquals("A", gradeBook.get(student1));
        assertEquals("B", gradeBook.get(student2));
        assertEquals("C", gradeBook.get(student3));
        assertEquals("D", gradeBook.get(student4));
        assertEquals("F", gradeBook.get(student5));
    }
}

