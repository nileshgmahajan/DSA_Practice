class Solution {
    public int removeElement(int[] nums, int val) {
        int store=0;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=val)
            {
                nums[store]=nums[i];
                store++;
            }
        }
        return store;
    }
}