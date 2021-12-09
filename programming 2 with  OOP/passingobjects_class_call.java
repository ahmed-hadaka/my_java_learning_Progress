public class passingobjects_class_call {
    public static void main(String[] args) {
        passingobjects_class obj2 = new passingobjects_class();
        passingobjects_class obj3 = new passingobjects_class();

        System.out.println("the length after adding is :"+(obj2.add_objects(obj3).getlength()));             //adding objects
        System.out.println("the width after adding is :"+(obj2.add_objects(obj3).getwidth()));
        System.out.println("the area after adding is :"+(obj2.add_objects(obj3).getarea()));

        passingobjects_class obj4 = new passingobjects_class(2.3,54.65);           //adding objects      
        passingobjects_class obj5 = new passingobjects_class(14.0,87.7);
        System.out.println("the length after adding is :"+(obj4.add_objects(obj5).getlength()));
        System.out.println("the width after adding is :"+(obj4.add_objects(obj5).getwidth()));
        System.out.println("the area after adding is :"+(obj4.add_objects(obj5).getarea()));

        if(obj3.isequal(obj2))                   //comparing objects
            System.out.println("obj3 and obj2 are equal");
        else
            System.out.println(" obj3 and obj2 aren't equal");

        passingobjects_class obj6 = new passingobjects_class(obj5);      //copy object
         System.out.println(obj6.getarea());



    }
}
