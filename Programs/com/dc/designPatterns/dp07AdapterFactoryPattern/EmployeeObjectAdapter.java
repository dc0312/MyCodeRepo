package Programs.com.dc.designPatterns.dp07AdapterFactoryPattern;

/**
 * An object adapter. Using composition to translate interface
 */
public class EmployeeObjectAdapter implements Customer{

    public Employee employee;

    EmployeeObjectAdapter(Employee employee){
        this.employee=employee;
    }

    @Override
    public String getName() {
        return employee.getFullName();
    }

    @Override
    public String getDesignation() {
        return employee.getJobTitle();
    }

    @Override
    public String getAddress() {
        return employee.getOfficeLocation();
    }

}
