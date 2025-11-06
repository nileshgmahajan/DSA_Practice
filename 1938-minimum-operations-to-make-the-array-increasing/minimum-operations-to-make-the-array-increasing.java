class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int no=nums[0];
        int count=0;
        for(int i=1;i<n;i++)
        {
            if(no >= nums[i])
            {
                no++;
                count += (no-nums[i]);
            }
            else{
                no = nums[i];
            }
        }
        return count;
    }
}