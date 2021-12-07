public class passingobjects_class_call {
    public static void main(String[] args) {
        passingobjects_class obj2 = new passingobjects_class();
        passingobjects_class obj3 = new passingobjects_class();
        System.out.println(obj2.add_objects(obj3).getlength());
        System.out.println(obj2.add_objects(obj3).getwidth());
        System.out.println(obj2.add_objects(obj3).getarea());

        passingobjects_class obj4 = new passingobjects_class(2.3,54.65);
        passingobjects_class obj5 = new passingobjects_class(14.0,87.7);
        System.out.println(obj4.add_objects(obj5).getlength());
        System.out.println(obj4.add_objects(obj5).getwidth());
        System.out.println(obj4.add_objects(obj5).getarea());

    }
}
