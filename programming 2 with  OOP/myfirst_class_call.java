public class myfirst_class_call {
    public static void main(String[] args) {
        myfirst_class r1 = new myfirst_class();
         //normal calling
        r1.setlength(18.4);
        r1.setwidth(39.32);
        System.out.println(r1.getarea());
        //calling with abstract 1
        myfirst_class r2 = new myfirst_class();
        System.out.println(r2.getarea());
        //calling with abstract 2
        myfirst_class r3= new myfirst_class(21.4, 9.0);
        System.out.println(r3.getarea());


    }

}


