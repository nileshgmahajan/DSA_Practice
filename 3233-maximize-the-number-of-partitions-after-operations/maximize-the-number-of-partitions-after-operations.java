class Solution {
    int n, K;
    String s;
    int[][] freq;  // prefix frequencies: freq[i][c] = count of char c in s[0..i-1]
    int[] pref;    // pref[i]: number of partitions in s[0..i]
    int[] suff;    // suff[i]: number of partitions in s[i..n−1]
    int[] partStart;  // partStart[i]: start index of partition containing i in base partitioning

    public int maxPartitionsAfterOperations(String s, int k) {
        this.s = s;
        this.n = s.length();
        this.K = k;

        // Build prefix frequency array
        freq = new int[n + 1][26];
        for (int i = 0; i < n; i++) {
            for (int c = 0; c < 26; c++) {
                freq[i + 1][c] = freq[i][c];
            }
            freq[i + 1][s.charAt(i) - 'a']++;
        }

        // Compute base partitions, partStart, pref
        pref = new int[n];
        partStart = new int[n];
        {
            int parts = 0;
            int start = 0;
            int l = 0;
            int distinct = 0;
            int[] cnt = new int[26];
            for (int r = 0; r < n; r++) {
                int c = s.charAt(r) - 'a';
                if (cnt[c] == 0) distinct++;
                cnt[c]++;
                while (distinct > K) {
                    int c2 = s.charAt(l) - 'a';
                    cnt[c2]--;
                    if (cnt[c2] == 0) distinct--;
                    l++;
                }
                // the valid window [l..r] is the max suffix ending at r
                // But we only end a partition when we are forced to push next
                // Actually, we can greedily decide partitions by scanning:
                // If we could extend, do so; when we have to break, mark
                // But easier: greedily simulate partitions:
                // — simpler method below
                // we do a fresh partition simulation below separately
            }
            // We'll do a cleaner simulation for pref and partStart:
            parts = 0;
            int i = 0;
            while (i < n) {
                parts++;
                int j = findMaxEndForStart(i);
                for (int x = i; x <= j; x++) {
                    partStart[x] = i;
                    pref[x] = parts;
                }
                i = j + 1;
            }
        }

        // Compute suffix partitions: suff[i] = partitions in s[i..n-1]
        suff = new int[n + 1];
        {
            // We do a right-to-left version
            int parts = 0;
            int i = n - 1;
            while (i >= 0) {
                parts++;
                int j = findMinStartForEnd(i);
                for (int x = j; x <= i; x++) {
                    suff[x] = parts;
                }
                i = j - 1;
            }
            suff[n] = 0;  // beyond end has 0 partitions
        }

        // Now try every position i, every replacement char
        int answer = pref[n - 1];  // no change case
        for (int i = 0; i < n; i++) {
            char orig = s.charAt(i);
            for (int c = 0; c < 26; c++) {
                char nc = (char) ('a' + c);
                if (nc == orig) continue;

                // Let the local partition start = partStart[i]
                int ps = partStart[i];

                // We want the maximum r ≥ ps such that substring [ps..r] has ≤ K distinct
                // when we replace s[i] by nc
                int low = i, high = n - 1;
                int bestR = i - 1;  // if nothing
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (validWithChange(ps, mid, i, nc)) {
                        bestR = mid;
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                if (bestR >= i) {
                    // The changed char still stays within this partition
                    int beforeParts = (ps > 0 ? pref[ps - 1] : 0);
                    int afterParts = (bestR + 1 < n ? suff[bestR + 1] : 0);
                    answer = Math.max(answer, beforeParts + 1 + afterParts);
                } else {
                    // bestR < i → change causes partition to split
                    // We also need to find how far the next partition can extend
                    // Starting from i as a new partition, find r2
                    int low2 = i, high2 = n - 1, bestR2 = i - 1;
                    while (low2 <= high2) {
                        int mid = (low2 + high2) / 2;
                        if (validWithChange(i, mid, i, nc)) {
                            bestR2 = mid;
                            low2 = mid + 1;
                        } else {
                            high2 = mid - 1;
                        }
                    }
                    int beforeParts = (ps > 0 ? pref[ps - 1] : 0);
                    int afterParts = (bestR2 + 1 < n ? suff[bestR2 + 1] : 0);
                    // We split into two partitions: one for [ps..i-1] and one for [i..bestR2]
                    answer = Math.max(answer, beforeParts + 2 + afterParts);
                }
            }
        }

        return answer;
    }

    /** Return the maximum `j` such that substring s[i..j] can be a valid partition (≤ K distinct). */
    private int findMaxEndForStart(int i) {
        int low = i, high = n - 1, best = i;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (distinct(i, mid) <= K) {
                best = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return best;
    }

    /** Return the minimum `j` such that substring s[j..i] can be a valid partition (≤ K distinct). */
    private int findMinStartForEnd(int i) {
        int low = 0, high = i, best = i;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (distinct(mid, i) <= K) {
                best = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return best;
    }

    /** Count distinct characters in s[l..r] in O(26) via prefix freq. */
    private int distinct(int l, int r) {
        int cnt = 0;
        for (int c = 0; c < 26; c++) {
            if (freq[r + 1][c] - freq[l][c] > 0) {
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * Check if making s[idx] = newChar allows substring [l..r] to have ≤ K distinct.
     * We override the original char at idx in this check.
     */
    private boolean validWithChange(int l, int r, int idx, char newChar) {
        int distinctCount = 0;
        for (int c = 0; c < 26; c++) {
            int total = freq[r + 1][c] - freq[l][c];
            if (c == s.charAt(idx) - 'a') {
                // subtract the original if it lies in [l..r]
                if (idx >= l && idx <= r) total--;
            }
            if (c == newChar - 'a') {
                // add the new char if idx in [l..r]
                if (idx >= l && idx <= r) total++;
            }
            if (total > 0) distinctCount++;
            if (distinctCount > K) return false;
        }
        return true;
    }
}
