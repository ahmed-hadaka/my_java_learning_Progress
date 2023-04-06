public class Manipulate_With_Employees {
    public static void main(String[] args) {
        System.out.println("hey!");
        Department D1 = new Department(1, "Value");
        Hourly_Employee h1 = new Hourly_Employee(75.6, 8, "Ahmed", 234, "Nasr City - Cairo", Gender.mail);
        Salaried_Employee s1 = new Salaried_Employee(1500, 200, 50, "Ahmed", 234, "Nasr City - Cairo", Gender.mail);
        Commission_Employee c1 = new Commission_Employee(5.2, 80, "Ahmed", 234, "Nasr City - Cairo", Gender.mail);
        D1.add(h1);
        D1.add(c1);
        D1.getSize();
        D1.displayAllDetails();
        System.out.println();
        s1.displayAllDetails();
        System.out.println();
        c1.displayEarning();

    }
}
