import java.util.*;

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> remainderCount = new HashMap<>();

        // Step 1: Count remainders
        for (int num : nums) {
            int r = ((num % value) + value) % value; // ensure non-negative remainder
            remainderCount.put(r, remainderCount.getOrDefault(r, 0) + 1);
        }

        // Step 2: Find maximum MEX
        int mex = 0;
        while (true) {
            int r = mex % value;
            if (remainderCount.getOrDefault(r, 0) > 0) {
                remainderCount.put(r, remainderCount.get(r) - 1);
                mex++;
            } else {
                return mex;
            }
        }
    }
}
