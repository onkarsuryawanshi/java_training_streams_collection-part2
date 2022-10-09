package collectionPart2.services;

import collectionPart2.model.Student;

import java.util.List;
import java.util.NoSuchElementException;

public class StudentService {
    public List<Student> students;

    public StudentService(List<Student> students) {
        this.students = students;
    }

    public Double averageMarksForStudentHavingLowestId() {
        try {
            Integer lowestId = getLowestId(students);
            Double averageMarks = getAverageMarks(lowestId, students);
            return averageMarks;
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private Double getAverageMarks(Integer id, List<Student> students) {
        Double averageMarks = students.stream()
                .filter(student -> student.getStudentId() == id)
                .mapToInt(student -> student.getStudentMarks())
                .average()
                .orElseThrow(NoSuchElementException::new);
        return averageMarks;
    }

    private Integer getLowestId(List<Student> students) {
        Integer lowestId = students.stream()
                .mapToInt(student -> student.getStudentId())
                .min()
                .orElseThrow(NoSuchElementException::new);
        return lowestId;
    }
}
