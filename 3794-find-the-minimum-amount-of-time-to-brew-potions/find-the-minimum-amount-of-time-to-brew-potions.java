class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] f = new long[n]; // wizard free times

        for (int j = 0; j < m; j++) {
            int x = mana[j];
            long now = f[0] + 1L * skill[0] * x;

            // Forward pass: compute finish time of last wizard for this potion
            for (int i = 1; i < n; i++) {
                now = Math.max(now, f[i]) + 1L * skill[i] * x;
            }

            // Backward pass: update all f[i] for next potion
            f[n - 1] = now;
            for (int i = n - 2; i >= 0; i--) {
                f[i] = Math.max(f[i], f[i + 1] - 1L * skill[i + 1] * x);
            }
        }

        return f[n - 1];
    }
}
        
