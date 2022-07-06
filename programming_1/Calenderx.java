import java.util.Calendar;

class Calenderx {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2022, 5, 3, 6, 15);
        long day1 = c.getTimeInMillis();
        System.out.println(day1);
        day1 += 1000 * 60 * 60;
        c.setTimeInMillis(day1);
        System.out.println(c.get(Calendar.HOUR_OF_DAY));
        c.add(Calendar.DATE, 35);
        System.out.println("add 35 days: " + c.getTime());
        c.set(Calendar.DATE, 3);
        System.out.println("set to 3: " + c.getTime());
    }
}