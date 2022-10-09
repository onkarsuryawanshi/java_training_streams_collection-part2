package collectionPart2.services;
import collectionPart2.model.Employee;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class EmployeeService {

    public List<Employee> employees;

    public EmployeeService(List<Employee> employees) {
        this.employees = employees;
    }

    public Map<String, Employee> employeeIdsOfHighestPaidInDepartment() {
        Map<String, Employee> employeeIdHighestPaidInDept = getIdOfHighestPaidInDept();

        return employeeIdHighestPaidInDept;
    }
    private Map<String, Employee> getIdOfHighestPaidInDept() {
        Map<String, Employee> highestPaidEmployeeId =
                employees
                        .stream()
                        .collect(groupingBy(
                                emp->emp.getEmployeeDepartment(),
                                collectingAndThen(maxBy(comparingInt(e -> e.getEmployeeSalary())), Optional::get)
                        ));
        return highestPaidEmployeeId;
    }

}
