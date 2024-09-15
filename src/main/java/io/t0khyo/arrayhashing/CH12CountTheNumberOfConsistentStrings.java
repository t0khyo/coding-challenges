package io.t0khyo.arrayhashing;

public class CH12CountTheNumberOfConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        int numOfConsistentWords = 0;

        for (String word : words) {
            numOfConsistentWords++;
            for (Character c : word.toCharArray()) {
                if (!allowed.contains(c.toString())) {
                    numOfConsistentWords--;
                    break;
                }
            }
        }
        return numOfConsistentWords;
    }
}
