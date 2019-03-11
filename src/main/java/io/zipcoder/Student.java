package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student implements Comparable<Student> {
    String firstName;
    String lastName;
    ArrayList<Double> examScores;


    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.examScores = new ArrayList<Double>(Arrays.asList(testScores));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Method to get the lastName
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumberOfExamsTaken() {
        return examScores.size();
    }


    public String getExamScores() {
        String scores = "Exam Scores:" + "\n";
        int counter = 1;
        for (int i = 0; i < examScores.size(); i++) {
            scores += "Exam " + counter + " -> " + examScores.get(i).intValue();

            if(counter<examScores.size()) {
                scores+= "\n";
            }
            counter++;
        }
        return scores;
    }


    public void addExamScore(Double score) {
        examScores.add(score);
    }

    public void setExamScore(int examNumber, Double score) {
        examScores.set(examNumber,score);

    }

    public Double getAverageExamScore() {
        Double sum = 0.0;
        for(Double score: examScores){
            sum +=score;
        }return sum/getNumberOfExamsTaken();
    }

    @Override
    public String toString() {
        return
                "Student Name: " + firstName +" "+lastName+"\n"+
                "> Average Score: " + getAverageExamScore().intValue() + "\n" +
                "> "+getExamScores();

    }

    @Override
    public int compareTo(Student o) {
        return o.getFirstName().compareTo(this.getFirstName());
    }




}

