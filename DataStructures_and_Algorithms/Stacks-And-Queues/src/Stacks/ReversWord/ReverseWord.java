/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
 package Stacks.ReversWord;

/**
 *
 * @author mf
 */
public class ReverseWord {
    private String input;

    public ReverseWord(String input) {
        this.input = input;
    }

    public void doReverse() {
        StackX stack1 = new StackX(input.length());
        for (int i = 0; i < input.length(); i++) {
            stack1.push(input.charAt(i));
        }
        while (!stack1.isEmpty()) {
            System.out.print(stack1.pop());
        }

    }
}
