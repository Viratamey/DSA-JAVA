package LinkedList;

class Node<E> {
     Node(E element) {
        this.item = element;
    }
    public E item;
    public Node prev;
    public Node next;
}


public class LinkedListImpl<E> {

    Node start;
    Node end;

    public String toString() {
        Node<E> n = start;
        String s = "";
        while(n!=null) {
            s += n.item + " ";
            n = n.next;
        }
        return s;
    }

    void addFirst(E element) {
        Node<E> n = new Node(element);
        n.next = start;
        if(start != null) {
            start.prev = n;
        }
        start = n;
        if(end == null) {
            end = start;
        }
    }

    void addLast(E element) {
        Node<E> n = new Node(element);
        n.prev = end;
        if(end != null) {
            end.next = n;
        }
        end = n;
        if(start == null) {
            start = end;
        }
    }

    E removeFirst() {
        Node<E> temp = start;
        if(start != null) {
            if(start == end) {
                start = end  = null;
            }
            else {
                start = start.next;
                start.prev = null;
            }
            return temp.item;
        }
        return null;

    }

    E removeLast() {
        Node<E> temp = end;
        if(end != null) {
            if(start == end) {
                start = end = null;
            }
            else {
                end = end.prev;
                end.next = null;
            }
            return temp.item;
        }
        return null;
    }

    boolean remove(E element) {
        if(start == null) {
            return false;
        }
        Node<E> node = start;
        if(element == null) {
            while(node!=null && node.item != element) {
                node = node.next;
            }
            if(node!=null && element == node.item) {
                unlink(node);
                return true;
            }
        }
        else {
            while(node!=null && node.item != element) {
                node = node.next;
            }
            if(node!=null && node.item == element) {
                unlink(node);
                return true;
            }
        }
        return false;
    }

    //  Remember this code to remove any node in the linked list whether its in middle start or end everywhere
    private void unlink(Node<E> node) {
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if(prev == null) {
            start = next;
        }
        else {
            prev.next = next;
            node.prev = null;
        }
        if(next == null) {
            end = prev;
        }
        else {
            next.prev =prev;
            node.next = null;
        }
    }

    public static void main(String[] args) {
//      First will create list of object class not String class
//      LinkedListImpl list = new LinkedListImpl();
        LinkedListImpl<String> list = new LinkedListImpl<>();
        list.addLast("rohit");
        list.addLast("rahul");
        list.addFirst("virat");
        list.addFirst("king");
        System.out.println(list);
        list.remove("rohit");
        System.out.println(list);
        list.remove("rohit");
        System.out.println(list);
        list.remove("king");
        System.out.println(list);
        list.remove("rahul");
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
    }
}
