package io.t0khyo.strings;

import java.util.Objects;

public class SentenceSimilarityIII {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1, s2;
        if (sentence1.length() <= sentence2.length()) {
            s1 = sentence1.split(" ");
            s2 = sentence2.split(" ");
        } else {
            s1 = sentence2.split(" ");
            s2 = sentence1.split(" ");
        }

        // s1 should be a prefix, suffix or combination of both.
        int l1 = 0;
        int l2 = 0;

        // match prefix
        while (l1 < s1.length && l2 < s2.length && Objects.equals(s1[l1], s2[l2])) {
            l1++;
            l2++;
        }

        int r1 = s1.length - 1;
        int r2 = s2.length - 1;

        // match suffix
        while (r1 >= 0 && r2 >= 0 && Objects.equals(s1[r1], s2[r2])) {
            r1--;
            r2--;
        }

        return l1 > r1;
    }
}
