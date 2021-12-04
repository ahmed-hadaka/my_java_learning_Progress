public class myfirst_class {
    private double width;   //properties
    private double length;

    public myfirst_class() {  // abstract 1
        length = 10;
        width = 5;
    }
    
    public myfirst_class(double l,double w) {   // abstract 2
        length = l;
        width = w;
 }

 public void setwidth(double w) {   //method 1
     if (w < 0) {
         System.out.println("invalid width");
        }
        else
            width = w;
    }

 public void setlength(double l) {      //method 2
    if (l < 0) {
        System.out.println("invalid length");
            }
            else
        length = l;
    }
    
    public double getwidth() { //method 3
        return width;
    }

    public double getlength() { //method 4
        return length;
    }
    public double getarea() {      //method 5
        return length * width;
    }
    
}
    
