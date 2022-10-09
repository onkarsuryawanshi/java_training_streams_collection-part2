package collectionPart2.model;
public class Employee {
    private Integer employeeId;
    private String employeeName;
    private String employeeDepartment;
    private Integer employeeSalary;


    public Employee(Integer employeeId, String employeeName, String employeeDepartment, Integer employeeSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
        this.employeeSalary = employeeSalary;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public Integer getEmployeeSalary() {
        return employeeSalary;
    }
}
