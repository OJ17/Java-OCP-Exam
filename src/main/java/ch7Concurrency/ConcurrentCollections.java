package ch7Concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollections {
    // There are a number of concurrent collections in Java also they are useful when
    // you want to use multiple threads for modifying a colletion outside of a synchronized block
    // below is a simple demo of some of them

    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1, "0");

        ConcurrentLinkedDeque<String> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque.add("Fear");

        // concurrent skip list map. This is a sorted version of TreeMap. Not sure why the name though
        ConcurrentSkipListMap<Integer, String> concurrentSkipListMap = new ConcurrentSkipListMap<>();
        concurrentSkipListMap.put(1, "0");

        // The copy on write array list is as the name suggest an array list that creates a copy of itself
        // when you are writing an object to it
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("10");

        // There are also Synchronized version of extant collections
        // without being exhaustive, here are a few:
        List<String> lString = Collections.synchronizedList(
                new ArrayList<>(Arrays.asList("4", "3", "52")));
        synchronized (lString) {
            for (String x : lString) {
                System.out.println(x + " ");
            }
        }
    }


}
