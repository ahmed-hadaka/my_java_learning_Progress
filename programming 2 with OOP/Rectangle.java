
public class Rectangle {
    private double width;
    private double length;

    public Rectangle() {  // abstract 1
        length = 10;
        width = 5;
    }
    
    public Rectangle(double l,double w) {   // abstract 2
        length = l;
        width = w;
 }

    public void setwidth(double w) {
        width = w;
    }

    public void setlength(double l) {
        length = l;
    }
    
    public double getwidth() {
       return width;
    }
        
    public double getlength() {
        return length;
    }
    public double getarea() {
        return length * width;
    }
    
}
    
