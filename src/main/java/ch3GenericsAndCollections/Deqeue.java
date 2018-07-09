package main.java.ch3GenericsAndCollections;

import java.util.ArrayDeque;
import java.util.Deque;

public class Deqeue {

    public static void main(String[] args) {
        Deque<Integer> d = new ArrayDeque<>();
        d.push(1);
        System.out.println(d);
        d.offerLast(2);
        System.out.println(d);
        d.push(3);
        System.out.println(d);
        d.peekFirst();
        System.out.println(d);
        d.removeLast();
        System.out.println(d);
        d.pop();
        System.out.println(d);

    }


}
