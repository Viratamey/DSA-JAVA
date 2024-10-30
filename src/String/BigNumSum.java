package String;

public class BigNumSum {
    public static void main(String[]args){
        String s1 = "423619268961982321132231";
        String s2 = "923619268961982321132231";
        System.out.println(123 + 2123879879);

        StringBuilder str1 = new StringBuilder(s1);
        StringBuilder str2 = new StringBuilder(s2);
        StringBuilder ans = Sum.addStrings(str1, str2);
        System.out.println(ans.reverse());
    }
    public static class Sum {
        static StringBuilder addStrings(StringBuilder s1, StringBuilder s2) {
            int length1 = s1.length();
            int length2 = s2.length();
            StringBuilder s3 = new StringBuilder();
            StringBuilder s4 = new StringBuilder();

            for(int i=0; i<length1; ++i) {
                s3.append(s1.charAt(length1 - i - 1));
            }
//            System.out.println(s3);

            for(int i=0; i<length2; ++i) {
                s4.append(s2.charAt(length2 - i - 1));
            }
//            System.out.println(s4);

            int minlen;
            if(length1 > length2) {
                minlen = length2;
            }
            else {
                minlen = length1;
            }
            int carry = 0;
            for(int i=0; i<minlen; ++i) {
                int digit = ((s3.charAt(i)-'0') + (s4.charAt(i)-'0') + carry)%10;
                carry = (s3.charAt(i)-'0' + s4.charAt(i)-'0'  + carry)/10;
                s3.setCharAt(i, (char)(digit + '0'));

            }
            for( int i=minlen; i<Math.max(length1, length2); ++i) {
                if(length1 < length2) {
                    s3.append('0');

                }
//                int digit = ((s3.charAt(i)-'0') + (s4.charAt(i)-'0')  + carry)%10;
                int bitSum = 0;
                if(i<s3.length()) {
                    bitSum = bitSum + (s3.charAt(i)-'0');
                }
                if(i<s4.length()) {
                    bitSum = bitSum + (s4.charAt(i)-'0');
                }
                int digit = (bitSum + carry)%10;
                carry = (bitSum)/10;
                s3.setCharAt(i, (char)(digit + '0'));
            }
            if(carry!=0) {
                s3.append((char)(carry+'0'));
            }

            return s3;
        }
    }


}

