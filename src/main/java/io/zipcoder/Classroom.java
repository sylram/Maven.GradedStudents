package io.zipcoder;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;



import java.util.*;
import java.util.stream.Stream;

public class Classroom {

    int maxNumberOfStudents;
    Student[] students;
    private Object Student;

    public Classroom() {
        this.students = new Student[30];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }


    public Student[] getStudents() {
        return students;
    }

    public Double getAverageExamScore() {
        Double total = 0.0;
        for (Student s : students) {
            total += s.getAverageExamScore();
        }
        return total / students.length;
    }

    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
            }
        }
    }


    public String toString() {
        String room = "[";
        for (Student s : students) {
            if (s == null) {
                room += "]";
            }
            room += s.toString() + "]";
        }
        return room;
    }

    public Student[] removeStudent(String firstName, String lastName) {
        for (int i = 0; i < students.length - 1; i++) {
            if (students[i].getFirstName().equals(firstName) && students[i].getLastName().equals(lastName)) {
                students[i] = null;
            }
        }
        Arrays.sort(students, Comparator.nullsLast(Comparator.naturalOrder()));
        return students;
    }

    public Student[] getStudentsByScore(Comparator<Student> comparator) {

        Arrays.sort(students, comparator);
        return students;
    }

    public Double[] getGrades() {

        Double[] scores = new Double[students.length];
        for (int i = 0; i < students.length; i++) {
            scores[i] = students[i].getAverageExamScore();
        }
        Arrays.sort(scores);
        return scores;
    }


    public Map getGradeBook(Student[] students) {
        double percentile = 0;
        String grade = "";
        HashMap<String, ArrayList<Student>> book = new HashMap<>();
        students = getStudentsByScore(new ScoreComparator());
        ArrayList<Student> studentList = new ArrayList<>();
        Double[] studentsGrade = getGrades();
        for (int i = 0; i < students.length; i++) {
            percentile = 100 * ((i + 1) / (double) (students.length));

            assignGrade(book, students[students.length - i - 1], percentile);

        }
        return book;
    }


    public void assignGrade(HashMap<String, ArrayList<Student>> book, Student student, double percentile) {


        String grade = "";

        if (percentile < 11) {
            grade = "F"; }
        if (percentile <= 51) {
            grade = "D";
        } else if (percentile <= 71) {
            grade = "C";
        } else if (percentile <= 89) {
            grade = "B";
        } else {
            grade = "A";
        }
        ArrayList<Student> students = book.getOrDefault(grade, new ArrayList<Student>());
        students.add(student);
        book.put(grade, students);

    }


}

