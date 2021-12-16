
public class My_First_class {
  public static void main(String[] args) {
    // Employee Emp1 = new Employee();     //-----Objects & calls (belonges to Employee)-----
    // Employee Emp2 = new Employee();
    // Employee Emp3 = new Employee();

    // Emp1.set_salary(13000);
    // Emp1.print_Emp_data();
    // System.out.println(Employee.get_num_of_objects());  //calling static method


  //   Rectangle r1 = new Rectangle();        //-----Objects & calls (belonges to Rectangle)----
  //   //normal calling
  //  r1.setlength(18.4);
  //  r1.setwidth(39.32);
  //  System.out.println(r1.getarea());
  //  //calling with abstract 1
  //  Rectangle r2 = new Rectangle();
  //  System.out.println(r2.getarea());
  //  //calling with abstract 2
  //  Rectangle r3= new Rectangle(21.4, 9.0);
  //  System.out.println(r3.getarea());                                                   
                                                        

                                                        
passing_objects obj2 = new passing_objects();     //-----Objects & calls (belonges to passing_objects )----
passing_objects obj3 = new passing_objects();

System.out.println("the length after adding is :"+(obj2.add_objects(obj3).getlength()));      //adding objects
System.out.println("the width after adding is :"+(obj2.add_objects(obj3).getwidth()));
System.out.println("the area after adding is :"+(obj2.add_objects(obj3).getarea()));

passing_objects obj4 = new passing_objects(2.3,54.65);           //adding objects      
passing_objects obj5 = new passing_objects(14.0,87.7);
System.out.println("the length after adding is :"+(obj4.add_objects(obj5).getlength()));
System.out.println("the width after adding is :"+(obj4.add_objects(obj5).getwidth()));
System.out.println("the area after adding is :"+(obj4.add_objects(obj5).getarea()));

if(obj3.isequal(obj2))                   //comparing objects
    System.out.println("obj3 and obj2 are equal");
else
    System.out.println(" obj3 and obj2 aren't equal");

passing_objects obj6 = new passing_objects(obj5);      //copy object
  System.out.println(obj6.getarea());
                                                       

    }
    
}
