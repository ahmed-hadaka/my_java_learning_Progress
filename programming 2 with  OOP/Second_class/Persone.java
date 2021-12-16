public class Persone {
    private String name;
    private int age;
    private String address;
    private String nationality;

    public Persone() {          //constructor1 with overloading        
        name = "abd allah";
        age = 19;
        address = "sobaih - Hehya - sharqyaa";
        nationality = "egyption";
}
 
    public Persone(  String name,int age,String address,String nationality) {       //constructor2 with overloading
        this.name = name;
        this.age = age;
        this.address = address;
        this.nationality = nationality;
    }
    


  public void set_name(String name) {
        this.name = name;
    }
    public void set_age(int age) {
        this.age = age;
    }
    public void set_address(String address) {
        this.address = address;
    }

    public void set_nationality(String nationality) {
        this.nationality = nationality;
    }

    public String get_name() {
        return name;
    }
    public int get_age() {
        return age;
            
    }
    
    public String get_address() {
        return address;
    }

    public String get_nationality() {
        return nationality;
    }
    public void print_data() {
        System.out.println("the name is :" + name);
        System.out.println("the  age is :" + age);
        System.out.println("the  address is :" + address);
        System.out.println("the  nationality is :"+nationality);
    }
    

}
