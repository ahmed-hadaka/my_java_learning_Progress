import java.util.*;

public class Department {
    private int no_of_department;
    private String name_of_department;

    ArrayList<Employee> empList;

    public Department() {
        empList = new ArrayList<Employee>();

    }

    public Department(int no_of_department, String name_of_department) {
        this.no_of_department = no_of_department;
        this.name_of_department = name_of_department;

        empList = new ArrayList<Employee>();
    }

    public String getName_of_department() {
        return name_of_department;
    }

    public void setName_of_department(String name_of_department) {
        this.name_of_department = name_of_department;
    }

    public int getNo_of_department() {
        return no_of_department;
    }

    public void setNo_of_department(int no_of_department) {
        this.no_of_department = no_of_department;
    }

    public void add(Employee element) {
        empList.add(element);
    }

    public void getSize() {
        System.out.println(empList.size());
    }

    public void remove_Employee(Employee emp) {
        int index = empList.indexOf(emp);
        empList.remove(index);
    }

    public void displayDetails() {
        System.out.println("\nNo Of Department:" + no_of_department + "\nName Of Department:" + name_of_department);
    }

    public void displayAllDetails() {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i) instanceof Salaried_Employee) {
                this.displayDetails();
                ((Salaried_Employee) empList.get(i)).displayAllDetails();
            } else if (empList.get(i) instanceof Hourly_Employee) {
                this.displayDetails();
                ((Hourly_Employee) empList.get(i)).displayAllDetails();
            } else if (empList.get(i) instanceof Commission_Employee) {
                this.displayDetails();
                ((Commission_Employee) empList.get(i)).displayAllDetails();
            } else if (empList.get(i) instanceof Base_Plus_Commission_Employee) {
                this.displayDetails();
                ((Base_Plus_Commission_Employee) empList.get(i)).displayAllDetails();
            }
        }
    }

}
