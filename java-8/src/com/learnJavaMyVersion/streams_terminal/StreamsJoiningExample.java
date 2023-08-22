package com.learnJavaMyVersion.streams_terminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.stream.Collectors;

public class StreamsJoiningExample {

    public static String joining_1(){
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining());

    }
    public static String joining_2(){
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining(", "));

    }
    public static String joining_3(){
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining(", ","(",")"));

    }
    public static void main(String[] args) {
        System.out.println("Joining_1 : " +joining_1());
        System.out.println("Joining_2 : "+ joining_2());
        System.out.println("Joining_3 : "+joining_3());

    }
}
