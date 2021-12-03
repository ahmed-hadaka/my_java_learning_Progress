
public class myfirstclass {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
         //normal calling
        r1.setlength(-18.4);
        r1.setwidth(39.32);
        System.out.println(r1.getarea());
            
        Rectangle r2 = new Rectangle();     //calling with abstract 1
        System.out.println(r2.getarea());
       
        Rectangle r3= new Rectangle(21.4, 9.0);     //calling with abstract 2
        System.out.println(r3.getarea());


    }

}


