 package Stacks.ReversWord;

import java.io.*;

public class ReverseWordApp {
    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println("\nenter your word");
            // System.out.flush();
            String input = getString();
            if (input.equals(""))
                break;
            ReverseWord reverse = new ReverseWord(input);
            reverse.doReverse();
        }
    }

    public static String getString() throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;

    }

}
