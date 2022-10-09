package collectionPart2;

import collectionPart2.mapper.EmployeeMapper;
import collectionPart2.model.Employee;
import collectionPart2.parser.InputParser;
import collectionPart2.services.EmployeeService;


import java.util.List;
import java.util.Map;

public class EmployeeServiceTest {
    public static void main(String[] args) {
        String[] employeeInfo = {
                "22, Rajan Anand, Engineering, 1600000",
                "23, Swati Patil, Testing, 800000",
                "27, Vijay Chawda, Engineering, 800000",
                "29, Basant Mahapatra, Engineering, 600000",
                "32, Ajay Patel, Testing, 350000",
                "34, Swaraj Birla, Testing, 350000"
        };


        EmployeeMapper mapper = new EmployeeMapper();
        List<Employee> employees;
        InputParser parser = new InputParser<>(mapper);
        employees = parser.parseArray(employeeInfo);


        EmployeeService service = new EmployeeService(employees);

        System.out.println(" --- Employee Department ==> employee Id ");
        Map<String,Employee> highestPaidEmployee = service.employeeIdsOfHighestPaidInDepartment();

        highestPaidEmployee.entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() + "==>" + e.getValue().getEmployeeId()));
    }
}
