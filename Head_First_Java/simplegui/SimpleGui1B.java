package simplegui;

import javax.swing.*;
import java.awt.event.*;

public class SimpleGui1B implements ActionListener {
    JButton button;

    public static void main(String[] args) {
        SimpleGui1B simpleGui1B = new SimpleGui1B();
        simpleGui1B.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("click me");
        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(2, 50);
        frame.setVisible(true);

        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        button.setText("I've been clicked");
    }

}
