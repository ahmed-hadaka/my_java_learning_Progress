import java.util.Map;

public class HashMap {
    public static void main(String[] args) {

        java.util.HashMap<Integer, String> map = new java.util.HashMap<Integer, String>();

        map.put(5, "Five");
        map.put(8, "Eight");
        map.put(6, "Six");
        map.put(2, "Two");
        map.put(4, "Four");

        String text = map.get(6);

        System.out.println(text);

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int key = entry.getKey();
            String value = entry.getValue();

            System.out.println(key + ": " + value);
        }
    }
}

