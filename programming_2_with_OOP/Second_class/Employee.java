/***********************************************************************
 * Employee.java
 * Ahmed hadaka
 * 
 * this program store the employee's data
 **********************************************************************************/

public  class  Employee extends Persone {
     double salary;
     int Rank;
     String job;
     static int num_of_objects;
public Employee(){           //constructor 1 with overloading
    salary = 5000;
    Rank = 4;
    job = "accountent";
    num_of_objects++;
}




public Employee(  String name,int age,String address,String nationality, double salary,int Rank,String job) {   //constructor 2 with overloading
    super(name, age, address, nationality);
    this.salary = salary;
    this.Rank = Rank;
    this.job = job;

}

public static int get_num_of_objects() {    //static method
    return num_of_objects;
}


public void set_salary(double s) {
    salary = s;
}

public double get_salary() {
    return salary;
}
  

public void set_Rank( int R) { 
    Rank=R;
}

public void set_job(String J) { 
    job = J;
}

@Override
public  void print_data() {    //Overriding method
    super.print_data();
    System.out.println("the employee salary is :" + salary);
    System.out.println("the employee Rank is :" + Rank);
    System.out.println("the employee job is :"+job);


}

}
