public class Commission_Employee extends Employee implements Displayable {
    double grossSales;
    double commissionRate;

    public Commission_Employee() {

    }

    public Commission_Employee(double grossSales, double commissionRate, String name, int ssn, String address,
            Gender sex) {
        super(name, ssn, address, sex);
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    @Override
    public double erning() {
        return grossSales * commissionRate;
    }

    @Override
    public String displayDetails() {
        return "Gross Sales:" + grossSales + "\nCommission Rate:" + commissionRate;
    }

    public void displayAllDetails() {
        System.out.println(super.displayDetails());
        System.out.println(this.displayDetails());
    }

    public void displayEarning() {
        System.out.println(erning());
    }

    public void setGrossSales(Double grossSales) {
        this.grossSales = grossSales;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setCommissionRate(Double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

}
