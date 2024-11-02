package io.t0khyo.strings;

public class DeleteCharactersToMakeFancyString {
    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();

        char current = s.charAt(0);
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == current) {
                count++;
            } else {
                count = 0;
                current = c;
            }

            if (count <= 2) {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}
