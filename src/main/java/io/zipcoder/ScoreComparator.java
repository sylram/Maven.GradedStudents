package io.zipcoder;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {

        int byScore =s2.getAverageExamScore().compareTo(s1.getAverageExamScore());
        int byName = s2.compareTo(s1);
        if(byScore==0){
          return byName;
        }


        return byScore;
    }
}
