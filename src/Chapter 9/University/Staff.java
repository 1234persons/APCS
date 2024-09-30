package University;

public class Staff extends UEmployee{
    
    private String title;

    public Staff(String name, double salary) {
        super(name, salary);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return(title);
    }

    public String toString() {
        return(super.getName() + " is a staff in " + title  +  " and makes " + super.getSalary());
    }

}
