class Solution {
    static final long MOD = 1_000_000_007L;
    public int magicalSum(int m, int k, int[] nums) {
         int n = nums.length;
        int W = 1;
        while ((1 << W) <= m) W++; // window size for carry bits
        int MASK_SIZE = 1 << W;

        long[] fact = new long[m + 1];
        long[] invFact = new long[m + 1];
        fact[0] = 1;
        for (int i = 1; i <= m; i++) fact[i] = fact[i - 1] * i % MOD;
        invFact[m] = pow(fact[m], MOD - 2);
        for (int i = m; i > 0; i--) invFact[i - 1] = invFact[i] * i % MOD;

        // Precompute nums^c / c!
        long[][] ways = new long[n][m + 1];
        for (int t = 0; t < n; t++) {
            ways[t][0] = 1;
            long p = 1;
            for (int c = 1; c <= m; c++) {
                p = p * nums[t] % MOD;
                ways[t][c] = p * invFact[c] % MOD;
            }
        }

        // dp[s][mask][j]
        long[][][] cur = new long[m + 1][MASK_SIZE][m + 1];
        cur[0][0][0] = 1;

        for (int t = 0; t < n; t++) {
            long[][][] nxt = new long[m + 1][MASK_SIZE][m + 1];
            for (int s = 0; s <= m; s++) {
                for (int mask = 0; mask < MASK_SIZE; mask++) {
                    for (int j = 0; j <= m; j++) {
                        long val = cur[s][mask][j];
                        if (val == 0) continue;
                        int maxC = m - s;
                        for (int c = 0; c <= maxC; c++) {
                            int newBefore = mask + c;
                            int bit = newBefore & 1;
                            int nextMask = newBefore >> 1;
                            int nj = j + bit;
                            nxt[s + c][nextMask][nj] = (nxt[s + c][nextMask][nj]
                                    + val * ways[t][c]) % MOD;
                        }
                    }
                }
            }
            cur = nxt;
        }

        long ans = 0;
        for (int mask = 0; mask < MASK_SIZE; mask++) {
            int pop = Integer.bitCount(mask);
            for (int j = 0; j <= m; j++) {
                if (j + pop == k) {
                    ans = (ans + cur[m][mask][j]) % MOD;
                }
            }
        }

        ans = ans * fact[m] % MOD;
        return (int) ans;
    }

    private long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
        
    }
}