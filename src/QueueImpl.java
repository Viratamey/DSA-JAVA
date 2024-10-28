import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueImpl {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // add and remove gives exception but offer and poll does same
        // thing but returns null instead of giving exception
        queue.add(12);
        queue.add(67);
        queue.add(34);
        queue.add(67);
        queue.add(26);
        queue.add(69);
        System.out.println("top element = " + queue.peek());
        System.out.println(queue.contains(26));
        System.out.println(queue.contains(134));
        System.out.println(queue.containsAll(List.of(12, 34, 69)));
        System.out.println(queue.containsAll(List.of(12, 36, 69)));
        System.out.println(queue.size());
        System.out.println(queue.remove(34));
        System.out.println(queue);
        System.out.println(queue.removeAll(List.of(12, 34, 69)));
        System.out.println(queue);
        System.out.println(queue.element());
        System.out.println();

        queue.add(47);
        queue.add(90);
        queue.add(49);
        queue.add(76);
        queue.add(56);
        queue.add(36);
        queue.add(98);
        System.out.println(queue.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 == o2) {
                    return 1;
                }
                return o1-o2;
            }
        }));
        System.out.println();

        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        System.out.println(queue.peek());  // returns null
        System.out.println(queue.poll());   // returns null
        System.out.println(queue.remove()); // throws exception


    }
}
