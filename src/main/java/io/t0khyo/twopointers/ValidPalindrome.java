package io.t0khyo.twopointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String phrase = s.toLowerCase();
        int left = 0;
        int right = phrase.length() - 1;

        while (right >= left) {
            char lChar = phrase.charAt(left);
            char rChar = phrase.charAt(right);

            if (!Character.isLetterOrDigit(lChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rChar)) {
                right--;
            } else {
                if (lChar != rChar) return false;

                left++;
                right--;
            }
        }
        return true;
    }
}
