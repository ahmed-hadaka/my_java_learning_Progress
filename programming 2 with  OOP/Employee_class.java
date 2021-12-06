public class Employee_class {
    private int Emp_ID;
    private String Name;
    private String  Depart;
    private double Salary;
    private double Bonus;
    private boolean Resident;
    private static int num_of_objects;
public Employee_class(){           //constructor 1 with overloading
    Emp_ID=100;
    Name="Ahmed";
    Depart="not assigned";
    Salary=5000;
    Bonus=600;
    Resident = true;
    num_of_objects++;
}

public Employee_class(int id, String n) {      //constructor 2 with overloading
    Emp_ID = id;
    Name = n;
    num_of_objects++;
}

public Employee_class(int id, String n, boolean res) {         //constructor 3 with overloading and constructor chaining
    this(id, n);  
    Resident = res;
    num_of_objects++;
}

public Employee_class(int id, String n, String dep, double s, double b, boolean res) {       //constructor 4 with overloading and constructor chaining
    this(id, n, res);
    Depart = dep;
    Salary = s;
    Bonus = b;
    num_of_objects++;
}

public static int get_num_of_objects() {    //static method
    return num_of_objects;
}


public void set_salary(double s){          //method with overloading
    Salary = s;
}  

public void set_salary(double s, double b) {         //method with overloading
    this.set_salary(s);
    Bonus = b;
}

public void set_depart(String d) {
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
