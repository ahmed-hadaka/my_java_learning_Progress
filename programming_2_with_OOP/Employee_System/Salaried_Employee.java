public class Salaried_Employee extends Employee implements Displayable {
    private double salary;
    private double bonus;
    private double deductions;

    public Salaried_Employee() {

    }

    public Salaried_Employee(double salary, double bonus, double deductions, String name, int ssn, String address,
            Gender sex) {
        super(name, ssn, address, sex);
        this.salary = salary;
        this.bonus = bonus;
        this.deductions = deductions;
    }

    @Override
    public String displayDetails() {
        return "salary:" + salary + "\nBonus:" + bonus + "\nDeductions:" + deductions;
    }

    // overriding abstract method in Employee class
    @Override
    public double erning() {
        return (salary + bonus) - deductions;
    }

    public void displayAllDetails() {
        System.out.println(super.displayDetails());
        System.out.println(this.displayDetails());
    }

    public void displayEarning() {
        System.out.println(erning());
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setDeductions(Double deductions) {
        this.deductions = deductions;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

}
