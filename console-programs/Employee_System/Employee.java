enum Gender {
    mail,
    femail
}

public abstract class Employee {

    private String name;
    int ssn;
    String address;
    Gender sex;

    // empty constructor
    public Employee() {

    }

    // full constructor
    public Employee(String name, int ssn, String address, Gender sex) {
        this.name = name;
        this.ssn = ssn;
        this.address = address;
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return this.name;
    }

    public void setSSN(int SSN) {
        this.ssn = SSN;
    }

    public int getSSN() {
        return this.ssn;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setGender(Gender sex) {
        this.sex = sex;
    }

    public Gender getGender() {
        return this.sex;
    }

    public String displayDetails() {
        return "Employee Information:\nname:" + this.name + "\nSSN:" + this.ssn + "\naddress:" + this.address
                + "\nGender:" + this.sex;
    }

    public abstract double erning();
}