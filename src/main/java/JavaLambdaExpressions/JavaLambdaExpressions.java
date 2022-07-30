package JavaLambdaExpressions;

import java.io.*;
import java.util.*;

@FunctionalInterface
interface PerformOperation {
    boolean check(int a);
}
class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

public static PerformOperation isOdd() {
        return n -> !(n % 2 == 0);
    }

    public static PerformOperation isPrime() {
        return n -> {
            int max = 1;
            int cont = 0;
            while (max <= n) {
                if(n % max == 0) cont ++;
                if(cont >= 3) break;
                max ++;
            }
            return cont == 2;
        };
    }

    public static PerformOperation isPalindrome() {
        return n -> {
            String numInString = Integer.toString(n);
            char[] chars = numInString.toCharArray();
            int charsLength = chars.length;
            for (int i = 0, r = charsLength; i < charsLength; i ++, r --) {
                if(chars[i] != chars[r-1]) return false;
            }
          return true;
        };
    }
}
public class JavaLambdaExpressions {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T--> 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}
