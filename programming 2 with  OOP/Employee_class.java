public class Employee_class {
    private int Emp_ID;
    private String Name;
    private String  Depart;
    private double Salary;
    private double Bonus;
    private boolean Resident;
public Employee_class(){
    Emp_ID=100;
    Name="Ahmed";
    Depart="not assigned";
    Salary=5000;
    Bonus=600;
    Resident=true;
}

public Employee_class(int id, String n) {
    Emp_ID = id;
    Name = n;
}

public Employee_class(int id, String n, boolean res) {
    this(id, n);
    Resident = res;
}

public Employee_class(int id, String n, String dep, double s, double b, boolean res) {
    this(id, n, res);
    Depart = dep;
    Salary = s;
    Bonus = b;
}
public void set_salary(double s){
    Salary = s;
}  

public void set_salary(double s, double b) {
    this.set_salary(s);
    Bonus = b;
}

public void depart(String d) {
    Depart=d;
}

public void set_Emp_ID(int id) {
    Emp_ID = id;
}

public void print_Emp_data() {
    System.out.println("the employee ID is :" + Emp_ID);
    System.out.println("the employee name is :" + Name);
    System.out.println("the employee department is :" + Depart);
    System.out.println("the employee salary is :" + Salary);
    System.out.println("the employee bonus is :" + Bonus);
    System.out.println("the employee resident is :"+Resident);
}

}
