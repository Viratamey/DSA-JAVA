package Comparator;

import java.util.*;
//import javafx.util.Comparator.Pair;

public class Pair implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Map.Entry<Integer, String> p1 = (Map.Entry<Integer, String>) o1;
        Map.Entry<Integer, String> p2 = (Map.Entry<Integer, String>) o2;
        return p1.getKey() < p2.getKey() ? 1:0;
    }

    public static <K, V> Map.Entry<K, V> of(K key, V value) {
        return new AbstractMap.SimpleEntry<>(key, value);
    }

    public static void main(String[] args) {
        Map.Entry p1 = Pair.of(12, "java");
        Map.Entry p2 = Pair.of(5, "c++");
        Map.Entry p3 = Pair.of(21, "python");
        Map.Entry p4 = Pair.of(11, "javascript");

        Set<Map.Entry<Integer, String>> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);

        Set<Map.Entry<Integer, String>> treeSet = new TreeSet<>(new Comparator <Map.Entry<Integer, String>> () {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                if (o1.getKey() - o2.getKey() == 0) {
                    if (o1.getKey() == o2.getKey())
                        return 1;
                    else
                        return o1.getKey() - o2.getKey();
                }
                return o1.getKey() - o2.getKey();
            };
        });
        treeSet.add(p1);
        treeSet.add(p2);
        treeSet.add(p3);
        treeSet.add(p4);

        set.forEach(entry -> {
            System.out.println(entry);
        });

        System.out.println();

        treeSet.forEach(entry -> {
            System.out.println(entry);
        });
    }

}
