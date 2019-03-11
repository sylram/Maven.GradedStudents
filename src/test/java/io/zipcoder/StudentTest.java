package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {





    @Test
    public void getFirstName(){
        //Given
        String givenName = "First Name";
        String givenLastName = "Last Name";
        Double[] givenScore = {100.0};
        Student student = new Student(givenName,givenLastName,givenScore);


        //When
        String expectedFirstName = student.getFirstName();
        String expectedLastName = student.getLastName();


        //Then
        Assert.assertEquals(givenName,expectedFirstName);
        Assert.assertEquals(givenLastName,expectedLastName);
    }
    @Test
    public void setName(){
        //Given
        String givenName = "Bella";
        String givenLastName = "Anderson";
        Double[] givenScore = {100.0};
        Student student = new Student(null,null,givenScore);
        student.setLastName(givenLastName);
        student.setFirstName(givenName);

        //When
        String expectedName = student.getFirstName();
        String expectedLastN = student.getLastName();


        //Then
        Assert.assertEquals(givenName,expectedName);
        Assert.assertEquals(givenLastName,expectedLastN);

    }
    @Test
    public void getExamScoresTest(){
        //Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Integer expected =4;
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        String output = "Exam Scores:\nExam 1 -> 100\nExam 2 -> 95\nExam 3 -> 123\nExam 4 -> 96";
        String actual= student.getExamScores();
        Integer actualNumberOfExams = student.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(output,actual);
        Assert.assertEquals(expected,actualNumberOfExams);

    }
    @Test
    public void addExamScoreTest(){
        //Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {};
        Student student = new Student(firstName, lastName, examScores);
        String expected = "Exam Scores:\nExam 1 -> 100";

        // When
        student.addExamScore(100.0);
        String output = student.getExamScores();

        // Then
        Assert.assertEquals(output,expected);
    }
    @Test
    public void setExamScoreTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0 };
        Student student1 = new Student(firstName, lastName, examScores);
        String expected = "Exam Scores:\nExam 1 -> 150";

        // When
        student1.setExamScore(0, 150.0);
        String output = student1.getExamScores();
        student1.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(expected,output);

    }

    @Test
    public void getAverageExamScoreTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";

        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student(firstName, lastName, examScores);
        Double expected = 125.0;

        // When
        Double output = student.getAverageExamScore();

        // Then
        Assert.assertEquals(expected,output);
    }
    @Test
            public void toStringTest(){
    // : Given
    String firstName = "Leon";
    String lastName = "Hunter";
    Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
    Student student = new Student(firstName, lastName, examScores);
    String expected = "Student Name: Leon Hunter\n> Average Score: 125\n" +
            "> Exam Scores:\nExam 1 -> 100\nExam 2 -> 150\nExam 3 -> 250\nExam 4 -> 0";

    // When
    String  output = student.toString();

    // Then
    Assert.assertEquals(output,expected);
    }

}