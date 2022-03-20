package Stacks.DelimiterMatching;

import java.io.*;

public class BracketCheckerApp {

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("Enter Your Sentence");
            String input = getString();

            if (input.equals("")) 
                break;
            
            BracketChecker Chaker = new BracketChecker(input);
            Chaker.checkStr();
        }

    }

    public static String getString() throws IOException {
        InputStreamReader str = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(str);
        String s = br.readLine();
        return s;

    }
}
