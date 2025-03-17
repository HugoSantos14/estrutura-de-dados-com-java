package main;

import exceptions.StackException;
import structures.DoublyLinkedList;
import structures.Queue;
import structures.Stack;

public class App {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.pop(3);

        System.out.println(stack);
    }
}
