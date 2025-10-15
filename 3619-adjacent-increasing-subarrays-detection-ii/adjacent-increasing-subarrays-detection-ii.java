class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] left = new int[n];
        int[] right = new int[n];

        // Step 1: Compute left array (increasing lengths ending at i)
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1))
                left[i] = left[i - 1] + 1;
            else
                left[i] = 1;
        }

        // Step 2: Compute right array (increasing lengths starting at i)
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1))
                right[i] = right[i + 1] + 1;
            else
                right[i] = 1;
        }

        // Step 3: Find maximum possible k
        int maxK = 0;
        for (int i = 0; i < n - 1; i++) {
            maxK = Math.max(maxK, Math.min(left[i], right[i + 1]));
        }

        return maxK;
    }
}
