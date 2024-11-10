package Vector;

import java.util.*;

public class VectorImpl {
    public static void main(String[] args) {
        ArrayList<Integer> vec = new ArrayList<>();
        vec.addAll(List.of(12,23,454,56,23,82));
        System.out.println(vec);
        System.out.println();

        ArrayList<Integer> vec2 = new ArrayList<>(vec);
        vec2.set(1, 12);
        vec2.set(4, 78);
        System.out.println(vec2);
        System.out.println(vec2.indexOf(454));
        System.out.println(vec2.get(3));
        System.out.println(vec);
        vec2.addAll(vec);
        System.out.println(vec2);
        System.out.println(vec);
        vec2.addAll(9, vec);
        System.out.println(vec2);
        System.out.println();

        ArrayList<Integer> vec3 = new ArrayList<>(vec);
        vec3.set(0,21);
        vec3.set(3,44);
        System.out.println(vec3);
        vec3.addAll(3, vec3);
        System.out.println(vec3);
        System.out.println(vec3.indexOf(44));
        System.out.println(vec3.lastIndexOf(44));

        System.out.println();
        vec3.forEach(integer -> {
            System.out.print(integer);
            System.out.print(" ");
        });
        vec3.add(3, 37);
        System.out.println();
        vec3.forEach(integer -> {
            System.out.print(integer);
            System.out.print(" ");
        });
        vec3.add(99);System.out.println();
        vec3.forEach(integer -> {
            System.out.print(integer);
            System.out.print(" ");
        });
        System.out.println();
        System.out.println(vec3.isEmpty());
        System.out.println(vec3.size());
        vec3.clear();
        System.out.println(vec3.isEmpty());
        vec3 = (ArrayList<Integer>) vec2.clone();
        System.out.println(vec3);
        System.out.println(vec3.remove(12));
        System.out.println(vec3);
        vec3.ensureCapacity(25);
        System.out.println(vec3.size());
        System.out.println(vec3.containsAll(List.of(12,34,99)));
        System.out.println(vec3.containsAll(List.of(12,23,56,82)));
        System.out.println();

        vec3.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println(vec3);

        Comparator<Integer> decreasing = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        ArrayList<Integer> arr = new ArrayList<>(List.of(12,56,78,90,34,24));
        arr.sort(decreasing);
        System.out.println(arr);

        ArrayList<Map.Entry<Integer, Integer>> paiArr = new ArrayList<>();
        paiArr.add(Map.entry(12,45));
        paiArr.add(Map.entry(14,45));
        paiArr.add(Map.entry(19,45));
        paiArr.add(Map.entry(98,45));
        paiArr.add(Map.entry(58,45));
        paiArr.add(Map.entry(45,56));
        paiArr.add(Map.entry(45,12));
        paiArr.add(Map.entry(14,34));
        paiArr.add(Map.entry(14,87));
        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> p1, Map.Entry<Integer, Integer> p2) {
                if(p1.getKey() == p2.getKey()) {
                    return p1.getValue()-p2.getValue();
                }
                else{
                    return p2.getKey()-p1.getKey();
                }
            }
        };
        paiArr.sort(comparator);
        System.out.println(paiArr);
        System.out.println();

        Comparator<Map.Entry<Integer, Integer>> sumComparator = new Comparator<>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> p1, Map.Entry<Integer, Integer> p2) {
                return (p1.getKey()+p1.getValue())-(p2.getKey()+p2.getValue());
            }
        };
        paiArr.sort(sumComparator);
        System.out.println(paiArr);
    }
}
