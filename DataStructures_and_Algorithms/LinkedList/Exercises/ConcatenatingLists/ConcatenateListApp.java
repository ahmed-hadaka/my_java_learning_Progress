package Exercises.ConcatenatingLists;

/**
 * (Concatenating Lists) Write a program that concatenates two linked list
 * objects of characters Class ListConcatenate should include a static method
 * concatenate that takes references to both list objects as arguments and
 * concatenates the second list to the first list
 *
 * @AhmedHadaka
 */
public class ConcatenateListApp {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        ListConcatenate listCon = new ListConcatenate();

        list1.insert('A');
        list1.insert('h');
        list1.insert('m');
        list1.insert('e');
        list1.insert('d');

        System.out.println(list1.toString());

        list2.insert('H');
        list2.insert('a');
        list2.insert('d');
        list2.insert('a');
        list2.insert('k');
        list2.insert('a');

        System.out.println(list2.toString());

        listCon.concatenate(list1, list2);

        System.out.println(list1.toString());

    }
}
