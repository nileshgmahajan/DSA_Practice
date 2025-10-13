import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String prev = result.get(result.size() - 1);
            if (!isAnagram(prev, words[i])) {
                result.add(words[i]);
            }
        }

        return result;
    }

    // Frequency-based check (O(k) time, O(1) memory)
    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for (int f : freq)
            if (f != 0) return false;

        return true;
    }
}
