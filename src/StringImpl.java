public class StringImpl {
    public static void main(String[] args) {
        String str = "custom string";
        updateString(str);
        System.out.println(str);
        String str1 = new String("custom string");
        updateString(str1);
        System.out.println(str1);
        StringBuilder stringBuilder = new StringBuilder("custom string");
        updateString(String.valueOf(stringBuilder));
        System.out.println(stringBuilder);
        updateString(stringBuilder);
        System.out.println(stringBuilder);
        StringBuffer stringBuffer = new StringBuffer("custom string");
        updateString(stringBuffer);
        System.out.println(stringBuffer);
        StringBuffer stringBuffer1 = new StringBuffer(stringBuilder);
        System.out.println(stringBuffer1);
        updateString(stringBuffer1);
        System.out.println(stringBuffer1);
    }

    private static void updateString(String str) {
        str = "updated string";
    }

    private static void updateString(StringBuilder stringBuilder) {
        stringBuilder.reverse();
    }

    private static void updateString(StringBuffer stringBuffer) {
        stringBuffer.reverse();
    }
}
