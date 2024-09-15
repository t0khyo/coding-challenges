package io.t0khyo.arrayhashing;

import java.util.HashMap;
import java.util.Map;

public class CH06ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "mragana";
        System.out.println(isAnagram(s, t));
    }

    // another solution will ba a hash map for each string <char, numOfRepetition>
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] counts = new int[26];

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            // if the char in [c-'a'] not exist in s string then not anagram.
            if (counts[c - 'a'] == 0) return false;

            counts[c - 'a']--;
        }

        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> sSet = new HashMap<>();
        Map<Character, Integer> tSet = new HashMap<>();

        for (int i = 0;i < s.length();i++) {
//            sSet.put(c);

        }
        for (char c : t.toCharArray()) {
//            tSet.add(c);
        }

        return tSet.equals(sSet);
    }
}
