
public class My_Second_class {
    public static void main(String[] args) {

          //Student Area
        Student std1 = new Student("Ahmed", 19, "Hehya-Elsharqya", "egyption", 7, "16", 4.5f);
        System.out.println(std1.get_address());
        System.out.println(std1.get_study_Level());

        //Employee Area
        Employee emp1 = new Employee();   
        emp1.print_data();

        //salaried_Employee Area
        salaried_Employee sa1 = new salaried_Employee();  
        System.out.println(sa1.get_salary());

      

    }
    

}
