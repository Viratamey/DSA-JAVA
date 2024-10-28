import java.util.ArrayList;
import java.util.regex.Pattern;
public class BlockIterator {
    String[] strarr;
    String pattern;
    int size;
    int currIndex;

    public BlockIterator(String[] strarr, String pattern) {
        this.strarr = strarr;
        this.size = strarr.length;
        this.currIndex = 0;
        this.pattern = pattern;
    }

    public boolean hasNext() {
        int temp = currIndex;
        while(currIndex < size) {
            if(Pattern.matches(pattern+"(.*)", strarr[currIndex])) {
                currIndex = temp;
                return true;
            }else{
                currIndex++;
            }
        }
        currIndex = temp;
        return false;
    }

    public ArrayList<String> next() {
        ArrayList<String> arrList = new ArrayList<>();
        while(!Pattern.matches(pattern+"(.*)", strarr[currIndex])) {
            currIndex++;
        }
        arrList.add(strarr[currIndex++]);
        while(currIndex<size && !Pattern.matches(pattern+"(.*)", strarr[currIndex])) {
            arrList.add(strarr[currIndex++]);
        }
        return arrList;
    }

    public static void main(String[] args) {
        String[] strArr = {"virat", "start1", "stort12", "rohit", "start34", "sachin", "start89", "start31","dravid"};
        String pattern = "start";
        BlockIterator blockIterator = new BlockIterator(strArr, pattern);
        while(blockIterator.hasNext()) {
            System.out.println(blockIterator.next());
        }

//        Blockiterator will iterate and give list with first string matches pattern will print following:
//          [start1, stort12, rohit]
//          [start34, sachin]
//          [start89]
//          [start31, dravid]

//        System.out.println(Pattern.matches("^abc(.*)", "abcdedf")); //true
//        System.out.println(Pattern.matches("^abc(.*)", "abdfghg")); //false
//        System.out.println(Pattern.matches("^abc(.*)", "ab")); //false
//        System.out.println(Pattern.matches("^abc(.*)", "abc")); //true
//        System.out.println(Pattern.matches("abcdedf", "^abc(.*)")); //false
//        System.out.println(Pattern.matches( "abdfghg", "^abc(.*)")); //false
//        System.out.println(Pattern.matches( "ab", "^abc(.*)")); //false
//        System.out.println(Pattern.matches("abc", "^abc(.*)")); //false

    }
}

