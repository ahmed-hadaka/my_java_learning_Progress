public class Bear {
    private final String MAKER;
    private final String TYPE;

    public Bear(String maker, String type) {
        this.MAKER = maker;
        this.TYPE = type;
    }

    public void display() {
        System.out.println(MAKER + ":" + TYPE);
    }
}
