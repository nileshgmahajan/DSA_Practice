class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> map = new HashMap<>();
        for (int p : power) {
            map.put(p, map.getOrDefault(p, 0L) + p);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        int n = keys.size();
        long[] dp = new long[n];
        dp[0] = map.get(keys.get(0));

        for (int i = 1; i < n; i++) {
            long take = map.get(keys.get(i));

            // binary search for last index j where keys[j] < keys[i] - 2
            int left = 0, right = i - 1, j = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (keys.get(mid) < keys.get(i) - 2) {
                    j = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (j >= 0) take += dp[j];
            dp[i] = Math.max(dp[i - 1], take);
        }

        return dp[n - 1];
        
    }
}