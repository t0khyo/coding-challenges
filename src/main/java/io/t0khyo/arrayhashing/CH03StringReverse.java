package io.t0khyo.arrayhashing;

public class CH03StringReverse {
    public static void main(String[] args) {
        String str = "Hello, World!";
        System.out.println(reverseString(str));
        System.out.println(reverseStringManually(str));
    }

    public static String reverseString(String str) {
        StringBuilder result = new StringBuilder(str);
        result.reverse();

        return result.toString();
    }

    public static String reverseStringManually(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = str.length() - 1;i >= 0;i--) {
            result.append(str.charAt(i));
        }
        return result.toString();
    }
}
