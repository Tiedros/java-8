package com.learnJavaMyVersion.streams_terminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.*;
import java.util.stream.Collectors;

public class StreamGroupByExample {
    public static Map<String, List<Student>> groupStudentsByGender(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGender));
    }
    public static Map<String, List<Student>> customizedGroupingBy(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING":"AVERAGE"));
    }

    public static Map<Integer, Map<String, List<Student>>> twoLevelGrouping_1(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING":"AVERAGE")));
    }
    public static Map<Integer, Integer> twoLevelGrouping_2(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.summingInt(Student::getNoteBooks)));
    }
    public static LinkedHashMap<String, Set<Student>> threeArgumentGroupBy(){
      return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getName,
                        LinkedHashMap::new,
                        Collectors.toSet()));
    }
    public static Map<Integer, Optional<Student>> caluclateTopGpa(){
       return  StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.maxBy(Comparator.comparing(Student::getGpa))));
    }
    public static Map<Integer, Student> caluclateLeastGpa(){
        return  StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Student::getGpa)),
                        Optional::get)));
    }

    public static void main(String[] args) {

       // System.out.println(groupStudentsByGender());
        //System.out.println(customizedGroupingBy());
       // System.out.println(twoLevelGrouping_1());
        //System.out.println(twoLevelGrouping_2());
        System.out.println(threeArgumentGroupBy());
        System.out.println(caluclateTopGpa());
        System.out.println(caluclateLeastGpa());
    }
}
