
/**************************************************************************************************************
 * passingobjects_class.java
 * Ahmed hadaka
 * 
 * this program calculate the area of a given regtangle by it's width and length and sum of it's dimensions
 ***************************************************************************************************************/

public class passingobjects_class {
    private double width;   //properties
    private double length;
    

    public passingobjects_class() {  // abstract 1
        length = 10;
        width = 5;
    }
    
    public passingobjects_class(double l, double w) { // abstract 2
        length = l;
        width = w;
    }

    public passingobjects_class(passingobjects_class objectcopy) {   //abstract making a copy from object
        length = objectcopy.length;
        width = objectcopy.width;
    }
 public passingobjects_class add_objects(passingobjects_class obj1) {     //method passing objects as an arguments
     passingobjects_class result = new passingobjects_class();
     result.length = this.length + obj1.length;
     result.width = this.width + obj1.width;
     return result;
 }

 public boolean isequal(passingobjects_class source) {              //method comparing objects
    if(this.length==source.length && this.width==source.width)
        return true;
        else
            return false;
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
    
