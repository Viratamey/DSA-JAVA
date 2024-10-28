import java.util.*;

public class PriorityQueueImplementation {

    public static void main(String[] args) {

        //min PQ
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        minPQ.add(39);
        minPQ.add(23);
        minPQ.add(78);
        minPQ.add(34);
        minPQ.add(12);
        while(!minPQ.isEmpty()){
            System.out.println(minPQ.poll());
        }

        System.out.println();

        //max PQ
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        maxPQ.add(39);
        maxPQ.add(23);
        maxPQ.add(78);
        maxPQ.add(34);
        maxPQ.add(12);
        while(!maxPQ.isEmpty()){
            System.out.println(maxPQ.poll());
        }

        //PriorityQueue for pairs
         PriorityQueue<Map.Entry<Integer, Integer> > minPairPQ = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
             @Override
             public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                 return o1.getKey()-o2.getKey() == 0 ? o1.getValue()-o2.getValue() : o1.getKey()-o2.getKey();
             }
        });

        minPairPQ.add(Map.entry(12, 78));
        minPairPQ.add(Map.entry(145, 21));
        minPairPQ.add(Map.entry(17, 59));
        minPairPQ.add(Map.entry(46, 98));
        minPairPQ.add(Map.entry(32, 102));
        minPairPQ.add(Map.entry(78, 29));
        minPairPQ.add(Map.entry(145, 2));
        minPairPQ.add(Map.entry(19, 98));
        minPairPQ.add(Map.entry(46, 12));
        minPairPQ.add(Map.entry(46, 5));

        System.out.println();
        while(!minPairPQ.isEmpty()){
            System.out.println(minPairPQ.poll());
        }

        PriorityQueue<Map.Entry<Integer, Integer> > maxPairPQ = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getKey()-o1.getKey() == 0 ? o2.getValue()-o1.getValue() : o2.getKey()-o1.getKey();
            }
        });

        maxPairPQ.add(Map.entry(12, 78));
        maxPairPQ.add(Map.entry(145, 21));
        maxPairPQ.add(Map.entry(17, 59));
        maxPairPQ.add(Map.entry(46, 98));
        maxPairPQ.add(Map.entry(32, 102));
        maxPairPQ.add(Map.entry(78, 29));
        maxPairPQ.add(Map.entry(145, 2));
        maxPairPQ.add(Map.entry(19, 98));
        maxPairPQ.add(Map.entry(46, 12));
        maxPairPQ.add(Map.entry(46, 5));

        System.out.println();
        while(!maxPairPQ.isEmpty()){
            System.out.println(maxPairPQ.poll());
        }

    }
}
