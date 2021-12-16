public class salaried_Employee extends Employee {
    private double Bonus;
    private double Deductions;

    public salaried_Employee() {
        Bonus=300;
    Deductions=100;
    }

    public salaried_Employee(String name, int age, String address, String nationality, double salary, int Rank,
            String job, double Bonus, double Deductions) {
        super(name, age, address, nationality, salary, Rank, job);
        this.Bonus = Bonus;
        this.Deductions = Deductions;
    }
@Override
public double get_salary() { //method with overriding
    return (salary + Bonus - Deductions);
}
    
    }

