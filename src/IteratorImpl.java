import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorImpl {
    public static void main(String[] args) {
        String[] strArr = {"virat", "rohit", "sachin", "dravid"};
        ArrayList<String> strList = new ArrayList<>(List.of("virat", "rohit", "sachin", "dravid"));
        Iterator<String> itArrayList = strList.iterator();
        Iterator<String> itStrArr = Arrays.stream(strArr).iterator();
        while(itArrayList.hasNext()){
            System.out.println(itArrayList.next());
        }
        System.out.println();
        while(itStrArr.hasNext()){
            System.out.println(itStrArr.next());
        }
    }
}
