package com.learnJavaMyVersion.streams_terminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsMappingExample {
    public static void main(String[] args) {
        List<String> studentsList = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.mapping(Student::getName,Collectors.toList()));
        Set<String> studentsSet = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.mapping(Student::getName,Collectors.toSet()));
        System.out.println(" Students Name List   : "+ studentsList);

        System.out.println(" Students Name Set   : "+ studentsSet);
    }
}
