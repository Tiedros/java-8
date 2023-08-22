package com.learnJavaMyVersion.parallelstreams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamExample1 {

    public static List<String> sequentialPrintStudentActivities(){
        long startTime = System.currentTimeMillis();

        List<String> studentActivities=  StudentDataBase.getAllStudents().stream()  // Stream<Student>
                .map(Student::getActivities) //Stream<List<String>>
                .flatMap(List::stream) //Stream<String>
                .distinct() // removes duplicate
                .sorted() // sort them
                .collect(Collectors.toList());

        long endTime = System.currentTimeMillis();
        System.out.println("Duration to execute the pipline in sequential: "+ (endTime - startTime));
        return studentActivities;
    }

    public static List<String> parallelPrintStudentActivities(){

        long startTime = System.currentTimeMillis();
        List<String> studentActivities =  StudentDataBase.getAllStudents().stream()  // Stream<Student>
                .parallel()
                .map(Student::getActivities) //Stream<List<String>>
                .flatMap(List::stream) //Stream<String>
                .distinct() // removes duplicate
                .sorted() // sort them
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Duration to execute the pipline in parallel: "+ (endTime - startTime));
        return studentActivities;
    }
    public static void main(String[] args) {
        sequentialPrintStudentActivities();
        parallelPrintStudentActivities();

    }
}
