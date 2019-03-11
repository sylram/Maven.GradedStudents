package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class ClassroomTest {

    @Test
    public void getStudentsTest(){
        //Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        //When
        Student[] actual = classroom.getStudents();
        //Then
        Assert.assertEquals(students,actual);
    }

    @Test
    public void getAverageExamScoreTest(){
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };
        Double expected = 125.0;
        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        Double output = classroom.getAverageExamScore();

        // Then
        Assert.assertEquals(expected,output);

    }
    @Test
    public void addStudentTest(){

        //Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);
//        Student[] expected = {student};
//        String preEnrollmentAsString = "[]";
        String postEnrollmentAsString = "[Student Name: Leon Hunter\n> Average Score: 125\n" +
                "> Exam Scores:\nExam 1 -> 100\nExam 2 -> 150\nExam 3 -> 250\nExam 4 -> 0]";

        // When
//        Student[] preEnrollment = classroom.getStudents();
//        String actualPre= classroom.toString();
        classroom.addStudent(student);
        String actual= classroom.toString();
       // String actualPost=classroom.toString();

        // Then
        Assert.assertEquals(postEnrollmentAsString,actual);

    }

    @Test
    public void removeStudentTest(){
        //Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };
        String firstName = "student";
        String lastName = "one";
        Student s1 = new Student(firstName,lastName, s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student[] students = {s1,s2};
        Student[] expectedArray ={s2,null};
        Classroom classroom = new Classroom(students);

        //When
        Student[] actual = classroom.removeStudent(firstName,lastName);

        //Then

        Assert.assertEquals(expectedArray,actual);
    }

    @Test
    public void getStudentsByScoreTest1(){
        //Given
        Double[] s1Scores = { 95.0, 100.0 };
        Double[] s2Scores = { 100.0, 100.0 };
        Student s1 = new Student("student","one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);
        Student[] expected = {s2,s1};

        //When
        ScoreComparator comparator = new ScoreComparator();
        Student[] actual = classroom.getStudentsByScore(comparator);

        //Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void getStudentsByScoreTest2(){
        //Given
        Double[] s1Scores = { 95.0, 100.0 };
        Double[] s2Scores = { 100.0, 100.0 };
        Double[] s3Scores = {100.0,100.0};
        Student s1 = new Student("student","one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("Lucas", "three", s3Scores);
        Student[] expected = {s3,s2,s1};

        Student[] students = {s1,s2,s3};
        Classroom classroom = new Classroom(students);


        //When
        ScoreComparator comparator = new ScoreComparator();
        Student[] actual = classroom.getStudentsByScore(comparator);

        //Then
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void getGradedBookTest(){
        //Given
        Double[] s1Scores = { 95.0 };
        Double[] s2Scores = { 100.0};
        Double[] s3Scores = {87.0};
        Double[] s4Scores = { 40.0 };
        Double[] s5Scores = { 70.0};
        Double[] s6Scores = {37.0};
        Double[] s7Scores ={60.0};
        Student s1 = new Student("student1","one", s1Scores);
        Student s2 = new Student("student2", "two", s2Scores);
        Student s3 = new Student("Lucas", "three", s3Scores);
        Student s4 = new Student("student4","one", s4Scores);
        Student s5 = new Student("student5", "two", s5Scores);
        Student s6 = new Student("Lucas", "three", s6Scores);
        Student s7 = new Student("Lala", "three", s7Scores);
        Student[] students = {s1,s2,s3,s4,s5,s6,s7};
        Classroom classroom = new Classroom(students);
        Double[] expected = {37.0,40.0,60.0,70.0,87.0,95.0,100.0};
        //When
        Double[] actual =classroom.getGrades();
        Map<String, ArrayList<Student>> map = classroom.getGradeBook(students);
        Boolean actual2 = map.containsKey("A");


        //Then
        Assert.assertEquals(expected,actual);
        Assert.assertTrue(actual2);

    }


}
