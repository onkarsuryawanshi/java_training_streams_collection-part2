package collectionPart2.mapper;

import collectionPart2.model.Employee;
import collectionPart2.model.Student;

public class EmployeeMapper implements CSVToPojoMapper{

    @Override
    public Object map(String[] values) {

        if (values == null || values.length!=4) {
            throw new RuntimeException("Invalid input values");
        }
        Integer employeeId = null;
        String employeeName = null;
        String employeeDepartment = null;
        Integer employeeSalary = null;
        try {
            employeeId = Integer.parseInt(values[0].trim());

        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid employee Id ", e);
        }
        ;
        employeeName = values[1].trim();
        employeeDepartment = values[2].trim();
        try {
            employeeSalary  = Integer.parseInt(values[3].trim());

        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid employee salary Id ", e);
        }
        Employee employee = new Employee(employeeId,employeeName,employeeDepartment,employeeSalary);
        return employee;
    }

}
