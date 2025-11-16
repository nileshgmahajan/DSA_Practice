class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // Step 1: store allowed chars
        boolean[] allowedSet = new boolean[26];
        for (char c : allowed.toCharArray()) {
            allowedSet[c - 'a'] = true;
        }

        int count = 0;

        // Step 2: check every word
        for (String word : words) {
            boolean isConsistent = true;

            for (char c : word.toCharArray()) {
                if (!allowedSet[c - 'a']) {
                    isConsistent = false;
                    break;
                }
            }

            if (isConsistent) count++;
        }

        return count;
    }
}
