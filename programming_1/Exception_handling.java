import java.io.IOException;

public class Exception_handling {
    static class Lunder {
        void doLunder() throws IOException {
            System.out.println("doLunder called");
            if (true)
                throw new IOException();
        }
    }

    static void foo() throws IOException {
        System.out.println("foo called");
        Lunder lander = new Lunder();
        lander.doLunder();
    }

    public static void main(String[] args) { // you may prefer to just Duck It (declare the exception in the main method
                                             // declaratio)
        try {
            Exception_handling.foo();
            System.out.println("uncatched");
        } catch (IOException ex) {
            System.out.println("catched");
        }
    }
}
