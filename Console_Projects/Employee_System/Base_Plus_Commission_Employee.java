public class Base_Plus_Commission_Employee extends Commission_Employee {
    double base;

    public Base_Plus_Commission_Employee() {

    };

    public Base_Plus_Commission_Employee(double grossSales, double commissionRate, double base, String name, int ssn,
            String address, Gender sex) {
        super(grossSales, commissionRate, name, ssn, address, sex);
        this.base = base;
    }

    @Override
    public double erning() {
        return base + super.erning();
    }

    @Override
    public String displayDetails() {
        return "The Base: " + base;
    }

    @Override
    public void displayAllDetails() {
        System.out.println(super.displayDetails());
        System.out.println(this.displayDetails());
    }

    public void displayEarning() {
        System.out.println(erning());
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public double getBase() {
        return base;
    }

}