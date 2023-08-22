package com.learnJavaMyVersion.streams_terminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsPartitioningByExample {
    public static Map<Boolean, List<Student>> partitioningBy_1(){
        Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.8;
      return   StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(gpaPredicate));
    }
    public static Map<Boolean, Set<Student>> partitioningBy_2(){
        Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.8;
        return   StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(gpaPredicate,Collectors.toSet()));
    }
    public static void main(String[] args) {
        System.out.println("PartitioningMap_1 : "+ partitioningBy_1());
        System.out.println("PartitioningMap_2 : "+ partitioningBy_2());


    }
}
