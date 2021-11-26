
public class myfirstclass {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
         //normal calling
        r1.setlength(18.4);
        r1.setwidth(39.32);
        System.out.println(r1.getarea());
        //calling with abstract 1
        Rectangle r2 = new Rectangle();
        System.out.println(r2.getarea());
        //calling with abstract 2
        Rectangle r3= new Rectangle(21.4, 9.0);
        System.out.println(r3.getarea());


    }

}


