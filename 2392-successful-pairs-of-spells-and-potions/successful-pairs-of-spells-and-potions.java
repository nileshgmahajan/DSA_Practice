class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

         Arrays.sort(potions);                    // Step 1: sort potions
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            long spell = spells[i];
            long minPotion = (success + spell - 1) / spell;  // ceil(success / spell)
            int index = firstGreaterOrEqual(potions, minPotion);
            result[i] = m - index;             // remaining potions are successful
        }

        return result;
    }
     private int firstGreaterOrEqual(int[] potions, long target) {
        int left = 0, right = potions.length; // right is exclusive
        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((long) potions[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
    }

    