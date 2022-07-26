public class Hourly_Employee extends Employee implements Displayable {
    private double hourRate;
    private int numOfHours;

    public Hourly_Employee() {
    };

    public Hourly_Employee(double hourRate, int numOfHours, String name, int ssn, String address, Gender sex) {
        super(name, ssn, address, sex);
        this.hourRate = hourRate;
        this.numOfHours = numOfHours;
    }

    @Override
    public double erning() {
        return hourRate * numOfHours;
    }

    @Override
    public String displayDetails() {
        return "Hour Rate:" + hourRate + "\nnumber of hours:" + numOfHours;
    }

    public void displayAllDetails() {
        System.out.println(super.displayDetails());
        System.out.println(this.displayDetails());
    }

    public void displayEarning() {
        System.out.println(erning());
    }

    public void setHourRate(Double hourRate) {
        this.hourRate = hourRate;
    }

    public double getHourRate() {
        return hourRate;
    }

    public void setNumOfHours(int numOfHours) {
        this.numOfHours = numOfHours;
    }

    public int getNumOfHours() {
        return numOfHours;
    }

}
