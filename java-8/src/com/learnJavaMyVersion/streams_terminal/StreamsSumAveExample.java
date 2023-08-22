package com.learnJavaMyVersion.streams_terminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.stream.Collectors;

public class StreamsSumAveExample {
    public static int sum(){
       return  StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.summingInt(Student::getNoteBooks));
    }
    public static double average(){
        return  StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.averagingInt(Student::getNoteBooks));
    }
    public static void main(String[] args) {
        System.out.println("Sum of Student Notebooks : "+ sum());
        System.out.println("Average no of Notebooks: "+ average());
    }
}
