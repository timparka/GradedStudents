package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Student implements Comparable<Student>{
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;
    private int examNumber;
    private double newScore;

    public Student(String firstName, String lastName, Double[] testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        examScores = new ArrayList<>(Arrays.asList(testScores)); //Student Constructor
    }
    public void setFirstName(String firstName){

        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setExamScores(int examNumber, double newScore) {
        examScores.set(examNumber - 1, newScore);
    }

    public String getExamScores() {
        StringBuilder sb = new StringBuilder();
        sb.append("Exam Scores:\n");
        for (int i = 0; i < examScores.size(); i++){ //looping thru examscores array getting each index
            sb.append("Exam " + (i + 1) + " -> " + examScores.get(i) + "\n");
        }
        return sb.toString();
    }
    public void addExamScore(double examScore){

        this.examScores.add(examScore);//adding examScore to array using .add method of java class
    }
    public double getAverageExamScore(){
        double average = 0;
        for (int i = 0; i < examScores.size(); i++){
            average += examScores.get(i);
        }
        average /= examScores.size();
        return average;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Student Name: " + firstName + " " + lastName + "\n");
        sb.append("> Average Score: " + getAverageExamScore() + "\n");
        sb.append("> Exam Scores:\n");
        for (int i = 0; i < examScores.size(); i++) {
            sb.append("Exam " + (i + 1) + " -> " + examScores.get(i) + "\n");
        }
        return sb.toString();
    }
    @Override
    public int compareTo(Student student) {
        if (this.getAverageExamScore() < student.getAverageExamScore()){
            return 1;
        } else if (this.getAverageExamScore() > student.getAverageExamScore()) {
            return -1;
        } else if (this.getFirstName().charAt(0) < student.getFirstName().charAt(0)){
            return 1;
        } else {
            return -1;
        }

    }
}
