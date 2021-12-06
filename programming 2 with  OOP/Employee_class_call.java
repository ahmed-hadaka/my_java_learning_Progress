public class Employee_class_call {
  public static void main(String[] args) {
    Employee_class Emp1 = new Employee_class();
    Employee_class Emp2 = new Employee_class();
    Employee_class Emp3 = new Employee_class();

    Emp1.set_salary(13000);
    Emp1.print_Emp_data();
    System.out.println(Employee_class.get_num_of_objects());  //calling static method
    // System.out.println(Emp1.get_num_of_objects());
   
    }
    
}
