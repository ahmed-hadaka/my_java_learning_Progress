package Exercises.Deque;

/**
 *
 * @AhmedHadaka
 */
public class DequeListApp {

    public static void main(String[] args) {

        DequeList dc = new DequeList(6);
        dc.insertLeft(1); //  1 4 9 14 8
        dc.insertLeft(4);
        dc.insertLeft(9);
        dc.insertLeft(14);
        dc.insertLeft(8);

        dc.deleteLeft();
        dc.deleteRight();//   4 9 14  

        dc.insertRight(5);
        dc.insertRight(95);
        dc.insertRight(61);//61 95 5 4 9 14  

        dc.deleteRight();
        dc.deleteRight();// 5 4 9 14  

        dc.display();

    }
}
