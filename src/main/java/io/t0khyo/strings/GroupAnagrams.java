package io.t0khyo.strings;

import java.util.*;

public class GroupAnagrams {

    // takes (m*nlog(n))
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> group = new HashMap<>();

        for (String str : strs) {
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr); // O(nlog(n))

            String key = new String(chArr);

            if (group.containsKey(key)) {
                group.get(key).add(str);
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add(str);
                group.put(key, stringList);
            }
        }

        result.addAll(group.values());

        return result;
    }

//    public static List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> result = new ArrayList<>();
//
//        for (int i = 0;i < strs.length;i++) {
//            if (strs[i] == null) continue;
//
//            List<String> group = new ArrayList<>();
//            group.add(strs[i]);
//
//            for (int j = i + 1;j < strs.length;j++) {
//                if (strs[j] == null) continue;
//
//                if (isAnagram(strs[i], strs[j])) {
//                    group.add(strs[j]);
//                    strs[j] = null;
//                }
//            }
//
//            result.add(group);
//        }
//
//        return result;
//    }

    private static boolean isAnagram(String strA, String strB) {
        if (strA.length() != strB.length())
            return false;

        int[] counts = new int[26]; // counter for each char in a sring

        for (char c : strA.toCharArray()) {
            counts[c - 'a']++;
        }

        for (char c : strB.toCharArray()) {
            if (counts[c - 'a'] == 0) return false;

            counts[c - 'a']--;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams(strs));
    }
}
