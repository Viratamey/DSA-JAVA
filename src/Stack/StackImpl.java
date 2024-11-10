package Stack;

import java.util.Stack;

public class StackImpl {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.add(12);
        st.add(67);
        st.add(34);
        st.add(67);
        st.add(26);
        st.add(69);

        System.out.println("top element = " + st.peek());
        System.out.println("bottom element = " + st.firstElement());

        while(!st.empty()) {
            System.out.println(st.pop());
        }

    }
}
