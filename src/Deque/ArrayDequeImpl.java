package Deque;

import java.lang.reflect.Array;

public class ArrayDequeImpl<E> {

    // generally we create array of Object class rather than of generic E because in constructor the new E[SIZE] doesn't work
    // and there are cast exception if we do E[] arr = (E[]) new Object[SIZE]
//    public Object[] array;
    public E[] array;
    private int head, tail;
    private static final int SIZE = 5;

    public ArrayDequeImpl() {
        array = (E[]) new Object[SIZE];
//        array = (E[]) Array.newInstance(String.class, SIZE);

    }

    public ArrayDequeImpl(Class<E> clazz) {
        array = (E[]) Array.newInstance(clazz, SIZE);

    }


    public void addFirst(E element) {
    }

    private void resize() {

    }

    public static void main(String[] args) {
        ArrayDequeImpl<String> arrdq = new ArrayDequeImpl<>();
        ArrayDequeImpl<String> arrdq1 = new ArrayDequeImpl<>(String.class);
        System.out.println(arrdq1.array.length);
        System.out.println(arrdq.array.length);
        arrdq.addFirst("rohit");
        arrdq.addFirst("rohit");
    }
}
