package io.t0khyo.strings;

public class FindTheLongestSubstringContainingVowelsEvenCounts {
    public int findTheLongestSubstring(String s) {
        int prefixXOR = 0;

        int[] charMap = new int[26];
        charMap[0] = 1;
        charMap['e' - 'a'] = 2;
        charMap['i' - 'a'] = 4;
        charMap['o' - 'a'] = 8;
        charMap['u' - 'a'] = 16;

        // This will store the index of the first occurrence of each prefixXOR value.
        int[] mp = new int[32];

        for (int i = 0;i < 32;i++) mp[i] = -1;
        int longestSubString = 0;
        for (int i = 0;i < s.length();i++) {
            prefixXOR ^= charMap[s.charAt(i) - 'a'];
            if (mp[prefixXOR] == -1 && prefixXOR != 0) mp[prefixXOR] = i;
            longestSubString = Math.max(longestSubString, i - mp[prefixXOR]);
        }

        return longestSubString;
    }
}
