package University;

public class Faculty extends UEmployee {
    
    private String department;

    public Faculty(String name, double salary) {
        super(name, salary);
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return(department);
    }

    public String toString() {
        return(super.getName() + " is a faculty in " + department  +  " and makes " + super.getSalary());
    }

}
