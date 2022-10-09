package collectionPart2;

import collectionPart2.mapper.StudentMapper;
import collectionPart2.model.Student;
import collectionPart2.parser.InputParser;
import collectionPart2.services.StudentService;

import java.util.List;

public class StudentServiceTest {
    public static void main(String[] args) {
        String[] studentInformation = {
                "22, Data Structures, 45",
                "23, English, 52",
                "22, English, 51",
                "26, Data Structures, 72",
                "23, Data Structures, 61",
                "24, English, 81"
        };
        StudentMapper mapper = new StudentMapper();
        List<Student> students;
        InputParser parser = new InputParser<>(mapper);
        students = parser.parseArray(studentInformation);


        StudentService service = new StudentService(students);
        Double averageMarks = service.averageMarksForStudentHavingLowestId();

        System.out.println("  ---- students list --- ");
        students.stream().forEach(System.out::println);

        System.out.print("average marks for the student of lowest ID :: ");
        System.out.println(averageMarks);
    }
}
