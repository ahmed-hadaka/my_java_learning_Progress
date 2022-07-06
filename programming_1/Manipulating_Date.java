import java.util.Date;

class Manipulating_Date {

    public static void main(String[] args) {
        String s;
        s = String.format("%tc", new Date());
        System.out.println(s);
        s = String.format("%tr", new Date());
        System.out.println(s);
        s = String.format("%tA, %<tB %<td", new Date());
        System.out.println(s);
    }
}