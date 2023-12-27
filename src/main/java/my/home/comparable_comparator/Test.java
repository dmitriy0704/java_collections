package my.home.comparable_comparator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

//   https://javarush.com/groups/posts/6459-kofe-breyk-253-v-chem-razlichie-mezhdu-comparable-i-comparator-chto-takoe-varargs-peremennihe-a
    public static void main(String[] args) {

        //Comparable:
//        Student student = new Student(1, "John Doe", "Java");
//        Student student2 = new Student(2, "Jane Doe", "Java");
//        Student student3 = new Student(3, "Mile", "Java");
//        List<Student> students = Arrays.asList(student, student2, student3);
//        System.out.println(students);
//        Collections.sort(students);
//        System.out.println(students);

        // Comparator:
        Student student = new Student(1, "Jane", "Java");
        Student student2 = new Student(2, "John", "React");
        Student student3 = new Student(3, "Mike", "BA");
        List<Student> students = Arrays.asList(student, student2, student3);
//        List<Student> students = List.of(student, student2, student3);
        System.out.println(students);

        Collections.sort(students, new StudentDeptComparator());
        System.out.println(students);

        Collections.sort(students, new StudentNameComparator());
        System.out.println(students);

        // сортируем список по имени и названию кафедры
        Collections.sort(students, new StudentNameComparator().thenComparing(new StudentDeptComparator()));
        System.out.println(students);

        // Лямбда
        Collections.sort(
                students,
                (s1, s2) -> s1.getDepartment().compareTo(s2.getDepartment())
        );
    }
}

//Comparable:
@Data
@AllArgsConstructor
@NoArgsConstructor
class Student implements Comparable<Student> {
    private Integer id;
    private String name;
    private String department;

    @Override
    public int compareTo(Student student) {
        return this.name.compareTo(student.name);
    }
}

//Comparator:
class StudentDeptComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getDepartment().compareTo(s2.getDepartment());
    }
}

class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}